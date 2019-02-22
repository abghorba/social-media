package Utilities;

import java.util.Date;

public class Message extends Event {

    private String text;
    private Date timestamp;
    public User poster;

    public Message( String text, User poster) {
        this.text = text;
        this.timestamp = new Date();
        this.poster = poster;
    }

    @Override
    public void retrieveLog() {
        System.out.println(poster.name + ": " + text + " @ " + timestamp);
    }
}
