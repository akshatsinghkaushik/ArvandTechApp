package com.arvandtechapp.Account;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.support.v7.app.AppCompatActivity;

import com.arvandtechapp.R;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

    RelativeLayout rellay1, rellay2;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            rellay1.setVisibility(View.VISIBLE);
            rellay2.setVisibility(View.VISIBLE);
        }
    };


    private EditText inputEmail, inputPassword;
    private Button btnSignIn, btnSignUp, btnResetPassword;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            //startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        setContentView(R.layout.activity_main);

        rellay1 = (RelativeLayout) findViewById(R.id.rellay1);
        rellay2 = (RelativeLayout) findViewById(R.id.rellay2);

        handler.postDelayed(runnable, 1200);

        inputEmail = (EditText) findViewById(R.id.EmailSignIn);
        inputPassword = (EditText) findViewById(R.id.PasswordSignIn);
        progressBar = (ProgressBar) findViewById(R.id.LoginProgressSignIn);
        btnSignUp = (Button) findViewById(R.id.SignUpSignIn);
        btnSignIn = (Button) findViewById(R.id.LoginButtonSignIn);
        btnResetPassword = (Button) findViewById(R.id.ForgotPassSignIn);
    }

}
