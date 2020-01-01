package com.example.david.myfitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class PullActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    Person p1;

    String [] pullPower = {"- EXERCISE 1: Weighted Pullups/ Body Weighted Pullups  (4 sets, 5-8 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 2: Barbell Deadlifts (5 sets, 3-5 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 3: Pendlay Rows (5 sets, 5-8 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 4: Barbell Shrugs (4 sets, 5-8 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 5: Lat Pulldowns (4 sets, 5-8 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 6: Dumbbell Bicep Curls (3 sets, 8-10 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 7: Dumbbell Hammer Curls (3 sets, 8-10 repetitions per set, 90 seconds rest between sets)\n\n\n"};

    String [] pullBody = {"- EXERCISE 1: Weighted Pullups/ Body Weighted Pullups  (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 2: Barbell Rows (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 3: Lat Pulldowns (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 4: Seated cable rows (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 5: Standing Cable Lat Pushdowns(3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 6: Dumbbell Bicep Curls (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 7: Dumbbell Hammer Curls (3 sets, 8-12 repetitions per set, 60 seconds rest between sets)\n\n\n",
            "- EXERCISE 8: Barbell Shrugs (3 sets, 8-14 repetitions per set, 60 seconds rest between sets)\n\n\n"};

    String [] pullGain = {"- EXERCISE 1: Weighted Pullups/ Body Weighted Pullups  (4 sets, 6-10 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 2: Barbell Deadlifts (4 sets, 5-8 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 3: Pendlay Rows (4 sets, 6-10 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 4: Barbell Shrugs (4 sets, 6-10 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 5: Lat Pulldowns (4 sets, 6-10 repetitions per set, 2 minutes rest between sets)\n\n\n",
            "- EXERCISE 6: Dumbbell Bicep Curls (3 sets, 8-12 repetitions per set, 90 seconds rest between sets)\n\n\n",
            "- EXERCISE 7: Dumbbell Hammer Curls (3 sets, 8-12 repetitions per set, 90 seconds rest between sets)\n\n\n"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);

        firebaseAuth = FirebaseAuth.getInstance();

        p1 = (Person)getIntent().getSerializableExtra("Person");
        TextView textView = findViewById(R.id.pullView);
        textView.setMovementMethod(new ScrollingMovementMethod());

        textView.append("Pull Workout\n\n\n\n");

        if (p1.focus.equals("Strength Training (Powerlifting)")){
            for (int i = 0; i<pullPower.length; i++){
                textView.append(pullPower[i]);
            }
            textView.append("ESTIMATED WORKOUT TIME ~ 1 hour");
        }

        else if (p1.focus.equals("Bodybuilding Training") || p1.focus.equals("Lose weight(lean out)")){
            for (int i = 0; i<pullBody.length; i++){
                textView.append(pullBody[i]);
            }
            textView.append("ESTIMATED WORKOUT TIME ~ 1 hour");
        }
        else if (p1.focus.equals("Gain weight/muscle")){
            for (int i = 0; i<pullGain.length; i++){
                textView.append(pullGain[i]);
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
