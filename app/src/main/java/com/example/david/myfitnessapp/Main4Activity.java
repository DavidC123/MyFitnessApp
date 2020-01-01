package com.example.david.myfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Main4Activity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    Person p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        firebaseAuth = FirebaseAuth.getInstance();

        Person p1 = (Person)getIntent().getSerializableExtra("Person");
        TextView textView = findViewById(R.id.splits);
        if (p1.frequency == 1){
            textView.setText("Day 1. Full body workout");
        }
        else if (p1.frequency == 2){
            textView.setText("Day 1. Full body workout\n\n" + "Day 2. Full body workout");
        }
        else if (p1.frequency == 3){
            textView.setText("Day 1. Push workout\n\n" + "Day 2. Pull workout\n\n" + "Day 3. Leg workout");
        }
        else if (p1.frequency == 4){
            textView.setText("Day 1. Upper body workout\n\n" + "Day 2. Lower body workout\n\n" + "Day 3. Upper body workout\n\n" + "Day 4. Lower body workout");
        }
        else if (p1.frequency == 5){
            textView.setText("Day 1. Push workout\n\n" + "Day 2. Pull workout\n\n" + "Day 3. Leg workout\n\n" + "Day 4. Upper body workout\n\n" +"Day 5. Lower body workout");
        }
        else if (p1.frequency == 6){
            textView.setText("Day 1. Push workout\n\n" + "Day 2. Pull workout\n\n" + "Day 3. Leg workout\n\n" + "Day 4. Push workout\n\n" +"Day 5. Pull workout\n\n"+"Day 6. Leg workout");
        }
        else if (p1.frequency == 7){
            textView.setText("Day 1. Push workout\n\n" + "Day 2. Pull workout\n\n" + "Day 3. Leg workout\n\n" + "Day 4. Push workout\n\n" +"Day 5. Pull workout\n\n"+"Day 6. Leg workout\n\n"+"Day 7. Cardio/abs");
        }


      //  textView.setText(p1.currWeight +"\n" + p1.experience + "\n" + p1.frequency+ "\n" + p1.focus +"\n" +p1.targetWeight +"\n" +p1.improve +"\n");
    }

    public void buttonClicked4(View v) {
        Person p1 = (Person)getIntent().getSerializableExtra("Person");
        p2 = new Person(p1.currWeight,p1.experience,p1.frequency,p1.focus,p1.targetWeight, p1.improve);
        openActivity5();
    }

    public void logout4btn(View v) {
        firebaseAuth.signOut();
        finish();
        openMainActivity();
    }

    public void openActivity5(){
        Intent intent = new Intent (this,Main5Activity.class);
        intent.putExtra("Person", p2);
        startActivity(intent);
    }
    public void openMainActivity(){
        Intent intent = new Intent (this,MainActivity.class);
        startActivity(intent);
    }



}
