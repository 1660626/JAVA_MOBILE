package com.jerem.fragments2;

import android.app.Activity;
import android.app.Fragment;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by jerem on 24/08/2017.
 */

public class FragmentsA extends Fragment implements View.OnClickListener,ActivityToFragment{
    Giaotiep giaotiep;
    int position=0;
    ListView lst1;
    ArrayList<User> dsUser;
    UserAdapter userAdapter;
    User user=null;
    Button btnfirst,btnlast,btnpre,btnnext;
    @Override
    public void onClick(View view) {
       // giaotiep.Guidata(editText.getText().toString());
    }

    @Override
    public void senData(String data) {
        if(data.equals("first"))
        {
            //btnfirst.setEnabled(false);
            dsUser.get(position).setHienthi(false);
            position=0;
            lst1.setSelection(position);
            checkButton(position);
            user=dsUser.get(position);
            user.setHienthi(true);
            setData();
            userAdapter.notifyDataSetChanged();


        }
        if(data.equals("next"))
        {
            dsUser.get(position).setHienthi(false);
            if(position>=0 && position < (dsUser.size()-1) ){
                position++;
                Log.d("LOG_TAM", "onCreateView: "+position);
                user=dsUser.get(position);
                lst1.setSelection(position);
                checkButton(position);
                setData();
                user.setHienthi(true);
                userAdapter.notifyDataSetChanged();
            }
        }
        if(data.equals("pre"))
        {
            dsUser.get(position).setHienthi(false);
            if(position > 0 ){
                position --;
                user=dsUser.get(position);
                lst1.setSelection(position);
                checkButton(position);
                setData();
                user.setHienthi(true);
                userAdapter.notifyDataSetChanged();
            }
        }
        if(data.equals("last"))
        {
            dsUser.get(position).setHienthi(false);
            position=dsUser.size()-1;
            user=dsUser.get(position);
            lst1.setSelection(position);
            checkButton(position);
            user.setHienthi(true);
            setData();
            userAdapter.notifyDataSetChanged();

        }
    }

    public interface Giaotiep
    {
        public void Guidata(String data);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        giaotiep= (Giaotiep) activity;
    }

  private void addData() {
    dsUser=new ArrayList<>();
    dsUser.add(new User(R.drawable.user1,9.3,"A1_1234","nguyễn văn tâm","A1",false));
    dsUser.add(new User(R.drawable.user2,4.9,"A3_1234","nguyễn văn ","A3",false));
    dsUser.add(new User(R.drawable.user3,9.3,"A4_1234","nguyễn  tâm","A4",false));
    dsUser.add(new User(R.drawable.user4,5.9,"A5_7654","nguyễn văn tâm","A5",false));
    dsUser.add(new User(R.drawable.user5,9.3,"A1_1234","nguyễn tâm tâm","A1",false));
    dsUser.add(new User(R.drawable.user6,6.8,"A2_4444"," văn tâm","A2",false));
    dsUser.add(new User(R.drawable.user7,9.3,"A5_1456","nguyễn văn tâm","A5",false));
    dsUser.add(new User(R.drawable.user8,3.3,"A2_1234","nguyễn  tâm","A2",false));
    dsUser.add(new User(R.drawable.user9,9.3,"A7_9876","nguyễn văn tâm","A7",false));
    dsUser.add(new User(R.drawable.user10,5.7,"A1_3452","nguyễn văn ","A1",false));
    dsUser.add(new User(R.drawable.user11,9.3,"A5_1234"," văn tâm","A1",false));
    dsUser.add(new User(R.drawable.user12,7.8,"A9_1898","nguyễn văn tâm","A9",false));
      dsUser.add(new User(R.drawable.user6,6.8,"A2_1234"," văn tâm","A2",false));
      dsUser.add(new User(R.drawable.user7,9.3,"A5_1234","nguyễn văn tâm","A5",false));
      dsUser.add(new User(R.drawable.user8,3.3,"A2_2457","nguyễn  tâm","A2",false));
      dsUser.add(new User(R.drawable.user9,9.3,"A7_1234","nguyễn văn tâm","A7",false));
      dsUser.add(new User(R.drawable.user10,5.7,"A1_8765","nguyễn văn ","A1",false));
      dsUser.add(new User(R.drawable.user11,9.3,"A5_1234"," văn tâm","A1",false));
      dsUser.add(new User(R.drawable.user12,7.8,"A9_1898","nguyễn văn tâm","A9",false));
}

public void checkButton(int i)
{
    btnfirst= (Button) getActivity().findViewById(R.id.btnfirst);
    btnlast= (Button) getActivity().findViewById(R.id.btnlast);
    btnnext= (Button) getActivity().findViewById(R.id.btnnext);
    btnpre= (Button) getActivity().findViewById(R.id.btnpre);
    if(i==0)
    {
        btnfirst.setEnabled(false);
        btnpre.setEnabled(false);
    }else {
        btnfirst.setEnabled(true);
        btnpre.setEnabled(true);
    }

    if(i==(dsUser.size()-1))
    {
        btnlast.setEnabled(false);
        btnnext.setEnabled(false);
    }else {
        btnlast.setEnabled(true);
        btnnext.setEnabled(true);
    }
}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fargment_a_layout,container,false);
        lst1= (ListView) view.findViewById(R.id.lst1);

        addData();
        userAdapter=new UserAdapter(dsUser,getActivity());
        lst1.setAdapter(userAdapter);
        userAdapter.notifyDataSetChanged();


        lst1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dsUser.get(position).setHienthi(false);
                position=i;
                checkButton(position);
                user=dsUser.get(i);
                user.setHienthi(true);
                setData();
                userAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }
   public void setData(){
       TextView txthoten= (TextView) getActivity().findViewById(R.id.txthoten);
       TextView txtlop= (TextView) getActivity().findViewById(R.id.txtlop);
       TextView txtdtb= (TextView) getActivity().findViewById(R.id.txtdtb);
       TextView txtmasv=(TextView) getActivity().findViewById(R.id.txtidsinhvien);

       txthoten.setText(user.getHoten());
       txtlop.setText(user.getLop()+"");
       txtdtb.setText(user.getDtb()+"");
       txtmasv.setText(user.getMasv()+"");

       giaotiep.Guidata(user.getMasv()+"");
   }
    @Override
    public void onPause() {
        super.onPause();
    }
}
