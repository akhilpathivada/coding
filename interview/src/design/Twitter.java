/**
 * author: akhilpathivada
 * time: 20/05/24 15:44
 */
package design;

import java.util.*;

public class Twitter {

    private final List<Tweet> tweets;

    private final Map<Integer, User> users;

    private static final class User {

        private final int userId;

        private final Set<Integer> follows;

        private User(int userId) {
            this.userId = userId;
            this.follows = new HashSet<>();
        }
    }

    private static final class Tweet {

        private final int userId;

        private final int tweetId;

        private Tweet(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    public Twitter() {
        tweets = new ArrayList<>();
        users = new HashMap<>();
    }

    private void addUser(int userId) {
        users.put(userId, new User(userId));
    }

    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            addUser(userId);
        }
        tweets.add(new Tweet(userId, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId)) {
            addUser(userId);
        }
        List<Integer> newsFeed = new ArrayList<>();
        for (int i = tweets.size() - 1; i >= 0 && newsFeed.size() < 10; --i) {
            int tweetUserId = tweets.get(i).userId;
            int tweetId = tweets.get(i).tweetId;
            if (tweetUserId == userId || users.get(userId).follows.contains(tweetUserId)) {
                newsFeed.add(tweetId);
            }
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            addUser(followerId);
        }
        if (!users.containsKey(followeeId)) {
            addUser(followeeId);
        }
        users.get(followerId).follows.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            addUser(followerId);
        }
        if (!users.containsKey(followeeId)) {
            addUser(followeeId);
        }
        users.get(followerId).follows.remove(followeeId);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
    }
}
