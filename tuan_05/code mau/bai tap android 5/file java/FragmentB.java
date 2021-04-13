package com.jerem.fragments2;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jerem on 24/08/2017.
 */

public class FragmentB extends Fragment implements View.OnClickListener {
   Button btnfirst, btnpre, btnnext, btnlast;
   GiaotiepAB giaotiep;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fargment_b_layout,container,false);
        btnfirst= (Button) view.findViewById(R.id.btnfirst);
        btnpre= (Button) view.findViewById(R.id.btnpre);
        btnnext= (Button) view.findViewById(R.id.btnnext);
        btnlast= (Button) view.findViewById(R.id.btnlast);

        btnfirst.setOnClickListener(this);
        btnpre.setOnClickListener(this);
        btnnext.setOnClickListener(this);
        btnlast.setOnClickListener(this);

        return view;
    }
    public interface GiaotiepAB
    {
        public void GuidataAB(String data);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        giaotiep= (GiaotiepAB) activity;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onClick(View view) {
      int id=view.getId();
            if(id==R.id.btnfirst){
                giaotiep.GuidataAB("first");
            }
        if(id==R.id.btnlast){
            giaotiep.GuidataAB("last");

        }
        if(id==R.id.btnnext){
            giaotiep.GuidataAB("next");

        }
        if(id==R.id.btnpre){
            giaotiep.GuidataAB("pre");

        }

    }
}
