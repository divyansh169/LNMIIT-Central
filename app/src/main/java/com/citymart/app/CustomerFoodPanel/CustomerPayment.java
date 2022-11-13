package com.citymart.app.CustomerFoodPanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.citymart.app.ChefFoodPanel.Type;
import com.citymart.app.ChefFoodPanel.Type2;
import com.citymart.app.CustomerFoodPanel_BottomNavigation;
import com.citymart.app.R;
import com.citymart.app.SendNotification.APIService;
import com.citymart.app.SendNotification.Client;
import com.citymart.app.SendNotification.Data;
import com.citymart.app.SendNotification.MyResponse;
import com.citymart.app.SendNotification.NotificationSender;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.razorpay.Checkout;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CustomerPayment extends AppCompatActivity {

    TextView OnlinePayment, CashPayment, upipayment, takeitaway;
    LottieAnimationView deliveryanim;
    LottieAnimationView takeanim;
    LottieAnimationView helpanim, twitteranim, instaanim, linkedinanim, gmailanim, whatsappanim;
    TextView needhelp;
    public static int flag=0;
//    public static String stringflag;
    DatabaseReference orderdataflag;
    Dialog dialog;
    String RandomUID, ChefID;
    private APIService apiService;
    private TextView textView;
//    private static final String TAG = "Razorpay";
//    Checkout checkout;
//    RazorpayClient razorpayClient;
//    Order order;

    private String order_receipt_no = "Receipt No. " +  System.currentTimeMillis()/1000;
    private String order_reference_no = "Reference No. #" +  System.currentTimeMillis()/1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_payment);

//        OnlinePayment = (TextView) findViewById(R.id.online);
//        upipayment = (TextView) findViewById(R.id.upipayment);
//        CashPayment = (TextView) findViewById(R.id.cash);
        needhelp = (TextView) findViewById(R.id.needhelp);
        deliveryanim = findViewById(R.id.deliveryanim);
        takeanim = findViewById(R.id.takeanim);
        helpanim = findViewById(R.id.helpanim);
//        twitteranim, instaanim, linkedinanim, gmailanim, whatsappanim
        twitteranim = findViewById(R.id.twitteranim);
        instaanim = findViewById(R.id.instaanim);
        linkedinanim = findViewById(R.id.linkedinanim);
        gmailanim = findViewById(R.id.gmailanim);
        whatsappanim = findViewById(R.id.whatsappanim);
//        facebookanim = findViewById(R.id.facebookanim);
        dialog= new Dialog(this);
//        takeitaway = (TextView) findViewById(R.id.takeitaway);
        RandomUID = getIntent().getStringExtra("RandomUID");
        apiService = Client.getClient("https://fcm.googleapis.com/").create(APIService.class);

//        textView.setText("Payment ID: " + s);
//        textView.append("\nOrder ID: " + order.get("id"));
//        textView.append("\n" + order_reference_no);

//        OnlinePayment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(CustomerPayment.this, CustomerOnlinePayment.class);
//                intent.putExtra("randomUID", RandomUID);
//                startActivity(intent);
//            }
//        });

//        upipayment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(CustomerPayment.this, PaytmGateway.class);
//                intent.putExtra("randomUID", RandomUID);
//                startActivity(intent);
//            }
//        });


        deliveryanim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                orderdataflag = FirebaseDatabase.getInstance().getReference().child("orderflag");
//                flag=1;
//                Type2 type2= new Type2(flag);
//                orderdataflag.push().setValue(type2);
//
//                stringflag = String.valueOf(flag);

                openDialog();

                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("Dishes");
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            final CustomerPaymentOrders customerPaymentOrders = dataSnapshot1.getValue(CustomerPaymentOrders.class);
                            HashMap<String, String> hashMap = new HashMap<>();
                            String dishid = customerPaymentOrders.getDishId();
                            hashMap.put("ChefId", customerPaymentOrders.getChefId());
                            hashMap.put("DishId", customerPaymentOrders.getDishId());
                            hashMap.put("DishName", customerPaymentOrders.getDishName());
                            hashMap.put("DishPrice", customerPaymentOrders.getDishPrice());
                            hashMap.put("DishQuantity", customerPaymentOrders.getDishQuantity());
                            hashMap.put("RandomUID", RandomUID);
                            hashMap.put("TotalPrice", customerPaymentOrders.getTotalPrice());
                            hashMap.put("UserId", customerPaymentOrders.getUserId());
                            FirebaseDatabase.getInstance().getReference("CustomerFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("Dishes").child(dishid).setValue(hashMap);
                        }
                        DatabaseReference data = FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("OtherInformation");
                        data.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                final CustomerPaymentOrders1 customerPaymentOrders1 = dataSnapshot.getValue(CustomerPaymentOrders1.class);
                                HashMap<String, String> hashMap1 = new HashMap<>();
                                hashMap1.put("Address", customerPaymentOrders1.getAddress());
                                hashMap1.put("GrandTotalPrice", customerPaymentOrders1.getGrandTotalPrice());
                                hashMap1.put("MobileNumber", customerPaymentOrders1.getMobileNumber());
                                hashMap1.put("Name", customerPaymentOrders1.getName());
                                hashMap1.put("Note", customerPaymentOrders1.getNote());
//                                hashMap1.put("OrderFlag", stringflag);
                                hashMap1.put("RandomUID", RandomUID);
                                hashMap1.put("Status", "Your order is waiting to be prepared by Chef...");
                                FirebaseDatabase.getInstance().getReference("CustomerFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("OtherInformation").setValue(hashMap1).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        DatabaseReference Reference = FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("Dishes");
                                        Reference.addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                                    final CustomerPaymentOrders customerPaymentOrderss = snapshot.getValue(CustomerPaymentOrders.class);
                                                    HashMap<String, String> hashMap2 = new HashMap<>();
                                                    String dishid = customerPaymentOrderss.getDishId();
                                                    ChefID = customerPaymentOrderss.getChefId();
                                                    hashMap2.put("ChefId", customerPaymentOrderss.getChefId());
                                                    hashMap2.put("DishId", customerPaymentOrderss.getDishId());
                                                    hashMap2.put("DishName", customerPaymentOrderss.getDishName());
                                                    hashMap2.put("DishPrice", customerPaymentOrderss.getDishPrice());
                                                    hashMap2.put("DishQuantity", customerPaymentOrderss.getDishQuantity());
                                                    hashMap2.put("RandomUID", RandomUID);
                                                    hashMap2.put("TotalPrice", customerPaymentOrderss.getTotalPrice());
                                                    hashMap2.put("UserId", customerPaymentOrderss.getUserId());
                                                    FirebaseDatabase.getInstance().getReference("ChefWaitingOrders").child(ChefID).child(RandomUID).child("Dishes").child(dishid).setValue(hashMap2);
                                                }
                                                DatabaseReference dataa = FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("OtherInformation");
                                                dataa.addListenerForSingleValueEvent(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                        CustomerPaymentOrders1 customerPaymentOrders11 = dataSnapshot.getValue(CustomerPaymentOrders1.class);
                                                        HashMap<String, String> hashMap3 = new HashMap<>();
                                                        hashMap3.put("Address", customerPaymentOrders11.getAddress());
                                                        hashMap3.put("GrandTotalPrice", customerPaymentOrders11.getGrandTotalPrice());
                                                        hashMap3.put("MobileNumber", customerPaymentOrders11.getMobileNumber());
                                                        hashMap3.put("Name", customerPaymentOrders11.getName());
                                                        hashMap3.put("Note", customerPaymentOrders11.getNote());
//                                                        hashMap3.put("OrderFlag", stringflag);
                                                        hashMap3.put("RandomUID", RandomUID);
                                                        hashMap3.put("Status", "Your order is waiting to be prepared by Seller...");
                                                        FirebaseDatabase.getInstance().getReference("ChefWaitingOrders").child(ChefID).child(RandomUID).child("OtherInformation").setValue(hashMap3).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                FirebaseDatabase.getInstance().getReference("ChefPaymentOrders").child(ChefID).child(RandomUID).child("Dishes").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                    @Override
                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                        FirebaseDatabase.getInstance().getReference("ChefPaymentOrders").child(ChefID).child(RandomUID).child("OtherInformation").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                            @Override
                                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                                FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("Dishes").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                    @Override
                                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                                        FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("OtherInformation").removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                                            @Override
                                                                                            public void onSuccess(Void aVoid) {
                                                                                                FirebaseDatabase.getInstance().getReference().child("Tokens").child(ChefID).child("token").addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                                    @Override
                                                                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                                        String usertoken = dataSnapshot.getValue(String.class);
                                                                                                        sendNotifications(usertoken, "Order Confirmed", "Payment mode is confirmed by user, Now you can start the order", "Confirm");
                                                                                                    }

                                                                                                    @Override
                                                                                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                                    }
                                                                                                });

                                                                                            }
                                                                                        }).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                                            @Override
                                                                                            public void onSuccess(Void aVoid) {
                                                                                                AlertDialog.Builder builder = new AlertDialog.Builder(CustomerPayment.this);
                                                                                                builder.setMessage("Payment mode confirmed, Now you can track your order.");
                                                                                                builder.setCancelable(false);
                                                                                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                                                    @Override
                                                                                                    public void onClick(DialogInterface dialog, int which) {

                                                                                                        dialog.dismiss();
                                                                                                        Intent b = new Intent(CustomerPayment.this, CustomerFoodPanel_BottomNavigation.class);
                                                                                                        b.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                                                                        startActivity(b);
                                                                                                        finish();

                                                                                                    }
                                                                                                });
                                                                                                AlertDialog alert = builder.create();
                                                                                                alert.show();
                                                                                            }
                                                                                        });
                                                                                    }
                                                                                });
                                                                            }
                                                                        });
                                                                    }
                                                                });
                                                            }
                                                        });

                                                    }

                                                    @Override
                                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                                    }
                                                });

                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                    }
                                });


                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }

        });

        takeanim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                orderdataflag = FirebaseDatabase.getInstance().getReference().child("orderflag");
//                flag=2;
//                Type2 type2= new Type2(flag);
//                orderdataflag.push().setValue(type2);
//
//                stringflag = String.valueOf(flag);

                openDialog();

                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("Dishes");
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            final CustomerPaymentOrders customerPaymentOrders = dataSnapshot1.getValue(CustomerPaymentOrders.class);
                            HashMap<String, String> hashMap = new HashMap<>();
                            String dishid = customerPaymentOrders.getDishId();
                            hashMap.put("ChefId", customerPaymentOrders.getChefId());
                            hashMap.put("DishId", customerPaymentOrders.getDishId());
                            hashMap.put("DishName", customerPaymentOrders.getDishName());
                            hashMap.put("DishPrice", customerPaymentOrders.getDishPrice());
                            hashMap.put("DishQuantity", customerPaymentOrders.getDishQuantity());
                            hashMap.put("RandomUID", RandomUID);
                            hashMap.put("TotalPrice", customerPaymentOrders.getTotalPrice());
                            hashMap.put("UserId", customerPaymentOrders.getUserId());
                            FirebaseDatabase.getInstance().getReference("CustomerFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("Dishes").child(dishid).setValue(hashMap);
                        }
                        DatabaseReference data = FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("OtherInformation");
                        data.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                final CustomerPaymentOrders1 customerPaymentOrders1 = dataSnapshot.getValue(CustomerPaymentOrders1.class);
                                HashMap<String, String> hashMap1 = new HashMap<>();
                                hashMap1.put("Address", customerPaymentOrders1.getAddress());
                                hashMap1.put("GrandTotalPrice", customerPaymentOrders1.getGrandTotalPrice());
                                hashMap1.put("MobileNumber", customerPaymentOrders1.getMobileNumber());
                                hashMap1.put("Name", customerPaymentOrders1.getName());
                                hashMap1.put("Note", customerPaymentOrders1.getNote());
//                                hashMap1.put("OrderFlag", stringflag);
                                hashMap1.put("RandomUID", RandomUID);
                                hashMap1.put("Status", "Your order is waiting to be prepared by Seller...");
                                FirebaseDatabase.getInstance().getReference("CustomerFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("OtherInformation").setValue(hashMap1).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        DatabaseReference Reference = FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("Dishes");
                                        Reference.addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                                    final CustomerPaymentOrders customerPaymentOrderss = snapshot.getValue(CustomerPaymentOrders.class);
                                                    HashMap<String, String> hashMap2 = new HashMap<>();
                                                    String dishid = customerPaymentOrderss.getDishId();
                                                    ChefID = customerPaymentOrderss.getChefId();
                                                    hashMap2.put("ChefId", customerPaymentOrderss.getChefId());
                                                    hashMap2.put("DishId", customerPaymentOrderss.getDishId());
                                                    hashMap2.put("DishName", customerPaymentOrderss.getDishName());
                                                    hashMap2.put("DishPrice", customerPaymentOrderss.getDishPrice());
                                                    hashMap2.put("DishQuantity", customerPaymentOrderss.getDishQuantity());
                                                    hashMap2.put("RandomUID", RandomUID);
                                                    hashMap2.put("TotalPrice", customerPaymentOrderss.getTotalPrice());
                                                    hashMap2.put("UserId", customerPaymentOrderss.getUserId());
                                                    FirebaseDatabase.getInstance().getReference("ChefWaitingOrders").child(ChefID).child(RandomUID).child("Dishes").child(dishid).setValue(hashMap2);
                                                }
                                                DatabaseReference dataa = FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("OtherInformation");
                                                dataa.addListenerForSingleValueEvent(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                        CustomerPaymentOrders1 customerPaymentOrders11 = dataSnapshot.getValue(CustomerPaymentOrders1.class);
                                                        HashMap<String, String> hashMap3 = new HashMap<>();
                                                        hashMap3.put("Address", customerPaymentOrders11.getAddress());
                                                        hashMap3.put("GrandTotalPrice", customerPaymentOrders11.getGrandTotalPrice());
                                                        hashMap3.put("MobileNumber", customerPaymentOrders11.getMobileNumber());
                                                        hashMap3.put("Name", customerPaymentOrders11.getName());
                                                        hashMap3.put("Note", customerPaymentOrders11.getNote());
//                                                        hashMap3.put("OrderFlag", stringflag);
                                                        hashMap3.put("RandomUID", RandomUID);
                                                        hashMap3.put("Status", "Your order is waiting to be prepared by Seller...");
                                                        FirebaseDatabase.getInstance().getReference("ChefWaitingOrders").child(ChefID).child(RandomUID).child("OtherInformation").setValue(hashMap3).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                FirebaseDatabase.getInstance().getReference("ChefPaymentOrders").child(ChefID).child(RandomUID).child("Dishes").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                    @Override
                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                        FirebaseDatabase.getInstance().getReference("ChefPaymentOrders").child(ChefID).child(RandomUID).child("OtherInformation").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                            @Override
                                                                            public void onComplete(@NonNull Task<Void> task) {
                                                                                FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("Dishes").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                    @Override
                                                                                    public void onComplete(@NonNull Task<Void> task) {
                                                                                        FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("OtherInformation").removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                                            @Override
                                                                                            public void onSuccess(Void aVoid) {
                                                                                                FirebaseDatabase.getInstance().getReference().child("Tokens").child(ChefID).child("token").addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                                    @Override
                                                                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                                        String usertoken = dataSnapshot.getValue(String.class);
                                                                                                        sendNotifications(usertoken, "Order Confirmed", "Payment mode is confirmed by user, Now you can start the order", "Confirm");
                                                                                                    }

                                                                                                    @Override
                                                                                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                                                    }
                                                                                                });

                                                                                            }
                                                                                        }).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                                            @Override
                                                                                            public void onSuccess(Void aVoid) {
                                                                                                AlertDialog.Builder builder = new AlertDialog.Builder(CustomerPayment.this);
                                                                                                builder.setMessage("Payment mode confirmed, Now you can track your order.");
                                                                                                builder.setCancelable(false);
                                                                                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                                                    @Override
                                                                                                    public void onClick(DialogInterface dialog, int which) {

                                                                                                        dialog.dismiss();
                                                                                                        Intent b = new Intent(CustomerPayment.this, CustomerFoodPanel_BottomNavigation.class);
                                                                                                        b.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                                                                        startActivity(b);
                                                                                                        finish();

                                                                                                    }
                                                                                                });
                                                                                                AlertDialog alert = builder.create();
                                                                                                alert.show();
                                                                                            }
                                                                                        });
                                                                                    }
                                                                                });
                                                                            }
                                                                        });
                                                                    }
                                                                });
                                                            }
                                                        });

                                                    }

                                                    @Override
                                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                                    }
                                                });

                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                    }
                                });


                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        helpanim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                helpanim.setVisibility(View.GONE);
                needhelp.setVisibility(View.GONE);
                twitteranim.setVisibility(View.VISIBLE);
                instaanim.setVisibility(View.VISIBLE);
                linkedinanim.setVisibility(View.VISIBLE);
                gmailanim.setVisibility(View.VISIBLE);
                whatsappanim.setVisibility(View.VISIBLE);

//                facebookanim.setVisibility(View.VISIBLE);



            }
        });

        needhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                helpanim.setVisibility(View.GONE);
                needhelp.setVisibility(View.GONE);
                twitteranim.setVisibility(View.VISIBLE);
                instaanim.setVisibility(View.VISIBLE);
                linkedinanim.setVisibility(View.VISIBLE);
                gmailanim.setVisibility(View.VISIBLE);
                whatsappanim.setVisibility(View.VISIBLE);

//                facebookanim.setVisibility(View.VISIBLE);



            }
        });

//        helpanim.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                backanim.setAnimation(R.raw.help);
//                twitteranim.setVisibility(View.INVISIBLE);
//                instaanim.setVisibility(View.INVISIBLE);
//                linkedinanim.setVisibility(View.INVISIBLE);
//                gmailanim.setVisibility(View.INVISIBLE);
//                whatsappanim.setVisibility(View.INVISIBLE);
//
////                facebookanim.setVisibility(View.VISIBLE);
//
//
//
//            }
//        });

    }

    private void openDialog() {

        dialog.setContentView(R.layout.activity_loading_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        LottieAnimationView loadingutensils = dialog.findViewById(R.id.progressAnimationView);
        dialog.show();

    }

    private void sendNotifications(String usertoken, String title, String message, String confirm) {
        Data data = new Data(title, message, confirm);
        NotificationSender sender = new NotificationSender(data, usertoken);
        apiService.sendNotification(sender).enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                if (response.code() == 200) {
                    if (response.body().success != 1) {
                        Toast.makeText(CustomerPayment.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {

            }
        });
    }
}
