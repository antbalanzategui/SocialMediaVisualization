// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Team

package prj5;

/**
 * Project: P5 Social Media Visualization
 * Class: Influencer
 *
 * Implementation of the Influencer class, to later
 * be stored within linked list
 *
 * @author Antonio Balanzategui (antbalanzategui)
 * @author Lukyan Sukhachevskyi (lukyan)
 * @author Nana Yaw Barimah Oteng (nanayawo21)
 * @version 2022.12.02
 */
public class Influencer {

    private final String username;
    private final String channelName;
    private final String country;
    private final String mainTopic;
    private Engagement[] engagements;


    /**
     * Constructor for the Influencer class
     *
     * @param username    user name of influencer
     * @param channelName channelName of influencer
     * @param country     country of influencer
     * @param mainTopic   mainTopic of influencer
     */
    public Influencer(
        String username, String channelName, String country, String mainTopic) {

        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.mainTopic = mainTopic;
    }


    /**
     * Getter for username
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }


    /**
     * Getter for channelName
     *
     * @return channelName
     */
    public String getChannelName() {
        return channelName;
    }


    /**
     * Getter for country
     *
     * @return country
     */
    public String getCountry() {
        return country;
    }


    /**
     * Getter for mainTopic
     *
     * @return mainTopic
     */
    public String getMainTopic() {
        return mainTopic;
    }


    /**
     * Getter for engagements
     *
     * @return engagements
     */
    public Engagement[] getEngagements() {
        return engagements;
    }


    /**
     * Setter for engagements
     *
     * @param engagements the engagement data for influencer.
     */
    public void setEngagements(Engagement[] engagements) {

        this.engagements = engagements;
    }


    /**
     * Method to find the engagment for a particular month
     * within our engagement array
     *
     * @param month month requested
     * @return the engagement of that particular month
     * null if month is not found
     */
    public Engagement getEngagementForMonth(MonthEnum month) {

        //first quarter case
        if (month == MonthEnum.FIRSTQUART) {

            return getFirstQuartEngagement();
        }

        //all other cases
        for (Engagement engagement : engagements) {

            if (engagement.getMonth() == month) {

                return engagement;
            }
        }

        //null if not found
        return null;
    }


    /**
     * Helper method that finds the engagement for the first quarter
     *
     * @return the engagement for the first quarter
     */
    private Engagement getFirstQuartEngagement() {

        //array representing the total stats of the influencer for first qtr
        int[] totalStats = { 0, 0, 0, 0, 0 };

        //for each of the first qtr months, sum the stats
        for (Engagement engagement : engagements) {

            if (engagement.getMonth().equals(MonthEnum.MARCH)
                || engagement.getMonth().equals(MonthEnum.FEBRUARY)
                || engagement.getMonth().equals(MonthEnum.JANUARY)) {

                totalStats[0] += engagement.getNumLikes();
                totalStats[1] += engagement.getNumPosts();
                totalStats[3] += engagement.getNumComments();
                totalStats[4] += engagement.getNumViews();
            }

            if (engagement.getMonth() == MonthEnum.MARCH) {

                //for first qtr followers, its the num of followers at
                //the end of March
                totalStats[2] = engagement.getNumFollowers();
            }
        }

        return new Engagement(MonthEnum.FIRSTQUART, totalStats[0],
            totalStats[1], totalStats[2], totalStats[3], totalStats[4]);
    }


    /**
     * Method used to get a specified type of engagement rate.
     *
     * @param month   the month of the engagement
     * @param engType the type of the engagement (Traditional or Reach)
     * @return the specified engagement rate calculation for that month
     */
    public double getEngagementRate(MonthEnum month, String engType) {

        if(this.getEngagementForMonth(month) == null){

            return 0;
        }

        if (engType.equals("Traditional Engagement Rate")) {

            return this.getEngagementForMonth(month).getTradEngagementRate();
        }
        else {

            return this.getEngagementForMonth(month).getReachEngagementRate();
        }
    }


    /**
     * Method to check equality of two influencer objects
     *
     * @param obj object of comparison to "this"
     * @return true if equal,
     * false otherwise
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
        Influencer inf = (Influencer)obj;

        //engagement array check
        if (inf.engagements.length != this.engagements.length) {

            return false;
        }

        //elements in engagement check
        for (int i = 0; i < engagements.length; i++) {

            if (!(engagements[i].equals(inf.engagements[i]))) {

                return false;
            }
        }

        //fields check
        return (username.equals(inf.username)
            && channelName.equals(inf.channelName)
            && country.equals(inf.country)
            && mainTopic.equals(inf.mainTopic));
    }


    /**
     * Method to display data of influencer
     * object as a string
     *
     * @return String of influencer object
     */
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append("[");
        str.append(username);
        str.append(", ");
        str.append(channelName);
        str.append(", ");
        str.append(country);
        str.append(", ");
        str.append(mainTopic);

        for (Engagement engagement : this.engagements) {
            str.append(", ");
            str.append(engagement.toString());
        }

        str.append("]");
        return str.toString();
    }
}
