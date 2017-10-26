package com.tobidaada.fiatconverter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by TOBI DAADA on 10/22/2017.
 */

public class RVTouchListener implements RecyclerView.OnItemTouchListener{

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);

    }

    private GestureDetector mGestureDetector;
    private ClickListener mClickListener;

    public RVTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {

        mClickListener = clickListener;

        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return true;
            }

            @Override
            public void onLongPress(MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if (child != null && mClickListener != null) {
                    mClickListener.onLongClick( child, recyclerView.getChildAdapterPosition(child));
                }
            }

        });
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View child = rv.findChildViewUnder(e.getX(), e.getY());

        if (child != null && mClickListener != null && mGestureDetector.onTouchEvent(e)) {
            mClickListener.onClick(child, rv.getChildAdapterPosition(child));
        }

        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
