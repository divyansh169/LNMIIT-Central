package com.citymart.app.ChefFoodPanel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.citymart.app.Chef;
import com.citymart.app.R;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.UUID;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.citymart.app.MainActivity;
import com.citymart.app.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Chef_PostRazorpayIDDDD extends AppCompatActivity  {

//        EditText etnewsnumber;
//        EditText etdesc;
//        EditText ethead;
//        EditText etimagelink;
//        EditText etnewslink;
//        EditText ettitle;
//        TextInputLayout etselid;
//        String sellerid;
        EditText etrzpid;
    String randomuid;
        Button RegisterRazorpayID;

        DatabaseReference mRef;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chef__post_razorpayid);

//            etnewsnumber= findViewById(R.id.etnewsnumber);
//            etdesc= findViewById(R.id.etdesc);
//            ethead= findViewById(R.id.ethead);
//            etimagelink= findViewById(R.id.etimagelink);
//            etnewslink= findViewById(R.id.etnewslink);
//            ettitle= findViewById(R.id.ettitle);
//            insertbutton= findViewById(R.id.insertbutton);

            etrzpid = (EditText) findViewById(R.id.rzpid);
            RegisterRazorpayID = (Button) findViewById(R.id.RegisterRazorpayID);
            randomuid = UUID.randomUUID().toString();

//            String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();

            mRef = FirebaseDatabase.getInstance().getReference().child("Chef").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(randomuid);

//        var mRef = firebase.database().ref("News");
//
//
//        mRef.orderByChild("newsnumber").limitToFirst(7).on("child_added", Type(type) {
//        }

            RegisterRazorpayID.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    insertnewstypedata();

                }
            });



        }

        private void insertnewstypedata(){
//            int newsnumber = Integer.parseInt(etnewsnumber.getText().toString());
//            String desc = etdesc.getText().toString();
//            String head = ethead.getText().toString();
//            String imagelink = etimagelink.getText().toString();
//            String newslink = etnewslink.getText().toString();
//            String title = ettitle.getText().toString();
            String rzpid = etrzpid.getText().toString();

            Type4 type4= new Type4(rzpid, randomuid);

//        String note = ETNote.getText().toString();
//        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference().child("News").child(userID).child("Notes");
//        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference().child("News");
//        String newsID = mRef.push().getKey();
//        HashMap newPost = new HashMap();
//        newPost.put(type, newsnumber);
//        mRef.setValue(type);
//        Toast.makeText(MainActivity.this, "Note Saved", Toast.LENGTH_LONG).show();


            mRef.child("RazorpaySellerID").setValue(type4);
            Toast.makeText(Chef_PostRazorpayIDDDD.this, "Data inserted",Toast.LENGTH_SHORT).show();
        }


    }

