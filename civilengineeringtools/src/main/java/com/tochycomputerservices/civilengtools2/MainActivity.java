package com.tochycomputerservices.civilengtools2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

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

public class MainActivity extends AppCompatActivity {


    ImageView btmnav;
    RelativeLayout home,contact,contact2;
    CardView cal1,cal2,cal3,cal4,cal5,cal6,cal7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bottom dialogue
        btmnav = (ImageView)findViewById(R.id.bottom_nav);
        btmnav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();
            }
        });


        cal1 = (CardView)findViewById(R.id.cal1);
        cal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(MainActivity.this,USCS.class);
                startActivity(i);

            }
        });

        cal2 = (CardView)findViewById(R.id.cal2);
        cal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(MainActivity.this,ISSCS.class);
                startActivity(i);

            }
        });


        cal3 = (CardView)findViewById(R.id.cal3);
        cal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(MainActivity.this,AASHTO.class);
                startActivity(i);

            }
        });


        cal4 = (CardView)findViewById(R.id.cal4);
        cal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//This is for USDA we have not implemented the class yet
                Intent i =new Intent(MainActivity.this,USCS.class);
                startActivity(i);

            }
        });

        cal5 = (CardView)findViewById(R.id.cal5);
        cal5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(MainActivity.this,AsaActivity.class);
                startActivity(i);

            }
        });


        cal6 = (CardView)findViewById(R.id.cal6);
        cal6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(MainActivity.this,PdfActivity.class);
                startActivity(i);

            }
        });


        cal7 = (CardView)findViewById(R.id.cal7);
        cal7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//This is for ASTM we have not implemented the class yet
                Intent i =new Intent(MainActivity.this,ISSCS.class);
                startActivity(i);

            }
        });
















        //bottom navigation setup
        home = (RelativeLayout)findViewById(R.id.home);
        contact = (RelativeLayout)findViewById(R.id.contact);
        contact2 = (RelativeLayout)findViewById(R.id.contact2);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g =new Intent(MainActivity.this,Contact.class);
                startActivity(g);
            }
        });

        contact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g =new Intent(MainActivity.this,Contact2.class);
                startActivity(g);
            }
        });


    }

    //BottomSheet implimentation
    private void showBottomSheetDialog()
    {


        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog_layout);

        LinearLayout share = bottomSheetDialog.findViewById(R.id.share);
        LinearLayout rating = bottomSheetDialog.findViewById(R.id.rating);
        LinearLayout contact = bottomSheetDialog.findViewById(R.id.contact);

        //not implimented yet
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Share is Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Rating is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Update is Clicked", Toast.LENGTH_SHORT).show();
            }
        });
        bottomSheetDialog.show();


    }
    //Back to Exit
    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                        quit();
                    }
                }).create().show();
    }
    public void quit() {
        Intent start = new Intent(Intent.ACTION_MAIN);
        start.addCategory(Intent.CATEGORY_HOME);
        start.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        start.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(start);
    }
}