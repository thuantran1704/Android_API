package com.example.wibugrams.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wibugrams.Model.Post;
import com.example.wibugrams.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends ArrayAdapter<Post> {
    Context context;
    int resource;
    Post post = null;
    ArrayList<Post> data = null;


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

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        PostHolder holder = null;

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

        final Post post = data.get(position);
        holder.username.setText(post.getUser().getUsername());
//            holder.img_profile.setImageDrawable(post.getImage());
//            Picasso.with(getBaseContext()).load(post.getImage());

        holder.username.setText(post.getUser().getUsername());
        holder.username.setText(post.getUser().getUsername());
        holder.username.setText(post.getUser().getUsername());
        holder.username.setText(post.getUser().getUsername());
        holder.username.setText(post.getUser().getUsername());


        return row;
    }
}



