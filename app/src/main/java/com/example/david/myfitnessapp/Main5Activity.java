package com.example.david.myfitnessapp;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Main5Activity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    Person p1;
    Person p2;

    int gainloseWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        firebaseAuth = FirebaseAuth.getInstance();

        p1 = (Person)getIntent().getSerializableExtra("Person");
        TextView textView = findViewById(R.id.split);
        if (p1.frequency == 1){
            textView.setText("Day 1. Full body workout");
        }
        else if (p1.frequency == 2){
            textView.setText("Day 1. Full body workout\n" + "Day 2. Full body workout");
        }
        else if (p1.frequency == 3){
            textView.setText("Day 1. Push workout\n" + "Day 2. Pull workout\n" + "Day 3. Leg workout");
        }
        else if (p1.frequency == 4){
            textView.setText("Day 1. Upper body workout\n" + "Day 2. Lower body workout\n" + "Day 3. Upper body workout\n" + "Day 4. Lower body workout");
        }
        else if (p1.frequency == 5){
            textView.setText("Day 1. Push workout\n" + "Day 2. Pull workout\n" + "Day 3. Leg workout\n" + "Day 4. Upper body workout\n" +"Day 5. Lower body workout");
        }
        else if (p1.frequency == 6){
            textView.setText("Day 1. Push workout\n" + "Day 2. Pull workout\n" + "Day 3. Leg workout\n" + "Day 4. Push workout\n" +"Day 5. Pull workout\n"+"Day 6. Leg workout");
        }
        else if (p1.frequency == 7){
            textView.setText("Day 1. Push workout\n" + "Day 2. Pull workout\n" + "Day 3. Leg workout\n" + "Day 4. Push workout\n" +"Day 5. Pull workout\n"+"Day 6. Leg workout\n"+"Day 7. Cardio/abs");
        }
    }


    public void onClickUpper(View v) {
        p1 = (Person)getIntent().getSerializableExtra("Person");
        p2 = new Person(p1.currWeight,p1.experience,p1.frequency,p1.focus,p1.targetWeight, p1.improve);
        openUpper();

    }

    public void onClickLower(View v) {
        p1 = (Person)getIntent().getSerializableExtra("Person");
        p2 = new Person(p1.currWeight,p1.experience,p1.frequency,p1.focus,p1.targetWeight, p1.improve);
        openLower();

    }

    public void onClickPush(View v) {
        p1 = (Person)getIntent().getSerializableExtra("Person");
        p2 = new Person(p1.currWeight,p1.experience,p1.frequency,p1.focus,p1.targetWeight, p1.improve);
        openPush();

    }

    public void onClickPull(View v) {
        p1 = (Person)getIntent().getSerializableExtra("Person");
        p2 = new Person(p1.currWeight,p1.experience,p1.frequency,p1.focus,p1.targetWeight, p1.improve);
        openPull();

    }

    public void onClickLegs(View v) {
        p1 = (Person)getIntent().getSerializableExtra("Person");
        p2 = new Person(p1.currWeight,p1.experience,p1.frequency,p1.focus,p1.targetWeight, p1.improve);
        openLegs();
    }

    public void onClickCardio(View v) {
        p1 = (Person)getIntent().getSerializableExtra("Person");
        p2 = new Person(p1.currWeight,p1.experience,p1.frequency,p1.focus,p1.targetWeight, p1.improve);
        openCardio();
    }

    public void onClickFull(View v) {
        p1 = (Person)getIntent().getSerializableExtra("Person");
        p2 = new Person(p1.currWeight,p1.experience,p1.frequency,p1.focus,p1.targetWeight, p1.improve);
        openFull();
    }

//----

    public void openUpper(){
        Intent intent = new Intent (this,UpperActivity.class);
        intent.putExtra("Person", p2);
        startActivity(intent);
    }

    public void openLower(){
        Intent intent = new Intent (this,LowerActivity.class);
        intent.putExtra("Person", p2);
        startActivity(intent);
    }
    public void openPush(){
        Intent intent = new Intent (this,PushActivity.class);
        intent.putExtra("Person", p2);
        startActivity(intent);
    }
    public void openPull(){
        Intent intent = new Intent (this,PullActivity.class);
        intent.putExtra("Person", p2);
        startActivity(intent);
    }
    public void openLegs(){
        Intent intent = new Intent (this,LegsActivity.class);
        intent.putExtra("Person", p2);
        startActivity(intent);
    }

    public void openCardio(){
        Intent intent = new Intent (this,CardioActivity.class);
        intent.putExtra("Person", p2);
        startActivity(intent);
    }

    public void openFull(){
        Intent intent = new Intent (this,FullActivity.class);
        intent.putExtra("Person", p2);
        startActivity(intent);
    }

    public void logout5btn(View v) {
        firebaseAuth.signOut();
        finish();
        openMainActivity();
    }

    public void openMainActivity(){
        Intent intent = new Intent (this,MainActivity.class);
        startActivity(intent);
    }
}
