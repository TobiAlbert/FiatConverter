package com.tobidaada.fiatconverter.adapter;

import android.content.Context;
import android.content.Intent;
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

import com.tobidaada.fiatconverter.R;
import com.tobidaada.fiatconverter.model.data.Card;
import com.tobidaada.fiatconverter.model.data.CryptoTable;
import com.tobidaada.fiatconverter.model.data.FiatCurrency;
import com.tobidaada.fiatconverter.model.data.FiatCurrencyTable;
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
        TextView cardTitle = holder.cardTitle;
        final TextView cardAmount = holder.cardAmount;
        Spinner cryptoSpinner = holder.cryptoSpinner;

        cardTitle.setText(mCard.get(position).getTitle());
        cardAmount.setText(mCard.get(position).getAmount());
        cryptoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
