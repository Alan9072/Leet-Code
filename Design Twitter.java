class Twitter {
    int timeCtr;
    HashMap<Integer, HashSet<Integer>> followList;
    HashMap<Integer, List<Tweet>> tweetList;

    public class Tweet{
        int time;
        int tId;
        public Tweet(int tId,int time){
            this.time = time;
            this.tId = tId;
        }
    }

    public Twitter() {
        this.timeCtr = 0;
        followList = new HashMap<>();
        tweetList = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
         if (!tweetList.containsKey(userId)) {
            tweetList.put(userId, new ArrayList<>());
            tweetList.get(userId).add(new Tweet(tweetId,timeCtr++));
        } else {
            tweetList.get(userId).add(new Tweet(tweetId,timeCtr++));
        }
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a,b) ->b.time - a.time);
        Set<Integer> following = followList.getOrDefault(userId,new HashSet<>());
        following.add(userId);

        for(int user : following){
            List<Tweet> tweets = tweetList.getOrDefault(user,new ArrayList<>());
            for (Tweet tweet : tweets) {
                maxHeap.add(tweet);
            }
        }

        List<Integer> newsFeed = new ArrayList<>();
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            newsFeed.add(maxHeap.poll().tId);
            count++;
        }
        
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        if (!followList.containsKey(followerId)) {
            followList.put(followerId, new HashSet<>());
            followList.get(followerId).add(followeeId);
        } else {
            followList.get(followerId).add(followeeId);
        }

    }

    public void unfollow(int followerId, int followeeId) {
        if (followList.containsKey(followerId)) {
            followList.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
