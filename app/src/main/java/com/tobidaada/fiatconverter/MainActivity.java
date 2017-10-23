package com.tobidaada.fiatconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;


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

        adapter = new RVAdapter(mCardList, this);

        mRecyclerView.setAdapter(adapter);

        initializeCard();

        adapter.notifyItemChanged(mCardList.size() - 1);

        mRecyclerView.addOnItemTouchListener(new RVTouchListener(getApplicationContext(), mRecyclerView,
                new RVTouchListener.ClickListener() {

                    @Override
                    public void onClick(View view, int position) {

                    }
                }));

    }

    public void initializeCard() {
        mCardList.add( new Card("Bitcoin", "235432345.23", 23));
        mCardList.add(new Card("Ethereum", "1234523.33", 2323));
    }
}
