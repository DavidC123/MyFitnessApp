package com.example.david.myfitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class PushActivity extends AppCompatActivity {

    Person p1;
    private FirebaseAuth firebaseAuth;

    String [] pushPower = {"- EXERCISE 1: Barbell Bench Press (5 sets, 3-5 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 2: Dumbbell Incline Bench Press (4 sets, 3-6 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 3: Dumbbell Chest Flys (3 sets, 6-10 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 4: Seated Dumbbell Tricep Extensions (3 sets, 6-10 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 5: Dumbbell Side Lateral Raise (3 sets, 8-10 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 6: Dumbbell Shoulder Press(5 sets, 3-5 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 7: Reverse Machine Flys (3 sets, 6-10 repetitions per set, 90 seconds rest between sets)\n\n\n"};

    String [] pushBody = {"- EXERCISE 1: Barbell/Dumbbell Bench Press (4 sets, 8-12 repetitions per set, 80 seconds rest between sets)\n\n\n",
            "- EXERCISE 2: Cable/Machine Chest Fly (4 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 3: Dumbbell Incline Bench Press (4 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 4: Cable Tricep Pushdown (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 5: Dumbbell Side Lateral Raise (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 6: Dumbbell Shoulder Press/Arnold Press (3 sets, 8-12 repetitions per set, 80 seconds rest between sets)\n\n\n",
            "- EXERCISE 7: Cable Rear Delt Flys (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 8: Body Weighted Dips (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n"};

    String [] pushGain = {"- EXERCISE 1: Barbell Bench Press (4 sets, 5-8 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 2: Dumbbell Incline Bench Press (4 sets, 6-10 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 3: Dumbbell Chest Flys (4 sets, 8-10 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 4: Seated Dumbbell Tricep Extensions (4 sets, 8-10 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 5: Dumbbell Side Lateral Raise (4 sets, 8-10 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 6: Dumbbell Shoulder Press(4 sets, 6-10 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 7: Reverse Machine Flys (4 sets, 8-10 repetitions per set, 90 seconds rest between sets)\n\n\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push);

        firebaseAuth = FirebaseAuth.getInstance();

        p1 = (Person)getIntent().getSerializableExtra("Person");
        TextView textView = findViewById(R.id.pushView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        textView.append("Push Workout\n\n\n\n");

        if (p1.focus.equals("Strength Training (Powerlifting)")){
            for (int i = 0; i<pushPower.length; i++){
                textView.append(pushPower[i]);
            }
            textView.append("ESTIMATED WORKOUT TIME ~ 1 hour");
        }

        else if (p1.focus.equals("Bodybuilding Training") || p1.focus.equals("Lose weight(lean out)")){
            for (int i = 0; i<pushBody.length; i++){
                textView.append(pushBody[i]);
            }
            textView.append("ESTIMATED WORKOUT TIME ~ 1 hour");
        }
        else if (p1.focus.equals("Gain weight/muscle")){
            for (int i = 0; i<pushGain.length; i++){
                textView.append(pushGain[i]);
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
