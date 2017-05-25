package com.example.avdhesh007.testurl;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Avdhesh007 on 5/25/2017.
 */

public class Source2 extends Fragment {
    WebView myWebView;
    final static String myBlogAddr = "http://android-er.blogspot.com";
    String myUrl;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle=getActivity().getIntent().getExtras();
        String message=bundle.getString("message");
        View view =   inflater.inflate
                (R.layout.source2,container,false);
        myWebView = (WebView)view.findViewById(R.id.webview2);

        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("view-source:"+""+message);
        myWebView.setWebViewClient(new WebViewClient());

        return view;

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }
}
