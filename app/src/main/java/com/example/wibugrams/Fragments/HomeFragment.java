package com.example.wibugrams.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.eschao.android.widget.elasticlistview.ElasticListView;
import com.eschao.android.widget.elasticlistview.OnLoadListener;
import com.eschao.android.widget.elasticlistview.OnUpdateListener;
import com.example.wibugrams.Adapter.PostAdapter;
import com.example.wibugrams.Common;
import com.example.wibugrams.Model.JSONResponsePost;
import com.example.wibugrams.Model.Post;
import com.example.wibugrams.R;
import com.example.wibugrams.Retrofit.ApiInterface;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment implements OnUpdateListener, OnLoadListener {
    private static final String TAG = "HomeFragment";
    final String key = "APIKEY";
    private ArrayList<Post> posts;
    PostAdapter viewPagerAdapter;
    //    private ListView mListView;
    ElasticListView mListView;
    RecyclerView mRecyclerView;
    ApiInterface service;


    @Override
    public void onUpdate() {
        Log.d(TAG, "ElasticListView: updating list view...");
//        getFollowing();
    }

    @Override
    public void onLoad() {
        Log.d(TAG, "ElasticListView: loading...");
        // Notify load is done
        mListView.notifyLoaded();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = (View) inflater.inflate(R.layout.fragment_login, container, false);

        mListView = view.findViewById(R.id.listView);

        service = Common.getGsonService();
        init();

        return view;
    }

    private void init() {
        if (Common.isConnectedToInternet(getActivity().getBaseContext())) {
            ProgressDialog mDialog = new ProgressDialog(getActivity().getBaseContext().getApplicationContext());
            loadJSONPost();

//            mListView.scheduleLayoutAnimation();

        } else {
            Toast.makeText(getActivity(), "Please check your internet!!", Toast.LENGTH_SHORT).show();
//            return;
        }
    }

    private void loadJSONPost() {
        service.getPost(key).enqueue(new Callback<JSONResponsePost>() {
            @Override
            public void onResponse(Call<JSONResponsePost> call, Response<JSONResponsePost> response) {
                JSONResponsePost jsonResponsePost = response.body();
                if (jsonResponsePost.getData() == null) {
                    Toast.makeText(getActivity(), "This Home does not has Post", Toast.LENGTH_SHORT).show();
                    return;
                }
                posts = new ArrayList<>(Arrays.asList(jsonResponsePost.getData()));
                viewPagerAdapter = new PostAdapter(getActivity(), R.layout.activity_home, posts);
                mListView.setAdapter(viewPagerAdapter);
            }

            @Override
            public void onFailure(Call<JSONResponsePost> call, Throwable t) {
                Toast.makeText(getContext(), "Erro : "+ t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}


//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = (View) inflater.inflate(R.layout.fragment_home, container, false);
//        mListView = view.findViewById(R.id.listView);
//        tvResult = view.findViewById(R.id.tvResult);
//
//        service = Common.getGsonService();
//
//        if(Common.isConnectedToInternet(getActivity().getBaseContext())){
//            ProgressDialog mDialog = new ProgressDialog(getActivity().getBaseContext().getApplicationContext());
//
//            service.getPost("VSBG").enqueue(new Callback<JSONResponsePost>() {
//                @Override
//                public void onResponse(Call<JSONResponsePost> call, Response<JSONResponsePost> response) {
//                    Log.e("vlxx","abc");
//                    if(Integer.parseInt(response.body().getStatus())==1){
//
//                        JSONResponsePost jsonResponsePost = response.body();
//                        posts = new ArrayList<>(Arrays.asList(jsonResponsePost.getData()));
//                        for(Post post1 : posts){
//                            String str="";
//                            str+=post1.getUser().getName()+"\n";
//                            str+=post1.getImage()+"\n";
//                            tvResult.append(str);
//
//                        }
//
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<JSONResponsePost> call, Throwable t) {
//
//                    Toast.makeText(getContext(), "ấccacaca", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//
//        }else{
//            Toast.makeText(getActivity().getBaseContext(), "Please check your connection !!", Toast.LENGTH_SHORT).show();
////                    return;
//        }
//
//        return view;
//
//    }
