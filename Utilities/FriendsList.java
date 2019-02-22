package Utilities;

import java.util.HashSet;

public class FriendsList {

    HashSet<User> allFriends = new HashSet<User>();

    void addFriend( User user ) {
        allFriends.add( user );
    }

    void removeFriend( User user ) {
        allFriends.remove( user );
    }

    boolean isFriend( User user ) {
        return allFriends.contains( user );
    }
}