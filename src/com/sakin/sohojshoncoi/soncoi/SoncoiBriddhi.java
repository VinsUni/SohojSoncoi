package com.sakin.sohojshoncoi.soncoi;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sakin.sohojshoncoi.R;
import com.sakin.sohojshoncoi.Utils;
import com.sakin.sohojshoncoi.custom.NetworkReceiver;
import com.sakin.sohojshoncoi.custom.TabsAdapter;
import com.sakin.sohojshoncoi.sofol.SofolVideosFragment;

public class SoncoiBriddhi extends Fragment {
	ViewPager soncoiPager;
	TabsAdapter mTabsAdapter;
	String[] playlist_url;
	String[] tab_title;
	private NetworkReceiver receiver = null;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.soncoi_briddi, container, false);

		init();
		if (Utils.refreshDisplay) {
			//check for network connection
			if (((Utils.sPref.equals(Utils.ANY)) && (Utils.wifiConnected || Utils.mobileConnected))
	                || ((Utils.sPref.equals(Utils.WIFI)) && (Utils.wifiConnected))) {
				loadTabs(view);
			} else {
				Utils.print("No network connectivity");
				Toast.makeText(getActivity(), R.string.lost_connection, Toast.LENGTH_SHORT).show();
			}
        }
		Utils.setActionBarTitle(getActivity(), "mÂq e„w×i †KŠkj");
	    return view;
	}
	
	private void init(){
		IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
		receiver = new NetworkReceiver();
        getActivity().registerReceiver(receiver, filter);
        
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        Utils.sPref = sharedPrefs.getString("listPref", "Any");

        receiver.updateConnectedFlags(getActivity());
	}
	
	private void loadTabs(View view){
		final ActionBar bar = ((ActionBarActivity) getActivity()).getSupportActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS );
		bar.removeAllTabs();
		soncoiPager = (ViewPager) view.findViewById(R.id.soncoi_pager);

        mTabsAdapter = new TabsAdapter((ActionBarActivity) getActivity(), soncoiPager);
        playlist_url = getResources().getStringArray(R.array.soncoi_tab_url);        
        tab_title = getResources().getStringArray(R.array.support_soncoi_tab_title);
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
        	tab_title = getResources().getStringArray(R.array.soncoi_tab_title);
        }
        int totalTabs = tab_title.length;
        soncoiPager.setOffscreenPageLimit(totalTabs);
        
        Bundle args = null;
        for(int i=0; i<totalTabs; i++){
        	args = new Bundle();
        	args.putString(Utils.TAB_URL_ID, playlist_url[i]);
    		args.putInt(Utils.TAB_ID, i + 10);
    		ActionBar.Tab curTab = CreateNewTab(bar, i);
    		mTabsAdapter.addTab(curTab, SofolVideosFragment.class, args);
        }
        
	}
	
	private ActionBar.Tab CreateNewTab(ActionBar bar, int ind) {
		LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		LinearLayout layoutView = (LinearLayout)inflater.inflate(R.layout.tab_title_view, null);
		TextView title = (TextView)layoutView.findViewById(R.id.tab_title_text);
		if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
			title.setTypeface(Utils.banglaTypeFace);
		} else {
			title.setTypeface(Utils.banglaTypeFaceSutonny);
		}
		title.setText(tab_title[ind]);
		return bar.newTab().setCustomView(layoutView);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if (receiver != null) {
            getActivity().unregisterReceiver(receiver);
        }
	}

}