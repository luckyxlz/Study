package SnakeGame;

import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Snake {
    private LinkedList<Node> snake;     //蛇的身体
    private Direction direction;        //蛇的运动方向
    private Node snake_head;            //蛇头
    private Node snake_tail;            //蛇尾
    private boolean snake_status;       //蛇的状态
    private int length;                 //蛇的长度
    private MusicPlayer sound;          //碰撞音效


    //构造函数
    public Snake() throws FileNotFoundException {
        init_snake();//初始化蛇身
        set_eat_sound();//设置食物音效
    }

    //对蛇进行初始化
    protected void init_snake() {
        snake = new LinkedList<>(); //创建蛇身集合
        snake_status = true;        //蛇的状态默认为活
        direction = Direction.RIGHT; //蛇的默认方向
        snake.add(new Node(11, 15));
        snake.add(new Node(10, 15));
        snake.add(new Node(9, 15));
        snake_head = snake.getFirst();
        snake_tail = snake.getLast();
        length = snake.size();
    }

    //返回蛇的状态
    public boolean isSnake_status() {
        return snake_status;
    }

    //设置蛇的运动方向
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    //返回蛇的运动方向
    public Direction getDirection() {
        return direction;
    }

    //返回蛇的节点
    public LinkedList<Node> getSnake() {
        return this.snake;
    }

    //碰撞检测
    protected void check(LinkedList<Node> snake) {
        Node head;
        head = snake.getFirst();
        if (head.getX() < 1 || head.getX() >= 31 || head.getY() < 7  || head.getY() >= 41)
            this.snake_status = false;
        //如果碰到身体，蛇的状态为死亡
        for (Node node : snake) {
            if (node != head && head.getX() == node.getX() && head.getY() == node.getY()) {
                this.snake_status = false;
                break;
            }
        }

    }

    //蛇移动
    public void move() {
        //蛇每次移动后，判断蛇的状态
        //蛇状态为活着的时候运行移动
        if (this.snake_status) {
            switch (direction) {
                case UP -> snake.addFirst(new Node(snake_head.getX(), snake_head.getY() - 1));
                case DOWN -> snake.addFirst(new Node(snake_head.getX(), snake_head.getY() + 1));
                case LEFT -> snake.addFirst(new Node(snake_head.getX() - 1, snake_head.getY()));
                case RIGHT -> snake.addFirst(new Node(snake_head.getX() + 1, snake_head.getY()));
            }
            snake.removeLast();
        }

        //检测蛇是否撞墙和撞到身体
        check(snake);

        //更新以下蛇头和蛇尾
        update_snake();
    }

    //更新蛇头和蛇尾
    private void update_snake() {
        this.snake_head = snake.getFirst();//把队首给蛇头
        this.snake_tail = snake.getLast();//把队尾给蛇尾
        this.length = snake.size();
    }

    //蛇吃食物
    public void eat(Food food) {
        if (snake_head.getX() == food.getX() && snake_head.getY() == food.getY()) {
            snake.add(new Node(snake_tail.getX(), snake_tail.getY()));
            food.random();
            sound.play();


            //食物不能产生在身体里面
            for(Node node: getSnake()){
                if (food.getX() == node.getX() && food.getY() == node.getY()){
                    food.random();
                }
            }
        }
    }

    //设置吃到食物的音效
    private void set_eat_sound() throws FileNotFoundException {
        this.sound = new MusicPlayer("src/music/碰撞音效.wav",false);
    }

    //获得蛇的长度
    public int getLength() {
        return length;
    }

    public Node getSnake_head() {
        return snake_head;
    }
}
