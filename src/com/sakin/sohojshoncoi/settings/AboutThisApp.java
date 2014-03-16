package com.sakin.sohojshoncoi.settings;

import com.sakin.sohojshoncoi.R;
import com.sakin.sohojshoncoi.Utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

public class AboutThisApp extends Fragment {
	
	View rootView = null;
	private WebView webView;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.about_this_app, container, false);
		
		TextView tv = (TextView) rootView.findViewById(R.id.about_app1);
		tv.setTypeface(Utils.banglaTypeFaceSutonny);
		tv.setText("mnR-m�q e�w�MZ Avq-e��qi wnmve msi��Yi Rb� GKwU Abb� Gwc��Kkb| �aygv� wnmve msi�YB bq, Avcbvi �`bw�`b Rxebhv�vi Db�q�bi j���I GLv�b cv�eb wewfb� w`K-wb�`�kbv Ges civgk�| Gwc��KkbwUi �h �Kvb �cBR G evg �_�K Wv�b W�vM Ki�j A_ev Dc�ii mnR-m�q AvBK�b wK�K Ki�j Avcwb AwZwiw� �gbyevi �`L�Z cv�eb| GLv�b e�w�MZ Avq e�w�i Rb� m�q e�w�i �K�kj �mKk�b wKQz wfwWI ms�hvRb Kiv n�q�Q| GQvovI wewfb� Av�qi �K�kj �mKk�b Av�qi wewfb� gva�g m�^wjZ w`K wb�`�kbvg~jK wfwWI �`qv n�q�Q| mdj�`i mvdj�Mv_v �mKk�b wewfb� ���� mdj e�w��`i cwik�gx Rxeb Ges mvd�j�i �cQ�bi M� m�^wjZ wfwWI ms�hvRb Kiv n�q�Q| GQvovI �h �Kvb �mKk�b Avcwb Avcbvi cQ�` Abyhvqx �Kvb wfwWI ms�hvRb Ki�Z PvB�j A_ev Avcbvi mvd�j�i K_v Avgv�`i Rvbv�Z PvB�j wb���v� wVKvbvq Avcbvi wfwWI B-�gBj Ki�b");
		
		TextView tv1 = (TextView) rootView.findViewById(R.id.about_mail);
		tv1.setText("sohoj.sonchoy@gmail.com");
		
		TextView tv2 = (TextView) rootView.findViewById(R.id.about_app2);
		tv2.setTypeface(Utils.banglaTypeFaceSutonny);
		tv2.setText("GQvovI �h �Kvb civg�k�i Rb� A_ev Avcbvi e�w�MZ Awf�Zv �kqvi Kivi Rb� GLv�b i�q�Q GKwU �WwW�K�UW �dvivg| wR�vmv �mKkbwU �dBmeyK wbf�i GKwU �cBR �hLv�b Avcwb �h �Kvb wKQz wR�vmv A_ev Avcbvi gyj�evb gZvgZ w`�Z cvi�eb| wet`�t G���� Avcbvi Aek�B GKwU �dBmeyK GKvD�U _vK�Z n�e|");
		Utils.setActionBarTitle(getActivity(), "mnR m�q");
		
		return rootView;
	}
}
