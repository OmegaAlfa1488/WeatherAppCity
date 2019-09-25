package com.example.mytest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterComments extends RecyclerView.Adapter<AdapterComments.ViewHolder> {

    private List<ListCommentsEvaluation> listCommentsEvaluation;
    private Context context;


    public AdapterComments(List<ListCommentsEvaluation> listCommentsEvaluation, Context context) {
        this.listCommentsEvaluation = listCommentsEvaluation;
        this.context = context;
    }

    @Override
    public AdapterComments.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_comments, parent, false);
        return new AdapterComments.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterComments.ViewHolder holder, int position) {
        final ListCommentsEvaluation listItem = listCommentsEvaluation.get(position);
        holder.textViewTitle.setText(listItem.getComment());
        holder.textViewText.setText(listItem.getRate());
    }

    @Override
    public int getItemCount() {
        return listCommentsEvaluation.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewText;
        public TextView textViewTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewText = itemView.findViewById(R.id.comment);
            textViewTitle = itemView.findViewById(R.id.rate);

        }
    }
}
