package SnakeGame;

import javax.swing.*;
import java.awt.*;



public class Index_panel extends JPanel {
    protected JButton enter;    //进入按钮
    protected JButton setting;  //设置按钮
    protected JPanel cards;     //面板选项卡

    //构造函数
    public Index_panel(JPanel cards) {
        init_panel(cards);
    }

    //重构paint函数
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        draw_title(g);
    }

    //初始化面板
    protected void init_panel(JPanel cards){
        this.cards = cards;
        set_background();
        init_enter_button();
        init_setting_button();
        add(enter);
        add(setting);
    }

    //绘制标题
    private void draw_title(Graphics g) {
        String title = "S n a k e    G a m e";
        g.setColor(new Color(0, 162, 232));
        g.setFont(new Font("Impact",Font.BOLD, 60));
        g.drawString(title, 30, 140);
    }

    //绘制背景
    private void set_background(){
        setBackground(new Color(69, 187, 159));
        setLayout(null);
    }

    //初始化进入按钮
    private void init_enter_button(){
        this.enter = new JButton("进入游戏");
        this.enter.setBounds(225-70, 300, 140, 50);//设置按钮位置大小
        this.enter.setFocusPainted(false);//关闭文字的虚线框
        this.enter.setBackground(Color.white);//设置背景颜色
        this.enter.setBorderPainted(false);//按钮边框
        this.enter.setFont(new Font("华文行楷",Font.BOLD,25));//设置文字格式
        this.enter.addActionListener(e -> {
            CardLayout cl = (CardLayout) (cards.getLayout());//get cards
            cl.next(cards);//下一张面板
            add_tip();//添加提示
        });
    }

    //初始化设置按钮
    private void init_setting_button(){
        this.setting = new JButton("游戏设置");
        this.setting.setBounds(225-70, 380, 140, 50);//设置按钮位置大小
        this.setting.setFocusPainted(false);//关闭文字的虚线框
        this.setting.setBackground(Color.white);//设置背景颜色
        this.setting.setBorderPainted(false);//按钮边框
        this.setting.setFont(new Font("华文行楷",Font.BOLD,25));//设置文字格式
        this.setting.addActionListener(e -> {
            CardLayout cl = (CardLayout) (cards.getLayout());//get cards
            cl.previous(cards);
        });
    }

    //增加提示
    private void add_tip(){
        JButton yes = new JButton("OK");
        yes.setFocusPainted(false);
        Icon icon = new ImageIcon("../images/tip.png");
        yes.addActionListener(e -> {
            Window win = SwingUtilities.getWindowAncestor(yes);
            win.dispose();
        });
        Object[] object = {yes};
        yes.setFocusPainted(false);
        JOptionPane.showOptionDialog(null,"Enter space start game ","Tip", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon,object,null);
    }

}
