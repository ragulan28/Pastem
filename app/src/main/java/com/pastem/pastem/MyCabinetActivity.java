package com.pastem.pastem;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyCabinetActivity extends AppCompatActivity {
    Button returnBtn;
    Button switchBtn;
    TextView mTextField;

    private DatabaseReference mDatabase;
    boolean mSwitch = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cabinet);


        returnBtn = findViewById(R.id.pay_btn);
        mTextField = findViewById(R.id.mTextField);
        switchBtn = findViewById(R.id.switch_btn);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        switchBtn.setBackgroundResource(R.mipmap.lock);
        updateSwitch(false);

        new CountDownTimer(10800000, 1000) {

            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000) % 60;
                int minutes = (int) ((millisUntilFinished / (1000 * 60)) % 60);
                int hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);


                mTextField.setText("0"+hours + " : " + minutes + " : " + seconds);
            }

            public void onFinish() {
                mTextField.setText("done!");
            }
        }.start();

    }

    public void returnClick(View view) {
        Intent intent = new Intent(this, FinalPaymentActivity.class);
        intent.putExtra("key", "lockerId"); //Optional parameters
        startActivity(intent);
    }

    private void updateSwitch(boolean b) {
        mDatabase.child("Cabinet")
                 .child("CabinetId")
                 .child("lockers")
                 .child("lockerId")
                 .child("IsOpen")
                 .setValue(b);
    }

    public void switchClick(View view) {
        if (mSwitch) {
            switchBtn.setBackgroundResource(R.mipmap.lock);
            mSwitch = false;
        } else {
            switchBtn.setBackgroundResource(R.mipmap.un_lock);
            mSwitch = true;
        }
        updateSwitch(mSwitch);
    }
}
