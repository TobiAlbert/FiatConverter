package com.tobidaada.fiatconverter;

import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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

        mRecyclerView.addOnItemTouchListener(new RVTouchListener(getApplicationContext(), mRecyclerView,
                new RVTouchListener.ClickListener() {

                    @Override
                    public void onClick(View view, int position) {

                    }

                    @Override
                    public void onLongClick(View view, int position) {

                        final int cardPosition = position;

                        AlertDialog.Builder mAlertDialog = new AlertDialog.Builder(view.getContext());
                        mAlertDialog.setMessage(R.string.delete_card)
                                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int position) {

                                        position = cardPosition;

                                        mCardList.remove(position);
                                        adapter.notifyItemRemoved(position);
                                        dialog.dismiss();
                                    }

                                })
                                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog , int position) {
                                        dialog.dismiss();
                                    }

                                });

                        mAlertDialog.create().show();
                    }
                }));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {

        switch(menuItem.getItemId()) {
            case R.id.add_card:
                createNewCard();
                return true;

            default:
                return super.onOptionsItemSelected(menuItem);
        }

    }

    public void createNewCard() {
        AlertDialog.Builder mAlertDialog = new AlertDialog.Builder(this);
        mAlertDialog.setTitle("Choose a Card")
                .setItems(R.array.card_array, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        switch(which) {
                            case 0:
                                mCardList.add(new Card("Bitcoin", ""));
                                break;
                            case 1:
                                mCardList.add(new Card("Ethereum", ""));
                                break;
                        }

                        adapter.notifyItemInserted(mCardList.size() - 1);
                        mRecyclerView.smoothScrollToPosition(mCardList.size() - 1);

                        Snackbar.make(mRecyclerView, "Card Created", Snackbar.LENGTH_SHORT)
                                .setAction(R.string.undo, new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        mCardList.remove(mCardList.size() - 1);
                                        adapter.notifyItemRemoved(mCardList.size());
                                    }

                                })
                                .setActionTextColor(ContextCompat.getColor(mRecyclerView.getContext(), R.color.colorPrimary))
                                .show();

                    }
                });

        mAlertDialog.create().show();
    }

    public void initializeCard() {
        mCardList.add( new Card("Bitcoin", ""));
    }

}
