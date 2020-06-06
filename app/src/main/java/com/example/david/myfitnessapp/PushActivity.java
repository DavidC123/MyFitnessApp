package com.example.david.myfitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

        textView.append("PUSH WORKOUT\n\n\n");

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

        String text = textView.getText().toString();

        SpannableString ss = new SpannableString(text);

        ClickableSpan benchPress = new ClickableSpan(){
            @Override
            public void onClick(View widget){
//                Toast.makeText(PushActivity.this, "Bench Press", Toast.LENGTH_SHORT).show();
                bench_modal m = new bench_modal();
                m.show(getSupportFragmentManager(), "bench_modal");
            }
        };

        ClickableSpan inclineBench = new ClickableSpan(){
            @Override
            public void onClick(View widget){
                incline_press_modal m = new incline_press_modal();
                m.show(getSupportFragmentManager(), "incline_press_modal");
            }
        };

        ClickableSpan dumbbellFlys = new ClickableSpan(){
            @Override
            public void onClick(View widget){
                dumbbell_flys_modal m = new dumbbell_flys_modal();
                m.show(getSupportFragmentManager(), "dumbbell_flys_modal");
            }
        };

        ClickableSpan seatedTriceps = new ClickableSpan(){
            @Override
            public void onClick(View widget){
                seatedTriceps m = new seatedTriceps();
                m.show(getSupportFragmentManager(), "seatedTriceps");
            }
        };

        ClickableSpan lateralRaise = new ClickableSpan(){
            @Override
            public void onClick(View widget){
                lateralRaise m = new lateralRaise();
                m.show(getSupportFragmentManager(), "lateralRaise");
            }
        };

        ClickableSpan shoulderPress = new ClickableSpan(){
            @Override
            public void onClick(View widget){
                shoulderPress m = new shoulderPress();
                m.show(getSupportFragmentManager(), "shoulderPress");
            }
        };

        ClickableSpan reverseFly = new ClickableSpan(){
            @Override
            public void onClick(View widget){
                reverseFly m = new reverseFly();
                m.show(getSupportFragmentManager(), "reverseFly");
            }
        };

        ClickableSpan cableFly = new ClickableSpan(){
            @Override
            public void onClick(View widget){
                cableFly m = new cableFly();
                m.show(getSupportFragmentManager(), "cableFly");
            }
        };

        ClickableSpan tricepPushdown = new ClickableSpan(){
            @Override
            public void onClick(View widget){
                tricepPushdown m = new tricepPushdown();
                m.show(getSupportFragmentManager(), "tricepPushdown");
            }
        };

        ClickableSpan cableRear = new ClickableSpan(){
            @Override
            public void onClick(View widget){
                cableRear m = new cableRear();
                m.show(getSupportFragmentManager(), "cableRear");
            }
        };

        ClickableSpan dips = new ClickableSpan(){
            @Override
            public void onClick(View widget){
                dips m = new dips();
                m.show(getSupportFragmentManager(), "dips");
            }
        };


        if (p1.focus.equals("Strength Training (Powerlifting)") || p1.focus.equals("Gain weight/muscle")) {
            ss.setSpan(benchPress, text.indexOf("Bench Press"), text.indexOf("Bench Press") + 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(inclineBench, text.indexOf("Incline Bench Press"), text.indexOf("Incline Bench Press") + 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(dumbbellFlys, text.indexOf("Dumbbell Chest Flys"), text.indexOf("Dumbbell Chest Flys") + 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(seatedTriceps, text.indexOf("Seated Dumbbell Tricep Extensions"), text.indexOf("Seated Dumbbell Tricep Extensions") + 33, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(lateralRaise, text.indexOf("Dumbbell Side Lateral Raise"), text.indexOf("Dumbbell Side Lateral Raise") + 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(shoulderPress, text.indexOf("Dumbbell Shoulder Press"), text.indexOf("Dumbbell Shoulder Press") + 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(reverseFly, text.indexOf("Reverse Machine Flys"), text.indexOf("Reverse Machine Flys") + 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }else {
            ss.setSpan(benchPress, text.indexOf("Bench Press"), text.indexOf("Bench Press") + 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(cableFly, text.indexOf("Cable/Machine Chest Fly"), text.indexOf("Cable/Machine Chest Fly") + 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(inclineBench, text.indexOf("Incline Bench Press"), text.indexOf("Incline Bench Press") + 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(tricepPushdown, text.indexOf("Cable Tricep Pushdown"), text.indexOf("Cable Tricep Pushdown") + 21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(lateralRaise, text.indexOf("Dumbbell Side Lateral Raise"), text.indexOf("Dumbbell Side Lateral Raise") + 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(shoulderPress, text.indexOf("Dumbbell Shoulder Press"), text.indexOf("Dumbbell Shoulder Press") + 23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(cableRear, text.indexOf("Cable Rear Delt Flys"), text.indexOf("Cable Rear Delt Flys") + 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ss.setSpan(dips, text.indexOf("Body Weighted Dips"), text.indexOf("Body Weighted Dips") + 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }



        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
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
