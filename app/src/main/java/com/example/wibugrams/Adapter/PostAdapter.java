package com.example.wibugrams.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wibugrams.Common;
import com.example.wibugrams.Home.HomeActivity;
import com.example.wibugrams.Interface.ItemClickListener;
import com.example.wibugrams.Model.Post;
import com.example.wibugrams.Profile.ProfileActivity;
import com.example.wibugrams.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends ArrayAdapter<Post> {
    Context context;
    int resource;
    Post post = null;
    ArrayList<Post> data = null;
    PostAdapter adapter;
    PostHolder holder = null;


    public PostAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Post> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    class PostHolder {
        CircleImageView img_profile;
        TextView username, count_like, publisher, description, no_of_comments;
        ImageView post_image, like, comment;

        public PostHolder() {
        }
    }

    @Override
    public int getCount() {
        return data.size();
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.e("abc","abcd");
        View row = convertView;


        if (row != null) {
            holder = (PostHolder) row.getTag();
        } else {
            holder = new PostHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            row = inflater.inflate(R.layout.post_item, parent, false);

            holder.username = row.findViewById(R.id.username);
            holder.img_profile = row.findViewById(R.id.img_profile);
            holder.description = row.findViewById(R.id.description);
            holder.publisher = row.findViewById(R.id.publisher);
            holder.post_image = row.findViewById(R.id.post_image);
            holder.like = row.findViewById(R.id.like);
            holder.comment = row.findViewById(R.id.comment);

            row.setTag(holder);
        }

         Post post = data.get(position);
        holder.username.setText(post.getUser().getUsername());
//            holder.img_profile.setImageDrawable(post.getImage());
//            Picasso.with(getBaseContext()).load(post.getImage());

        //holder.post_image.setText(post.getUser().getUsername());
        holder.description.setText(post.getContent());

        //Picasso.with(getBaseContext()).load(post.getImage()).into(holder.post_image);
        Picasso.get().load(data.get(position).getImage())
                .into(holder.post_image);
        /*holder.username.setText(post.getUser().getUsername());
        holder.username.setText(post.getUser().getUsername());
        holder.username.setText(post.getUser().getUsername());*/


        holder.img_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHome = new Intent(getContext(), ProfileActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("UserID", String.valueOf(post.getUser().getId()));
                intentHome.putExtras(bundle);
                Log.e("ghi","slasdjsaldjaslsd"+String.valueOf(post.getUser().getId()));
                /*intentHome.putExtra("UserID",adapter.post.getUser().getId());
                Log.e("def","slaldkasldasl");*/
                context.startActivity(intentHome);
            }
        });

            /*@Override
            public void onClick(View v, int position) {
                //Common.currentUser.setUsername(post.getUser().getUsername());
                Intent intentHome = new Intent(getContext(), ProfileActivity.class);
                intentHome.putExtra("UserID",holder.username.getId());
                context.startActivity(intentHome);
                //getActivity().getFragmentManager().popBackStack();
            }*/


        return row;
    }
}



