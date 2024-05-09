package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private EditText userName, email ,cratePassword , confirmPassword;
    private Button register;
    private TextView sinUp, texterror,texterrorMatch;
    private ImageView createPassword_visable , repeatePassword_visable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName = findViewById(R.id.input_field_username);
        email = findViewById(R.id.input_user_email);
        cratePassword = findViewById(R.id.input_create_user_password);
        confirmPassword = findViewById(R.id.input_repate_user_password);
        register = findViewById(R.id.button_register);
        sinUp = findViewById(R.id.go_to_sign_up);
        texterror = findViewById(R.id.textinput_error);
        texterrorMatch = findViewById(R.id.textinput_error_cant_match);
        createPassword_visable = findViewById(R.id.password_create_visibility_toggle);
        repeatePassword_visable = findViewById(R.id.password_confirm_visibility_toggle);

        cratePassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean valid = isValidPassword(s);
                if(!valid)
                {
                    texterror.setText("your password must be 8 characters");
                }
                else {
                    texterror.setText(""); // Clear the error if valid
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cratePassword.getText() != confirmPassword.getText()) {
                    texterrorMatch.setText("password dosen't mstch");
                    Toast.makeText(getApplicationContext(), "password cant match", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent i = new Intent(getApplicationContext(), Login.class);
                    startActivity(i);
                }
            }
        });

        sinUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Login.class);
                startActivity(i);
            }
        });

        createPassword_visable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility(cratePassword,createPassword_visable);
            }
        });

        repeatePassword_visable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                togglePasswordVisibility(confirmPassword,repeatePassword_visable);
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


    public static boolean isValidPassword(CharSequence password) {
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