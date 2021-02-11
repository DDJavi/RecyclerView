package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterWord> {

    class AdapterWord extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Adapter adapter;
        public TextView itemView;

        public AdapterWord(View itemView, Adapter adapter) {
            super(itemView);
            this.itemView = itemView.findViewById(R.id.word);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            this.itemView.setText("Clicked!" + this.itemView.getText());
        }
    }

    private LayoutInflater layoutInflater;
    private LinkedList<String> words;

    public Adapter(Context context, LinkedList<String> words) {
        this.layoutInflater = LayoutInflater.from(context);
        this.words = words;
    }


    @Override
    public AdapterWord onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = this.layoutInflater.inflate(R.layout.item, parent, false);
        return new AdapterWord(mItemView, this);
    }

    @Override
    public void onBindViewHolder( AdapterWord holder, int position) {
        String mCurrent = this.words.get(position);
        holder.itemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return this.words.size();
    }
}
