package com.tochycomputerservices.civilengtools2;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

/*
 *  Author: Eze-Odikwa Tochukwu Jed
 *  Last date modified: 11-12-2022
 *  (C), All rights reserved, Tochy computer services 2022
 *
 * */
public class TableFragment extends Fragment {
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
    private final String LOG_TAG = getClass().getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =  inflater.inflate(R.layout.table_fragment, container, false);
        TableLayout tl = (TableLayout) view.findViewById(R.id.tableLayout);

        try {
            JSONObject data = new JSONObject(getArguments().getString("data"));

            for (int i = 0; i < 8; i++) {
                View tableRow = LayoutInflater.from(view.getContext()).inflate(R.layout.table_item_view, tl, false);

                String SieveNumberText = getSieveNumber(i);
                String SieveOpening = getSieveOpening(SieveNumberText);
                String WeightRetained;

                if (i < 7) {
                    WeightRetained = Double.toString(data.getJSONObject("WEIGHT_RETAINED").getDouble("SIEVE_NO_"+SieveNumberText.substring(9)));
                } else {
                    WeightRetained = Double.toString(data.getJSONObject("WEIGHT_RETAINED").getDouble("PAN"));
                }

                String PercentRetained = String.format("%.2f", Double.parseDouble(data.getJSONArray("PERCENT_RETAINED_VALUES").get(i).toString()));
                String CumulativePercent = String.format("%.2f", Double.parseDouble(data.getJSONArray("CUMULATIVE_PERCENTS").get(i).toString()));
                String PercentFiner = String.format("%.2f", Double.parseDouble(data.getJSONArray("PERCENT_FINER").get(i).toString()));
                ((TextView)tableRow.findViewById(R.id.SIEVE_NO)).setText(SieveNumberText);
                ((TextView)tableRow.findViewById(R.id.SIEVE_OPENING)).setText(SieveOpening);
                ((TextView)tableRow.findViewById(R.id.WEIGHT_RETAINED)).setText(WeightRetained);
                ((TextView)tableRow.findViewById(R.id.PERCENT_RETAINED)).setText(PercentRetained);
                ((TextView)tableRow.findViewById(R.id.CUMULATIVE_PERCENT)).setText(CumulativePercent);
                ((TextView)tableRow.findViewById(R.id.PERCENT_FINER)).setText(PercentFiner);
                tl.addView(tableRow);
            }
        } catch (JSONException e) {
            Log.d(LOG_TAG, "JSONException in file TableFragment.java");
        }



        return view;
    }

    private String getSieveNumber(int i) {
        String result;
        switch (i) {
            case 0:
                result = "Sieve No.4";
                break;
            case 1:
                result = "Sieve No.8";
                break;
            case 2:
                result = "Sieve No.16";
                break;
            case 3:
                result = "Sieve No.30";
                break;
            case 4:
                result = "Sieve No.50";
                break;
            case 5:
                result = "Sieve No.100";
                break;
            case 6:
                result = "Sieve No.200";
                break;
            case 7:
                result = "Pan";
                break;
            default:
                result = "-";
                break;
        }
        return result;
    }


    private String getSieveOpening(String sieve_no) {
        String result = "";
        switch(sieve_no) {
            case "Sieve No.4":
                result = "4.750";
                break;
            case "Sieve No.8":
                result = "2.360";
                break;
            case "Sieve No.16":
                result = "1.180";
                break;
            case "Sieve No.30":
                result = "0.600";
                break;
            case "Sieve No.50":
                result = "0.300";
                break;
            case "Sieve No.100":
                result = "0.150";
                break;
            case "Sieve No.200":
                result = "0.075";
                break;
            default:
                result = "";
                break;
        }
        return result;
    }


}
