package nyc.c4q.hyun.letterapplication.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.hyun.letterapplication.R;
import nyc.c4q.hyun.letterapplication.network.Availablekeys;

/**
 * Created by Hyun on 1/11/17.
 */
public class LetterAdapter extends RecyclerView.Adapter<LetterViewHolder> {

    private List<Availablekeys> letters;
    private View view;

    public LetterAdapter(List<Availablekeys> letters) {
        this.letters = letters;
    }

    @Override
    public LetterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        view = layoutInflater
                .inflate(R.layout.recycler_layout, parent, false);
        return new LetterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LetterViewHolder holder, int position) {
        holder.setData(letters.get(position));
    }

    @Override
    public int getItemCount() {
        return letters.size();
    }
}