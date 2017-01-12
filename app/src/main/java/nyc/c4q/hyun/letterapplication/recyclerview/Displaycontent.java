package nyc.c4q.hyun.letterapplication.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import nyc.c4q.hyun.letterapplication.R;

/**
 * Created by Hyun on 1/11/17.
 */
public class Displaycontent extends AppCompatActivity{

    private static final String API_URL = "http://jsjrobotics.nyc";
    private ImageView imageView;
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewimage_layout);

        imageView = (ImageView) findViewById(R.id.seetheimage);

        Bundle fromLetterVH = getIntent().getExtras();
        if(fromLetterVH!=null){
            url = fromLetterVH.getString("thephoto",url);
            Picasso.with(this).load(API_URL+url).fit().into(imageView);
        }

    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this,"Heading back soon", Toast.LENGTH_LONG).show();
        int i = 0;
        if(i<1){
            onBackPressed();
            i++;
        } else {
            Intent intent = new Intent(this, Displaycontent.class);
            intent.putExtra("toActivity",1);
            startActivity(intent);
        }
        super.onBackPressed();

    }
}
