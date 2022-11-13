package prj5;



public class Engagement implements Comparable {
    
    private int numLikes;
    private int numPosts;
    private int numFollowers;
    private int numComments;
    private int numViews;
    
    public Engagement(int likes, int posts, int followers, int comments, int views) {
        this.numLikes = likes;
        this.numPosts = posts;
        this.numFollowers = followers;
        this.numComments = comments;
        this.numViews = views;
    }
    public int getNumLikes() {
        return numLikes;
    }
    public int getNumPosts() {
        return numPosts;
    }
    public int getNumFollowers() {
        return numFollowers;
    }
    public int getNumComments() {
        return numComments;
    }
    public int getNumViews() {
        return numViews;
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
