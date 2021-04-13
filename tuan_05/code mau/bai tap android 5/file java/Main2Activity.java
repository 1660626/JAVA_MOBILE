package com.jerem.fragments2;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends Activity implements FragmentsA.Giaotiep,FragmentB.GiaotiepAB {
    TextView txtmaso;
    public ActivityToFragment activityToFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    LinearLayout linearLayout_left,linearLayout_rigth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControl();

    }

    private void addControl() {

        txtmaso= (TextView) findViewById(R.id.txtmaso);
        linearLayout_left= (LinearLayout) findViewById(R.id.linearLayout_left);
        linearLayout_rigth= (LinearLayout) findViewById(R.id.linearLayout_right);

        fragmentManager =getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();

        FragmentsA fragmentsA=new FragmentsA();
        activityToFragment=fragmentsA;
        Bundle bundle=new Bundle();
        bundle.putString("tam","null");
        fragmentsA.setArguments(bundle);
        fragmentTransaction.add(R.id.linearLayout_left,fragmentsA);
        fragmentTransaction.commit();

        FragmentB fragmentB=new FragmentB();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.linearLayout_right,fragmentB);
        transaction.commit();
    }

    @Override
    public void Guidata(String data) {
        txtmaso.setText(data);
    }

    @Override
    public void GuidataAB(String data) {
        if(data.equals("first")){
            activityToFragment.senData("first");
        }
        if(data.equals("last")){
            activityToFragment.senData("last");
        }
        if(data.equals("next")){
            activityToFragment.senData("next");
        }
        if(data.equals("pre")){
            activityToFragment.senData("pre");
        }
    }
}
