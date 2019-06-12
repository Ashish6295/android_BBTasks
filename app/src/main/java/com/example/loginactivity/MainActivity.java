package com.example.loginactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    private EditText userName;
    private EditText userEmail;
    private EditText userPassword;

    private Button userSignUp;
    private Button Skip2ListView;
    private Button Skip2NewsList;

    private boolean validName;
    private boolean validEmail;
    private boolean validPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userName = (EditText) findViewById(R.id.editText_Name);
        userEmail = (EditText) findViewById(R.id.editText_eMail);
        userPassword = (EditText) findViewById(R.id.editText_Password);

        Skip2ListView = (Button) findViewById(R.id.Button_SkipToListView);
        Skip2NewsList = (Button) findViewById(R.id.Button_SkipToNewsList);
        userSignUp = (Button) findViewById(R.id.Button_CreateAccount);

        Skip2ListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Display3rdPageActivity.class);
                startActivity(intent);
            }
        });

        Skip2NewsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MainActivity_news_listView.class);
                startActivity(intent);
            }
        });

        userSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name = userName.getText().toString();
                String regexExp = "^[a-zA-Z_]{3,15}$";

                Pattern NamePattern = Pattern.compile(regexExp);

                validName = NamePattern.matcher(Name).matches();

                String Email = userEmail.getText().toString();
                Pattern EmailPattern = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

                validEmail = (EmailPattern.matcher(Email).matches());

                String Password = userPassword.getText().toString();
                Pattern PasswordPattern = Pattern.compile("^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,16})$");

                validPassword = (PasswordPattern.matcher(Password).matches());

                if(!validName){
                    Toast toast = Toast.makeText(MainActivity.this,"Invalid Input in name Input Field(s)",Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
                }else if(!validEmail){
                    Toast toast = Toast.makeText(MainActivity.this,"Invalid Input in email Input Field(s)",Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
                }else if(!validPassword){
                    Toast toast = Toast.makeText(MainActivity.this,"Invalid Input in password Input Field(s)",Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
                }else{
                    GlobalVariable.setPassNameToPageTwo(Name);
                    GlobalVariable.setPassEmailToPageTwo(Email);
                    GlobalVariable.setPassPasswordToPageTwo(Password);

                    Intent intent = new Intent(MainActivity.this, Display2ndPageActivity.class);
                    startActivity(intent);

                    userName.setText("");
                    userEmail.setText("");
                    userPassword.setText("");

                    userName.requestFocus();

                }

            }
        });

    }
}
