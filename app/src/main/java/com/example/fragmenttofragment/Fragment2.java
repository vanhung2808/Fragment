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


public class Fragment2 extends Fragment {

    private EditText editText2;
    private Button button2;
    private View mView;

    private iSenddata miSenddata;
    public interface iSenddata{
        void senddata1(String email);
    }
    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        miSenddata= (iSenddata) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mView= inflater.inflate(R.layout.fragment_2, container, false);
        editText2=mView.findViewById(R.id.edittext2);
        button2=mView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senddatatoFragment1();
            }
        });
        return mView;
    }
    public void receivedatafrom1(String email){
        editText2.setText(email);
    }
    private void senddatatoFragment1() {
        String email= editText2.getText().toString();
        miSenddata.senddata1(email);
    }
}