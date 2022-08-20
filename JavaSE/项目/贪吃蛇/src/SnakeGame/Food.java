package SnakeGame;
import java.util.Random;

public class Food extends Node{
    protected int x;
    protected int y;

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    //构造函数
    public Food(){
        this.random();
    }

    //随机生成食物
    public void random() {
        //创建random对象
        Random rand = new Random();
        this.x = rand.nextInt(30)+1;//随机生成横坐标<1,31>
        this.y = rand.nextInt(34)+7;//随机生成纵坐标<7,41>
    }
}
