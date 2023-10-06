package be.ehb.inputdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import be.ehb.inputdemo.R.id;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.email);
        etPin = (EditText) findViewById(R.id.pin_code);
        Button loginBtn = (Button) findViewById(id.login_btn);

        loginBtn.setOnClickListener(loginListener);

        Log.d("VALUE", "it works");
    }

    private View.OnClickListener loginListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email = etEmail.getText().toString();
            String pinString = etPin.getText().toString();
            int pin = -1;

            //validatie
            if (email.isEmpty()) {
                Toast.makeText(getApplication(), "Email must be filled in", Toast.LENGTH_LONG).show();
                return;
            } else if (!pinString.matches("[0-9]{4,8}")) {
                Toast.makeText(getApplication(), R.string.txt_invalid_pin, Toast.LENGTH_LONG).show();
                return;
            }
            pin = Integer.parseInt(pinString);

            Log.d("InputDemo: ", "Logged in as" + email + "with pin" + pin);
            Toast.makeText(getApplication(), "Succesfully logged in", Toast.LENGTH_LONG).show();

        }
    };
}