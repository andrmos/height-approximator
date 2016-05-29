package com.mossige.andre.heightapproximator.interfaces;

/**
 * View interface responsible for updating the user interface of the main activity.
 *
 * Created by André on 29.05.2016.
 */
public interface MainView {

    /**
     * Updates the text of the TextView that displays the current calculated height.
     * @param text
     *          The text to be displayed.
     */
    void updateTextView(String text);

}
