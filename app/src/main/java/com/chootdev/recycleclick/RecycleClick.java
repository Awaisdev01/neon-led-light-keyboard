package com.chootdev.recycleclick;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Minimal local replacement for the discontinued com.chootdev:recycleclick
 * library. Adds an item-click listener to a RecyclerView.
 */
public final class RecycleClick {

    public interface OnItemClickListener {
        void onItemClicked(RecyclerView recyclerView, int position, View view);
    }

    public interface OnItemLongClickListener {
        boolean onItemLongClicked(RecyclerView recyclerView, int position, View view);
    }

    private RecycleClick() {
    }

    public static ClickManager addTo(RecyclerView recyclerView) {
        return new ClickManager(recyclerView);
    }

    public static class ClickManager {

        private final RecyclerView recyclerView;

        ClickManager(RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
        }

        public RecyclerView setOnItemClickListener(final OnItemClickListener listener) {
            recyclerView.addOnItemTouchListener(new RecyclerTouchListener(recyclerView.getContext(),
                    recyclerView, new RecyclerTouchListener.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                    if (listener != null) {
                        listener.onItemClicked(recyclerView, position, view);
                    }
                }

                @Override
                public void onLongClick(View view, int position) {
                }
            }));
            return recyclerView;
        }

        public RecyclerView setOnItemLongClickListener(final OnItemLongClickListener listener) {
            recyclerView.addOnItemTouchListener(new RecyclerTouchListener(recyclerView.getContext(),
                    recyclerView, new RecyclerTouchListener.ClickListener() {
                @Override
                public void onClick(View view, int position) {
                }

                @Override
                public void onLongClick(View view, int position) {
                    if (listener != null) {
                        listener.onItemLongClicked(recyclerView, position, view);
                    }
                }
            }));
            return recyclerView;
        }
    }
}
