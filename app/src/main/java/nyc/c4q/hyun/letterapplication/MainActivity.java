package nyc.c4q.hyun.letterapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nyc.c4q.hyun.letterapplication.network.LetterFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.main_container, new LetterFragment())
                .commit();
    }
}
