package nyc.c4q.hyun.letterapplication.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hyun on 1/11/17.
 */

public class Letters {

    @SerializedName("success")
    private boolean success;
    @SerializedName("available keys")
    private List<Availablekeys> availablekeys;

    public boolean isSuccess() {
        return success;
    }

    public List<Availablekeys> getLetters() {
        return availablekeys;
    }
//
//    @Override
//    public String toString() {
//        // TODO Auto-generated method stub
//        return "Employee with first name " + firstName + " and last name " + lastName ;
//    }

}
