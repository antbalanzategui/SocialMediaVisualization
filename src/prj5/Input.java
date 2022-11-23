// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Team

package prj5;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

/**
 * Project Runner.
 *
 * @author Nana Yaw Barimah Oteng (nanayawo21)
 * @version 2022.11.18
 */
public class Input {

    public Input() {
        // TODO Auto-generated constructor stub
    }


    /**
     * Driver code for the socialmediavisualization project.
     *
     * @param args is the array parameter containing an input file.
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        DataReader man = new DataReader("SampleInput1_2022.csv");
        if (args.length == 1) {
            man = new DataReader(args[0]);
        }
        man.getList().sortByName();

        for (int i = 0; i < man.getList().toArray().length; i++) {
            int janTotalEng = 0;
            int marchTotalEng =
                man.getList().getEntry(i).getEngagementForMonth(MonthEnum.MARCH)
                    .getTotalEngagement();

            int febTotalEng = man.getList().getEntry(i)
                .getEngagementForMonth(MonthEnum.FEBRUARY).getTotalEngagement();

            if (man.getList().getEntry(i)
                .getEngagementForMonth(MonthEnum.JANUARY) != null) {
                janTotalEng = man.getList().getEntry(i)
                    .getEngagementForMonth(MonthEnum.JANUARY)
                    .getTotalEngagement();
            }

            double totalEng = marchTotalEng + febTotalEng + janTotalEng;
            double followers =
                man.getList().getEntry(i).getEngagementForMonth(MonthEnum.MARCH)
                    .getNumFollowers();

            if (followers != 0) {
                double tradRate = (totalEng / followers) * 100;
                System.out.println(man.getList().getEntry(i).getChannelName());
                System.out.println("traditional: " + new DecimalFormat("#.#")
                    .format(tradRate));

            }
            else {
                System.out.println(man.getList().getEntry(i).getChannelName());
                System.out.println("traditional: N/A");

            }
            System.out.println("==========");
        }
        System.out.println("**********");
        System.out.println("**********");

        /*
         * System.out.println(Arrays.toString(man.getList().toArray()));
         * System.out.println(man.getList().getEntry(0).getEngagementForMonth(
         * MonthEnum.MARCH));
         */
        man.getList().sortByEngagement();
        for (int i = 0; i < man.getList().toArray().length; i++) {
            int janTotalEng1 = 0;
            int janTotalViews = 0;

            int marchTotalEng =
                man.getList().getEntry(i).getEngagementForMonth(MonthEnum.MARCH)
                    .getTotalEngagement();

            int febTotalEng = man.getList().getEntry(i)
                .getEngagementForMonth(MonthEnum.FEBRUARY).getTotalEngagement();

            if (man.getList().getEntry(i)
                .getEngagementForMonth(MonthEnum.JANUARY) != null) {
                janTotalEng1 = man.getList().getEntry(i)
                    .getEngagementForMonth(MonthEnum.JANUARY)
                    .getTotalEngagement();
            }

            int marchTotalViews =
                man.getList().getEntry(i).getEngagementForMonth(MonthEnum.MARCH)
                    .getNumViews();

            int febTotalViews = man.getList().getEntry(i)
                .getEngagementForMonth(MonthEnum.FEBRUARY).getNumViews();

            if (man.getList().getEntry(i)
                .getEngagementForMonth(MonthEnum.JANUARY) != null) {
                janTotalViews = man.getList().getEntry(i)
                    .getEngagementForMonth(MonthEnum.JANUARY).getNumViews();
            }

            double totalEng = marchTotalEng + febTotalEng + janTotalEng1;
            double totalViews = marchTotalViews + febTotalViews + janTotalViews;
            double tradRate = (totalEng / totalViews) * 100;

            System.out.println(man.getList().getEntry(i).getChannelName());
            System.out
                .println("reach: " + new DecimalFormat("#.#").format(tradRate));
            System.out.println("==========");

        }
    }

}
