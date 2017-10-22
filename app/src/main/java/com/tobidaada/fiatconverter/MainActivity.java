package com.tobidaada.fiatconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.tobidaada.fiatconverter.adapter.RVAdapter;
import com.tobidaada.fiatconverter.adapter.RVTouchListener;
import com.tobidaada.fiatconverter.model.data.Card;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Card> mCardList;
    RVAdapter adapter;
    RecyclerView mRecyclerView;
    CardView mCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCardView = (CardView) findViewById(R.id.my_custom_card);
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(llm);

        mCardList = new ArrayList<>();

        adapter = new RVAdapter(mCardList);

        mRecyclerView.setAdapter(adapter);

        initializeCard();

        adapter.notifyItemChanged(mCardList.size() - 1);

        mRecyclerView.addOnItemTouchListener(new RVTouchListener(getApplicationContext(), mRecyclerView,
                new RVTouchListener.ClickListener() {

                    @Override
                    public void onClick(View view, int position) {

                        Button button = (Button) findViewById(R.id.convert_button);

                        final int adapterPosition = position;

                        /*TextView mTextView = (TextView) findViewById(R.id.card_amount);
                        Spinner mSpinner = (Spinner) findViewById(R.id.crypto_spinner); */

                        Log.i("MainActivity", "AdapterPosition: " + position);

                       switch (position) {

                            case 1:

                                break;

                            case 2:

                                break;
                        }

                    }
                }));

    }

    public void initializeCard() {
        mCardList.add( new Card("Bitcoin", "235432345.23", 23));
        mCardList.add(new Card("Ethereum", "1234523.33", 2323));
    }
}
