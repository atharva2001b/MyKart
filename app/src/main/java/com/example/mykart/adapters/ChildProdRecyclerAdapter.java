package com.example.mykart.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mykart.R;
import com.example.mykart.models.ChildProdEntity;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ChildProdRecyclerAdapter extends RecyclerView.Adapter<ChildProdRecyclerAdapter.ChildRecyclerViewHolder> {

    ArrayList<ChildProdEntity> itemList;
    Context context;

    public ChildProdRecyclerAdapter(Context context, ArrayList<ChildProdEntity> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ChildRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_child_prod_rv, parent, false);
        return new ChildRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildRecyclerViewHolder holder, int position) {

        holder.prodName.setText(itemList.get(position).getProdName());
        holder.prodPrice.setText(itemList.get(position).getPrice());
        holder.prodOfferPrice.setText(itemList.get(position).getOfferPrice());

        RequestOptions options = new RequestOptions().placeholder(R.drawable.ic_bag)
                .error(R.drawable.ic_bag);

        Glide.with(context)
                .applyDefaultRequestOptions(options)
                .load(itemList.get(position).getImg())
                .into(holder.prodImg);
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ChildRecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView prodImg;
        TextView prodName;
        TextView prodPrice;
        TextView prodOfferPrice;

        public ChildRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            prodImg = itemView.findViewById(R.id.img_prod);
            prodName = itemView.findViewById(R.id.txt_prod_name);
            prodPrice = itemView.findViewById(R.id.txt_price);
            prodOfferPrice = itemView.findViewById(R.id.txt_offer_price);

        }
    }
}
