// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
// -- Team

package prj5;

import cs2.*;
import cs2.Button;
import cs2.Shape;
import cs2.Window;

import java.awt.*;
import java.text.DecimalFormat;

/**
 * Project: P5 Social Media Visualization
 * Class: GUIWindow
 *
 * @author Lukyan Sukhachevskyi (lukyan)
 * @version 2022.11.14
 */
public class GUIWindow {

    private final Window window;

    private final DLinkedList list;

    //flags
    private MonthEnum month;
    private String engType;
    private String sortType;

    //labels
    private final TextShape monthLbl;
    private final TextShape engTypeLbl;
    private final TextShape sortTypeLbl;

    //dimensions
    private final int BAR_WIDTH = 40;
    private Shape gridShape;

    /**
     * Instantiates a new window.
     *
     * @param list the influencer list.
     */
    public GUIWindow(DLinkedList list) {

        //create a window
        window = new Window("Social Media Visualization");

        //initialize the list
        this.list = list;

        //setDefault
        month = MonthEnum.FIRSTQUART;
        monthLbl = new TextShape(10, 10, "First Quarter (Jan - March)");
        window.addShape(monthLbl);

        sortType = "Sort by Engagement Rate";
        sortTypeLbl = new TextShape(10, monthLbl.getY() + monthLbl.getHeight(), "Sort by Engagement Rate");
        window.addShape(sortTypeLbl);

        engType = "Traditional Engagement Rate";
        engTypeLbl = new TextShape(10, sortTypeLbl.getY() + sortTypeLbl.getHeight(), "Traditional Engagement Rate");
        window.addShape(engTypeLbl);

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

        //this is a rectangle shape which sets the dimensions for the bars
        gridShape = drawGrid();
        //initial visualization
        visualize();
    }


    /**
     * Helper method that uses flags (fields) to decide how to show data on
     * the screen.
     */
    private void visualize() {

        //remove the previous data from the screen
        window.removeAllShapes();
        //redraw the correct labels
        drawLabels();
        //redraw the grid
        drawGrid();

        //sort decision
        if (sortType.equals("Sort by Engagement Rate")) {

            list.sortByEngagement();
        }
        else {

            list.sortByName();
        }

        double engagementRate = 0.0;
        double maxEngagementRate = 0.0;

        //for loop determines max engagement rate based on sort type
        for (int i = 0; i < list.getLength(); i++) {

            Influencer influencer = list.getEntry(i);
            Engagement engagementForMonth =
                influencer.getEngagementForMonth(month);

            if (engagementForMonth != null) {

                if (engType.equals("Traditional Engagement Rate")) {

                    engagementRate = engagementForMonth.getTradEngagementRate();
                }
                else {

                    engagementRate =
                        engagementForMonth.getReachEngagementRate();
                }

                if(maxEngagementRate < engagementRate){

                    maxEngagementRate = engagementRate;
                }
            }
        }

        //for loop determines and draws the scale of the grid
        //adds the bars to the grid based on scale
        DecimalFormat engFmt = new DecimalFormat("#.#");
        for (int i = 0; i < list.getLength(); i++) {

            Influencer influencer = list.getEntry(i);
            Engagement engagementForMonth =
                influencer.getEngagementForMonth(month);

            //Engagement type decision for each influencer
            if (engagementForMonth != null) {

                if (engType.equals("Traditional Engagement Rate")) {

                    engagementRate = engagementForMonth.getTradEngagementRate();
                }
                else {

                    engagementRate =
                        engagementForMonth.getReachEngagementRate();
                }
            }

            double range = drawScale(maxEngagementRate);

            //scales the bars to the scale
            int barHeight = (int)((engagementRate / range) * ((double)gridShape.getHeight()));
            int barX = gridShape.getX() + BAR_WIDTH + (i * (gridShape.getWidth() / list.getLength())); //good
            int barY = gridShape.getY() + gridShape.getHeight() - barHeight;

            Shape bar = new Shape(barX, barY, BAR_WIDTH, barHeight, getColor());
            window.addShape(bar);
            window.moveToFront(bar);

            TextShape userLbl = new TextShape(0, 0, influencer.getUsername());
            userLbl.setX(barX + (BAR_WIDTH / 2) - (userLbl.getWidth() / 2));
            userLbl.setY(barY + barHeight + (userLbl.getHeight() / 2));
            window.addShape(userLbl);

            String engStr = engFmt.format(engagementRate);
            if (engagementRate == 0) {
                engStr = "N/A";
            }

            TextShape engLbl = new TextShape(0, 0, engStr);
            engLbl.setX(userLbl.getX() + (userLbl.getWidth() / 2) - (engLbl.getWidth() / 2));
            engLbl.setY(barY + barHeight + userLbl.getHeight() + (engLbl.getHeight() / 2));
            window.addShape(engLbl);
        }
    }

    private double drawScale(double maxEngagementRate){

        //decimal formatter
        DecimalFormat engFmt = new DecimalFormat("#.#");

        //counter for the grid line
        int count = 8;
        //for each position of the grid line i
        for (int i = gridShape.getY(); i <= gridShape.getY() + gridShape.getHeight(); i += 50) {

            //get each value for the grid line starting at the rounded up max
            //engagement value
            double lblVal = (Math.ceil(maxEngagementRate / 10.0) * 10.0 / 8.0) * count;
            count--;

            //create the label at correct positions
            TextShape gridLineLbl = new TextShape(0, 0, engFmt.format(lblVal));
            gridLineLbl.setX(gridShape.getX() - 15 - gridLineLbl.getWidth());
            gridLineLbl.setY(i - (gridLineLbl.getHeight() / 2));
            window.addShape(gridLineLbl);
        }

        return (Math.ceil(maxEngagementRate / 10.0) * 10.0 / 8.0) * 8;
    }

    private Shape drawGrid(){

        int numBars = list.getLength();

        //colors
        Color gridColor = new Color(0, 0, 0);
        Color gridLineColor = new Color(206, 206, 206);

        //grid
        int gridHeight = 400;
        int gridWidth = numBars * (BAR_WIDTH * 3);

        int upperBound = engTypeLbl.getY() + engTypeLbl.getHeight() + 10;
        int leftBound = (int)((((double)gridWidth) / 0.80 - ((double)gridWidth)) / 2);

        int lnW = 5; //line width

        //line array (for ease of drawing)
        Shape[] gridLines = new Shape[2];
        gridLines[0] = new Shape(leftBound, upperBound, lnW, gridHeight);  //y
        gridLines[1] = new Shape(leftBound, upperBound + gridHeight, gridWidth, lnW); //x

        //draw the lines
        for (Shape line : gridLines) {

            line.setBackgroundColor(gridColor);
            line.setForegroundColor(gridColor);
            window.addShape(line);
            window.moveToBack(line);
        }

        //draw the gridLines
        lnW = 2;
        for (int i = 0; i <= gridHeight; i += 50) {

            Shape gridLine = new Shape(leftBound - 10, upperBound + i, gridWidth + 10, lnW, gridLineColor);
            window.addShape(gridLine);
            window.moveToBack(gridLine);
        }

        //determine window size based on graph
        //last ints account for buttons
        int windowW = (leftBound * 2) + gridWidth + 211;
        int windowH = 50 + upperBound + gridHeight + 107; //50p is padding under
        window.setSize(windowW, windowH);

        //return the dimensions of the grid
        return new Shape(leftBound, upperBound, gridWidth, gridHeight);
    }

    private void drawLabels() {

        window.addShape(monthLbl);
        window.addShape(engTypeLbl);
        window.addShape(sortTypeLbl);
    }


    private Color getColor() {

        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);
        double luma = (0.2126 * r) + (0.7152 * g) + (0.0722 * b);

        while (luma < 75) {
            r = (int)(Math.random() * 256);
            g = (int)(Math.random() * 256);
            b = (int)(Math.random() * 256);
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

        sortType = button.getTitle();
        sortTypeLbl.setText(sortType);
        visualize();
    }


    /**
     * Displays the data for the button specified month.
     *
     * @param button month button
     */
    public void clickedMonth(Button button) {

        switch (button.getTitle()) {

            case "January":

                month = MonthEnum.JANUARY;
                break;
            case "February":

                month = MonthEnum.FEBRUARY;
                break;
            case "March":

                month = MonthEnum.MARCH;
                break;
            case "First Quarter (Jan - March)":

                month = MonthEnum.FIRSTQUART;
                break;
        }

        monthLbl.setText(button.getTitle());
        visualize();
    }


    /**
     * Calculates the engagement rate the button specified way.
     *
     * @param button engagement rate type button
     */
    public void clickedEngagementCalc(Button button) {

        engType = button.getTitle();
        engTypeLbl.setText(engType);
        visualize();
    }
}
