package com.example.david.myfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class createActivity extends AppCompatActivity {

    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);


        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    public void signupClicked(View v) { //login button
        EditText userView = (EditText) findViewById(R.id.user1);
        String username = userView.getText().toString();
        EditText passView1 = (EditText) findViewById(R.id.pass1);
        String password1 = passView1.getText().toString();
        EditText passView2 = (EditText) findViewById(R.id.pass2);
        String password2 = passView2.getText().toString();

        if ((!TextUtils.isEmpty(username))&&(!TextUtils.isEmpty(password1))&&(!TextUtils.isEmpty(password2))&&password1.length()>=6&&password1.equals(password2)){
            //Person p = new Person(username,password1);
            mFirebaseAuth.createUserWithEmailAndPassword(username,password1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"Signup Successful!",Toast.LENGTH_SHORT).show();
                        openMainActivity();

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Signup unsuccessful, try again",Toast.LENGTH_SHORT).show();
                    }
                }
            });
           // Toast.makeText(getApplicationContext(),"Success! Account created.",Toast.LENGTH_SHORT).show();

        }
        else if (!password1.equals(password2)){
            Toast.makeText(getApplicationContext(),"Passwords do not match",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password1) || TextUtils.isEmpty(password2)){
            Toast.makeText(getApplicationContext(),"Please fill out all the fields",Toast.LENGTH_SHORT).show();
        }
        else if(password1.length()<6){
            Toast.makeText(getApplicationContext(),"Password must be at least 6 characters long",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Please fill out all the fields",Toast.LENGTH_SHORT).show();
        }
    }

    public void openMainActivity(){
        Intent intent = new Intent (this,MainActivity.class);
        startActivity(intent);
    }

}
