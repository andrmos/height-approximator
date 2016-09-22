package com.mossige.andre.heightapproximator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mossige.andre.heightapproximator.interfaces.MainView;
import com.mossige.andre.heightapproximator.interfaces.Presenter;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = "MainActivity";
    private Button button;
    private TextView heightText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Presenter presenter = new PresenterImpl(this);

        button = (Button) findViewById(R.id.button1);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // Pressed
                        Log.i(TAG, "onTouch: pressed");
                        presenter.onButtonPressed();
                        return true;
                    case MotionEvent.ACTION_UP:
                        // Released
                        Log.i(TAG, "onTouch: released");
                        presenter.onButtonReleased();
                        return true;
                }
                return false;
            }
        });

        heightText = (TextView) findViewById(R.id.heightText);

    }

    @Override
    public void updateTextView(String text) {
        heightText.setText(text);
    }
}
