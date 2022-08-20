package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class  Game_panel extends JPanel {
    protected Snake snake;//面版中的蛇
    protected Food food;//面板中的食物
    protected Timer timer;//
    protected TimerTask timerTask;
    protected boolean status;
    protected int difficult;
    protected int sign;

    //在构造使将蛇作为参数传进
    public Game_panel(Setting_panel setting) throws FileNotFoundException {
        init_game_panel();
        set_key_listener(setting);
        init_timer();
    }

    //初始化游戏面板
    protected void init_game_panel() throws FileNotFoundException {
        status = false;
        sign = 0;
        init_snake();
        init_food();
    }

    //
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        draw_head(g);
        draw_background(g);
        draw_line(g);
        draw_snake_head(g);
        draw_snake_body(g);
        draw_food(g);

    }

    //初始化食物
    private void init_food() {
        this.food = new Food();
    }

    //初始化蛇
    private void init_snake() throws FileNotFoundException {
        this.snake = new Snake();
    }

    //绘制网格
    protected void draw_line(Graphics g){
        g.setColor(new Color(255, 255, 255, 100));

        for (int i = 0; i < 31; i++) {
            g.drawLine((15*i)+15, 90+15, (15*i)+15, 600+15);//绘制竖线
        }
        for (int i = 6; i < 41; i++) {
            g.drawLine(15,(15*i)+15, 450+15, (15*i)+15);//绘制横线
//            g.drawLine(5,15*i, 600, 15*i);//绘制横线
        }
    }

    //绘制蛇头
    protected void draw_snake_head(Graphics g){
        Node head = snake.getSnake_head();
        g.setColor(new Color(131, 166, 213));
        g.fillRect(head.getX() * 15, head.getY() * 15, 15, 15);
    }

    //绘制蛇身
    protected void draw_snake_body(Graphics g){
        g.setColor(Color.white);
        LinkedList<Node> all = snake.getSnake();
        for (Node node: all) {
            if (node != all.getFirst()) {
                g.fillRect(node.getX() * 15, node.getY() * 15, 15, 15);
            }
        }
    }

    //绘制食物
    private void draw_food(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(food.getX()*15, food.getY()*15, 15, 15);
    }

    //绘制背景
    private void draw_background(Graphics g){
        setBackground(new Color(187, 217, 184));
        g.setColor(new Color(194, 182, 151, 255));
        g.fillRect(15,105, 450,510);
    }

    //绘制头部面板
    private void draw_head(Graphics g){
        g.setColor(new Color(255, 255, 255));
        g.drawRoundRect(15,5, 450, 90,20 ,20);
        draw_title(g);
        draw_score(g);
        draw_score_num(g,snake);
    }

    //绘制分数
    private void draw_score_num(Graphics g,Snake snake) {
//        int length = snake.getLength();//蛇的初始化长度
        g.setColor(Color.BLACK);
        g.setFont(new Font("Impact",Font.BOLD,20));
        String score_num = String.valueOf(snake.getLength()-3);
        g.drawString(score_num,420,70 );

    }

    //绘制分数
    private void draw_score(Graphics g) {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Impact",Font.BOLD,20));
        String score = "Score :";
        g.drawString(score,350,70 );
    }

    //绘制标题
    private void draw_title(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Segoe Script",Font.BOLD, 42));
        String title = "snake game";
        g.drawString(title, 30, 60);
    }

    //初始化定时器
    public void init_timer() {
        //新建一个定时器
        this.setFocusable(true);
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                if (status) {
                    snake.move();
                    snake.eat(food);
                    if (snake.isSnake_status())
                        repaint();
                    else {
                        status = false;
                        add_tip();
                    }
                }
            }
        };
    }

    //新建提示
    private void add_tip(){
        JButton yes = new JButton("OK");
        yes.setFocusPainted(false);
        Icon icon = new ImageIcon("../out/production/JAVA/images/tip.png");
        yes.addActionListener(e -> {
            Window win = SwingUtilities.getWindowAncestor(yes);
            win.dispose();
        });
        Object[] object = {yes};
        yes.setFocusPainted(false);
        JOptionPane.showOptionDialog(null,"           Game over\nPlease Enter Space restart game","Tip", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon,object,null);
    }

    //设置监听器
    private void set_key_listener(Setting_panel setting_panel){
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> {
                        if (snake.getDirection() != Direction.DOWN)
                            snake.setDirection(Direction.UP);
                    }
                    case KeyEvent.VK_DOWN -> {
                        if (snake.getDirection() != Direction.UP) {
                            snake.setDirection(Direction.DOWN);
                        }
                    }
                    case KeyEvent.VK_LEFT -> {
                        if (snake.getDirection() != Direction.RIGHT) {
                            snake.setDirection(Direction.LEFT);
                        }
                    }
                    case KeyEvent.VK_RIGHT -> {
                        if (snake.getDirection() != Direction.LEFT) {
                            snake.setDirection(Direction.RIGHT);
                        }
                    }
                    case KeyEvent.VK_SPACE -> {
                        //在蛇活着的时候，空格可可以控制游戏的暂停，死亡空格则重新初始化，并重绘
                        if (sign == 0 ) {
                            difficult = setting_panel.getDifficulty_status();
                            timer.scheduleAtFixedRate(timerTask, 0, difficult);
                            sign = 1;
                        }
                        if (snake.isSnake_status()) {
                            status = !status;
                        } else {
                            snake.init_snake();
                            repaint();
                        }
                    }
                }

            }
        })
        ;}

}
