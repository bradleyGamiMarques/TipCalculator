package edu.harding.bmarques.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    private EditText mBillEditText;
    private EditText mTipPercentEditText;
    private TextView mTotalDisplayTextView;
    private TextView mTipAmountDisplayTextView;
    TipCalculatorCPU CPU = new TipCalculatorCPU();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBillEditText = (EditText) findViewById(R.id.billEditText);
        mTipPercentEditText= (EditText) findViewById(R.id.tipPercentEditText);
        mTotalDisplayTextView = (TextView) findViewById(R.id.totalDisplayTextView);
        mTipAmountDisplayTextView = (TextView) findViewById(R.id.tipAmountDisplayTextView);
        mTotalDisplayTextView = (TextView) findViewById(R.id.totalDisplayTextView);

    }
    public void calculateClick(View view){

        try{
            CPU.setmBill(Float.parseFloat(mBillEditText.getText().toString()));
            CPU.setmTipPercentage(Float.parseFloat(mTipPercentEditText.getText().toString()));
            NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

            CPU.setmTipAmount(CPU.getmBill() * CPU.getmTipPercentage() * 0.01f);
            CPU.setmTotalBill(CPU.getmBill() + CPU.getmTipAmount());
            mTipAmountDisplayTextView.setText(moneyFormat.format(CPU.getmTipAmount()));
            mTotalDisplayTextView.setText(moneyFormat.format(CPU.getmTotalBill()));
        }
        catch(NumberFormatException ex){
            String errorMessage = getResources().getString(R.string.error_message);
            makeText(this, errorMessage, LENGTH_SHORT).show();
            mTipAmountDisplayTextView.setText("");
            mTotalDisplayTextView.setText("");
        }

    }
}
