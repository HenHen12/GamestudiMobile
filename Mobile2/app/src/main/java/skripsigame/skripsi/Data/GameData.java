package skripsigame.skripsi.Data;

public class GameData {
    String game_name;
    String release_date;
    String harga;
    String id;
    String rating;
    String photo_url;

    public GameData(String game_name, String release_date, String harga, String id, String rating, String photo_url){
        this.game_name = game_name;
        this.release_date = release_date;
        this.harga = harga;
        this.id = id;
        this.rating = rating;
        this.photo_url =photo_url;
    }

    public String getGame_name() {return  game_name;}
    public String getRelease_date() {return release_date;}
    public String getHarga() {return  harga;}
    public String getId() {return  id;}
    public String getRating() {return rating;}
    public String getPhoto_url() {return photo_url;}
}
