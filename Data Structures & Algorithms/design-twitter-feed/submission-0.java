class Twitter {
    HashMap<Integer, ArrayList<Tweet>> userTweets = new HashMap<>();
    HashMap<Integer, HashSet<Integer>> following = new HashMap<>();
    int time = 0;
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userTweets.containsKey(userId)){
            userTweets.put(userId, new ArrayList<Tweet>());
        }
        userTweets.get(userId).add(new Tweet(tweetId, time++));
    }
    
public List<Integer> getNewsFeed(int userId) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> y[0] - x[0]);

    Set<Integer> feedUsers = new HashSet<>();
    if(following.containsKey(userId)){
        feedUsers.addAll(following.get(userId));
    }
    feedUsers.add(userId);

    for(int followeeId : feedUsers){
        ArrayList<Tweet> tweets = userTweets.get(followeeId);
        if(tweets == null || tweets.isEmpty()) continue;
        int last = tweets.size() - 1;
        Tweet t = tweets.get(last);
        pq.offer(new int[]{t.timestamp, t.id, followeeId, last});
    }

    List<Integer> feed = new ArrayList<>();
    while(!pq.isEmpty() && feed.size() < 10){
        int[] curr = pq.poll();
        feed.add(curr[1]);
        int nextIdx = curr[3] - 1;
        if(nextIdx >= 0){
            int followeeId = curr[2];
            Tweet t = userTweets.get(followeeId).get(nextIdx);
            pq.offer(new int[]{t.timestamp, t.id, followeeId, nextIdx});
        }
    }
    return feed;
}
    
    public void follow(int followerId, int followeeId) {
        if(!following.containsKey(followerId)){
            following.put(followerId, new HashSet<>());
        }
        following.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!following.containsKey(followerId)){
            following.put(followerId, new HashSet<>());
        }
        following.get(followerId).remove(followeeId);
    }
}
class Tweet{
    int id;
    int timestamp;
    public Tweet(int id, int timestamp){
        this.id = id;
        this.timestamp = timestamp;
    }

    
}
