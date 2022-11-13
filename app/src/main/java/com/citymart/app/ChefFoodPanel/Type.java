package com.citymart.app.ChefFoodPanel;

import android.widget.Spinner;

public class Type {


    String deliverychargetext;
    String enablepodt_flag;
    String randomuidk;

    public Type(){

    }

    public Type(String deliverychargetext, String enablepodt_flag, String randomuidk) {

        this.deliverychargetext = deliverychargetext;
        this.enablepodt_flag = enablepodt_flag;
        this.randomuidk = randomuidk;
    }

    public String getdeliverychargetext() {
        return deliverychargetext;
    }
    public String getEnablepodt_flag() {
        return enablepodt_flag;
    }
    public String getRandomuidk() {
        return randomuidk;
    }
    public void  setdeliverychargetext(String deliverychargetext) {
        this.deliverychargetext = deliverychargetext;
    }
    public void  setEnablepodt_flag(String enablepodt_flag) {
        this.enablepodt_flag = enablepodt_flag;
    }
    public void  setRandomuidk(String randomuidk) {
        this.randomuidk = randomuidk;
    }


}
