package com.mossige.andre.heightapproximator.interfaces;

/**
 * Presenter interface responsible for handling the communication between the views and the models.
 *
 * Created by André on 29.05.2016.
 */
public interface Presenter {

    /**
     * Called when the button that interacts with the approximator is pressed.
     */
    void onButtonPressed();

    /**
     * Called when the button that interacts with the approximator is released.
     */
    void onButtonReleased();


    double getHeight();

    // TODO: 29.05.2016 Add activity lifecycle methods.

}
