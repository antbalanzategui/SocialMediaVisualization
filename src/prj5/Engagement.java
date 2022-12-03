// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Team

package prj5;

import java.text.DecimalFormat;

/**
 * Project: P5 Social Media Visualization
 * Class: Engagement
 *
 * Class to hold the Engagement data of Influencers for a certain month
 *
 * @author Lukyan Sukhachevskyi (lukyan)
 * @author Antonio Balanzategui (antbalanzategui)
 * @version 2022.12.02
 */

public class Engagement {

    private final MonthEnum month;
    private final int numLikes;
    private final int numPosts;
    private final int numFollowers;
    private final int numComments;
    private final int numViews;


    /**
     * Constructor for Class
     *
     * @param mon       month of engagement
     * @param likes     number of likes
     * @param posts     number of posts
     * @param followers number of followers
     * @param comments  number of comments
     * @param views     number of views
     */
    public Engagement(
        MonthEnum mon,
        int likes,
        int posts,
        int followers,
        int comments,
        int views) {
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

        if (numFollowers == 0) {

            return -1.0;
        }

        DecimalFormat df = new DecimalFormat("#.#");
        String engagementRate =
            df.format((getTotalEngagement() / numFollowers) * 100.0);
        return (Double.parseDouble(engagementRate));
    }


    /**
     * Calculates engagement rate based off of
     * number of likes, comments, and views
     *
     * @return a percentage rounded to the first decimal
     */
    public double getReachEngagementRate() {

        if (numViews == 0) {

            return -1.0;
        }

        DecimalFormat df = new DecimalFormat("#.#");
        String engagementRate =
            df.format((getTotalEngagement() / numViews) * 100.0);
        return (Double.parseDouble(engagementRate));
    }


    /**
     * Helper method for calculation of EngagementRates
     *
     * @return totalEngagement (likes + comments)
     */
    private double getTotalEngagement() {

        return this.numComments + this.numLikes;
    }


    /**
     * Checks to see whether "this"
     * is equal to another object of Engagement
     *
     * @param obj object being compared to "this"
     * @return true if they are equal, false otherwise
     */
    @Override public boolean equals(Object obj) {

        //null check
        if (obj == null) {

            return false;
        }

        //self check
        if (this == obj) {

            return true;
        }

        //type check
        if (obj.getClass() != this.getClass()) {

            return false;
        }

        //cast
        Engagement eng = (Engagement)obj;

        //fields check
        return (this.numLikes == eng.getNumLikes() && this.numPosts == eng
            .getNumPosts() && this.numFollowers == eng.getNumFollowers()
            && this.numComments == eng.getNumComments() && this.numViews == eng
            .getNumViews() && this.month.equals(eng.getMonth()));

    }


    /**
     * Method to convert data into a string
     *
     * @return Parameters as a String
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(month);
        sb.append(", ");
        sb.append(numLikes);
        sb.append(", ");
        sb.append(numPosts);
        sb.append(", ");
        sb.append(numFollowers);
        sb.append(", ");
        sb.append(numComments);
        sb.append(", ");
        sb.append(numViews);
        sb.append("]");
        return sb.toString();
    }
}
