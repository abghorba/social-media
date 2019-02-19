package Utilities;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class User {

    private FriendsList friends;
    private Timeline timeline;


    public User() {
        friends = new FriendsList();
        timeline = new Timeline();
    }

    public void addToFriendList(User user) {
        friends.addFriend(user);
    }

    public void removeFromFriendList(User user) {
        friends.removeFriend(user);
    }

    public void sendFriendRequest() {
        return;
    }

    public int degreesOfSeparation(User user) {
        //Breadth-First Search
        int degrees = 1;

        Queue<User> queue = new LinkedList<>();
        Queue<User> processNext = new LinkedList<>();

        HashSet<User> processed = new HashSet<>();
        HashSet<User> processing = new HashSet<>();

        for(User friend: friends.allFriends) {
            queue.add(friend);
            processing.add(friend);
        }

        while( queue.size() != 0 ) {
            User nextUser = queue.poll();

            if(nextUser == user) {
                return degrees;
            } else {
                processed.add(nextUser);
                processing.remove(nextUser);

                for(User friend: nextUser.friends.allFriends) {
                    if( !(processing.contains(friend) || processed.contains(friend)) ) {
                        processNext.add(friend);
                        processing.add(friend);
                    }
                }
            }

            // The next degree of separation
            if( queue.size() == 0 && processNext.size() != 0 ) {
                degrees++;
                queue = processNext;
                processNext = new LinkedList<>();
            }
        }

        // If users are NOT connected.
        return -1;
    }

    public void postToTimeline( String message ) {
        timeline.addToTimeline(message);
    }

    public void displayUserTimeline() {
        timeline.displayTimeline();
    }
}
