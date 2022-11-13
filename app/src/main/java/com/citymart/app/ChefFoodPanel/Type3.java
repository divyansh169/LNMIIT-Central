package com.citymart.app.ChefFoodPanel;

public class Type3 {

    public String Sellerid,ImageURL, RandomUID;

    public Type3(String sellerid, String imageURL, String randomUID) {
        this.Sellerid = sellerid;
        this.ImageURL = imageURL;
        this.RandomUID = randomUID;
    }

    public String getSellerid() {
        return Sellerid;
    }
    public String getImageURL() {
        return ImageURL;
    }
    public String getRandomUID() {
        return RandomUID;
    }


}
