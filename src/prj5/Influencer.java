package prj5;

/**
 * Implementation of the Influencer class, to later
 * be stored within linked list
 * 
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself with honor and integrity at all times.
 * I will not lie, cheat, or steal,
 * nor will I accept the actions of those who do.
 * 
 * @author Antonio Balanzategui, antbalanzategui
 * 
 * @version 2022.11.14
 *
 */
public class Influencer {

    private String username;
    private String channelName;
    private String country;
    private String mainTopic;
    private Engagement[] engagements;

    /**
     * Constructor for the Influencer class
     * 
     * @param user
     *            username of influencer
     * 
     * @param cName
     *            channelName of influencer
     * 
     * @param con
     *            country of influencer
     * 
     * @param mTop
     *            mainTopic of influencer
     */
    public Influencer(String user, String cName, String con, String mTop) {
        this.username = user;
        this.channelName = cName;
        this.country = con;
        this.mainTopic = mTop;
    }


    /**
     * Getter for User name
     * 
     * @return user name
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
     * Setter for engagements
     *
     * @param engagements
     *            the engagement data for influencer.
     */
    public void setEngagements(Engagement[] engagements) {

        this.engagements = engagements;
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
     * Method to find the engagment for a particular month
     * within our engagement array
     * 
     * @param month
     *            month requested
     * 
     * @return the engagement of that particular month
     *         null if month is not found
     */
    public Engagement getEngagementForMonth(MonthEnum month) {
        for (int i = 0; i < engagements.length; i++) {
            if (engagements[i].getMonth() == month) {
                return engagements[i];
            }
        }
        return null;
    }


    /**
     * Method to check equality of
     * two influencer objects
     * 
     * @param obj
     *            object of comparison to "this"
     * 
     * @return true if equal,
     *         false otherwise
     * 
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        else if (obj.getClass() == this.getClass()) {
            Influencer inf = (Influencer)obj;
            if (inf.engagements.length != this.engagements.length) {
                return false;
            }
            for (int i = 0; i < engagements.length; i++) {
                if (!(engagements[i].equals(inf.engagements[i]))) {
                    return false;
                }
            }
            return (username.equals(inf.username) && channelName.equals(
                inf.channelName) && country.equals(inf.country) && mainTopic
                    .equals(inf.mainTopic));
        }
        else {
            return false;
        }
    }


    /**
     * Method to display data of influencer
     * object as a string
     * 
     * @return String of influencer object
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Username: " + username + ", ");
        sb.append("Channel Name: " + channelName + ", ");
        sb.append("Country: " + country + ", ");
        sb.append("Main Topic: " + mainTopic + ", ");
        for (int i = 0; i < this.engagements.length; i++) {
            sb.append(engagements[i].toString());
        }
        return sb.toString();
    }

}
