package skripsigame.skripsi.Model;

import com.google.gson.annotations.SerializedName;

public class Games {
    @SerializedName("game_name")
    private String game_name;

    @SerializedName("release_date")
    private String relase_date;

    @SerializedName("screenshot1_url")
    private String screenshot1_url;

    @SerializedName("screenshot2_url")
    private String screenshot2_url;

    @SerializedName("screnshot3_url")
    private String screenshot3_url;

    @SerializedName("photo_url")
    private String photo_url;

    @SerializedName("video_url")
    private String video_url;

    @SerializedName("harga")
    private String harga;

    @SerializedName("description")
    private String description;

    @SerializedName("OS")
    private String OS;

    @SerializedName("HDD_space")
    private String HDD_space;

    @SerializedName("rating")
    private String rating;

    @SerializedName("publisher")
    private String publisher;

    @SerializedName("id")
    private String id;

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelase_date() {
        return relase_date;
    }

    public void setRelase_date(String relase_date) {
        this.relase_date = relase_date;
    }

    public String getScreenshot1_url() {
        return screenshot1_url;
    }

    public void setScreenshot1_url(String screenshot1_url) {
        this.screenshot1_url = screenshot1_url;
    }

    public String getScreenshot2_url() {
        return screenshot2_url;
    }

    public void setScreenshot2_url(String screenshot2_url) {
        this.screenshot2_url = screenshot2_url;
    }

    public String getScreenshot3_url() {
        return screenshot3_url;
    }

    public void setScreenshot3_url(String screenshot3_url) {
        this.screenshot3_url = screenshot3_url;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getHDD_space() {
        return HDD_space;
    }

    public void setHDD_space(String HDD_space) {
        this.HDD_space = HDD_space;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
