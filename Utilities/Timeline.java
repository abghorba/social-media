package Utilities;

import java.util.ArrayList;
import java.util.TreeSet;

public class Timeline {

    private ArrayList<Message> feed;

    public Timeline() {
        feed = new ArrayList<>();
    }

    public void addToFeed( Message newMessage ) {
        feed.add(newMessage);
    }

    public void removeFromFeed( User removedFriend ) {
        System.out.println("removing friend");
        ArrayList<Message> toRemove = new ArrayList<>();

        for (int index = 0; index < feed.size(); index++) {
            if (feed.get(index).poster == removedFriend) {
                toRemove.add(feed.get(index));
            }
        }

        for (Message removeMessage : toRemove) {
            feed.remove(removeMessage);
        }
    }
    public void displayTimeline() {
        for (Message news: feed) {
            news.retrieveLog();
        }
    }

}
