package Utilities;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class User {


    private FriendsList friends;
    private Timeline timeline;
    private Queue<Event> eventQueue;
    public String name;


    public User(String name) {
        this.name = name;
        friends = new FriendsList();
        timeline = new Timeline();
        eventQueue = new LinkedList();
    }

    private void addToEventQueue(Event event) {
        eventQueue.add(event);
    }

    private void processEventQueue() {
        while (!eventQueue.isEmpty()) {
            Event event = eventQueue.poll();

            if (event instanceof Message) {
                timeline.addToFeed( (Message) event );
            } else if (event instanceof FriendRequest) {
                User requestee = ((FriendRequest) event).getRequestee();
                Action action = ((FriendRequest) event).getAction();
                Scanner input = new Scanner(System.in);

                System.out.println("We have a friend request!");

                if (action == Action.ADD) {
                    System.out.println(this.name + ", would you like to accept friend request from " + requestee.name + "? y/n");
//                    String response = input.nextLine();
//                    if ( response.equals("y") ) {
                        addToFriendList( requestee );
                        requestee.addToFriendList( this );
                        System.out.println("Added friend!");
//                    }
                } else if (action == Action.REMOVE) {
                    removeFromFriendList( requestee );
                    timeline.removeFromFeed( requestee );
                    requestee.timeline.removeFromFeed(this);
                    System.out.println("Removed friend!");
                    // update timeline!
                }
            }
        }
    }

    private void addToFriendList(User newFriend ) {
        friends.addFriend( newFriend );
    }

    private void removeFromFriendList(User friend) {
        friends.removeFriend( friend );
    }

    public void sendFriendRequest( User newFriend ) {
        newFriend.addToEventQueue( new FriendRequest(Action.ADD, newFriend.name, this) );
    }

    public void removeFriend( User friend ) {
        friend.addToEventQueue( new FriendRequest(Action.REMOVE, this.name, friend) );
        removeFromFriendList(friend);
    }

    public int degreesOfSeparation(User user) {
        //Breadth-First Search
        processEventQueue();
        int degrees = 1;

        if(friends.allFriends.contains(user)) {
            return degrees;
        }

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

    public void postToTimeline( String text ) {
        Message myMessage = new Message(text, this);
        eventQueue.add( myMessage );
        for( User friend: friends.allFriends ) {
            friend.addToEventQueue( myMessage );
        }
    }

    public void displayFeed() {
        processEventQueue();
        timeline.displayTimeline();
    }

    public boolean areFriends( User user ) {
        return friends.isFriend(user);
    }

    public void addTestFunc() {
        processEventQueue();
    }
}
