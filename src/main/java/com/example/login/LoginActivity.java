package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    private EditText edUserName;
    private EditText edPassword;
    private Button btnLogin;
    private Button btnSignUp;

    private final String Credentials_Shared_PREF = "our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUserName =findViewById(R.id.editText);
        edPassword = findViewById(R.id.editText1);
        btnLogin = findViewById(R.id.button);
        btnSignUp = findViewById(R.id.button1);

        btnSignUp.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });


    btnLogin.setOnClickListener(new View.OnClickListener()

    {

        public void onClick (View view){
        SharedPreferences credentials=getSharedPreferences(Credentials_Shared_PREF, Context.MODE_PRIVATE);
        String strUserName=credentials.getString("UserName",null);
        String strPassword=credentials.getString("Password",null);

        String username_from_ed=edUserName.getText().toString();
        String password_from_ed=edPassword.getText().toString();

        if(strUserName!=null && username_from_ed !=null && strUserName.equalsIgnoreCase(username_from_ed) ){
            if(strPassword!=null && password_from_ed !=null && strPassword.equalsIgnoreCase(password_from_ed)) {
                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
            }
            else{
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
    });
}
}


