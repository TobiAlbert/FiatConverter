package com.tobidaada.fiatconverter.ui.conversion;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tobidaada.fiatconverter.R;
import com.tobidaada.fiatconverter.model.data.CurrencyTable;

public class ConversionActivity extends AppCompatActivity implements ConversionMvpContract.View {

    TextView fiatCurrencyText;
    EditText fiatCurrencyEditText;
    TextView cryptoText;
    TextView cryptoValue;
    Button conversionButton;
    Intent getIntent;
    ConversionMvpContract.Presenter contractPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        contractPresenter = new ConversionPresenter(this);

        getIntent = getIntent();

        initializeViews();
        assignExtrasToViews();

        conversionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                contractPresenter.convertCurrency(getIntent.getStringExtra("conversionValue"),
                        fiatCurrencyEditText.getText().toString());
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }


    public void initializeViews() {
        fiatCurrencyText = (TextView) findViewById(R.id.fiat_currency_tv);
        fiatCurrencyEditText = (EditText) findViewById(R.id.fiat_currency_ed);
        cryptoText = (TextView) findViewById(R.id.crypto_currency_tv);
        cryptoValue = (TextView) findViewById(R.id.crypto_currency_value);
        conversionButton = (Button) findViewById(R.id.conversion_button);
    }

    public void assignExtrasToViews() {
        String cryptoCurrency = getIntent.getStringExtra("cryptoCurrency");
        String fiatCurrency = getIntent.getStringExtra("fiatCurrency");

        fiatCurrencyText.setText(CurrencyTable.getTickerSymbol(fiatCurrency));
        cryptoText.setText(CurrencyTable.getTickerSymbol(cryptoCurrency));

    }

    @Override
    public void showConversion(String result) {
        cryptoValue.setText(result);
    }
}
