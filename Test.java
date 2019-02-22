import Utilities.User;

public class Test {

    private static User Andrew = new User("Andrew");
    private static User user1 = new User("user1");
    private static User user2 = new User("user2");
    private static User user3 = new User("user3");
    private static User user4 = new User("user4");
    private static User user5 = new User("user5");
    private static User user6 = new User("user6");
    private static User user7 = new User("user7");

    public static void updateAll() {
        Andrew.addTestFunc();
        user1.addTestFunc();
        user2.addTestFunc();
        user3.addTestFunc();
        user4.addTestFunc();
        user5.addTestFunc();
        user6.addTestFunc();
        user7.addTestFunc();
    }

    public static void main(String[] args) {

        Andrew.sendFriendRequest(user1);
        Andrew.sendFriendRequest(user2);
        Andrew.sendFriendRequest(user3);
        Andrew.sendFriendRequest(user4);
        user2.sendFriendRequest(user5);
        user2.sendFriendRequest(user1);
        user5.sendFriendRequest(user6);

        updateAll();

        // We should have all these printed out in the timeline.
        user1.postToTimeline("This is user1's first post!");
        user2.postToTimeline("This is user2's first post!");
        Andrew.postToTimeline("This is my first post!");
        Andrew.displayFeed();


        System.out.println("\n Testing the degrees of separation.");
        // We should get the numbers 1, 2, 3, -1.
        System.out.println(Andrew.degreesOfSeparation(user2));
        System.out.println(Andrew.degreesOfSeparation(user5));
        System.out.println(Andrew.degreesOfSeparation(user6));
        System.out.println(Andrew.degreesOfSeparation(user7));

        // We should now get 4 because we removed user2, which shortened the path
        System.out.println(Andrew.areFriends(user2));
        Andrew.removeFriend(user2);
        updateAll();
        System.out.println(Andrew.degreesOfSeparation(user6));
        System.out.println(Andrew.areFriends(user2));

        // Should get 3
        System.out.println(user6.degreesOfSeparation(Andrew));

        // Should get 1
        System.out.println(user4.degreesOfSeparation(Andrew));

        // Should get 3
        System.out.println(user1.degreesOfSeparation(user6));


        System.out.println("\n Test the timeline some more.");
        // We should now not see user2's post.
        System.out.println("\nAfter removing user2:");
        Andrew.postToTimeline("Hello everyone!");
        updateAll();
        Andrew.displayFeed();

        // Only see Andrew's, User1's, User2's post
        System.out.println("\nTesting out user1 timelines!");
        user1.displayFeed();

        // Only see Andrew's post
        System.out.println("\nTesting out user3 timelines!");
        user3.displayFeed();

        user4.postToTimeline("Hello! I am user4!");
        user5.postToTimeline("Hi, my name is user5. :)");

        Andrew.addTestFunc();
        user1.addTestFunc();
        user2.addTestFunc();
        user3.addTestFunc();
        user4.addTestFunc();
        user5.addTestFunc();
        user6.addTestFunc();
        user7.addTestFunc();

        // We should see Andrew, user1, user4 posts
        System.out.println("\nAndrew's feed after adding new posts.");
        Andrew.displayFeed();

        // Only see Andrew, user1, and user2 post
        System.out.println("\nTesting out user1 timelines!");
        user1.displayFeed();

        // See Andrew, and user3 post
        System.out.println("\nTesting out user3 timelines!");
        user3.displayFeed();
    }

}