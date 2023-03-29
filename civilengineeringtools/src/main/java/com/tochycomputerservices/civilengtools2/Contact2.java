package com.tochycomputerservices.civilengtools2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

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

public class Contact2 extends AppCompatActivity {

    RelativeLayout home,contact,contact2;
    CardView cal1,cal2,cal3,cal4,cal5,cal6,cal7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact2);

//bottom dialogue


        cal1 = (CardView)findViewById(R.id.cal1);
        cal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(Contact2.this,ScientificCalculator.class);
                startActivity(i);

            }
        });

        cal2 = (CardView)findViewById(R.id.cal2);
        cal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(Contact2.this,ISSCS.class);
                startActivity(i);

            }
        });


        cal3 = (CardView)findViewById(R.id.cal3);
        cal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(Contact2.this,AASHTO.class);
                startActivity(i);

            }
        });


        cal4 = (CardView)findViewById(R.id.cal4);
        cal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(Contact2.this,NotesListActivity.class);
                startActivity(i);

            }
        });

        cal5 = (CardView)findViewById(R.id.cal5);
        cal5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(Contact2.this,Beamanalysis.class);
                startActivity(i);

            }
        });


        cal6 = (CardView)findViewById(R.id.cal6);
        cal6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(Contact2.this,PdfActivity.class);
                startActivity(i);

            }
        });


        cal7 = (CardView)findViewById(R.id.cal7);
        cal7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(Contact2.this,About.class);
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

                Intent g =new Intent(Contact2.this,MainActivity.class);
                startActivity(g);
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent g =new Intent(Contact2.this,Contact.class);
                startActivity(g);
            }
        });

        contact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g =new Intent(Contact2.this,Contact2.class);
                startActivity(g);
            }
        });

    }





}