package com.citymart.app.ChefFoodPanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.citymart.app.Chef;

import com.citymart.app.CustomerFoodPanel.CustomerFinalOrders;
import com.citymart.app.CustomerFoodPanel.CustomerFinalOrders1;
import com.citymart.app.CustomerFoodPanel.CustomerPayment;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChefPreparedOrderView extends AppCompatActivity {


    RecyclerView recyclerViewdish;
    private List<ChefFinalOrders> chefFinalOrdersList;
    private ChefPreparedOrderViewAdapter adapter;
    DatabaseReference reference;
    String RandomUID, userid;
    String chefidd;
    TextView grandtotal, address, name, number;
    TextView nt19, NOTE19;
    LinearLayout l1;
    Button Prepared;
    Button deliveritmyself;
    Button persontakeaway;
    Button finishtakeaway;

//    DatabaseReference orderdataflaghere;
//    Button finishdeliveritmyself;
    private ProgressDialog progressDialog;
    private APIService apiService;
//    public String stringhereflagg;
//    public int hereflagg;
    Spinner Shipper;
    String deliveryId = "Kwrnzmus0gcTOEOPNr4tu3YnBq22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_prepared_order_view);
        recyclerViewdish = findViewById(R.id.Recycle_viewOrder);
        grandtotal = findViewById(R.id.Gtotal);
        address = findViewById(R.id.Cadress);
        name = findViewById(R.id.Cname);
        number = findViewById(R.id.Cnumber);
        nt19 = findViewById(R.id.nt19);
        NOTE19 = findViewById(R.id.NOTE19);
        l1 = findViewById(R.id.linear);
//        Shipper = findViewById(R.id.shipper);
        Prepared = findViewById(R.id.prepared);
        deliveritmyself = findViewById(R.id.deliveritmyself);
        persontakeaway = findViewById(R.id.persontakeaway);
        finishtakeaway = findViewById(R.id.finishtakeaway);
//        finishdeliveritmyself = findViewById(R.id.finishdeliveritmyself);
        apiService = Client.getClient("https://fcm.googleapis.com/").create(APIService.class);
        progressDialog = new ProgressDialog(ChefPreparedOrderView.this);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        recyclerViewdish.setHasFixedSize(true);
        recyclerViewdish.setLayoutManager(new LinearLayoutManager(ChefPreparedOrderView.this));
        chefFinalOrdersList = new ArrayList<>();
        CheforderdishesView();
    }

    private void CheforderdishesView() {

        RandomUID = getIntent().getStringExtra("RandomUID");

        reference = FirebaseDatabase.getInstance().getReference("ChefFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("Dishes");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                chefFinalOrdersList.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ChefFinalOrders chefFinalOrders = snapshot.getValue(ChefFinalOrders.class);
                    chefFinalOrdersList.add(chefFinalOrders);
                }
                if (chefFinalOrdersList.size() == 0) {
                    l1.setVisibility(View.INVISIBLE);

                }
                else {
                    l1.setVisibility(View.VISIBLE);

                    finishtakeaway.setVisibility(View.INVISIBLE);


//                    if(hereflagg==1){
//
//                        Prepared.setVisibility(View.VISIBLE);
//                        deliveritmyself.setVisibility(View.VISIBLE);
//                        persontakeaway.setVisibility(View.INVISIBLE);
//
//                    }
//                    else if(hereflagg==2){
//                        Prepared.setVisibility(View.INVISIBLE);
//                        deliveritmyself.setVisibility(View.INVISIBLE);
//                        persontakeaway.setVisibility(View.VISIBLE);
//
//                    }
//                    else {
//                        Prepared.setVisibility(View.VISIBLE);
//                        deliveritmyself.setVisibility(View.VISIBLE);
//                        persontakeaway.setVisibility(View.VISIBLE);
//                    }




                    Prepared.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            persontakeaway.setVisibility(View.INVISIBLE);
                            deliveritmyself.setVisibility(View.INVISIBLE);

                            progressDialog.setMessage("Please wait...");
                            progressDialog.show();

                            DatabaseReference data = FirebaseDatabase.getInstance().getReference("Chef").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                            data.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    final Chef chef = dataSnapshot.getValue(Chef.class);
//                                    final CustomerFinalOrders1 customerFinalOrders1 = dataSnapshot.getValue(CustomerFinalOrders1.class);
//                                    final String stringnote = customerFinalOrders1.getNote();
//                                    NOTE19.setText(stringnote);
                                    final String ChefName = chef.getFname() + " " + chef.getLname();
                                    DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference("ChefFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("Dishes");
                                    databaseReference1.addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                                final ChefFinalOrders chefFinalOrders = dataSnapshot1.getValue(ChefFinalOrders.class);
                                                HashMap<String, String> hashMap = new HashMap<>();
                                                String dishid = chefFinalOrders.getDishId();
                                                userid = chefFinalOrders.getUserId();
                                                hashMap.put("ChefId", chefFinalOrders.getChefId());
                                                hashMap.put("DishId", chefFinalOrders.getDishId());
                                                hashMap.put("DishName", chefFinalOrders.getDishName());
                                                hashMap.put("DishPrice", chefFinalOrders.getDishPrice());
                                                hashMap.put("DishQuantity", chefFinalOrders.getDishQuantity());
                                                hashMap.put("RandomUID", RandomUID);
                                                hashMap.put("TotalPrice", chefFinalOrders.getTotalPrice());
                                                hashMap.put("UserId", chefFinalOrders.getUserId());
                                                FirebaseDatabase.getInstance().getReference("DeliveryShipOrders").child(deliveryId).child(RandomUID).child("Dishes").child(dishid).setValue(hashMap);
                                            }
                                            DatabaseReference data = FirebaseDatabase.getInstance().getReference("ChefFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("OtherInformation");
                                            data.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                    final ChefFinalOrders1 chefFinalOrders1 = dataSnapshot.getValue(ChefFinalOrders1.class);
                                                    HashMap<String, String> hashMap1 = new HashMap<>();
                                                    String chefid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                                    hashMap1.put("Address", chefFinalOrders1.getAddress());
                                                    hashMap1.put("ChefId", chefid);
                                                    hashMap1.put("ChefName", ChefName);
                                                    hashMap1.put("GrandTotalPrice", chefFinalOrders1.getGrandTotalPrice());
                                                    hashMap1.put("MobileNumber", chefFinalOrders1.getMobileNumber());
                                                    hashMap1.put("Note", chefFinalOrders1.getNote());
                                                    hashMap1.put("Name", chefFinalOrders1.getName());
                                                    hashMap1.put("RandomUID", RandomUID);
                                                    hashMap1.put("Status", "Order is Prepared");
                                                    hashMap1.put("UserId", userid);
                                                    FirebaseDatabase.getInstance().getReference("DeliveryShipOrders").child(deliveryId).child(RandomUID).child("OtherInformation").setValue(hashMap1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            FirebaseDatabase.getInstance().getReference("CustomerFinalOrders").child(userid).child(RandomUID).child("OtherInformation").child("Status").setValue("Order is Prepared...").addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                @Override
                                                                public void onSuccess(Void aVoid) {


//                                                                    FirebaseDatabase.getInstance().getReference("ChefFinalOrders").child(userid).child(RandomUID).child("OtherInformation").child("Note").setValue(CustomerFinalOrders1.getNote()).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                                                        @Override
//                                                                        public void onSuccess(Void aVoid) {


                                                                    FirebaseDatabase.getInstance().getReference().child("Tokens").child(userid).child("token").addListenerForSingleValueEvent(new ValueEventListener() {
                                                                        @Override
                                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                            String usertoken = dataSnapshot.getValue(String.class);
                                                                            sendNotifications(usertoken, "Estimated Time", "Your Order is Prepared", "Prepared");
                                                                        }

                                                                        @Override
                                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                        }
                                                                    });
//                                                                }
//                                                            });
                                                        }
                                                    }).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                @Override
                                                                public void onSuccess(Void aVoid) {
                                                                    FirebaseDatabase.getInstance().getReference().child("Tokens").child(deliveryId).child("token").addListenerForSingleValueEvent(new ValueEventListener() {
                                                                        @Override
                                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                            String usertoken = dataSnapshot.getValue(String.class);
                                                                            sendNotifications(usertoken, "New Order", "You have a New Order", "DeliveryOrder");
                                                                            progressDialog.dismiss();
                                                                            AlertDialog.Builder builder = new AlertDialog.Builder(ChefPreparedOrderView.this);
                                                                            builder.setMessage("Order has been sent to shipper");
                                                                            builder.setCancelable(false);
                                                                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                                                                @Override
                                                                                public void onClick(DialogInterface dialog, int which) {

                                                                                    dialog.dismiss();
                                                                                    Intent b = new Intent(ChefPreparedOrderView.this, ChefPreparedOrder.class);
                                                                                    startActivity(b);
                                                                                    finish();


                                                                                }
                                                                            });
                                                                            AlertDialog alert = builder.create();
                                                                            alert.show();
                                                                        }

                                                                        @Override
                                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

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

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });


                        }
                    });




                    deliveritmyself.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            finishtakeaway.setVisibility(View.VISIBLE);
                            persontakeaway.setVisibility(View.INVISIBLE);
                            Prepared.setVisibility(View.INVISIBLE);
                            deliveritmyself.setVisibility(View.INVISIBLE);

//                            progressDialog.setMessage("Please wait...");
//                            progressDialog.show();



                            DatabaseReference data = FirebaseDatabase.getInstance().getReference("Chef").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                            data.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    final Chef chef = dataSnapshot.getValue(Chef.class);
                                    final String ChefName = chef.getFname() + " " + chef.getLname();
                                    DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference("ChefFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("Dishes");
                                    databaseReference1.addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                                final ChefFinalOrders chefFinalOrders = dataSnapshot1.getValue(ChefFinalOrders.class);
                                                HashMap<String, String> hashMap = new HashMap<>();
                                                String dishid = chefFinalOrders.getDishId();
                                                userid = chefFinalOrders.getUserId();
                                                hashMap.put("ChefId", chefFinalOrders.getChefId());
                                                hashMap.put("DishId", chefFinalOrders.getDishId());
                                                hashMap.put("DishName", chefFinalOrders.getDishName());
                                                hashMap.put("DishPrice", chefFinalOrders.getDishPrice());
                                                hashMap.put("DishQuantity", chefFinalOrders.getDishQuantity());
                                                hashMap.put("RandomUID", RandomUID);
                                                hashMap.put("TotalPrice", chefFinalOrders.getTotalPrice());
                                                hashMap.put("UserId", chefFinalOrders.getUserId());
//                                                FirebaseDatabase.getInstance().getReference("DeliveryShipOrders").child(deliveryId).child(RandomUID).child("Dishes").child(dishid).setValue(hashMap);
                                            }
                                            DatabaseReference data = FirebaseDatabase.getInstance().getReference("ChefFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("OtherInformation");
                                            data.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                    final ChefFinalOrders1 chefFinalOrders1 = dataSnapshot.getValue(ChefFinalOrders1.class);
                                                    HashMap<String, String> hashMap1 = new HashMap<>();
                                                    String chefid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                                    chefidd=chefid;
                                                    hashMap1.put("Address", chefFinalOrders1.getAddress());
                                                    hashMap1.put("ChefId", chefid);
                                                    hashMap1.put("ChefName", ChefName);
                                                    hashMap1.put("GrandTotalPrice", chefFinalOrders1.getGrandTotalPrice());
                                                    hashMap1.put("MobileNumber", chefFinalOrders1.getMobileNumber());
                                                    hashMap1.put("Name", chefFinalOrders1.getName());
                                                    hashMap1.put("Note", chefFinalOrders1.getNote());
                                                    hashMap1.put("RandomUID", RandomUID);
                                                    hashMap1.put("Status", "Order is Prepared");
                                                    hashMap1.put("UserId", userid);
//                                                    FirebaseDatabase.getInstance().getReference("DeliveryShipOrders").child(deliveryId).child(RandomUID).child("OtherInformation").setValue(hashMap1).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                        @Override
//                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            FirebaseDatabase.getInstance().getReference("CustomerFinalOrders").child(userid).child(RandomUID).child("OtherInformation").child("Status").setValue("Order is Prepared...").addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                @Override
                                                                public void onSuccess(Void aVoid) {
                                                                    FirebaseDatabase.getInstance().getReference().child("Tokens").child(userid).child("token").addListenerForSingleValueEvent(new ValueEventListener() {
                                                                        @Override
                                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                            String usertoken = dataSnapshot.getValue(String.class);
                                                                            sendNotifications(usertoken, "Estimated Time", "Order Ready to deliver", "Prepared");
                                                                        }

                                                                        @Override
                                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                        }
                                                                    });
                                                                }
                                                            });


//                                                        }
//                                                    });
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

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });






                        }
                    });





                    persontakeaway.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            finishtakeaway.setVisibility(View.VISIBLE);
                            persontakeaway.setVisibility(View.INVISIBLE);
                            Prepared.setVisibility(View.INVISIBLE);
                            deliveritmyself.setVisibility(View.INVISIBLE);


//                            progressDialog.setMessage("Please wait...");
//                            progressDialog.show();



                            DatabaseReference data = FirebaseDatabase.getInstance().getReference("Chef").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                            data.addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    final Chef chef = dataSnapshot.getValue(Chef.class);
                                    final String ChefName = chef.getFname() + " " + chef.getLname();
                                    DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference("ChefFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("Dishes");
                                    databaseReference1.addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                                final ChefFinalOrders chefFinalOrders = dataSnapshot1.getValue(ChefFinalOrders.class);
                                                HashMap<String, String> hashMap = new HashMap<>();
                                                String dishid = chefFinalOrders.getDishId();
                                                userid = chefFinalOrders.getUserId();
                                                hashMap.put("ChefId", chefFinalOrders.getChefId());
                                                hashMap.put("DishId", chefFinalOrders.getDishId());
                                                hashMap.put("DishName", chefFinalOrders.getDishName());
                                                hashMap.put("DishPrice", chefFinalOrders.getDishPrice());
                                                hashMap.put("DishQuantity", chefFinalOrders.getDishQuantity());
                                                hashMap.put("RandomUID", RandomUID);
                                                hashMap.put("TotalPrice", chefFinalOrders.getTotalPrice());
                                                hashMap.put("UserId", chefFinalOrders.getUserId());
//                                                FirebaseDatabase.getInstance().getReference("DeliveryShipOrders").child(deliveryId).child(RandomUID).child("Dishes").child(dishid).setValue(hashMap);
                                            }
                                            DatabaseReference data = FirebaseDatabase.getInstance().getReference("ChefFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("OtherInformation");
                                            data.addListenerForSingleValueEvent(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                    final ChefFinalOrders1 chefFinalOrders1 = dataSnapshot.getValue(ChefFinalOrders1.class);
                                                    HashMap<String, String> hashMap1 = new HashMap<>();
                                                    String chefid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                                                    chefidd=chefid;
                                                    hashMap1.put("Address", chefFinalOrders1.getAddress());
                                                    hashMap1.put("ChefId", chefid);
                                                    hashMap1.put("ChefName", ChefName);
                                                    hashMap1.put("GrandTotalPrice", chefFinalOrders1.getGrandTotalPrice());
                                                    hashMap1.put("MobileNumber", chefFinalOrders1.getMobileNumber());
                                                    hashMap1.put("Name", chefFinalOrders1.getName());
                                                    hashMap1.put("Note", chefFinalOrders1.getNote());
                                                    hashMap1.put("RandomUID", RandomUID);
                                                    hashMap1.put("Status", "Order is Prepared");
                                                    hashMap1.put("UserId", userid);
//                                                    FirebaseDatabase.getInstance().getReference("DeliveryShipOrders").child(deliveryId).child(RandomUID).child("OtherInformation").setValue(hashMap1).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                        @Override
//                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            FirebaseDatabase.getInstance().getReference("CustomerFinalOrders").child(userid).child(RandomUID).child("OtherInformation").child("Status").setValue("Order is Prepared...").addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                @Override
                                                                public void onSuccess(Void aVoid) {
                                                                    FirebaseDatabase.getInstance().getReference().child("Tokens").child(userid).child("token").addListenerForSingleValueEvent(new ValueEventListener() {
                                                                        @Override
                                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                            String usertoken = dataSnapshot.getValue(String.class);
                                                                            sendNotifications(usertoken, "Estimated Time", "Order Ready for Takeaway", "Prepared");
                                                                        }

                                                                        @Override
                                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                                        }
                                                                    });
                                                                }
                                                            });


//                                                        }
//                                                    });
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

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });






                        }
                    });


                    finishtakeaway.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            progressDialog.setMessage("Please wait...");
                            progressDialog.show();

                            finishtakeaway.setVisibility(View.INVISIBLE);

                            FirebaseDatabase.getInstance().getReference("CustomerFinalOrders").child(userid).child(RandomUID).child("OtherInformation").child("Status").setValue("Your Order is Prepared").addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    FirebaseDatabase.getInstance().getReference().child("Tokens").child(userid).child("token").addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String usertoken = dataSnapshot.getValue(String.class);
                                            sendNotifications(usertoken, "Home Chef", "Thank you for Ordering", "ThankYou");
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                }
                            }).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    FirebaseDatabase.getInstance().getReference().child("Tokens").child(chefidd).child("token").addListenerForSingleValueEvent(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String usertoken = dataSnapshot.getValue(String.class);
                                            sendNotifications(usertoken, "Order Placed", "Message of Order Ready reached to the Customer", "Delivered");
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                }
                            }).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    FirebaseDatabase.getInstance().getReference("CustomerFinalOrders").child(userid).child(RandomUID).child("Dishes").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            FirebaseDatabase.getInstance().getReference("CustomerFinalOrders").child(userid).child(RandomUID).child("OtherInformation").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {

                                                    FirebaseDatabase.getInstance().getReference("AlreadyOrdered").child(userid).child("isOrdered").setValue("false");

//                                                    FirebaseDatabase.getInstance().getReference("DeliveryShipFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("Dishes").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                        @Override
//                                                        public void onComplete(@NonNull Task<Void> task) {
//                                                            FirebaseDatabase.getInstance().getReference("DeliveryShipFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("OtherInformation").removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
//                                                                @Override
//                                                                public void onSuccess(Void aVoid) {
//                                                                    FirebaseDatabase.getInstance().getReference("AlreadyOrdered").child(userid).child("isOrdered").setValue("false");
//                                                                }
//                                                            });
//                                                        }
//                                                    });
                                                }
                                            });
                                        }
                                    });
                                }
                            }).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    FirebaseDatabase.getInstance().getReference("ChefFinalOrders").child(chefidd).child(RandomUID).child("Dishes").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            FirebaseDatabase.getInstance().getReference("ChefFinalOrders").child(chefidd).child(RandomUID).child("OtherInformation").removeValue();
                                        }
                                    });
                                }
                            });
                            AlertDialog.Builder builder = new AlertDialog.Builder(ChefPreparedOrderView.this);
                            builder.setMessage("Message of Order Ready reached to the Customer");
                            builder.setCancelable(false);
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    dialog.dismiss();
                                    Intent b = new Intent(ChefPreparedOrderView.this, ChefPreparedOrder.class);
                                    startActivity(b);
                                    finish();


                                }
                            });

                            progressDialog.dismiss();
                            AlertDialog.Builder builder119 = new AlertDialog.Builder(ChefPreparedOrderView.this);
                            builder119.setMessage("Finished Successfully!");
                            builder119.setCancelable(false);
                            builder119.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    dialog.dismiss();
                                    Intent b = new Intent(ChefPreparedOrderView.this, ChefPreparedOrder.class);
                                    startActivity(b);
                                    finish();


                                }
                            });
                            AlertDialog alert = builder119.create();
                            alert.show();

                        }
                    });


//                    finishdeliveritmyself.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//
//                            finishdeliveritmyself.setVisibility(View.INVISIBLE);
//
//                            FirebaseDatabase.getInstance().getReference("CustomerFinalOrders").child(userid).child(RandomUID).child("OtherInformation").child("Status").setValue("Your Order is Prepared. You Can Now Go to Take Your Order").addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void aVoid) {
//                                    FirebaseDatabase.getInstance().getReference().child("Tokens").child(userid).child("token").addListenerForSingleValueEvent(new ValueEventListener() {
//                                        @Override
//                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                                            String usertoken = dataSnapshot.getValue(String.class);
//                                            sendNotifications(usertoken, "Home Chef", "Thank you for Ordering", "ThankYou");
//                                        }
//
//                                        @Override
//                                        public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                                        }
//                                    });
//                                }
//                            }).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void aVoid) {
//                                    FirebaseDatabase.getInstance().getReference().child("Tokens").child(chefidd).child("token").addListenerForSingleValueEvent(new ValueEventListener() {
//                                        @Override
//                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                                            String usertoken = dataSnapshot.getValue(String.class);
//                                            sendNotifications(usertoken, "Order Placed", "Message of Order Ready for deliver reached to the Customer", "Delivered");
//                                        }
//
//                                        @Override
//                                        public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                                        }
//                                    });
//                                }
//                            }).addOnSuccessListener(new OnSuccessListener<Void>() {
//                                @Override
//                                public void onSuccess(Void aVoid) {
//                                    FirebaseDatabase.getInstance().getReference("CustomerFinalOrders").child(userid).child(RandomUID).child("Dishes").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
//                                        @Override
//                                        public void onComplete(@NonNull Task<Void> task) {
//                                            FirebaseDatabase.getInstance().getReference("CustomerFinalOrders").child(userid).child(RandomUID).child("OtherInformation").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                @Override
//                                                public void onComplete(@NonNull Task<Void> task) {
//                                                    FirebaseDatabase.getInstance().getReference("DeliveryShipFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("Dishes").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                        @Override
//                                                        public void onComplete(@NonNull Task<Void> task) {
//                                                            FirebaseDatabase.getInstance().getReference("DeliveryShipFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("OtherInformation").removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
//                                                                @Override
//                                                                public void onSuccess(Void aVoid) {
//                                                                    FirebaseDatabase.getInstance().getReference("AlreadyOrdered").child(userid).child("isOrdered").setValue("false");
//                                                                }
//                                                            });
//                                                        }
//                                                    });
//                                                }
//                                            });
//                                        }
//                                    });
//                                }
//                            }).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    FirebaseDatabase.getInstance().getReference("ChefFinalOrders").child(chefidd).child(RandomUID).child("Dishes").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
//                                        @Override
//                                        public void onComplete(@NonNull Task<Void> task) {
//                                            FirebaseDatabase.getInstance().getReference("ChefFinalOrders").child(chefidd).child(RandomUID).child("OtherInformation").removeValue();
//                                        }
//                                    });
//                                }
//                            });
//                            AlertDialog.Builder builder = new AlertDialog.Builder(ChefPreparedOrderView.this);
//                            builder.setMessage("Message of Order Ready for Deliver reached to the Customer");
//                            builder.setCancelable(false);
//                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//
//                                    dialog.dismiss();
//                                    Intent b = new Intent(ChefPreparedOrderView.this, ChefPreparedOrder.class);
//                                    startActivity(b);
//                                    finish();
//
//
//                                }
//                            });
//
//                        }
//                    });




                }
                adapter = new ChefPreparedOrderViewAdapter(ChefPreparedOrderView.this, chefFinalOrdersList);
                recyclerViewdish.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("ChefFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("OtherInformation");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ChefFinalOrders1 chefFinalOrders1 = dataSnapshot.getValue(ChefFinalOrders1.class);
                grandtotal.setText("₹ " + chefFinalOrders1.getGrandTotalPrice());
                address.setText(chefFinalOrders1.getAddress());
                name.setText(chefFinalOrders1.getName());
                NOTE19.setText(chefFinalOrders1.getNote());
                number.setText("+91" + chefFinalOrders1.getMobileNumber());

//                CustomerFinalOrders1 customerFinalOrders1 = dataSnapshot.getValue(CustomerFinalOrders1.class);
//                NOTE19.setText(customerFinalOrders1.getNote());

            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


//        DatabaseReference databaseReferenceee = FirebaseDatabase.getInstance().getReference("ChefWaitingOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(RandomUID).child("OtherInformation");
//        databaseReferenceee.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                ChefWaitingOrders1 chefWaitingOrders1 = dataSnapshot.getValue(ChefWaitingOrders1.class);
//                NOTE19.setText(chefWaitingOrders1.getNote());
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });


    }

    private void sendNotifications(String usertoken, String title, String message, String prepared) {

        Data data = new Data(title, message, prepared);
        NotificationSender sender = new NotificationSender(data, usertoken);
        apiService.sendNotification(sender).enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                if (response.code() == 200) {
                    if (response.body().success != 1) {
                        Toast.makeText(ChefPreparedOrderView.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {

            }
        });
    }
}
