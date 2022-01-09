package com.example.mykart.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mykart.R;
import com.example.mykart.fragments.offersFragment;
import com.example.mykart.models.Deals;

import java.util.ArrayList;

public class DealsRecyclerAdapter extends RecyclerView.Adapter<DealsRecyclerAdapter.DealsViewHolder> {

    ArrayList<Deals> deals;
    Context context;
    ImageView img;

    public DealsRecyclerAdapter(Context context, ArrayList<Deals> deals) {
        this.deals = deals;
        this.context = context;
    }

    @NonNull
    @Override
    public DealsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_todays_deals, parent, false);


        return new DealsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealsViewHolder holder, int position) {

        RequestOptions options = new RequestOptions().placeholder(R.drawable.ic_bag);

        Glide.with(context)
                .applyDefaultRequestOptions(options)
                .load(deals.get(position).getImg())
                .into(img);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((AppCompatActivity)context).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new offersFragment()).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return deals.size();
    }

    public class DealsViewHolder extends RecyclerView.ViewHolder {
        public DealsViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_deals);
        }
    }
}
