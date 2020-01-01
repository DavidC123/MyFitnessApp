package com.example.david.myfitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class CardioActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;

    Person p1;

    String [] loseWeight = {"1. High Intensity Interval Training (HIIT) for 20-30 minutes\n\n\n",
                            "2. Hanging Leg Raises (3 sets, 8-14 repetitions per set, 60 seconds rest between sets)\n\n\n",
                            "3. Crunches (3 sets, 8-14 repetitions per set, 60 seconds rest between sets)\n\n\n",
                            "4. Russian Twists (3 sets, 8-14 repetitions per set, 60 seconds rest between sets)\n\n\n"};

    String [] gainWeight = {"1. Incline Treadmill Walk for 10-30 minutes\n\n\n",
            "2. Weighted Planks (3 sets, 90 seconds rest between sets)\n\n\n",
            "3. Crunches (3 sets, 8-14 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "4. Hanging Knee Raises (3 sets, 8-14 repetitions per set, 90 seconds rest between sets)\n\n\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio);

        firebaseAuth = FirebaseAuth.getInstance();

        p1 = (Person)getIntent().getSerializableExtra("Person");
        TextView textView = findViewById(R.id.cardioView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        textView.append("Cardio and Ab Workout\n\n\n\n");

        int weightdiff = p1.targetWeight - p1.currWeight;

        if (weightdiff>0){  //Gain weight
            for (int i = 0; i<gainWeight.length; i++){
                textView.append(gainWeight[i]);
            }
            textView.append("ESTIMATED WORKOUT TIME ~ 30-45 mins");
        }

        else if (weightdiff <= 0){  //lose weight
            for (int i = 0; i<loseWeight.length; i++){
                textView.append(loseWeight[i]);
            }
            textView.append("ESTIMATED WORKOUT TIME ~ 25-45 mins");
        }

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
