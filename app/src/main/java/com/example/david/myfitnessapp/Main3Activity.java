package com.example.david.myfitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class Main3Activity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    Person p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

       /* Person p = (Person)getIntent().getSerializableExtra("Person");
        TextView textView = findViewById(R.id.textView13);
        textView.setText(p.currWeight +"\n" + p.experience + "\n" + p.frequency+ "\n");

        */

        firebaseAuth = FirebaseAuth.getInstance();

        Spinner mySpinner4 = (Spinner) findViewById(R.id.spinner4);

        ArrayAdapter<String> myAdapter4 = new ArrayAdapter<String>
                (Main3Activity.this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.focus));
        myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner4.setAdapter(myAdapter4);

        //

        Spinner mySpinner6 = (Spinner) findViewById(R.id.spinner6);

        ArrayAdapter<String> myAdapter6 = new ArrayAdapter<String>
                (Main3Activity.this,android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.improvement));
        myAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner6.setAdapter(myAdapter6);

    }

    public void buttonClicked3(View v) {
        Spinner focusSpinner = (Spinner) findViewById(R.id.spinner4);
        String focus = focusSpinner.getSelectedItem().toString();
        EditText weightTargetView = (EditText) findViewById(R.id.weightTarget);
        Spinner improvementSpinner = (Spinner) findViewById(R.id.spinner6);
        String improvement = improvementSpinner.getSelectedItem().toString();
        String str = weightTargetView.getText().toString();


        if((!TextUtils.isEmpty(str))) {
            int targetweight = Integer.parseInt(str);
            Person p = (Person)getIntent().getSerializableExtra("Person");
            p1 = new Person(p.currWeight,p.experience,p.frequency,focus,targetweight, improvement);
            openActivity4();
        }
        else{
            openDialog();
        }

    }

    public void logout3btn(View v) {
        firebaseAuth.signOut();
        finish();
        openMainActivity();
    }

    public void openActivity4(){
        Intent intent = new Intent (this,Main4Activity.class);
        intent.putExtra("Person", p1);
        startActivity(intent);
    }

    public void openMainActivity(){
        Intent intent = new Intent (this,MainActivity.class);
        startActivity(intent);
    }

    public void openDialog(){
        ExampleDialog2 exampleDialog2 = new ExampleDialog2();
        exampleDialog2.show(getSupportFragmentManager(),"example dialog");
    }


}
