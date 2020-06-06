package com.example.david.myfitnessapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
       // FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


      //  if (user != null){
     //       finish();
      //      openActivity2();
       // }


    }


    public void buttonClicked(View v) { //login button
        EditText userView = (EditText) findViewById(R.id.user);
        String username = userView.getText().toString();
        EditText passView = (EditText) findViewById(R.id.pass);
        String password = passView.getText().toString();
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            validate(username, password);
        }
        else{
            Toast.makeText(getApplicationContext(),"Please fill out all the fields",Toast.LENGTH_SHORT).show();
        }
    }

    public void createButton(View v) {  //click signup button
        openActivityCreate();
    }

    public void openDialog(){
ExampleDialog exampleDialog = new ExampleDialog();
exampleDialog.show(getSupportFragmentManager(),"example dialog");
    }

    public void openActivity2(){
        Intent intent = new Intent (this,MainActivity2.class);
        startActivity(intent);
    }

    public void openActivityCreate(){
        Intent intent = new Intent (this,createActivity.class);
        startActivity(intent);
    }

    private void validate (String username, String password){

        progressDialog.setMessage("Loading...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(getApplicationContext(),"Login successful",Toast.LENGTH_SHORT).show();
                    openActivity2();
                }
                else{

                    Toast.makeText(getApplicationContext(),"Login failed, try again",Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }
        });
    }
}
