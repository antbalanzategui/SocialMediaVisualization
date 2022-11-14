package prj5;

public class Influencer {
    
    private String username;
    private String channelName;
    private String country;
    private String mainTopic;
    private Engagement[] engagements;
    
    public Influencer(String user, String cName, String con, String mTop, Engagement[] eng) {
        this.username = user;
        this.channelName = cName;
        this.country = con;
        this.mainTopic = mTop;
        this.engagements = eng;
    }
    
    public String getUsername() {
        return username;
    }
    public String getChannelName() {
        return channelName;
    }
    public String getCountry() {
        return country;
    }
    public String getMainTopic() {
        return mainTopic;
    }
    public Engagement[] getEngagements() {
        return engagements;
    }
    public Engagement getEngagementForMonth(MonthEnum month) {
        for (int i = 0; i < engagements.length; i++) {
            if (engagements[i].getMonth() == month) {
                return engagements[i];
            }
        }
        return null;
    }
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
            return (username.equals(inf.username) &&
                channelName.equals(inf.channelName) &&
                country.equals(inf.country) &&
                mainTopic.equals(inf.mainTopic));
        }
        else {
            return false;
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Username: "+username+", ");
        sb.append("Channel Name: "+channelName+", ");
        sb.append("Country: "+country+", ");
        sb.append("Main Topic: "+mainTopic+", ");
        for (int i = 0; i < this.engagements.length; i++) {
            sb.append(engagements[i].toString());
        }
        return sb.toString();  
    }

}
