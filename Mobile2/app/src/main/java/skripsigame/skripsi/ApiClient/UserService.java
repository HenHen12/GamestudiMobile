package skripsigame.skripsi.ApiClient;


import retrofit.http.Body;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import retrofit2.Call;
import skripsigame.skripsi.Model.User;

public interface UserService {
    @POST("masuk")
    Call<User> login (@Body User user);

}
