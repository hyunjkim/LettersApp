package nyc.c4q.hyun.letterapplication.recyclerview;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.hyun.letterapplication.R;
import nyc.c4q.hyun.letterapplication.network.Availablekeys;

/**
 * Created by Hyun on 1/11/17.
 */
public class LetterViewHolder extends RecyclerView.ViewHolder{

    private TextView textView;
    private String url;

    public LetterViewHolder(View view) {
        super(view);
        textView = (TextView) view.findViewById(R.id.lettersTV);
    }

    public void setData(Availablekeys keys) {
        url = keys.getUrl();

        textView.setText(keys.getName());
        textView.setTextColor(Color.parseColor(keys.getTextColor()));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.lettersTV){
                Intent intent = new Intent(v.getContext(), Displaycontent.class);
                intent.putExtra("thephoto",url);
                v.getContext().startActivity(intent);
                }
            }
        });
    }
}
