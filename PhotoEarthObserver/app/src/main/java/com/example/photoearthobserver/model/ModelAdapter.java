package com.example.photoearthobserver.model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photoearthobserver.R;
import com.squareup.picasso.Picasso;


import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ModelHolder> {
    private Context context;
    private List<EpicModel> epicModels;

    public ModelAdapter(Context context, List<EpicModel> epicModels) {
        this.context = context;
        this.epicModels = epicModels;
    }

    @NonNull
    @Override
    public ModelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_item, parent, false);
        return new ModelHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ModelHolder holder, int position) {
        EpicModel item = epicModels.get(position);
        holder.epicModel = item;
        holder.epicDate.setText(item.getDate());
        holder.epicDesc.setText(item.getCaption());
        String[] dateWithTme = item.getDate().split(" ");
        String date = dateWithTme[0];
        String[] splitDate = date.split("-");
        String imageUrl = EpicApi.baseImageUrl.concat(splitDate[0]).concat("/").concat(splitDate[1]).
                concat("/").concat(splitDate[2]).concat("/png/").concat(item.getImage()).concat(".png");
        //Picasso.get().load(imageUrl).placeholder(R.drawable.nasa_logo).into(holder.epicImg);
        Picasso.get()
                .load(imageUrl).fit()
                .placeholder(R.drawable.nasa_logo)
                .into(holder.epicImg);
    }

    public void setEpicModels(List<EpicModel> models){
        epicModels = models;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (epicModels == null){
            return 0;
        }else{
            return epicModels.size();
        }
    }

    public class ModelHolder extends RecyclerView.ViewHolder {
        EpicModel epicModel;
        ImageView epicImg;
        TextView epicDate,epicDesc;

        ModelHolder(View itemView) {
            super(itemView);

            epicImg = itemView.findViewById(R.id.epic_img);
            epicDate = itemView.findViewById(R.id.epic_date);
            epicDesc = itemView.findViewById(R.id.epic_desc);

        }
    }
}
