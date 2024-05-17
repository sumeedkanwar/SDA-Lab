package Sumeed.Task2;

public class Kalaam {
    private String title;
    private String artist;
    private int duration;

    public Kalaam(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }
}
