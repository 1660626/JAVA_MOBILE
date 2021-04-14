package com.example.manageruser;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment implements FragmentCallbacks {
    MainActivity main;
    Button btnFirst, btnLast, btnPre, btnNext;
    View view;

    public static Fragment2 newInstance(String strArg1) {
        Fragment2 fragment = new Fragment2();
        Bundle bundle = new Bundle();
        bundle.putString("arg1", strArg1);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!(getActivity() instanceof MainCallbacks)) {
            throw new IllegalStateException("Activity must implement MainCallbacks");
        }
        main = (MainActivity) getActivity();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment2, container, false);
        btnFirst = (Button) view.findViewById(R.id.btnFirst);
        btnLast = (Button) view.findViewById(R.id.btnLast);
        btnNext = (Button) view.findViewById(R.id.btnNext);
        btnPre = (Button) view.findViewById(R.id.btnPre);

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.btnFirst) {
                    main.onMsgFromFragToMain("B-FRAG", "first", null);
                }
            }
        });

        btnLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.btnLast) {
                    main.onMsgFromFragToMain("B-FRAG", "last", null);
                }
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.btnNext) {
                    main.onMsgFromFragToMain("B-FRAG", "next", null);
                }
            }
        });
        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                if (id == R.id.btnPre) {
                    main.onMsgFromFragToMain("B-FRAG", "pre", null);
                }
            }
        });

        return view;
    }


    @Override
    public void onMsgFromMainToFragment(User user) {
        TextView txtHoTen = (TextView) getActivity().findViewById(R.id.txtHoTen);
        TextView txtLop = (TextView) getActivity().findViewById(R.id.txtLop);
        TextView txtDTB = (TextView) getActivity().findViewById(R.id.txtDTB);
        TextView txtMSSV = (TextView) getActivity().findViewById(R.id.txtMSSV);
        txtHoTen.setText(user.getHoTen());
        txtLop.setText(user.getLop());
        txtDTB.setText(user.getDTB() + "");
        txtMSSV.setText(user.getMSSV());

    }


}
