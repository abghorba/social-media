package Utilities;

import java.util.Date;

public class Message {
    public String text;
    public Date timestamp;

    public Message( String text, Date timestamp ) {
        this.text = text;
        this.timestamp = timestamp;
    }
}
