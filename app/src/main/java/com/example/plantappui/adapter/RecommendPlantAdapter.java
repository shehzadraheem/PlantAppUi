package com.example.plantappui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantappui.R;
import com.example.plantappui.model.Plant;

import java.util.List;

public class RecommendPlantAdapter extends RecyclerView.Adapter<RecommendPlantAdapter.ViewHolder> {

    private Context context;
    private List<Plant> recommendList;

    public RecommendPlantAdapter(Context context, List<Plant> recommendList) {
        this.context = context;
        this.recommendList = recommendList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recommend_item_plant,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.plantImage.setImageResource(recommendList.get(position).getPlantImage());
        holder.plantName.setText(recommendList.get(position).getPlantName());
        holder.plantPrice.setText(recommendList.get(position).getPlantPrice());
        holder.plantCountry.setText(recommendList.get(position).getPlantCountry());
    }

    @Override
    public int getItemCount() {
        return recommendList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView plantImage;
        private TextView plantName,plantPrice,plantCountry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            plantImage = itemView.findViewById(R.id.recommend_item_plant_picture);
            plantName = itemView.findViewById(R.id.recommend_item_plant_title);
            plantPrice = itemView.findViewById(R.id.recommend_item_plant_price);
            plantCountry = itemView.findViewById(R.id.recommend_item_plant_country);
        }
    }
}
