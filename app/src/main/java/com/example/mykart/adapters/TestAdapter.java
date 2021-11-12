package com.example.mykart.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mykart.R;

import java.awt.font.TextAttribute;
import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    List<String> test;
    Context context;

    public TestAdapter(Context context, List<String> temp){
        this.test = temp;
        this.context = context;
    }

    @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.rv_row_test, parent, false );
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return test.size();
    }

    static public class TestViewHolder extends RecyclerView.ViewHolder {
        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
