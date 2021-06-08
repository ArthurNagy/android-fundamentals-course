package ro.scoalainformala.androidfundamentals;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.internal.TextWatcherAdapter;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText email = findViewById(R.id.email);
        EditText phone = findViewById(R.id.phone);
        CheckBox termsAndConditions = findViewById(R.id.t_and_c);
        Button submit = findViewById(R.id.submit);
        TextView result = findViewById(R.id.result);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailValue = email.getText().toString();
                if (TextUtils.isEmpty(emailValue) || !Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()) {
                    email.setError(getString(R.string.error_email));
                    return;
                } else {
                    email.setError(null);
                }

                String phoneValue = phone.getText().toString();
                if (TextUtils.isEmpty(phoneValue)) {
                    phone.setError(getString(R.string.error_phone));
                    return;
                } else {
                    phone.setError(null);
                }

                boolean termsAndConditionsValue = termsAndConditions.isChecked();
                if (!termsAndConditionsValue) {
                    Toast.makeText(MainActivity.this, getString(R.string.error_t_and_c), Toast.LENGTH_LONG).show();
                    return;
                }

                result.setText(getString(R.string.result, emailValue, phoneValue, String.valueOf(termsAndConditionsValue)));
            }
        });
    }

}