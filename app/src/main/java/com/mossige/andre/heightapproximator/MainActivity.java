package com.mossige.andre.heightapproximator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mossige.andre.heightapproximator.interfaces.MainView;
import com.mossige.andre.heightapproximator.interfaces.Presenter;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = "MainActivity";
    private static final int UPDATE_INTERVAL_MILLIS = 50;

    private TextView heightText;
    private Presenter presenter;
    private Thread updateThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new PresenterImpl(this);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Pressed
                        presenter.onButtonPressed();
                        updateThread.start();

                        return true;
                    case MotionEvent.ACTION_UP:
                        // Released
                        presenter.onButtonReleased();
                        updateThread.interrupt();

                        createUpdateThread();
                        return true;
                }
                return false;
            }
        });

        heightText = (TextView) findViewById(R.id.heightText);

        createUpdateThread();
    }

    @Override
    public void updateTextView(String text) {
        heightText.setText(text);
    }

    private void createUpdateThread() {
        updateThread = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(UPDATE_INTERVAL_MILLIS);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updateTextView("" + presenter.getHeight());
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    // Stopped
                }
            }
        };
    }

}
