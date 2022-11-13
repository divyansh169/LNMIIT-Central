package com.citymart.app.ChefFoodPanel;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;

import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ProgressDialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.citymart.app.Customer;
import com.citymart.app.CustomerFoodPanel.CustomerPayment;
import com.citymart.app.CustomerFoodPanel.PayableOrders;
import com.citymart.app.CustomerFoodPanel_BottomNavigation;
import com.citymart.app.Login;
import com.citymart.app.MainActivity;
import com.citymart.app.R;
import com.citymart.app.ReusableCode.ReusableCodeForAll;
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

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChefPendingOrdersAdapter extends RecyclerView.Adapter<ChefPendingOrdersAdapter.ViewHolder> {

    private Context context;
    private List<ChefPendingOrders1> chefPendingOrders1list;
    private APIService apiService;
    private ProgressDialog progressDialog;
    String userid, dishid;
    public static String fprice;
    public Button paydlbtn, nopaybtn;
    public String enablepodt_flag="0";
    CheckBox enablepodt;
    String randomuidk;
    public static String fnumber;
    public static String deliverychargetext;


    public String useriddd;

    DatabaseReference databaseReference, dataa;
    FirebaseDatabase firebaseDatabasee;


    public ChefPendingOrdersAdapter(Context context, List<ChefPendingOrders1> chefPendingOrders1list) {
        this.chefPendingOrders1list = chefPendingOrders1list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.chef_orders, parent, false);
        apiService = Client.getClient("https://fcm.googleapis.com/").create(APIService.class);
        return new ChefPendingOrdersAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final ChefPendingOrders1 chefPendingOrders1 = chefPendingOrders1list.get(position);
        holder.Address.setText(chefPendingOrders1.getAddress());
        holder.grandtotalprice.setText("Total Price: ₹ " + chefPendingOrders1.getGrandTotalPrice());

        holder.NOTE2.setText(chefPendingOrders1.getNote());
        holder.nm2.setText(chefPendingOrders1.getName());
        holder.num2.setText("+91" + chefPendingOrders1.getMobileNumber());
        final String random = chefPendingOrders1.getRandomUID();
        randomuidk = random;
        holder.Vieworder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Chef_order_dishes.class);
                intent.putExtra("RandomUID", random);
                context.startActivity(intent);
            }
        });

        progressDialog = new ProgressDialog(context);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);

        holder.paydlbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.paydlbtn.setVisibility(View.GONE);
                holder.nopaybtn.setVisibility(View.GONE);
                enablepodt.setTextColor(Color.parseColor("#5FB709"));
                enablepodt_flag = "1";

            }
        });
        holder.nopaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.nopaybtn.setVisibility(View.GONE);
                holder.paydlbtn.setVisibility(View.GONE);
                enablepodt.setTextColor(Color.parseColor("#ff0000"));
                enablepodt_flag = "10";

            }
        });

        holder.Accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference = FirebaseDatabase.getInstance().getReference("ChefPendingOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(random).child("Dishes");
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            ChefPendingOrders chefPendingOrders = snapshot.getValue(ChefPendingOrders.class);
//                        ChefPendingOrders chefPendingOrders = dataSnapshot.getValue(ChefPendingOrders.class);
//                            final String randomuido = snapshot.getKey();
//                            randomuuuiiiddd = randomuido;
                            final String usedid = chefPendingOrders.getUserId();
                            useriddd = usedid;


                dataa = FirebaseDatabase.getInstance().getReference().child("deliveryCharge").child(useriddd);
                String deliverychargetext = holder.deliverychargetext.getText().toString();

//                if (enablepodt.isChecked()) {
//                    enablepodt.setTextColor(Color.parseColor("#5FB709"));
//                    enablepodt_flag = "1";
//                }
//                else{
//                    enablepodt.setTextColor(Color.parseColor("#ff0000"));
//                    enablepodt_flag = "10";
//                }

                Type type = new Type(deliverychargetext, enablepodt_flag, randomuidk);
                dataa.setValue(type);


                int number = Integer.parseInt(deliverychargetext);
                fnumber = String.valueOf(number);
                fprice = String.valueOf(Integer.parseInt(chefPendingOrders1.getGrandTotalPrice()) + number);
                holder.finalgrandtotal.setText("Final Grand Total: ₹ " + fprice);

//                FirebaseDatabase.getInstance().getReference("deliveryCharge").removeValue();


                Toast.makeText(context, "Wait for The Message To Appear!", Toast.LENGTH_SHORT).show();

                progressDialog.setMessage("Please wait...");
                progressDialog.show();

                holder.Accept.setVisibility(View.GONE);
                holder.Vieworder.setVisibility(View.GONE);
                holder.Reject.setVisibility(View.GONE);

                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("ChefPendingOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(random).child("Dishes");
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            final ChefPendingOrders chefPendingOrders = snapshot.getValue(ChefPendingOrders.class);
                            HashMap<String, String> hashMap = new HashMap<>();
                            String chefid = chefPendingOrders.getChefId();
                            String dishid = chefPendingOrders.getDishId();
                            hashMap.put("ChefId", chefPendingOrders.getChefId());
                            hashMap.put("DishId", chefPendingOrders.getDishId());
                            hashMap.put("DishName", chefPendingOrders.getDishName());
                            hashMap.put("DishPrice", chefPendingOrders.getPrice());
                            hashMap.put("DishQuantity", chefPendingOrders.getDishQuantity());
                            hashMap.put("RandomUID", random);
                            hashMap.put("TotalPrice", chefPendingOrders.getTotalPrice());
                            hashMap.put("UserId", chefPendingOrders.getUserId());
                            FirebaseDatabase.getInstance().getReference("ChefPaymentOrders").child(chefid).child(random).child("Dishes").child(dishid).setValue(hashMap);
                        }
                        DatabaseReference data = FirebaseDatabase.getInstance().getReference("ChefPendingOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(random).child("OtherInformation");
                        data.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                ChefPendingOrders1 chefPendingOrders1 = dataSnapshot.getValue(ChefPendingOrders1.class);
                                HashMap<String, String> hashMap1 = new HashMap<>();
                                hashMap1.put("Address", chefPendingOrders1.getAddress());
//                                hashMap1.put("GrandTotalPrice", chefPendingOrders1.getGrandTotalPrice());
                                hashMap1.put("GrandTotalPrice", fprice);
                                hashMap1.put("MobileNumber", chefPendingOrders1.getMobileNumber());
                                hashMap1.put("Name", chefPendingOrders1.getName());
                                hashMap1.put("Note", chefPendingOrders1.getNote());
                                hashMap1.put("RandomUID", random);
                                FirebaseDatabase.getInstance().getReference("ChefPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(random).child("OtherInformation").setValue(hashMap1).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        DatabaseReference Reference = FirebaseDatabase.getInstance().getReference("ChefPendingOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(random).child("Dishes");
                                        Reference.addListenerForSingleValueEvent(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                                    final ChefPendingOrders chefPendingOrders = snapshot.getValue(ChefPendingOrders.class);
                                                    HashMap<String, String> hashMap2 = new HashMap<>();
                                                    userid = chefPendingOrders.getUserId();
                                                    dishid = chefPendingOrders.getDishId();
                                                    hashMap2.put("ChefId", chefPendingOrders.getChefId());
                                                    hashMap2.put("DishId", chefPendingOrders.getDishId());
                                                    hashMap2.put("DishName", chefPendingOrders.getDishName());
                                                    hashMap2.put("DishPrice", chefPendingOrders.getPrice());
                                                    hashMap2.put("DishQuantity", chefPendingOrders.getDishQuantity());
                                                    hashMap2.put("RandomUID", random);
                                                    hashMap2.put("TotalPrice", chefPendingOrders.getTotalPrice());
                                                    hashMap2.put("UserId", chefPendingOrders.getUserId());
                                                    FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(userid).child(random).child("Dishes").child(dishid).setValue(hashMap2);
                                                }
                                                DatabaseReference dataa = FirebaseDatabase.getInstance().getReference("ChefPendingOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(random).child("OtherInformation");
                                                dataa.addListenerForSingleValueEvent(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                        ChefPendingOrders1 chefPendingOrders1 = dataSnapshot.getValue(ChefPendingOrders1.class);
                                                        HashMap<String, String> hashMap3 = new HashMap<>();
                                                        hashMap3.put("Address", chefPendingOrders1.getAddress());
//                                                        hashMap3.put("GrandTotalPrice", chefPendingOrders1.getGrandTotalPrice());
                                                        hashMap3.put("GrandTotalPrice", fprice);
                                                        hashMap3.put("MobileNumber", chefPendingOrders1.getMobileNumber());
                                                        hashMap3.put("Name", chefPendingOrders1.getName());
                                                        hashMap3.put("Note", chefPendingOrders1.getNote());
                                                        hashMap3.put("RandomUID", random);
                                                        FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(userid).child(random).child("OtherInformation").setValue(hashMap3).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                            @Override
                                                            public void onComplete(@NonNull Task<Void> task) {

                                                                FirebaseDatabase.getInstance().getReference("CustomerPendingOrders").child(userid).child(random).child("Dishes").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                    @Override
                                                                    public void onComplete(@NonNull Task<Void> task) {

                                                                        FirebaseDatabase.getInstance().getReference("CustomerPendingOrders").child(userid).child(random).child("OtherInformation").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                            @Override
                                                                            public void onComplete(@NonNull Task<Void> task) {

                                                                                FirebaseDatabase.getInstance().getReference("ChefPendingOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(random).child("Dishes").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                                                    @Override
                                                                                    public void onComplete(@NonNull Task<Void> task) {

                                                                                        FirebaseDatabase.getInstance().getReference("ChefPendingOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(random).child("OtherInformation").removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                                                                            @Override
                                                                                            public void onSuccess(Void aVoid) {
                                                                                                FirebaseDatabase.getInstance().getReference().child("Tokens").child(userid).child("token").addListenerForSingleValueEvent(new ValueEventListener() {
                                                                                                    @Override
                                                                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                                                        String usertoken = dataSnapshot.getValue(String.class);
                                                                                                        sendNotifications(usertoken, "Order Accepted", "Your Order has been Accepted by the Seller. Delivery Charge of Rs." + fnumber + " has been added to your total price. Your final GrandTotal value is Rs." + fprice + ". Now make Payment for Order.", "Payment");
                                                                                                        progressDialog.dismiss();
                                                                                                        ReusableCodeForAll.ShowAlert(context, "", "Delivery Charge of Rs." + fnumber + " has been added to customer's Total Price. Wait for the Customer to make Payment, Pull down the page to Refresh!");

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
        }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




            }

//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }

                });

        holder.Reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Order Rejected..Pull down to refresh the page", Toast.LENGTH_SHORT).show();

                progressDialog.setMessage("Please wait...");
                progressDialog.show();

//                openDialog();


                DatabaseReference Reference = FirebaseDatabase.getInstance().getReference("ChefPendingOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(random).child("Dishes");
                Reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            final ChefPendingOrders chefPendingOrders = snapshot.getValue(ChefPendingOrders.class);
                            userid = chefPendingOrders.getUserId();
                            dishid = chefPendingOrders.getDishId();
                        }
                        FirebaseDatabase.getInstance().getReference().child("Tokens").child(userid).child("token").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                String usertoken = dataSnapshot.getValue(String.class);
                                sendNotifications(usertoken, "Order Rejected", "Your Order has been Rejected by the seller of the product due to some Circumstances.", "Home");
                                FirebaseDatabase.getInstance().getReference("CustomerPendingOrders").child(userid).child(random).child("Dishes").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {

                                        FirebaseDatabase.getInstance().getReference("CustomerPendingOrders").child(userid).child(random).child("OtherInformation").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {

                                                FirebaseDatabase.getInstance().getReference("ChefPendingOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(random).child("Dishes").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {

                                                        FirebaseDatabase.getInstance().getReference("ChefPendingOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(random).child("OtherInformation").removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                                            @Override
                                                            public void onSuccess(Void aVoid) {
                                                                FirebaseDatabase.getInstance().getReference("AlreadyOrdered").child(userid).child("isOrdered").setValue("false");
                                                                progressDialog.dismiss();
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

    private void sendNotifications(String usertoken, String title, String message, String order) {

        Data data = new Data(title, message, order);
        NotificationSender sender = new NotificationSender(data, usertoken);
        apiService.sendNotification(sender).enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                if (response.code() == 200) {
                    if (response.body().success != 1) {
                        Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return chefPendingOrders1list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Address, grandtotalprice, nt2, NOTE2, nm2, num2, finalgrandtotal;
        EditText deliverychargetext;
        Button Vieworder, Accept, Reject, paydlbtn, nopaybtn;
//        CheckBox enablepodt;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Address = itemView.findViewById(R.id.AD);
            grandtotalprice = itemView.findViewById(R.id.TP);
            nt2 = itemView.findViewById(R.id.nt2);
            NOTE2 = itemView.findViewById(R.id.NOTE2);
            nm2 = itemView.findViewById(R.id.nm2);
            num2 = itemView.findViewById(R.id.num2);
            finalgrandtotal = itemView.findViewById(R.id.finalgrandtotal);
            deliverychargetext = itemView.findViewById(R.id.deliverychargetext);
            Vieworder = itemView.findViewById(R.id.vieww);
            Accept = itemView.findViewById(R.id.accept);
            paydlbtn = itemView.findViewById(R.id.paydlbtn);
            nopaybtn = itemView.findViewById(R.id.nopaybtn);
            Reject = itemView.findViewById(R.id.reject);
            enablepodt = itemView.findViewById(R.id.enablepodt);
            randomuidk = UUID.randomUUID().toString();




        }
    }
}