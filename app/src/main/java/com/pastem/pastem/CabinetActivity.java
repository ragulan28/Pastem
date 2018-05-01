package com.pastem.pastem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CabinetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabinet);
    }

    public void pay(View view) {
        Intent intent = new Intent(this, BuyActivity.class);
        intent.putExtra("key", "lockerId"); //Optional parameters
        this.startActivity(intent);
    }
}
