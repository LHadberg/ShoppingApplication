package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView _textView;

    private Button _completePurchase;
    private CheckBox _chkCoffee, _chkTea, _chkJuice;
    private RadioGroup _rgPayment;
    private RadioButton _rbCash, _rbCreditCard, _rbPaypal;
    private LinearLayout _parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _parent = findViewById(R.id.parent);

        _textView = findViewById(R.id.text1);
        _completePurchase = findViewById(R.id.complete_purchase);
        _chkCoffee = findViewById(R.id.checkBox1);
        _chkTea = findViewById(R.id.checkBox2);
        _chkJuice = findViewById(R.id.checkBox3);

        _rgPayment = findViewById(R.id.rgPayment);
        _rbCash = findViewById(R.id.rbCash);
        _rbCreditCard = findViewById(R.id.rbCredit_Card);
        _rbPaypal = findViewById(R.id.rbPaypal);

        String clicked = getResources().getString(R.string.clicked);
        String checked = getResources().getString(R.string.checked);
        String checkedOff = getResources().getString(R.string.checked_off);
        String purchaseComplete = getResources().getString(R.string.purchase_complete);

        Snackbar snackbar = Snackbar.make(_parent, "Bitcoin", Snackbar.LENGTH_INDEFINITE);

        _rgPayment.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rbCash:
                        Log.d("lha", "cash");
                        break;
                    case R.id.rbCredit_Card:
                        Log.d("lha", "credit");
                        break;
                    case R.id.rbPaypal:
                        snackbar
                                .setAction("DISMISS", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(MainActivity.this, "Dismissed successfully", Toast.LENGTH_SHORT).show();
                                        snackbar.dismiss();
                                    }
                                })
                                .show();
                        break;
                }
            }
        });

        _chkCoffee.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String string = getResources().getString(R.string.coffee);
                if (b) {
                    Toast.makeText(MainActivity.this, "Du har valgt kaffe", Toast.LENGTH_SHORT).show();
                    _textView.setText(string + " " + checked + " :)");
                } else {
                    Toast.makeText(MainActivity.this, "Du har fjernet kaffe", Toast.LENGTH_SHORT).show();
                    _textView.setText(string + " " + checkedOff + " :O..");
                }
            }
        });

        _chkTea.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String string = getResources().getString(R.string.tea);
                if (b) {
                    Toast.makeText(MainActivity.this, "Du har valgt kaffe", Toast.LENGTH_SHORT).show();
                    _textView.setText(string + " " + checked + " :)");
                } else {
                    Toast.makeText(MainActivity.this, "Du har fjernet kaffe", Toast.LENGTH_SHORT).show();
                    _textView.setText(string + " " + checkedOff + " :O..");
                }
            }
        });

        _chkJuice.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                String string = getResources().getString(R.string.juice);
                if (b) {
                    Toast.makeText(MainActivity.this, "Du har valgt kaffe", Toast.LENGTH_SHORT).show();
                    _textView.setText(string + " " + checked + " :)");
                } else {
                    Toast.makeText(MainActivity.this, "Du har fjernet kaffe", Toast.LENGTH_SHORT).show();
                    _textView.setText(string + " " + checkedOff + " :O..");
                }
            }
        });

        _completePurchase.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("msgFromMain", "Text from Main");
            startActivity(intent);
        });
    }

    @Override
    public void onClick(View view) {

    }
}