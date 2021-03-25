package com.example.fragmenttofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Fragment1.iSenddata, Fragment2.iSenddata {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction= getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.content1, new Fragment1());
        fragmentTransaction.add(R.id.content2,new Fragment2());
        fragmentTransaction.commit();
    }

    @Override
    public void senddata(String email){
        Fragment2 frg2= (Fragment2) getSupportFragmentManager().findFragmentById(R.id.content2);
        frg2.receivedatafrom1(email);

    }
    public void senddata1(String email){
        Fragment1 frg1= (Fragment1) getSupportFragmentManager().findFragmentById(R.id.content1);
        frg1.receivedatafrom2(email);

    }
}