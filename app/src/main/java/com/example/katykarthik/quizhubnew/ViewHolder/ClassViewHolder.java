package com.example.katykarthik.quizhubnew.ViewHolder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.katykarthik.quizhubnew.Interface.ItemClickListener;
import com.example.katykarthik.quizhubnew.R;

public class ClassViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView class_name;
    public ImageView class_image;

    private ItemClickListener itemClickListener;

    public ClassViewHolder(View itemView) {
        super(itemView);
        class_image = (ImageView)itemView.findViewById(R.id.class_image);
        class_name = (TextView)itemView.findViewById(R.id.class_name);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
