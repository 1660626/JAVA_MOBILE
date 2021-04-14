package com.example.manageruser;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Fragment1 extends Fragment implements ItemClickListener {
    MainActivity main;
    Context context = null;
    ArrayList<User> dsUser;
    UserAdapter userAdapter;
    Button btnFirst, btnLast, btnPre, btnNext;
    ListView listviewUser;
    int position = 0;
    View view;


    public static Fragment1 newInstance(String strArg) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString("strArg1", strArg);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            context = getActivity();
            main = (MainActivity) getActivity();
        } catch (IllegalStateException e) {
            throw new IllegalStateException("ainActivity must implement callbacks");
        }
    }

    public void checkButton(int i) {
        btnFirst = (Button) getActivity().findViewById(R.id.btnFirst);
        btnLast = (Button) getActivity().findViewById(R.id.btnLast);
        btnNext = (Button) getActivity().findViewById(R.id.btnNext);
        btnPre = (Button) getActivity().findViewById(R.id.btnPre);
        if (i == 0) {
            btnFirst.setEnabled(false);
            btnFirst.setAlpha(.5f);
            btnFirst.setClickable(false);
            btnPre.setEnabled(false);
            btnPre.setAlpha(.5f);
            btnPre.setClickable(false);
        } else {
            btnFirst.setEnabled(true);
            btnFirst.setAlpha(1);
            btnFirst.setClickable(true);
            btnPre.setEnabled(true);
            btnPre.setAlpha(1);
            btnPre.setClickable(true);
        }
        if (i == (dsUser.size() - 1)) {
            btnLast.setEnabled(false);
            btnLast.setAlpha(.5f);
            btnLast.setClickable(false);
            btnNext.setEnabled(false);
            btnNext.setAlpha(.5f);
            btnNext.setClickable(false);
        } else {
            btnLast.setEnabled(true);
            btnLast.setAlpha(1);
            btnLast.setClickable(true);
            btnNext.setEnabled(true);
            btnNext.setAlpha(1);
            btnNext.setClickable(true);
        }
    }

    private void addArrayUser() {
        dsUser = new ArrayList<>();
        dsUser.add(new User(false, R.drawable._user_001, 9.3, "A7_1234", "Nguyễn Văn A", "A011"));
        dsUser.add(new User(false, R.drawable._user_002, 4.9, "A2_1234", "Lê Văn B", "A012"));
        dsUser.add(new User(false, R.drawable._user_003, 6.8, "A9_1898", "Nguyễn Thị C", "A013"));
        dsUser.add(new User(false, R.drawable._user_004, 3.3, "A5_1456", "Lý Văn D", "A014"));
        dsUser.add(new User(false, R.drawable._user_005, 7.8, "A9_1898", "Đinh Cao E", "A012"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment1, container, false);
        listviewUser = (ListView) view.findViewById(R.id.listviewUser);

        listviewUser.setBackgroundColor(Color.parseColor("#ffccddff"));
        addArrayUser();
        userAdapter = new UserAdapter(getActivity(), dsUser);
        listviewUser.setAdapter(userAdapter);
        userAdapter.notifyDataSetChanged();
        listviewUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view1, int i, long l) {
                dsUser.get(position).setHienthi(false);

                listviewUser.getChildAt(position).setBackgroundColor(Color.WHITE);
                position = i;
                dsUser.get(i).setHienthi(true);
                TextView txtShowMSSV = (TextView) getActivity().findViewById(R.id.txtShowMSSV);

                txtShowMSSV.setText(dsUser.get(position).getMSSV() + "");
                checkButton(position);
                listviewUser.getChildAt(position).setBackgroundColor(R.drawable.item_state_normal);

                main.onMsgFromFragToMain("A-FRAG", "A selected row=" + position, dsUser.get(position));
            }
        });
        return view;
    }

    void setPosition(int i) {
        dsUser.get(i).setHienthi(true);
        TextView txtShowMSSV = (TextView) getActivity().findViewById(R.id.txtShowMSSV);

        txtShowMSSV.setText(dsUser.get(i).getMSSV() + "");
        checkButton(i);

        listviewUser.getChildAt(i).setBackgroundColor(R.drawable.item_state_normal);

        main.onMsgFromFragToMain("A-FRAG", "A selected row=" + i, dsUser.get(i));


    }

    @Override
    public void onClick(String btn) {
        if (btn.equals("first")) {
            dsUser.get(position).setHienthi(false);
            listviewUser.getChildAt(position).setBackgroundColor(Color.WHITE);
            position = 0;
            setPosition(position);

        }
        if (btn.equals("last")) {
            dsUser.get(position).setHienthi(false);
            listviewUser.getChildAt(position).setBackgroundColor(Color.WHITE);

            position = dsUser.size() - 1;
            setPosition(position);
        }
        if (btn.equals("next")) {
            dsUser.get(position).setHienthi(false);
            listviewUser.getChildAt(position).setBackgroundColor(Color.WHITE);

            position = position + 1;
            setPosition(position);
        }
        if (btn.equals("pre")) {
            dsUser.get(position).setHienthi(false);
            listviewUser.getChildAt(position).setBackgroundColor(Color.WHITE);
            position = position - 1;
            setPosition(position);
        }
    }
}
