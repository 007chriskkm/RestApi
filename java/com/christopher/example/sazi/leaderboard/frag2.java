package com.christopher.example.sazi.leaderboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.christopher.example.sazi.leaderboard.LearningModel.skill_student;
import com.christopher.example.sazi.leaderboard.ViewHolder.SkillAdapter;
import java.util.List;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class frag2 extends Fragment {

    RecyclerView mrecyclerview;
    SkillAdapter myAdapter;
    List<skill_student> elites;


    public frag2() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.skill_iq, container, false);
        mrecyclerview = v.findViewById(R.id.recyclerview_item2);

        myAdapter = new SkillAdapter();

        loadData();
        return v;
    }

    private void loadData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiSkill.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiSkill api_call = retrofit.create(ApiSkill.class);
        Call<List<skill_student>> call = api_call.getSkills();
        call.enqueue(new Callback<List<skill_student>>() {
            @Override
            public void onResponse(Call<List<skill_student>> call, Response<List<skill_student>> response) {

                if (response.isSuccessful()){

                    List<skill_student> elites = response.body();
                    myAdapter.SetSkills(elites);
                    mrecyclerview.setAdapter(myAdapter);
                    mrecyclerview.setLayoutManager( new LinearLayoutManager(getActivity()));
                    Log.d("Api call 200","data are coming from api");
                }
            }

            @Override
            public void onFailure(Call<List<skill_student>> call, Throwable t) {

                Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_SHORT).show();

                Log.d("Error get api data",t.getLocalizedMessage());

            }
        });
    }
}
