package com.tobidaada.fiatconverter.adapter;

import android.content.Context;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.tobidaada.fiatconverter.ui.conversion.ConversionActivity;
import com.tobidaada.fiatconverter.R;
import com.tobidaada.fiatconverter.model.data.Card;
import com.tobidaada.fiatconverter.model.data.FiatCurrency;
import com.tobidaada.fiatconverter.model.data.CurrencyTable;
import com.tobidaada.fiatconverter.model.remote.ApiUtils;
import com.tobidaada.fiatconverter.model.remote.CurrencyService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TOBI DAADA on 10/22/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private List<Card> mCard;
    private CurrencyService mCurrencyService = ApiUtils.getCurrencyService();
    private Context context;

    public RVAdapter(List<Card> mCard, Context context) {
        this.mCard = mCard;
        this.context = context;
    }

    public Context getContext() {
        return this.context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_custom_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final TextView cardTitle = holder.cardTitle;
        final TextView cardAmount = holder.cardAmount;
        final Spinner cryptoSpinner = holder.cryptoSpinner;
        Button convertButton = holder.convertButton;
        final int cardPosition = position;

        cardTitle.setText(mCard.get(position).getTitle());
        cardAmount.setText(mCard.get(position).getAmount());

        convertButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                if (cardAmount.getText().toString().length() < 1) {
                    handleEmptyValue();
                } else {

                    Intent intent = new Intent(getContext(), ConversionActivity.class);
                    intent.putExtra("fiatCurrency", cryptoSpinner.getSelectedItem().toString());
                    intent.putExtra("conversionValue", cardAmount.getText().toString());
                    intent.putExtra("cryptoCurrency", cardTitle.getText().toString());
                    context.startActivity(intent);
                }

            }
        });

        cryptoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String toSymbolSpinner = parent.getSelectedItem().toString();
                String toSymbol = CurrencyTable.getTickerSymbol(toSymbolSpinner);

                String fromSymbolSpinner = cardTitle.getText().toString();
                String fromSymbol = CurrencyTable.getTickerSymbol(fromSymbolSpinner);

                getConversion(fromSymbol, toSymbol, cardPosition);

                cardAmount.setText(mCard.get(cardPosition).getAmount());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void handleEmptyValue() {

        AlertDialog.Builder mAlertDialog = new AlertDialog.Builder(getContext());

        mAlertDialog.setMessage(R.string.dialog_message);

        mAlertDialog.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }

        });

        mAlertDialog.create().show();
    }

    public void getConversion(String fromSymbol, final String toSymbol, final int position) {

        mCurrencyService.getFiatCurrency(fromSymbol, toSymbol).enqueue(new Callback<FiatCurrency>() {

            @Override
            public void onResponse(Call<FiatCurrency> call, Response<FiatCurrency> response) {
                if (response.isSuccessful()) {
                    String url = call.request().url().toString();

                    Log.d("RVAdapter", "Url endpoint: " + url);
                    double amount = response.body().getCurrency(toSymbol);

                    mCard.get(position).setAmount(String.valueOf(amount));

                } else {
                    Log.d("RVAdapter", "Error getting conversion");
                }
            }

            @Override
            public void onFailure(Call<FiatCurrency> call, Throwable t) {
                Toast.makeText(getContext(), "Error connecting to the Internet", Toast.LENGTH_SHORT).show();
                mCard.get(position).setAmount("");
                notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mCard.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        CardView mCardView;
        TextView cardTitle;
        TextView cardAmount;
        Spinner cryptoSpinner;
        Button convertButton;

        private ViewHolder(View itemView) {
            super(itemView);

            mCardView = (CardView) itemView.findViewById(R.id.my_custom_card);
            cardTitle = (TextView) itemView.findViewById(R.id.card_title);
            cardAmount = (TextView) itemView.findViewById(R.id.card_amount);
            cryptoSpinner = (Spinner) itemView.findViewById(R.id.crypto_spinner);
            convertButton = (Button) itemView.findViewById(R.id.convert_button);

            inflateSpinner();
        }

        private void inflateSpinner() {
            ArrayAdapter<CharSequence> mAdapter = ArrayAdapter.createFromResource(itemView.getContext(),
                    R.array.fiat_array, android.R.layout.simple_dropdown_item_1line);

            cryptoSpinner.setAdapter(mAdapter);
        }
    }
}
