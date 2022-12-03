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
     * @param args
     *            is the array parameter containing an input file.
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        DataReader man;
        if (args.length == 1) {
            man = new DataReader(args[0]);
        }else{

            man = new DataReader("SampleInput1_2022.csv");
        }
        /*man.getList().sort(new CompareByChannelName());

        for (int i = 0; i < man.getList().toArray().length; i++) {
            double followers = man.getList().getEntry(i).getEngagementForMonth(
                MonthEnum.MARCH).getNumFollowers();

            if (followers != 0) {
                System.out.println(man.getList().getEntry(i).getChannelName());
                System.out.println("traditional: " + new DecimalFormat("#.#")
                    .format(man.getList().getEntry(i).getFirstQuartEngagement()
                        .getTradEngagementRate()));

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
        
        /*man.getList().sort(new CompareByEngagementRate(MonthEnum.FIRSTQUART, "Reach Engagement Rate"));
        for (int i = 0; i < man.getList().toArray().length; i++) {

            System.out.println(man.getList().getEntry(i).getChannelName());
            System.out.println("reach: " + new DecimalFormat("#.#").format(
                man.getList().getEntry(i).getFirstQuartEngagement().getReachEngagementRate()));
            System.out.println("==========");

        }*/
    }

}
