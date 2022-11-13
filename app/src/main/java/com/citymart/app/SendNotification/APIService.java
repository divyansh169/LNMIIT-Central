package com.citymart.app.SendNotification;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAACsNsjOs:APA91bGQ391e_WUGlXCU8zxoAsLC-SQ4FUyWVZTJEWon0KXQBKVvjgQRRP6br5A3TGFb7kNhEaNF780ReBKGe1D9R1NsK0AukKXOps6tqGq_eyyylQHAbCAnjHbC3j81lVu2BTI0-_G-"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body NotificationSender body);
}
