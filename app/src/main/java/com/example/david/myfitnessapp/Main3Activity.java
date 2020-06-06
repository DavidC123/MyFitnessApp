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

public class Main3Activity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    FirebaseFirestore fStore;
    String userID;
    DocumentReference documentReference2;

    Person p1;
    EditText weightTargetView;
    Spinner focusSpinner;
    Spinner improvementSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setupUIViews();


        firebaseAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = firebaseAuth.getCurrentUser().getUid();
        documentReference2 = fStore.collection("user2").document(userID);

        documentReference2.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                if (documentSnapshot.exists()) {
                    focusSpinner.setSelection(documentSnapshot.getLong("focus").intValue());
                    weightTargetView.setText(documentSnapshot.getString("targetweight"), TextView.BufferType.EDITABLE);
                    improvementSpinner.setSelection(documentSnapshot.getLong("improvement").intValue());
                }
            }
        });

        Spinner mySpinner4 = (Spinner) findViewById(R.id.spinner4);

        ArrayAdapter<String> myAdapter4 = new ArrayAdapter<String>
                (Main3Activity.this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.focus));
        myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner4.setAdapter(myAdapter4);

        //

        Spinner mySpinner6 = (Spinner) findViewById(R.id.spinner6);

        ArrayAdapter<String> myAdapter6 = new ArrayAdapter<String>
                (Main3Activity.this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.improvement));
        myAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner6.setAdapter(myAdapter6);

    }

    public void setupUIViews(){
        weightTargetView = (EditText) findViewById(R.id.weightTarget);
        focusSpinner = (Spinner) findViewById(R.id.spinner4);
        improvementSpinner = (Spinner) findViewById(R.id.spinner6);

    }

    public void buttonClicked3(View v) {
        String focus = focusSpinner.getSelectedItem().toString();
        String improvement = improvementSpinner.getSelectedItem().toString();
        String str = weightTargetView.getText().toString();


        if((!TextUtils.isEmpty(str))) {
            int targetweight = Integer.parseInt(str);
            Person p = (Person)getIntent().getSerializableExtra("Person");
            p1 = new Person(p.currWeight,p.experience,p.frequency,focus,targetweight, improvement);


            Map<String, Object> user = new HashMap<>();
            user.put("focus", focusSpinner.getSelectedItemPosition());
            user.put("targetweight", str);
            user.put("improvement", improvementSpinner.getSelectedItemPosition());
            documentReference2.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    System.out.println("Success");
                }
            });

            openActivity4();
        }
        else{
            openDialog();
        }

    }

    public void logout3btn(View v) {
        firebaseAuth.signOut();
        finish();
        openMainActivity();
    }

    public void openActivity4(){
        Intent intent = new Intent (this,Main4Activity.class);
        intent.putExtra("Person", p1);
        startActivity(intent);
    }

    public void openMainActivity(){
        Intent intent = new Intent (this,MainActivity.class);
        startActivity(intent);
    }

    public void openDialog(){
        ExampleDialog2 exampleDialog2 = new ExampleDialog2();
        exampleDialog2.show(getSupportFragmentManager(),"example dialog");
    }


}
