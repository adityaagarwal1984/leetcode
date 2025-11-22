class Twitter {

    List<int[]> tweets; // [userId, tweetId]
    Map<Integer, Set<Integer>> follows;

    public Twitter() {
        tweets = new ArrayList<>();
        follows = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.add(new int[]{userId, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> news = new ArrayList<>();
        Set<Integer> set = follows.getOrDefault(userId, new HashSet<>());
        
        // user follows themselves
        set.add(userId);

        // Traverse from last => latest tweets first
        for(int i = tweets.size() - 1; i >= 0 && news.size() < 10; i--) {
            int[] t = tweets.get(i);
            if(set.contains(t[0])) {
                news.add(t[1]);
            }
        }
        return news;
    }

    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(follows.containsKey(followerId) && followerId != followeeId) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
