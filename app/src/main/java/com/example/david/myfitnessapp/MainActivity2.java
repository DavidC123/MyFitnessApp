package com.example.david.myfitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

public class MainActivity2 extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    FirebaseFirestore fStore;
    String userID;

    Person p;
    EditText weightView;
    Spinner experienceSpinner;
    Spinner frequencySpinner;
    DocumentReference documentReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = firebaseAuth.getCurrentUser().getUid();
        documentReference = fStore.collection("users").document(userID);


        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot.exists()) {
                    weightView.setText(documentSnapshot.getString("weight"), TextView.BufferType.EDITABLE);
                    experienceSpinner.setSelection(documentSnapshot.getLong("experience").intValue());
                    frequencySpinner.setSelection(documentSnapshot.getLong("frequency").intValue());
                }
            }
        });

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>
                (MainActivity2.this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.yearsExperience));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
//
        Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>
                (MainActivity2.this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.frequency));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);
    }

    public void setupUIViews(){
        weightView = (EditText) findViewById(R.id.weight);
        experienceSpinner = (Spinner) findViewById(R.id.spinner1);
        frequencySpinner = (Spinner) findViewById(R.id.spinner2);


    }




    public void buttonClicked2(View v) {

        String experience = experienceSpinner.getSelectedItem().toString();
        String frequency = frequencySpinner.getSelectedItem().toString();
        int freq = Integer.parseInt(frequency);
        String str = weightView.getText().toString();



        if((!TextUtils.isEmpty(str))) {
            int userweight = Integer.parseInt(str);
            p = new Person(userweight,experience, freq);

            Map<String, Object> user = new HashMap<>();
            user.put("weight", str);
            user.put("experience", experienceSpinner.getSelectedItemPosition());
            user.put("frequency", frequencySpinner.getSelectedItemPosition());
            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    System.out.println("Success");
                }
            });


            openActivity3();
        }

        else{
            openDialog();
        }
    }

    public void logout2btn(View v) {
        firebaseAuth.signOut();
        finish();
        openMainActivity();
    }

    public void openActivity3(){
        Intent intent = new Intent (this,Main3Activity.class);
        intent.putExtra("Person", p);
        startActivity(intent);
    }
    public void openDialog(){
        ExampleDialog2 exampleDialog2 = new ExampleDialog2();
        exampleDialog2.show(getSupportFragmentManager(),"example dialog");
    }


    public void openMainActivity(){
        Intent intent = new Intent (this,MainActivity.class);
        startActivity(intent);
    }




}
