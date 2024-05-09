package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private EditText userName, email ;
    private Button register;
    private TextView sinIN, texterror,texterrorMatch;
    private EditText password, repeatepassword;

    private ImageView password_toggel,repet_password_toggel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName = findViewById(R.id.input_field_username);
        email = findViewById(R.id.input_user_email);


        register = findViewById(R.id.button_register);

        sinIN = findViewById(R.id.go_to_sign_up);

        texterror = findViewById(R.id.textinput_error);
        texterrorMatch = findViewById(R.id.textinput_error_cant_match);

        password = findViewById(R.id.password_Sign_up);
        repeatepassword = findViewById(R.id.repet_password_signup);

        password_toggel=findViewById(R.id.password_create_visibility_toggle);
        repet_password_toggel=findViewById(R.id.repet_password_create_visibility_toggle);


        password_toggel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility(password,password_toggel);
            }
        });
        repet_password_toggel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility(repeatepassword,repet_password_toggel);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!password.getText().toString().equals(repeatepassword.getText().toString())  ) {
                    texterrorMatch.setText("password dosen't match");
                    texterror.setText("password dosen't match");
                    texterror.setTextColor(Color.parseColor("#FF0000"));
                    texterrorMatch.setTextColor(Color.parseColor("#FF0000"));

                    Toast.makeText(getApplicationContext(), "password does not  match", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(getApplicationContext(), Login.class);
                    startActivity(i);
                    finish();
                }
            }
        });

        sinIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Login.class);
                startActivity(i);

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!isValidPassword(s)){
                    texterror.setText("The password is not valid ");
                    texterror.setTextColor(Color.parseColor("#FF0000"));
                }
                else{
                    texterror.setText("The password is valid ");
                    texterror.setTextColor(Color.parseColor("#53B175"));

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });







    }



    private void togglePasswordVisibility(EditText inputPassword,ImageView passwordVisibilityToggle) {
        // Get the current inputType of the EditText
        int inputType = inputPassword.getInputType();

        // Toggle the password visibility
        if (inputType == InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
            // Password is currently visible, so hide it
            inputPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            passwordVisibilityToggle.setImageResource(R.drawable.show_password); // Change icon to hide
        } else {
            // Password is currently hidden, so show it
            inputPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            passwordVisibilityToggle.setImageResource(R.drawable.unshow_pass); // Change icon to show
        }
        // Move the cursor to the end of the text in the EditText
        inputPassword.setSelection(inputPassword.getText().length());
    }



    public  boolean isValidPassword(CharSequence password) {
        // Check if password length is at least 8 characters
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one uppercase letter, one lowercase letter, and one digit
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;

        // Check if password contains at least one special character
        boolean hasSpecialChar = false;
        String specialChars = "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";

        for (char c : password.toString().toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialChars.contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }
        }

        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

}