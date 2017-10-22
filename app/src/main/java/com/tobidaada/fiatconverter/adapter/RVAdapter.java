package com.tobidaada.fiatconverter.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.tobidaada.fiatconverter.R;
import com.tobidaada.fiatconverter.model.data.Card;

import java.util.List;

/**
 * Created by TOBI DAADA on 10/22/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private List<Card> mCard;

    public RVAdapter(List<Card> mCard) {
        this.mCard = mCard;
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
        holder.cardTitle.setText(mCard.get(position).getTitle());
        holder.cardAmount.setText(mCard.get(position).getAmount());
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
