package com.example.manageruser;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements MainCallbacks {
    FragmentTransaction ft;
    Fragment1 fragment_1;
    Fragment2 fragment_2;
    TextView txtHoTenF1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtHoTenF1 = (TextView) findViewById(R.id.txtHoTenF1);
        ft = getSupportFragmentManager().beginTransaction();
        fragment_1 = Fragment1.newInstance("ffffff1");
        ft.replace(R.id.main_Fr_A, fragment_1);
        ft.commit();
        ft = getSupportFragmentManager().beginTransaction();
        fragment_2 = Fragment2.newInstance("fffff2");
        ft.replace(R.id.main_Fr_B, fragment_2);
        ft.commit();

    }


    @Override
    public void onMsgFromFragToMain(String sender, String strValue, User user) {
        if (sender.equals("B-FRAG")) {
            try {
                fragment_1.onClick(strValue);
            } catch (Exception e) {
                Log.e("ERROR", "onStrFromFragToMain" + e.getMessage());
            }
        }
        if (sender.equals("A-FRAG")) {
            try {
                fragment_2.onMsgFromMainToFragment(user);
            } catch (Exception e) {
                Log.e("ERROR", "onStrFromFragToMain" + e.getMessage());
            }
        }
    }


}