package Utilities;

import java.util.ArrayList;
import java.util.Date;
public class Timeline {

    private ArrayList<Message> feed;

    public Timeline() {
        feed = new ArrayList<Message>();
    }

    public void addToTimeline( String message ) {
        Date timestamp = new Date();
        Message newMessage = new Message(message, timestamp);
        feed.add( newMessage );
    }

    public void displayTimeline() {
        for (int index = 0; index < feed.size(); index++){
            System.out.println( feed.get(index).text + " at " + feed.get(index).timestamp);
        }
    }
}
