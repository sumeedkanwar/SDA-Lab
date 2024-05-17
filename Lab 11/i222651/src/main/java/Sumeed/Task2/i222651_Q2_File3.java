package Sumeed.Task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("mp3beans.xml");
        MP3Player mp3Player = (MP3Player) context.getBean("mp3Player");
        mp3Player.playKalaam();
    }
}
