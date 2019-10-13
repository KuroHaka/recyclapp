package com.gamecode.recyclapp.ui.home;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gamecode.recyclapp.R;
import com.gamecode.recyclapp.data.model.Post;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Post post);
    }

    private List<Post> mDataset = new ArrayList<>();
    private OnItemClickListener listener;
    private View view;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView title;
        public TextView userName;
        public ImageView perfil;
        public ImageView postImg;
        public View view;

        public MyViewHolder(LinearLayout v) {
            super(v);
            this.view = v;
            title = v.findViewById(R.id.Title);
            perfil = v.findViewById(R.id.profilePic);
            postImg = v.findViewById(R.id.PostPic);
            userName = v.findViewById(R.id.username);
        }
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public PostAdapter() {
    }

    public void setDataSet(List<Post> dataSet) {
        this.mDataset = dataSet;
        notifyDataSetChanged();
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public PostAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout)  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.title.setText(mDataset.get(position).getTitle());

        holder.userName.setText(mDataset.get(position).getUsername());

        Glide.with(holder.view)
                .load(mDataset.get(position).getImage())
                .centerCrop()
                .into(holder.postImg);

        Glide.with(holder.view)
                .load(mDataset.get(position).getUsernameImg())
                .centerCrop()
                .apply(RequestOptions.circleCropTransform())
                .into(holder.perfil);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(mDataset.get(position));
            }
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
