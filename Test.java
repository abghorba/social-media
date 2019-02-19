import Utilities.User;

public class Test {

    public static void main(String[] args) {

        User Andrew = new User();
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        User user5 = new User();
        User user6 = new User();
        User user7 = new User();

        Andrew.addToFriendList(user1);
        user1.addToFriendList(Andrew);

        Andrew.addToFriendList(user2);
        user2.addToFriendList(Andrew);

        Andrew.addToFriendList(user3);
        user3.addToFriendList(Andrew);

        Andrew.addToFriendList(user4);
        user4.addToFriendList(Andrew);

        user2.addToFriendList(user5);
        user5.addToFriendList(user2);

        user5.addToFriendList(user6);
        user6.addToFriendList(user5);



        // We should have all these printed out in the timeline.
        user1.postToTimeline("This is user1's first post!");
        user2.postToTimeline("This is user2's first post!");
        Andrew.postToTimeline("This is my first post!");
        Andrew.displayUserTimeline();

        // We should get the numbers 1, 2, 3, -1.
        System.out.println(Andrew.degreesOfSeparation(user2));
        System.out.println(Andrew.degreesOfSeparation(user5));
        System.out.println(Andrew.degreesOfSeparation(user6));
        System.out.println(Andrew.degreesOfSeparation(user7));

        // We should now get -1 because we removed user2, which was the
        // connection to user5.
        Andrew.removeFromFriendList(user2);
        System.out.println(Andrew.degreesOfSeparation(user5));


    }

}