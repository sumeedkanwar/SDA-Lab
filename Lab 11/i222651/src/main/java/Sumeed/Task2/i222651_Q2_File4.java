package Sumeed.Task2;

import org.springframework.beans.factory.annotation.Autowired;

public class MP3Player {
    private Kalaam kalaam;

    @Autowired
    public MP3Player(Kalaam kalaam) {
        this.kalaam = kalaam;
    }

    public void playKalaam() {
        System.out.println("Playing: " + kalaam.getTitle() + " by " + kalaam.getArtist());
        System.out.println("Duration: " + kalaam.getDuration() + " seconds");
    }
}

