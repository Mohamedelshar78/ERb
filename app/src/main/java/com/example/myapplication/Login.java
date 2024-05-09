package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Login extends AppCompatActivity {

    private EditText password , useName;
    private Button login;
    private ImageView passwordVisibilityToggle ;
    private TextView registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        password = findViewById(R.id.input_password);
        useName = findViewById(R.id.input_field_username);
        passwordVisibilityToggle =findViewById(R.id.password_visibility_toggle);
        login = findViewById(R.id.button_login);
        registration = findViewById(R.id.go_to_sign_up);


        passwordVisibilityToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform action when the icon is clicked
                // For example, toggle password visibility
                togglePasswordVisibility();

            }
        });

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });

    }

    private void togglePasswordVisibility() {
        EditText inputPassword = findViewById(R.id.input_password);
        ImageView passwordVisibilityToggle = findViewById(R.id.password_visibility_toggle);

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


}