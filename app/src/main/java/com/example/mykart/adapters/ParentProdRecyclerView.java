package com.example.mykart.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykart.R;
import com.example.mykart.models.ChildProdEntity;

import java.util.ArrayList;

public class ParentProdRecyclerView extends RecyclerView.Adapter<ParentProdRecyclerView.ParentViewHolder> {

    ArrayList<ChildProdEntity> itemList;
    Context context;

    public ParentProdRecyclerView(Context context, ArrayList<ChildProdEntity> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_parent_prod_rv, parent, false);

        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {

        LinearLayoutManager childLayout = new LinearLayoutManager(context);
        childLayout.setOrientation(RecyclerView.HORIZONTAL);
        ChildProdRecyclerAdapter childProdRecyclerAdapter = new ChildProdRecyclerAdapter(context, itemList);
        holder.child_rv.setLayoutManager(childLayout);
        holder.child_rv.setAdapter(childProdRecyclerAdapter);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ParentViewHolder extends RecyclerView.ViewHolder {

        RecyclerView child_rv;

        public ParentViewHolder(@NonNull View itemView) {
            super(itemView);

            child_rv = itemView.findViewById(R.id.rv_prod_child);
        }
    }
}
