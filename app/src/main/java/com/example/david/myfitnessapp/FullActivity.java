package com.example.david.myfitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class FullActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    Person p1;

    String [] fullPower = {"- EXERCISE 1: Barbell Bench Press (5 sets, 3-5 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 2: Dumbbell Incline Bench Press (3 sets, 5-8 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 3: Barbell Deadlifts (5 sets, 3-5 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 4: Barbell Squats (5 sets, 3-5 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 5: Dumbbell Side Lateral Raise (3 sets, 8-10 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 6: Dumbbell Bicep Curls (3 sets, 8-10 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 7: Seated Dumbbell Tricep Extensions (3 sets, 6-10 repetitions per set, 90 seconds rest between sets)\n\n\n"};

    String [] fullBody = {"- EXERCISE 1: Barbell Bench Press (4 sets, 8-12 repetitions per set, 80 seconds rest between sets)\n\n\n",
            "- EXERCISE 2: Dumbbell/Machine Chest Fly (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 3: Body Weight Pull Ups (3 sets, 5-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 4: Seated Cable Rows (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 5: Dumbbell Side Lateral Raise (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 6: Barbell Squats (4 sets, 8-12 repetitions per set, 80 seconds rest between sets)\n\n\n",
            "- EXERCISE 7: Cable Tricep Pushdown (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 8: Dumbbell Bicep Curls (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n"};

    String [] fullGain = {"- EXERCISE 1: Barbell Bench Press (4 sets, 5-8 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 2: Dumbbell Incline Bench Press (3 sets, 6-10 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 3: Barbell Deadlifts (4 sets, 5-8 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 4: Barbell Squats (4 sets, 5-8 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 5: Dumbbell Side Lateral Raise (4 sets, 8-12 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 6: Dumbbell Bicep Curls (4 sets, 8-12 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 7: Seated Dumbbell Tricep Extensions (4 sets, 8-12 repetitions per set, 90 seconds rest between sets)\n\n\n"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);

        firebaseAuth = FirebaseAuth.getInstance();

        p1 = (Person)getIntent().getSerializableExtra("Person");
        TextView textView = findViewById(R.id.fullView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        textView.append("Full Body Workout\n\n\n\n");

        if (p1.focus.equals("Strength Training (Powerlifting)")){
            for (int i = 0; i<fullPower.length; i++){
                textView.append(fullPower[i]);
            }
            textView.append("ESTIMATED WORKOUT TIME ~ 1 hour");
        }

        else if (p1.focus.equals("Bodybuilding Training") || p1.focus.equals("Lose weight(lean out)")){
            for (int i = 0; i<fullBody.length; i++){
                textView.append(fullBody[i]);
            }
            textView.append("ESTIMATED WORKOUT TIME ~ 1 hour");
        }
        else if (p1.focus.equals("Gain weight/muscle")){
            for (int i = 0; i<fullGain.length; i++){
                textView.append(fullGain[i]);
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
