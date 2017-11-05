package com.example.utylo.apply;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import pojo.ETH;

/**
 * Created by UTYLO on 11/3/2017.
 */

public class EthConversion extends AppCompatActivity {

    private EditText mExchange;
    private TextView mName, mRate, mNewRate;
    private String receivedDataRate;
    private ETH eth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eth_conversion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.setTitle("Conversion Screen");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mExchange = (EditText) findViewById(R.id.et_number);
        mRate = (TextView) findViewById(R.id.rate);
        mName = (TextView) findViewById(R.id.from_indicator);
        mNewRate = (TextView) findViewById(R.id.new_rate);

        eth = getIntent().getParcelableExtra("data");

        mName.setText(eth.getName());

        receivedDataRate = eth.getRate();

        mRate.setText("1 " + eth.getName() + " = " + receivedDataRate);

    }

    public void btnConvert(View view) {
        performCalc();
    }

    void performCalc() {
        String value = mExchange.getText().toString().trim();

        if (value.isEmpty() || value.length() == 0 || value.equals("") || value == null) {
            return;
        } else {
            double userValue = Double.parseDouble(value);
            double rate = Double.parseDouble(receivedDataRate);
            mNewRate.setText(String.valueOf(eth.getName() + " " + userValue * rate));
        }
    }
}
