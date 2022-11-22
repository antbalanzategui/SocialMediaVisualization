// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of 
// those who do.
// -- Lukyan Sukhachevskyi (lukyan)

package prj5;

import cs2.*;
import cs2.Button;
import cs2.Shape;
import cs2.Window;

import java.awt.*;
import java.util.Random;

/**
 * Project: P5 Social Media Visualization
 * Class: GUIWindow
 *
 * @author Lukyan Sukhachevskyi (lukyan)
 * @version 2022.11.14
 */
public class GUIWindow {

    private final Window window;

    private DLinkedList list;

    private MonthEnum month;
    private Shape monthLbl;
    private Shape engagementTypeLbl;
    private Shape sortTypeLbl;


    public GUIWindow(DLinkedList list) {

        //create a window
        window = new Window("Social Media Visualization");
        window.setSize(960, 540);

        //initialize the list
        this.list = list;

        //*************** create buttons *******************\\

        //Sort By Channel Button
        Button sortNameBtn = new Button("Sort by Channel Name");
        sortNameBtn.onClick(this, "clickedSort");
        window.addButton(sortNameBtn, WindowSide.NORTH);

        //Sort By Engagement Button
        Button sortEngBtn = new Button("Sort by Engagement Rate");
        sortEngBtn.onClick(this, "clickedSort");
        window.addButton(sortEngBtn, WindowSide.NORTH);

        //Quit Button
        Button quitBtn = new Button("Quit");
        quitBtn.onClick(this, "clickedQuit");
        window.addButton(quitBtn, WindowSide.NORTH);

        //January Button
        Button janBtn = new Button("January");
        janBtn.onClick(this, "clickedMonth");
        window.addButton(janBtn, WindowSide.SOUTH);

        //February Button
        Button febBtn = new Button("February");
        febBtn.onClick(this, "clickedMonth");
        window.addButton(febBtn, WindowSide.SOUTH);

        //March Button
        Button marBtn = new Button("March");
        marBtn.onClick(this, "clickedMonth");
        window.addButton(marBtn, WindowSide.SOUTH);

        //First Quarter Button
        Button frstQrtBtn = new Button("First Quarter (Jan - March)");
        frstQrtBtn.onClick(this, "clickedMonth");
        window.addButton(frstQrtBtn, WindowSide.SOUTH);

        //Traditional Engagement Rate Button
        Button tradEngBtn = new Button("Traditional Engagement Rate");
        tradEngBtn.onClick(this, "clickedEngagementCalc");
        window.addButton(tradEngBtn, WindowSide.WEST);

        //Traditional Engagement Rate Button
        Button reachEngBtn = new Button("Reach Engagement Rate");
        reachEngBtn.onClick(this, "clickedEngagementCalc");
        window.addButton(reachEngBtn, WindowSide.WEST);
        //**************************************************\\


        month = MonthEnum.JANUARY;
    }

                            //data month     trad or reach      //eng or name
    private void visualize(MonthEnum month, String engType, String sortType){

        if(sortType.equals("Sort by Engagement Rate")){

            list.sortByEngagement();
        }else{

            list.sortByName();
        }

        double engagement = -1.0;

        for(int i = 0; i < list.getLength(); i++) {

            if(engType.equals("Traditional Engagement Rate")) {

                engagement = list.getEntry(i).getEngagementForMonth(month).getTradEngagementRate();
            }else{

                engagement = list.getEntry(i).getEngagementForMonth(month).getReachEngagementRate();
            }

            int winX = window.getGraphPanelWidth();
            int winY = window.getGraphPanelHeight();

            final int BAR_SCALE = 20;
            final int BAR_WIDTH = 40;

            Shape bar = new Shape(60 + i * ((winX / 4) / list.getLength()), winY * 2 / 3, BAR_WIDTH, (int)(engagement * BAR_SCALE), getColor());
        }
    }

    private Color getColor() {

        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);
        double luma = (0.2126 * r) + (0.7152 * g) + (0.0722 * b);

        while (luma < 75) {
            r = (int)(Math.random()*256);
            g = (int)(Math.random()*256);
            b = (int)(Math.random()*256);
            luma = (0.2126 * r) + (0.7152 * g) + (0.0722 * b);
        }
        return new Color(r, g, b);
    }


    /**
     * Quit button exits application.
     *
     * @param button the quit button
     */
    public void clickedQuit(Button button) {

        System.exit(0);
        //System exit with 0 errors.
    }


    /**
     * Sorts the list the user defined way.
     *
     * @param button the sort by engagement rate btn, or sort by name btn
     */
    public void clickedSort(Button button) {

        switch (button.getTitle()) {

            case "Sort by Engagement Rate":

                //TODO: Implement
                break;
            case "Sort by Channel Name":

                //TODO: Implement
                break;
        }
    }


    /**
     * Displays the data for the button specified month.
     *
     * @param button month button
     */
    public void clickedMonth(Button button) {

        switch (button.getTitle()) {

            case "January":

                //TODO: Implement
                break;
            case "February":

                //TODO: Implement
                break;
            case "March":

                //TODO: Implement
                break;
            case "First Quarter (Jan - March)":

                //TODO: Implement
                break;
        }
    }


    /**
     * Calculates the engagement rate the button specified way.
     *
     * @param button engagement rate type button
     */
    public void clickedEngagementCalc(Button button) {

        switch (button.getTitle()) {

            case "Traditional Engagement Rate":

                //TODO: Implement
                break;
            case "Reach Engagement Rate":

                //TODO: Implement
                break;
        }
    }
}
