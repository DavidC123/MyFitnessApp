package com.example.david.myfitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class LegsActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    Person p1;

    String [] legsPower = {"- EXERCISE 1:Barbell Squats (5 sets, 3-5 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 2: Barbell Romanian Deadlift (5 sets, 3-8 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 3: Barbell Lunges (4 sets, 6-10 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 4: Leg Press Machine (4 sets, 5-10 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 5: Seated Machine Leg Extension (3 sets, 6-10 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 6: Lying Leg Curl Machine (3 sets, 6-10 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 7: Standing Calf Raises (4 sets, 8-12 repetitions per set, 90 seconds rest between sets)\n\n\n"};

    String [] legsBody = {"- EXERCISE 1:Barbell Squats/Hack Squat Machine (4 sets, 8-12 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 2: Walking Dumbbell Lunges (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 3: Dumbbell Romanian Deadlift (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 4: Leg Press Machine (3 sets, 8-12 repetitions per set, 80 seconds rest between sets)\n\n\n",
            "- EXERCISE 5: Barbell Hip Thrusts (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 6: Seated Machine Leg Extension (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 7: Lying Leg Curl Machine (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 8: Standing Calf Raises (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n"};

    String [] legsGain = {"- EXERCISE 1:Barbell Squats (4 sets, 5-8 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 2: Barbell Romanian Deadlift (4 sets, 5-8 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 3: Barbell Lunges (4 sets, 6-10 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 4: Leg Press Machine (4 sets, 5-10 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 5: Seated Machine Leg Extension (4 sets, 6-10 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 6: Lying Leg Curl Machine (4 sets, 6-10 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 7: Standing Calf Raises (4 sets, 8-12 repetitions per set, 90 seconds rest between sets)\n\n\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legs);

        firebaseAuth = FirebaseAuth.getInstance();

        p1 = (Person)getIntent().getSerializableExtra("Person");
        TextView textView = findViewById(R.id.legsView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        textView.append("Leg Workout\n\n\n\n");

        if (p1.focus.equals("Strength Training (Powerlifting)")){
            for (int i = 0; i<legsPower.length; i++){
                textView.append(legsPower[i]);
            }
            textView.append("ESTIMATED WORKOUT TIME ~ 1 hour");
        }

        else if (p1.focus.equals("Bodybuilding Training") || p1.focus.equals("Lose weight(lean out)")){
            for (int i = 0; i<legsBody.length; i++){
                textView.append(legsBody[i]);
            }
            textView.append("ESTIMATED WORKOUT TIME ~ 1 hour");
        }
        else if (p1.focus.equals("Gain weight/muscle")){
            for (int i = 0; i<legsGain.length; i++){
                textView.append(legsGain[i]);
            }
            textView.append("ESTIMATED WORKOUT TIME ~ 1 hour");
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
