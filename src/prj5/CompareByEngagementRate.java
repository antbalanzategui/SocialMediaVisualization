// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of 
// those who do.
// -- Lukyan Sukhachevskyi (lukyan)

package prj5;

import java.util.Comparator;

/**
 * Project: socialmediavisualization
 * Class: CompareByEngagementRate
 *
 * @author Lukyan Sukhachevskyi (lukyan)
 * @version 2022.12.02
 */
public class CompareByEngagementRate implements Comparator<Influencer> {

    private MonthEnum month;
    private String engType;

    public CompareByEngagementRate(MonthEnum month, String engType){

        this.month = month;
        this.engType = engType;
    }
    /**
     * Compares its two arguments for order.  Returns a negative integer,
     * zero, or a positive integer as the first argument is less than, equal
     * to, or greater than the second.
     *
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return a negative integer, zero, or a positive integer as the
     * first argument is less than, equal to, or greater than the
     * second.
     * @throws NullPointerException if an argument is null and this
     *                              comparator does not permit null arguments
     * @throws ClassCastException   if the arguments' types prevent them from
     *                              being compared by this comparator.
     */
    @Override public int compare(Influencer o1, Influencer o2) {

        if (o1 == null || o2 == null) {

            throw new NullPointerException(
                "The object being compared is null.");
        }

        //type check
        if (o1.getClass() != Influencer.class
            || o2.getClass() != Influencer.class) {

            throw new ClassCastException(
                "The object being compared is not of type Influencer.");
        }

        return (int)(o1.getEngagementRate(month, engType)) -
              (int)((o2.getEngagementRate(month, engType)));
    }
}
