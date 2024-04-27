package data.retrofit;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("users")
    <User>
    Call<ArrayList<User>> getUsers();

    @GET("users/{username}")
    <User>
    Call<User> getUser(@Path("username") String username);
}
