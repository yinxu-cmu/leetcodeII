package heap.medium;

import java.util.*;

public class _355_Design_Twitter {
    /**
     *  Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
     *
     * postTweet(userId, tweetId): Compose a new tweet.
     * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     * follow(followerId, followeeId): Follower follows a followee.
     * unfollow(followerId, followeeId): Follower unfollows a followee.
     * Example:
     *
     * Twitter twitter = new Twitter();
     *
     * // User 1 posts a new tweet (id = 5).
     * twitter.postTweet(1, 5);
     *
     * // User 1's news feed should return a list with 1 tweet id -> [5].
     * twitter.getNewsFeed(1);
     *
     * // User 1 follows user 2.
     * twitter.follow(1, 2);
     *
     * // User 2 posts a new tweet (id = 6).
     * twitter.postTweet(2, 6);
     *
     * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
     * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
     * twitter.getNewsFeed(1);
     *
     * // User 1 unfollows user 2.
     * twitter.unfollow(1, 2);
     *
     * // User 1's news feed should return a list with 1 tweet id -> [5],
     * // since user 1 is no longer following user 2.
     * twitter.getNewsFeed(1);
     */

    /**
     * 傻逼题。
     * 各种条件不明。
     * 注意各种null pointer就行了。
     */
    class Twitter {

        Map<Integer, User> map;
        int time = 0;

        class User {
            int userId;
            List<Tweet> tweets;
            List<User> followees;
            public User(int userId) {
                this.userId = userId;
                tweets = new ArrayList<>();
                followees = new ArrayList<>();
            }
            public void postTweet(int tweetId) {
                tweets.add(0, new Tweet(tweetId, this));
            }
            public List<Tweet> getNewsFeed() {
                List<Tweet> res = new ArrayList<>();
                PriorityQueue<Tweet> q = new PriorityQueue<>((a, b) -> {
                    //if (1,2), return > 0
                    return b.timestamp - a.timestamp;
                });
                if (tweets.size() > 0) q.offer(tweets.get(0));
                for (User user : followees) {
                    if (user.tweets.size() > 0) q.offer(user.tweets.get(0));
                }
                int size = 10;
                while (size > 0) {
                    if (!q.isEmpty()) {
                        Tweet t = q.poll();
                        size--;
                        res.add(t);
                        User tu = t.user;
                        int index = tu.tweets.indexOf(t);
                        if (index == t.user.tweets.size() - 1) continue;
                        q.offer(t.user.tweets.get(index + 1));
                    } else {
                        break;
                    }
                }
                return res;
            }
            public void follow(int followeeId) {
                if (followeeId == userId) return;
                User f = map.get(followeeId);
                if (!followees.contains(f)) followees.add(f);
            }

            public void unfollow(int followeeId) {
                User f = map.get(followeeId);
                followees.remove(f);
            }
        }

        class Tweet {
            int id;
            User user;
            int timestamp;
            public Tweet(int id, User user) {
                this.id = id;
                this.user = user;
                this.timestamp = time++;
            }
        }

        /** Initialize your data structure here. */
        public Twitter() {
            map = new HashMap<>();
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            User u = map.get(userId);
            if (u == null) {
                u = new User(userId);
                map.put(userId, u);
            }
            u.postTweet(tweetId);
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            if (map.get(userId) == null) map.put(userId, new User(userId));
            User u = map.get(userId);
            List<Tweet> list = u.getNewsFeed();
            List<Integer> res = new ArrayList<>();
            list.stream().forEach(t -> res.add(t.id));
            return res;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {
            if (map.get(followerId) == null) map.put(followerId, new User(followerId));
            if (map.get(followeeId) == null) map.put(followeeId, new User(followeeId));
            map.get(followerId).follow(followeeId);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if (map.get(followerId) == null) map.put(followerId, new User(followerId));
            if (map.get(followeeId) == null) map.put(followeeId, new User(followeeId));
            User u = map.get(followerId);
            u.unfollow(followeeId);
        }
    }
}
