package Utilities;

import Utilities.User;

import java.util.HashSet;

public class FriendsList {

    public HashSet<User> allFriends = new HashSet<User>();

    public void addFriend( User user ) {
        allFriends.add( user );
    }

    public void removeFriend( User user ) {
        allFriends.remove( user );
    }

    public boolean isFriend( User user ) {
        return allFriends.contains( user );
    }
}