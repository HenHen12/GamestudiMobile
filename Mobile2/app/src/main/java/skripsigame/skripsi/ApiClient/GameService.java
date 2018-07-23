package skripsigame.skripsi.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import skripsigame.skripsi.Data.GameData;
import skripsigame.skripsi.Model.Games;

public interface GameService {
    @FormUrlEncoded
    @GET("games/populargameMobile")
    Call<List<Games>> getGame();
}
