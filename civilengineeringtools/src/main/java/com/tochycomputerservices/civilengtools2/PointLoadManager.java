package com.tochycomputerservices.civilengtools2;

import java.util.ArrayList;

import android.widget.ImageView;

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

public class PointLoadManager extends PointLoad {
	
	private ArrayList<PointLoad> pLoads = new ArrayList<PointLoad>();
	
	private static PointLoadManager instance = null;
	
	public static PointLoadManager getInstance() {
		if(instance == null) {
			instance = new PointLoadManager();
		}
		return instance;
	}
	
	protected PointLoadManager() {
	
	}

	public void addPtLoad(PointLoad pl, ImageView image, CustomParams params) {
		// TODO Auto-generated method stub
		Beamanalysis.rlpl.addView(image, pLoads.size(), params);
		pLoads.add(pl);
		pl.setIndex(PointLoadManager.getInstance().getPtLoads().size() - 1);
	}
	
	public void deletePtLoad(int pos) {
		pLoads.remove(pos);
		Beamanalysis.rlpl.removeViewAt(pos);
		
		for(int i = 0; i < pLoads.size(); i++)
			pLoads.get(i).setIndex(i);
	}

	public ArrayList<PointLoad> getPtLoads() {
		return pLoads;
	}

	public void setPtLoads(ArrayList<PointLoad> pLoads) {
		this.pLoads = pLoads;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return pLoads.size();
	}

}
