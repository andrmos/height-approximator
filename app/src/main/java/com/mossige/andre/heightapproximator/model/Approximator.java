package com.mossige.andre.heightapproximator.model;

/**
 * A height calculator that calculates the approximate height of an object in meters, by using the time which a rock takes to be dropped from the top of the object.
 * Uses the calculations described here: http://calculus-geometry.hubpages.com/hub/How-to-Find-the-Depth-of-a-Well-by-Dropping-a-Rock
 *
 * Created by André on 24.05.2016.
 */
public class Approximator {

    /** The current approximated height in meters */
    private double height;
    /** The start time of the calculation */
    private long startTime;
    /** True if the calculation has started */
    private boolean started;

    public Approximator() {
        height = 0.0;
    }

    /**
     * Starts the approximator at the current time.
     */
    public void start() {
        startTime = System.currentTimeMillis();
        started = true;
    }

    /**
     * Stops the approximator.
     */
    public void stop() {
        started = false;
    }

    /**
     * Returns the approximated height.
     * If the calculation has started, the new height value is calculated.
     * @return
     *      The approximated height in meters.
     */
    public double getHeight() {
        if (started) {
            calculateHeight();
        }
        return height;
    }

    /**
     * Calculates the approximated height in meters, based on current time.
     */
    private void calculateHeight() {
        double endTime = System.currentTimeMillis();
        double totalTime = (endTime - startTime) / 1000.0;
        height = 340.29 * totalTime + 11816.05 - Math.sqrt(8041766.9 * totalTime + 139619023.38);
    }
}
