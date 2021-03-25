package com.example.fragmenttofragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment1 extends Fragment {

    private EditText editText1;
    private Button button1;
    private View mView;

    private iSenddata miSenddata;
    public interface iSenddata{
        void senddata(String email);
    }


    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {//phai khoi tao moi dung duoc
        super.onAttach(context);
        miSenddata= (iSenddata) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView= inflater.inflate(R.layout.fragment_1, container, false);

        editText1 =mView.findViewById(R.id.edittext1);
        button1=mView.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senddatatoFragment2();
            }
        });
        return mView;
    }

    private void senddatatoFragment2() {

        String st=editText1.getText().toString();
        miSenddata.senddata(st);
    }
    public  void receivedatafrom2(String email){

        editText1.setText(email);
    }
}