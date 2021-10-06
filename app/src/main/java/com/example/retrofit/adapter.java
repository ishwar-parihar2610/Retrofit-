package com.example.retrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.retrofit.databinding.HeroListRecycleBinding;
import com.example.retrofit.model.Results;

import java.util.ArrayList;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.viewHolder> {
    List<Results> resultsArrayList;
    LayoutInflater inflater;
    Context context;

    public adapter(List<Results> resultsArrayList,Context context) {
        this.resultsArrayList = resultsArrayList;
        this.context=context;
    }




    @Override
    public adapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater==null){
            inflater=LayoutInflater.from(parent.getContext());
        }
        return new viewHolder(DataBindingUtil.inflate(inflater,R.layout.hero_list_recycle,parent,false));
    }

    @Override
    public void onBindViewHolder(adapter.viewHolder holder, int position) {
       Results results=resultsArrayList.get(position);
       holder.binding.nameTextView.setText("name : "+results.getName());
       holder.binding.realNameTextView.setText("Real Name :"+results.getRealname());
       holder.binding.teamTextView.setText("Team :"+results.getTeam());
       holder.binding.firstAppearanceTextView.setText("firstappearance :"+results.getFirstappearance());
       holder.binding.createdByTextView.setText("created by :"+results.getCreatedby());
       holder.binding.publisherTextView.setText("publisher :"+results.getPublisher());
        Glide.with(context).load(results.getImageurl()).into(holder.binding.heroImageView);
        holder.binding.bioTextView.setText("Bio :"+results.getBio());





    }

    @Override
    public int getItemCount() {
        return resultsArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        HeroListRecycleBinding binding;
        public viewHolder( HeroListRecycleBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
