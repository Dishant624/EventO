package com.example.evento.Coordinator.Home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.evento.Coordinator.EventDetail;
import com.example.evento.R;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
   
    private ArrayList<Integer> imagelist = new ArrayList<>();
    private final LayoutInflater inflater;
    Context mContext;
    private Random randomGenerator = new Random();

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.back_image)
        ImageView backImage;
        @BindView(R.id.textView3)
        TextView textView3;
        @BindView(R.id.textView4)
        TextView textView4;
        @BindView(R.id.imageView2)
        ImageView imageView2;
        @BindView(R.id.textView5)
        TextView textView5;
        @BindView(R.id.textView6)
        TextView textView6;

        public ViewHolder(View itemView) {
            super(itemView);
            this.backImage = (ImageView) itemView.findViewById(R.id.back_image);
            ButterKnife.bind((Object) this, itemView);
        }
    }

    public EventAdapter(Context context) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
        this.imagelist.add(R.drawable.card_bg_1);
        this.imagelist.add(R.drawable.card_bg_2);
        this.imagelist.add(R.drawable.card_bg);
        this.imagelist.add(R.drawable.card_bg_4);
        this.imagelist.add(R.drawable.card_bg_5);
        this.imagelist.add(R.drawable.card_bg_6);
        this.imagelist.add(R.drawable.card_bg_7);
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(this.inflater.inflate(R.layout.single_event, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.backImage.setImageResource(((Integer) this.imagelist.get(this.randomGenerator.nextInt(this.imagelist.size()))).intValue());
        holder.itemView.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                EventAdapter.this.mContext.startActivity(new Intent(EventAdapter.this.mContext, EventDetail.class));
            }
        });
    }

    public int getItemCount() {
        return 10;
    }
}
