package com.mossige.andre.heightapproximator;

import com.mossige.andre.heightapproximator.interfaces.MainView;
import com.mossige.andre.heightapproximator.interfaces.Presenter;
import com.mossige.andre.heightapproximator.model.Approximator;

/**
 * Created by andre on 22.07.16.
 */
public class PresenterImpl implements Presenter {


    private static final String TAG = "Presenter";
    private MainView mainActivity;
    private Approximator approximator;

    public PresenterImpl(MainView mainActivity) {
        this.mainActivity = mainActivity;
        this.approximator = new Approximator();
    }


    @Override
    public void onButtonPressed() {
        approximator.start();
    }

    @Override
    public void onButtonReleased() {
        approximator.stop();
    }

    @Override
    public double getHeight() {
        return approximator.getHeight();
    }
}
