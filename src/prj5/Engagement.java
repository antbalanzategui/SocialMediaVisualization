package prj5;

import java.text.DecimalFormat;


public class Engagement {
    
    private String month;
    private int numLikes;
    private int numPosts;
    private int numFollowers;
    private int numComments;
    private int numViews;
    
    public Engagement(String mon, int likes, int posts, int followers, int comments, int views) {
        this.month = mon;
        this.numLikes = likes;
        this.numPosts = posts;
        this.numFollowers = followers;
        this.numComments = comments;
        this.numViews = views;
    }
    public String getMonth() {
        return month;
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
    public double getTradEngagementRate() {
        double nLikes = numLikes;
        double nComments = numComments;
        double nFollowers = numFollowers;
        DecimalFormat df = new DecimalFormat("#.#");
        String engagementRate = df.format(((nLikes + nComments) / nFollowers) * 100);
        return (Double.valueOf(engagementRate));
    }
    public double getReachEngagementRate() {
        double nLikes = numLikes;
        double nComments = numComments;
        double nViews = numViews;
        DecimalFormat df = new DecimalFormat("#.#");
        String engagementRate = df.format(((nLikes + nComments) / nViews) * 100);
        return (Double.valueOf(engagementRate));
    }
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        else if (obj == this) {
            return true;
        }
        else if (obj.getClass() == this.getClass()) {
            Engagement eng = (Engagement)obj;
            return (this.numLikes == eng.getNumLikes() &&
                this.numPosts == eng.getNumPosts() && 
                this.numFollowers == eng.getNumFollowers() &&
                this.numComments == eng.getNumComments() &&
                this.numViews == eng.getNumViews());   
        }
        else {
            return false;
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Number of Likes: "+numLikes+", ");
        sb.append("Number of Posts: "+numPosts+", ");
        sb.append("Number of Followers: "+numFollowers+", ");
        sb.append("Number of Comments: "+numComments+", ");
        sb.append("Number of Views: "+numViews);
        return sb.toString();
    }
    public int compareTradEngagementRate(Engagement o) {
        if (this.getTradEngagementRate() > o.getTradEngagementRate()) {
            return 1;
        }
        else if (this.getTradEngagementRate() < o.getTradEngagementRate()) {
            return -1;
        }
        else {
            return 0;
        }
    }
    public int compareReachEngagementRate(Engagement o) {
        if (this.getReachEngagementRate() > o.getReachEngagementRate()) {
            return 1;
        }
        else if (this.getReachEngagementRate() < o.getReachEngagementRate()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
