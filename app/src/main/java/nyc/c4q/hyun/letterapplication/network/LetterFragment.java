package nyc.c4q.hyun.letterapplication.network;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import nyc.c4q.hyun.letterapplication.R;
import nyc.c4q.hyun.letterapplication.recyclerview.LetterAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hyun on 1/11/17.
 */

public class LetterFragment extends Fragment {

    private static final String API_URL = "http://jsjrobotics.nyc/";

    private RecyclerView mRecycler;
    private Letters readLetters;
    private List<Availablekeys> letters;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.letter_layout,container,false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        LetterService service = retrofit.create(LetterService.class);
        Call<Letters> posts = service.getLetters();
        posts.enqueue(new Callback<Letters>(){
            @Override
            public void onResponse(Call<Letters> call, Response<Letters> response) {
                readLetters = response.body();
                letters = readLetters.getLetters();

                mRecycler = (RecyclerView) getActivity().findViewById(R.id.letter_RV);
                mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                mRecycler.setAdapter(new LetterAdapter(letters));

                Toast.makeText(getActivity(),"SUCCESSSSS", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<Letters> call, Throwable t) {
                Toast.makeText(getActivity(),"failedddd",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
