package com.example.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Display2ndPageActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display2nd_page);

         TextView validName;
         TextView validEmail;
         TextView validPassword;

         Button logOut;
         Button ListView;

        validName = (TextView) findViewById(R.id.pageTwo_TextView_DisplayName);
        validEmail = (TextView) findViewById(R.id.pageTwo_TextView_DisplayEmail);
        validPassword = (TextView) findViewById(R.id.pageTwo_TextView_DisplayPassword);

        logOut = (Button) findViewById(R.id.Button_LogOut);
        ListView = (Button) findViewById(R.id.Button_ListView);

        validName.setText(GlobalVariable.getPassNameToPageTwo());
        validEmail.setText(GlobalVariable.getPassEmailToPageTwo());
        validPassword.setText(GlobalVariable.getPassPasswordToPageTwo());

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Display2ndPageActivity.this, Display3rdPageActivity.class);
                startActivity(intent);

            }
        });

    }
}
