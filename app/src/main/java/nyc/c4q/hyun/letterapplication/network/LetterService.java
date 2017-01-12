package nyc.c4q.hyun.letterapplication.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Hyun on 1/11/17.
 */

public interface LetterService {

    @GET("cgi-bin/1_11_2017_exam.pl")
    Call<Letters> getLetters();
}
