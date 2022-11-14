package prj5;

import java.text.DecimalFormat;

/**
 * Class to hold data of Influencers for a certain month
 * 
 *Virginia Tech Honor Code Pledge:
 *As a Hokie, I will conduct myself with honor and integrity at all times.
 *I will not lie, cheat, or steal, 
 *nor will I accept the actions of those who do.
 * 
 * @author Antonio Balanzategui, antbalanzategui
 * 
 * @version 2022.11.13
 *
 */

public class Engagement {
    
    private MonthEnum month;
    private int numLikes;
    private int numPosts;
    private int numFollowers;
    private int numComments;
    private int numViews;
    
    /**
     * Constructor for Class
     * 
     * @param mon
     * month of engagement
     * 
     * @param likes
     * number of likes
     * 
     * @param posts
     * number of posts
     * 
     * @param followers
     * number of followers
     * 
     * @param comments
     * number of comments
     * 
     * @param views
     * number of views
     */
    public Engagement(MonthEnum mon, int likes, int posts, int followers, int comments, int views) {
        this.month = mon;
        this.numLikes = likes;
        this.numPosts = posts;
        this.numFollowers = followers;
        this.numComments = comments;
        this.numViews = views;
    }
    /**
     * Getter for month parameter
     * 
     * @return String of month
     */
    public MonthEnum getMonth() {
        return month;
    }
    /**
     * Getter for numLikes
     * 
     * @return number of likes
     */
    public int getNumLikes() {
        return numLikes;
    }
    /**
     * Getter for numPosts
     * 
     * @return number of posts
     */
    public int getNumPosts() {
        return numPosts;
    }
    /**
     * Getter for numFollowers
     * 
     * @return number of followers
     */
    public int getNumFollowers() {
        return numFollowers;
    }
    /**
     * Getter for numComments
     * 
     * @return number of comments
     */
    public int getNumComments() {
        return numComments;
    }
    /**
     * Getter for numViews
     * 
     * @return number of views
     */
    public int getNumViews() {
        return numViews;
    }
    /**
     * Calculates engagement rate based off of 
     * number of likes, comments, and followers
     * 
     * @return a percentage rounded to the first decimal
     */
    public double getTradEngagementRate() {
        double nLikes = numLikes;
        double nComments = numComments;
        double nFollowers = numFollowers;
        DecimalFormat df = new DecimalFormat("#.#");
        String engagementRate = df.format(((nLikes + nComments) / nFollowers) * 100);
        return (Double.valueOf(engagementRate));
    }
    /**
     * Calculates engagement rate based off of
     * number of likes, comments, and views
     * 
     * @return a percentage rounded to the first decimal
     */
    public double getReachEngagementRate() {
        double nLikes = numLikes;
        double nComments = numComments;
        double nViews = numViews;
        DecimalFormat df = new DecimalFormat("#.#");
        String engagementRate = df.format(((nLikes + nComments) / nViews) * 100);
        return (Double.valueOf(engagementRate));
    }
    /**
     * Checks to see whether "this" 
     * is equal to another object of Engagement
     * 
     * @param obj
     * object being compared to "this"
     * 
     * @return true if they are equal 
     * False otherwise
     */
    @Override
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
                this.numViews == eng.getNumViews() &&
                this.month.equals(eng.getMonth()));   
        }
        else {
            return false;
        }
    }
    /**
     * Method to convert data into a string
     * 
     * @return Parameters as a String
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Month: "+month+", ");
        sb.append("Number of Likes: "+numLikes+", ");
        sb.append("Number of Posts: "+numPosts+", ");
        sb.append("Number of Followers: "+numFollowers+", ");
        sb.append("Number of Comments: "+numComments+", ");
        sb.append("Number of Views: "+numViews);
        return sb.toString();
    }
    /**
     * Compares two objects of Engagement class to each other
     * using traditional engagement rate
     * 
     * @param o
     * object being compared to this
     * 
     * @return 1 if "this" rate is greater
     * -1 if "this" rate is smaller
     * 0 if both rates are the same
     */
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
    /**
     * Compares two objects of Engagement class to each other
     * using reach engagement rate
     * 
     * @param o
     * object being compared to this
     * 
     * @return 1 if "this" rate is greater
     * -1 if "this" rate is smaller
     * 0 if both rates are the same
     */
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
