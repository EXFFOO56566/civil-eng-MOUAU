package com.tochycomputerservices.civilengtools2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Copyright 2022 Eze-Odikwa Tochukwu jed
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

public class SplashScreen extends AppCompatActivity {

    ProgressBar pb;
    int counter = 0;


    //After completion of 10000 ms, the next activity will get started.
    private static int SPLASH_SCREEN_TIME_OUT = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //This method is used so that your splash activity
        //can cover the entire screen.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //Intent is used to switch from one activity to another.
                Intent i = new Intent(SplashScreen.this,
                        MainActivity.class);

                //invoke the SecondActivity.
                startActivity(i);


                //the current activity will get finished.
                finish();

            }
        }, SPLASH_SCREEN_TIME_OUT);


        //Progress Bar
        prog();

    }


    //progress bar setup
    public void prog() {

        pb = (ProgressBar) findViewById(R.id.pb);

        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {

            @Override
            public void run() {
                counter++;
                pb.setProgress(counter);

                if (counter == 100)
                    t.cancel();


            }
        };

        t.schedule(tt, 0, 100);
    }


}