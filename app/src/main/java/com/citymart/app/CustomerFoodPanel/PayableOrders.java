package com.citymart.app.CustomerFoodPanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.citymart.app.ChefFoodPanel.ChefPaymentOrders;
import com.citymart.app.ChefFoodPanel.ChefPendingOrders;
import com.citymart.app.ChefFoodPanel.ChefPendingOrders1;
import com.citymart.app.ChefFoodPanel.ChefPendingOrdersAdapter;
import com.citymart.app.ChefFoodPanel.Type;
import com.citymart.app.ChefFoodPanel.Type4;
import com.citymart.app.R;
import com.citymart.app.SendNotification.APIService;
import com.citymart.app.SendNotification.Client;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import com.razorpay.Checkout;
//import com.razorpay.Order;
import com.razorpay.PaymentResultListener;
//import com.razorpay.RazorpayClient;
//import com.razorpay.RazorpayException;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import java.util.ArrayList;
import java.util.List;

public class PayableOrders extends AppCompatActivity implements PaymentResultListener {

    RecyclerView recyclerView;
    private List<CustomerPaymentOrders> customerPaymentOrdersList;
    private PayableOrderAdapter adapter;
    DatabaseReference databaseReference;
    private LinearLayout pay;
    Button payment;
    Button payondelivery;
    private Context context;
    private List<ChefPendingOrders1> chefPendingOrders1list;
    LottieAnimationView loadingutensils;
    Dialog dialog;
//    Button takeaway;
    TextView grandtotal;
    TextView info;
    private SwipeRefreshLayout swipeRefreshLayout;
    public String price;
    public String convcharge;
    public String randomuidd;
    private FirebaseAuth auth;
    private APIService apiService;
    private FirebaseUser user;
    public String usserid;
//    private String string_payondlv;
    String randomuuuiiiddd;
    public String payondbtn="0";
    DatabaseReference dataaa;

    private static final String TAG = "Razorpay";
    Checkout checkout;
//    RazorpayClient razorpayClient;
//    Order order;

    private String order_receipt_no = "Receipt No. " +  System.currentTimeMillis()/1000;
    private String order_reference_no = "Reference No. #" +  System.currentTimeMillis()/1000;

//    public PayableOrders(Context context, List<CustomerPaymentOrders> customerPaymentOrdersList) {
//        this.customerPaymentOrdersList = customerPaymentOrdersList;
//        this.context = context;
//
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payable_orders);
        recyclerView = findViewById(R.id.recyclepayableorder);
        pay = findViewById(R.id.btn);
        loadingutensils = findViewById(R.id.animationView);
        dialog= new Dialog(this);
        grandtotal = findViewById(R.id.rs);
        info = findViewById(R.id.info);
        payment = (Button) findViewById(R.id.paymentmethod);
        payondelivery = (Button) findViewById(R.id.payondelivery);
//        takeaway = (Button) findViewById(R.id.takeaway);
        Checkout.preload(getApplicationContext());
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(PayableOrders.this));
        customerPaymentOrdersList = new ArrayList<>();
        swipeRefreshLayout = findViewById(R.id.Swipe2);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimaryDark, R.color.green);
        adapter = new PayableOrderAdapter(PayableOrders.this, customerPaymentOrdersList);
        recyclerView.setAdapter(adapter);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                recyclerView = findViewById(R.id.recyclepayableorder);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(PayableOrders.this));
                customerPaymentOrdersList = new ArrayList<>();
                CustomerpayableOrders();
            }
        });
        CustomerpayableOrders();

    }

    private void CustomerpayableOrders() {


        payondelivery.setVisibility(View.INVISIBLE);
//        final List<String> mArrayList = new ArrayList<>();
//        usserid = FirebaseAuth.getInstance().getCurrentUser().getUid();
//        databaseReference = FirebaseDatabase.getInstance().getReference().child("deliveryCharge").child(usserid);
//thisone
//        databaseReference = FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                for (final DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    final String randomuido = snapshot.getKey();
//                    randomuuuiiiddd = randomuido;
//thisone

//        databaseReference = FirebaseDatabase.getInstance().getReference("deliveryCharge");
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//                for (final DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    final String randomuido = snapshot.getKey();
//                    randomuuuiiiddd = randomuido;


                    DatabaseReference datu = FirebaseDatabase.getInstance().getReference("deliveryCharge").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    datu.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Type type = dataSnapshot.getValue(Type.class);

                            payondbtn = type.getEnablepodt_flag();


                            if (payondbtn.equals("1")) {
                                payondelivery.setVisibility(View.VISIBLE);
                            }
                            else if(payondbtn.equals("10")){
                                payondelivery.setVisibility(View.INVISIBLE);
                            }
                            else{
                                payondelivery.setVisibility(View.GONE);
                            }

//                FirebaseDatabase.getInstance().getReference("deliveryCharge").child(randomuuuiiiddd).removeValue();


                        databaseReference = FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                        databaseReference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists()) {
                                    customerPaymentOrdersList.clear();
                                    for (final DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                        final String randomuid = snapshot.getKey();
                                        randomuidd = randomuid;

                                        final DatabaseReference data = FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(snapshot.getKey()).child("Dishes");
                                        data.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                                for (DataSnapshot snapshot1 : dataSnapshot.getChildren()) {
                                                    CustomerPaymentOrders customerPaymentOrders = snapshot1.getValue(CustomerPaymentOrders.class);
                                                    customerPaymentOrdersList.add(customerPaymentOrders);
                                                }
                                                if (customerPaymentOrdersList.size() == 0) {
                                                    pay.setVisibility(View.INVISIBLE);
                                                } else {
                                                    pay.setVisibility(View.VISIBLE);

                                                    payment.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
//                                            Intent intent = new Intent(PayableOrders.this, CustomerPayment.class);
//                                            intent.putExtra("RandomUID", randomuid);
//                                            startActivity(intent);
//                                            finish();
                                                            startPayment();
                                                        }
                                                    });
//                                    takeaway.setOnClickListener(new View.OnClickListener() {
//                                        @Override
//                                        public void onClick(View v) {
////                                            Intent intent = new Intent(PayableOrders.this, CustomerPayment.class);
////                                            intent.putExtra("RandomUID", randomuid);
////                                            startActivity(intent);
////                                            finish();
//                                            startPayment();
//                                        }
//                                    });
                                                    payondelivery.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View v) {
                                                            Intent intent = new Intent(PayableOrders.this, CustomerPayment.class);
                                                            intent.putExtra("RandomUID", randomuid);
                                                            startActivity(intent);
                                                            finish();
                                                        }
                                                    });
                                                }
                                                adapter = new PayableOrderAdapter(PayableOrders.this, customerPaymentOrdersList);
                                                recyclerView.setAdapter(adapter);
                                                swipeRefreshLayout.setRefreshing(false);

                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("CustomerPaymentOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(randomuid).child("OtherInformation");
                                        reference.addListenerForSingleValueEvent(new ValueEventListener() {
                                            @SuppressLint("SetTextI18n")
                                            @Override
                                            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                                                if (dataSnapshot.exists()) {
                                                    CustomerPaymentOrders1 customerPaymentOrders1 = dataSnapshot.getValue(CustomerPaymentOrders1.class);

                                                    grandtotal.setText("₹ " + customerPaymentOrders1.getGrandTotalPrice());
//                                                    convcharge = Double.toString((Integer.parseInt(price) * 0.02));
                                                    info.setText("Convenience Charge will be applied @0.02rs on order value.");
                                                    price = customerPaymentOrders1.getGrandTotalPrice();
                                                    swipeRefreshLayout.setRefreshing(false);

                                                }
//                                                }
//                                                @Override
//                                                public void onCancelled(@NonNull DatabaseError error) {
//
//                                                }
//                                                }

                                                else {
                                                    swipeRefreshLayout.setRefreshing(false);
                                                }

                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });


//                                    }
//                                    @Override
//                                    public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                                    }
//                                });


                                    }
                                } else {
                                    swipeRefreshLayout.setRefreshing(false);
                                }
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




        //this
//                    }

//                        }
//
//                            @Override
//                            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                            }
//
//
//                        });

                        //this




            }


//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


            private void startPayment() {

                /**
                 * Instantiate Checkout
                 */


                Checkout checkout = new Checkout();
                checkout.setKeyID("rzp_live_lYCx9db6SeGfcC");
                /**
                 * Set your logo here
                 */
                checkout.setImage(R.drawable.ic_shopping_cart_black_24dp);

                /**
                 * Reference to current activity
                 */
                final Activity activity = this;

                /**
                 * Pass your payment options to the Razorpay Checkout as a JSONObject
                 */
                try {
                    JSONObject options = new JSONObject();


                    options.put("name", "User Customer");
                    options.put("description", order_reference_no);
                    options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
//            options.put("order_id", order.get("id"));//from response of step 3.
                    options.put("theme.color", "#3399cc");
                    options.put("currency", "INR");
                    options.put("amount", Integer.parseInt(price) * 100 + (Integer.parseInt(price) * 100 * 0.02));//pass amount in currency subunits
//            options.put("amount", "200");//pass amount in currency subunits
                    options.put("prefill.email", user.getEmail());
//            options.put("prefill.contact","");
                    JSONObject retryObj = new JSONObject();
                    retryObj.put("enabled", true);
                    retryObj.put("max_count", 4);
                    options.put("retry", retryObj);

                    checkout.open(activity, options);

                } catch (Exception e) {
                    Log.e("TAG", "Error in starting Razorpay Checkout", e);
                }
            }

            @Override
            public void onPaymentSuccess(String s) {
                Log.d("ONSUCCESS", "onPaymentSuccess: " + s);
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PayableOrders.this, CustomerPayment.class);
                intent.putExtra("RandomUID", randomuidd);
                startActivity(intent);
//                                            openDialog();
                finish();
            }

//    private void openDialog() {
//        dialog.setContentView(R.layout.activity_loading_dialog);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//
//
//        LottieAnimationView loadingutensils = dialog.findViewById(R.id.progressAnimationView);
//        dialog.show();
//    }

            @Override
            public void onPaymentError(int i, String s) {
                Log.d("ONERROR", "onPaymentError: " + s);
                Toast.makeText(getApplicationContext(), "Error: " + s, Toast.LENGTH_LONG).show();
//        textView.setText("Error: " + s);
            }



}
