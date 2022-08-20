package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class Setting_panel extends JPanel {
    JButton sound;          //音效按钮
    JPanel cards;           //面板选项卡
    JButton enter;          //进入游戏按钮
    JButton difficulty;     //难度
    boolean sound_status;   //音效状态
    int difficulty_status;  //难度状态
    MusicPlayer back_music; //背景音乐

    //构造函数
    public Setting_panel(JPanel cards) throws FileNotFoundException {
        init_setting_panel(cards);
        init_music();
    }

    //重构paint函数
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        draw_sound_status(g);
        draw_difficulty_status(g);
    }

    //初始化设置面板
    private void init_setting_panel(JPanel cards) {
        sound_status = true;
        difficulty_status = 1;
        this.cards = cards;
        setBackground(new Color(175, 155, 94));
        setLayout(null);
        init_sound_button();
        init_difficulty_button();
        init_enter_button();
        set_sound_turn_listener();
        set_enter_listener();
        set_difficulty_turn_listener();
    }

    //初始化进入按钮
    private void init_enter_button(){
        enter = new JButton("Enter");
        enter.setBounds(160, 400, 140, 50);//设置按钮位置大小
        enter.setFocusPainted(false);//关闭文字的虚线框
        enter.setBackground(new Color(187, 217, 184));//设置背景颜色
        enter.setBorderPainted(false);//按钮边框
        enter.setFont(new Font("Impact",Font.BOLD,25));//设置文字格式
        add(enter);


    }

    //初始化背景音乐按钮
    private void init_sound_button() {
        sound = new JButton("Sound  Turn");
        sound.setBounds(130,220, 140,50);
        sound.setFocusPainted(false);//关闭文字的虚线框
        sound.setBackground(new Color(187, 217, 184));//设置背景颜色
        sound.setBorderPainted(false);//按钮边框
        sound.setFont(new Font("Impact",Font.PLAIN,22));//设置文字格式
        add(sound);
    }

    //初始化难度按钮
    private void init_difficulty_button(){
        difficulty = new JButton("Difficulty");
        difficulty.setBounds(130,300, 140,50);
        difficulty.setFocusPainted(false);//关闭文字的虚线框
        difficulty.setBackground(new Color(187, 217, 184));//设置背景颜色
        difficulty.setBorderPainted(false);//按钮边框
        difficulty.setFont(new Font("Impact",Font.PLAIN,22));//设置文字格式
        add(difficulty);

    }

    //设置enter监听器
    protected void set_enter_listener(){
        enter.addActionListener(e -> {
            CardLayout cl = (CardLayout) (cards.getLayout());//get cards
            cl.previous(cards);
            add_tip();
        });
    }

    //绘制音乐状态
    private void draw_sound_status(Graphics g){
        g.setColor(new Color(187, 217, 184));
        g.fillRect(272,220, 90,50);
        g.setColor(Color.BLACK);
        setFont(new Font("Impact",Font.PLAIN,22));
        if (sound_status){
            g.drawString("ON",300,255);
        }
        else g.drawString("OFF",300,255);

    }

    //绘制难度状态
    private void draw_difficulty_status(Graphics g){
        g.setColor(new Color(187, 217, 184));
        g.fillRect(272,300, 90,50);
        g.setColor(Color.BLACK);
        setFont(new Font("Impact",Font.PLAIN,22));
        switch (difficulty_status) {
            case 1 -> g.drawString("EASY", 295, 334);
            case 2 -> g.drawString("MEDIUM", 280, 334);
            case 3 -> g.drawString("DISASTER", 276, 334);
            default -> throw new IllegalStateException("Unexpected value: " + difficulty_status);
        }

    }

    private void change_difficulty_status() {
        switch (difficulty_status) {
            case 1 -> difficulty_status = 2;
            case 2 -> difficulty_status = 3;
            case 3 -> difficulty_status = 1;
            default -> throw new IllegalStateException("Unexpected value: " + difficulty_status);
        }
    }

    private void set_difficulty_turn_listener(){
        difficulty.addActionListener(e -> {
            change_difficulty_status();
            repaint();
        });
    }

    //设置sound监听器
    private void set_sound_turn_listener(){
        sound.addActionListener(e -> {
            change_sound_status();
            if (sound_status){
                back_music.play();
            }
            else back_music.stop();
            repaint();
        });
    }

    //更改音乐状态
    private void change_sound_status() {
        sound_status = !sound_status;
    }

    //初始化播放器
    private void init_music() throws FileNotFoundException {
        this.back_music = new MusicPlayer("src/music/backgroundmusic.wav",true);
        this.back_music.play();
    }

    //增加提示
    private void add_tip(){
        JButton yes = new JButton("OK");
        yes.setFocusPainted(false);
        Icon icon = new ImageIcon("src/Images/tip.png");
        yes.addActionListener(e -> {
            Window win = SwingUtilities.getWindowAncestor(yes);
            win.dispose();
        });
        Object[] object = {yes};
        yes.setFocusPainted(false);
        JOptionPane.showOptionDialog(null,"Enter space start game ","Tip", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon,object,null);
    }

    //获取难度
    public int getDifficulty_status() {
        int period = 120;
        switch (difficulty_status) {
            case 2 -> period = 100;
            case 3 -> period = 80;
        }
        return period;
    }


}
