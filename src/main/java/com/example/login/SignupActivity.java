package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignupActivity extends AppCompatActivity {

    private EditText edUserName;
    private EditText edPassword;
    private EditText edConfirmPassword;
    private Button btnCreateUser;


    private final String Credentials_Shared_PREF = "our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        edUserName = findViewById(R.id.editText2);
        edPassword = findViewById(R.id.editText3);
        edConfirmPassword = findViewById(R.id.editText4);
        btnCreateUser = findViewById(R.id.button2);

        btnCreateUser.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String strUserName=edUserName.getText().toString();
                String strPassword=edPassword.getText().toString();
                String strConfirmPassword=edConfirmPassword.getText().toString();

                if(strPassword!=null && strConfirmPassword !=null && strPassword.equalsIgnoreCase(strConfirmPassword)){
                    SharedPreferences credentials=getSharedPreferences(Credentials_Shared_PREF, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=credentials.edit();
                    editor.putString("Password",strPassword);
                    editor.putString("UserName",strUserName);
                    editor.commit();

                    SignupActivity.this.finish();
                }
            }
        });

    }
}
