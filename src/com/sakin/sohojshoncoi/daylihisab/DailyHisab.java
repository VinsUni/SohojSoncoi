package com.sakin.sohojshoncoi.daylihisab;

import com.sakin.sohojshoncoi.R;
import com.sakin.sohojshoncoi.Utils;

import android.os.Bundle;
import android.app.Fragment;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DailyHisab extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.dailyhisab, container, false);
		setText(view, "ব্যালেন্সঃ ৩০০");
		Button addNewButton;
		addNewButton = (Button) view.findViewById(R.id.addNewButton);
		addNewButton.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				Intent addNewHisabIntent = new Intent(getActivity(), AddNewHisab.class);
				startActivity(addNewHisabIntent);
			}
		});
	    return view;
	}

	public void setText(View view, String item) {
		TextView tv = (TextView) view.findViewById(R.id.dailyhisabText);
		tv.setTypeface(Utils.banglaTypeFace);
		tv.setText(item);
	}

}
