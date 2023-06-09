package com.tochycomputerservices.civilengtools2;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Random;

import me.ithebk.barchart.BarChart;
import me.ithebk.barchart.BarChartModel;
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
public class charts extends AppCompatActivity {
    private BarChart barChartVertical;
    private BarChart barChartHorizontal;
    private EditText etAddViewAt;
    private EditText etRemoveViewAt;
    private EditText etUpdateViewAt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);
        barChartVertical = (BarChart) findViewById(R.id.bar_chart_vertical);
        barChartHorizontal = (BarChart) findViewById(R.id.bar_chart_horizontal);
        etAddViewAt = (EditText) findViewById(R.id.et_add_view_at);
        etRemoveViewAt = (EditText) findViewById(R.id.et_remove_bar_at);
        etUpdateViewAt = (EditText) findViewById(R.id.et_update_bar_at);
        for (int i = 0; i < 3; i++) {
            BarChartModel barChartModel = new BarChartModel();
            barChartModel.setBarValue(new Random().nextInt(100));
            Random rnd = new Random();
            barChartModel.setBarColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
            barChartModel.setBarTag(null);
            barChartVertical.addBar(barChartModel);
        }
        String data[] = new String[]{"Gravel",
                "Sand",
                "Silt",
                "Clay"};
        int dataColor[] = new int[]{
                Color.parseColor("#00BCD4"),
                Color.parseColor("#3F51B5"),
                Color.parseColor("#2196F3"),
                Color.parseColor("#FF9800")};
        for (int i = 0; i < 4; i++) {
            BarChartModel barChartModel = new BarChartModel();
            barChartModel.setBarValue(new Random().nextInt(100));
            Random rnd = new Random();
            barChartModel.setBarColor(dataColor[i]);
            barChartModel.setBarTag(null);
            barChartModel.setBarText(data[i]);
            barChartHorizontal.addBar(barChartModel);
        }


        findViewById(R.id.tv_hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Clicked::");
                BarChartModel barChartModel = new BarChartModel();
                barChartModel.setBarValue(new Random().nextInt(100));
                Random rnd = new Random();
                barChartModel.setBarColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                barChartModel.setBarTag(null);
                barChartVertical.addBar(barChartModel);
                barChartHorizontal.addBar(barChartModel);
            }
        });

        findViewById(R.id.tv_hello_at).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Clicked::");
                BarChartModel barChartModel = new BarChartModel();
                barChartModel.setBarValue(new Random().nextInt(100));
                Random rnd = new Random();
                barChartModel.setBarColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                barChartModel.setBarTag(null);
                barChartVertical.addBar(Integer.parseInt(etAddViewAt.getText().toString()),barChartModel);
               // barChartHorizontal.addBar(Integer.parseInt(etAddViewAt.getText().toString()),barChartModel);
            }
        });
        findViewById(R.id.tv_clear).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        barChartVertical.clearAll();
                        barChartHorizontal.clearAll();
                    }
                });

        findViewById(R.id.tv_remove_bar_at).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                barChartVertical.removeBar(Integer.parseInt(etRemoveViewAt.getText().toString()));
                barChartHorizontal.removeBar(Integer.parseInt(etRemoveViewAt.getText().toString()));
            }});

        findViewById(R.id.tv_update_bar_at).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BarChartModel barChartModel = new BarChartModel();
                barChartModel.setBarValue(new Random().nextInt(100));
                Random rnd = new Random();
                barChartModel.setBarColor(Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256)));
                barChartModel.setBarTag(null);
                barChartVertical.updateBar(Integer.parseInt(etUpdateViewAt.getText().toString()),barChartModel);
              //  barChartHorizontal.updateBar(Integer.parseInt(etUpdateViewAt.getText().toString()),barChartModel);
            }});

        barChartVertical.setOnBarClickListener(new BarChart.OnBarClickListener() {
            @Override
            public void onBarClick(BarChartModel barChartModel) {
                barChartVertical.removeBar(barChartModel);
            }
        });
        barChartHorizontal.setOnBarClickListener(new BarChart.OnBarClickListener() {
            @Override
            public void onBarClick(BarChartModel barChartModel) {
                barChartHorizontal.removeBar(barChartModel);
            }
        });
//        int a[] =new int[]{-20,-5,2,4,5,1,-1};
//        //System.out.println("Minimum of "+ Arrays.toString(a)+":Is:"+solution(a));

    }


    private int solution(int a[]){
        int max=1;
        for (int anA1 : a) {
            if (anA1 > max) {
                max = anA1;
            }
        }
        boolean valArray[] = new boolean[max+1];
        for (int anA : a) {
            if(anA>0) {
                valArray[anA] = true;
            }
        }
        for(int i=1;i<valArray.length;i++){
            if(!valArray[i]){
                return i;
            }
        }
        return max;
    }
}
