package com.example.me.cmsc434doodler;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

import java.lang.Math;

public class MainActivity extends AppCompatActivity {

    private DoodleView doodleView;

    private ImageButton black;
    private ImageButton red;
    private ImageButton yellow;
    private ImageButton green;

    private ImageButton blue;
    private ImageButton magenta;
    private ImageButton cyan;

    private ImageButton one;
    private ImageButton two;
    private ImageButton three;
    private ImageButton four;
    private ImageButton five;
    private ImageButton six;
    private ImageButton seven;


    private ImageButton undoButton;
    private ImageButton clearButton;
    private ImageButton redoButton;

    private SeekBar sizeStroke;
    private SeekBar opacity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        doodleView = (DoodleView)findViewById(R.id.doodle);

        //row one
        black = (ImageButton) findViewById(R.id.Black);
        red = (ImageButton) findViewById(R.id.Red);
        yellow = (ImageButton) findViewById(R.id.Yellow);
        green = (ImageButton) findViewById(R.id.Green);
        blue = (ImageButton) findViewById(R.id.Blue);
        cyan = (ImageButton) findViewById(R.id.Cyan);
        magenta = (ImageButton) findViewById(R.id.Magenta);

        //row two
        one = (ImageButton) findViewById(R.id.one);
        two = (ImageButton) findViewById(R.id.two);
        three = (ImageButton) findViewById(R.id.three);
        four = (ImageButton) findViewById(R.id.four);
        five = (ImageButton) findViewById(R.id.five);
        six  = (ImageButton) findViewById(R.id.six);
        seven = (ImageButton) findViewById(R.id.seven);


        undoButton = (ImageButton) findViewById(R.id.undo);
        redoButton = (ImageButton) findViewById(R.id.redo);
        clearButton = (ImageButton) findViewById(R.id.clear);

        sizeStroke = (SeekBar) findViewById(R.id.sizeSeek);
        opacity = (SeekBar) findViewById(R.id.opacity);

        opacity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                doodleView.changeAlpha(Math.abs(value - 255));
            }
        });

        sizeStroke.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            float value = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                doodleView.changeStroke(value);

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doodleView.clear();
            }
        });


        undoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doodleView.undo();
            }
        });

        redoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doodleView.redo();
            }
        });


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int color = Color.parseColor("#FF44FF");

                doodleView.changeColor(color);

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int color = Color.parseColor("#FF8888");

                doodleView.changeColor(color);

            }
        });

         three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int color = Color.parseColor("#FF1212");

                doodleView.changeColor(color);

            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int color = Color.parseColor("#FF660000");

                doodleView.changeColor(color);

            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int color = Color.parseColor("#FF787878");

                doodleView.changeColor(color);

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int color = Color.parseColor("#FFFF6666");

                doodleView.changeColor(color);

            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int color = Color.parseColor("#FF990099");

                doodleView.changeColor(color);

            }
        });



        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doodleView.changeColor(Color.RED);

            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doodleView.changeColor(Color.GREEN);

            }
        });

        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doodleView.changeColor(Color.YELLOW);

            }
        });

        black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doodleView.changeColor(Color.BLACK);

            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doodleView.changeColor(Color.BLUE);

            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doodleView.changeColor(Color.GREEN);

            }
        });

        magenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doodleView.changeColor(Color.MAGENTA);

            }
        });

        cyan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doodleView.changeColor(Color.CYAN);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
