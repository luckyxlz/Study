package SnakeGame;


import java.awt.*;
import javax.swing.*;
import java.io.FileNotFoundException;

public class MainFrame extends JFrame {
    //窗口的基本属性
    protected int x;                      //窗口左上角的横坐标
    protected int y;                      //窗口左上角的纵坐标
    protected int weight;                 //窗口的宽度
    protected int height;                 //窗口的高度
    protected JPanel game_panel;          //游戏面板
    protected JPanel index_panel;         //开始页面板
    protected Setting_panel setting_panel;       //设置面板
    protected JPanel cards;               //面板选项卡

    //构造函数
    public MainFrame() throws HeadlessException, FileNotFoundException {
        init_frame();                 //初始化窗口
        init_panel();
    }

    //窗口初始化方法
    private void init_frame(){
        attribute_frame();
        set_frame();
    }

    //初始化面板
    private void init_panel() throws FileNotFoundException {
        init_index_panel();
        init_setting_panel();
        init_game_panel();
        cards.add(game_panel);
        cards.add(setting_panel);

        add(cards);
    }

    //窗口属性
    private void attribute_frame(){
        x = 485;//-15
        y = 85;
        weight = 494;//+30
        height = 667;
    }

    //设置窗口
    private void set_frame(){
        setTitle("Snake Game");     //设置窗口标题
        setLocation(x, y);           //设置窗口的左上角坐标
        setSize(weight, height);    //设置窗口的大小
        cards = new JPanel(new CardLayout());
        setVisible(true);           //设置窗口可见
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置窗口关闭则停止程序
    }

    //初始化设置面板
    private void init_setting_panel() throws FileNotFoundException {
        setting_panel = new Setting_panel(cards);
    }

    //初始化游戏面板
    private void init_game_panel() throws FileNotFoundException {
        game_panel = new Game_panel(setting_panel);
    }

    //欢迎面板
    private void init_index_panel() {
        index_panel = new Index_panel(cards);
        cards.add(index_panel);
    }

    public static void main(String[] args) throws FileNotFoundException {
        new MainFrame();
    }

}
