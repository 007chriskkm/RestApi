package com.christopher.example.sazi.leaderboard;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.christopher.example.sazi.leaderboard.LearningModel.learner;
import com.christopher.example.sazi.leaderboard.ViewHolder.LearnerAdapter;
import java.util.ArrayList;
import java.util.List;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class frag1 extends Fragment {

    private RecyclerView recyclerView;
    public LearnerAdapter adapter;
    public List<learner> learners;


    public frag1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.learning_leader,container,false);
        recyclerView = view.findViewById(R.id.recyclerview_item1);

        adapter = new LearnerAdapter();

        loadViewdata();

        return view;

    }

    private void loadViewdata() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api_Learner.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api_Learner Api = retrofit.create(Api_Learner.class);
        Call<List<learner>> call = Api.getlearner();
        call.enqueue(new Callback<List<learner>>() {
            @Override
            public void onResponse(Call<List<learner>> call, Response<List<learner>> response) {
                if (response.isSuccessful()){
                    List<learner> learners = response.body();
                    adapter.SetLearners(learners);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));


                    Log.d("Api call 200","data are coming from api");


                }

            }

            @Override
            public void onFailure(Call<List<learner>> call, Throwable t) {

                Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_SHORT).show();

                Log.d("Error get api data",t.getLocalizedMessage());

            }
        });


        }

}

