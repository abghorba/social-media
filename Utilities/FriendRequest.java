package Utilities;

import java.util.Date;

public class FriendRequest extends Event {

    private Action action;
    private String requestor;
    private User requestee;
    private Date timestamp;

    public FriendRequest( Action action, String requestor, User requestee ) {
        this.action = action;
        this.requestor = requestor;
        this.requestee = requestee;
        this.timestamp = new Date();
    }

    @Override
    public void retrieveLog() {
        if(action == Action.ADD) {
            System.out.println("Friend add request sent by " + requestor + " to " + requestee.name + " at " + timestamp);
        }
        else if(action == Action.REMOVE) {
            System.out.println("Friend removal request sent by " + requestor + " to " + requestee.name + " at " + timestamp);
        }
    }

    public User getRequestee() {
        return this.requestee;
    }

    public Action getAction() {
        return this.action;
    }
}
