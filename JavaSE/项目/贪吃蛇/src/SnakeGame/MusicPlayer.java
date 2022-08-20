package SnakeGame;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MusicPlayer implements Runnable{
    File soundFile;     //音乐文件
    Thread thread;      //父线程
    boolean circulate;  //是否循环播放


    public MusicPlayer(String filepath, boolean circulate) throws FileNotFoundException {
        this.circulate = circulate;
        soundFile = new File(filepath);
        if (!soundFile.exists()){//如果文件不存在
            throw new FileNotFoundException(filepath+"未找到");
        }
    }

    @Override
    public void run() {
        byte[]  auBuffer = new byte[1024 * 128];//创建缓冲区
        do{
            AudioInputStream audioInputStream;//创建音频输入流对象
            SourceDataLine auline = null;//混频器源数据行
            try{
                //从音乐文件中获取音频输入流
                audioInputStream = AudioSystem.getAudioInputStream(soundFile);
                AudioFormat format = audioInputStream.getFormat();//获取音频格式
                //按照源数据行类型和指定音频何时创建数据行对象
                DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
                //利用音频系统类获得与指定音Line.Info对象中的i傲视匹配的行对象
                auline = (SourceDataLine) AudioSystem.getLine(info);
                auline.open(format);//按照指定格式打开源数据行
                auline.start();//元数据行开启读写活动
                int byteCount = 0;//记录音频输入流读出的字节数
                while (byteCount != -1){//字节数不为1
                    byteCount = audioInputStream.read(auBuffer, 0, auBuffer.length);//读出128KB的数据
                    if (byteCount >= 0){//读出有效数据
                        auline.write(auBuffer, 0, byteCount);//写入
                    }
                }
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            } finally {
                assert auline != null;
                auline.drain();//清空数据行
                auline.close();//关闭数据行
            }
        }
        while(circulate);
    }

    public void play(){
        thread = new Thread(this);
        thread.start();
    }

    public void stop(){
        thread.stop();
    }


}

