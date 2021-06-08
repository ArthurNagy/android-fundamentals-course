package ro.scoalainformala.androidfundamentals;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.internal.TextWatcherAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_spinner);

//        EditText email = findViewById(R.id.email);
//        EditText phone = findViewById(R.id.phone);
//        CheckBox termsAndConditions = findViewById(R.id.t_and_c);
//        Button submit = findViewById(R.id.submit);
//        TextView result = findViewById(R.id.result);
//
//
//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String emailValue = email.getText().toString();
//                if (TextUtils.isEmpty(emailValue) || !Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()) {
//                    email.setError(getString(R.string.error_email));
//                    return;
//                } else {
//                    email.setError(null);
//                }
//
//                String phoneValue = phone.getText().toString();
//                if (TextUtils.isEmpty(phoneValue)) {
//                    phone.setError(getString(R.string.error_phone));
//                    return;
//                } else {
//                    phone.setError(null);
//                }
//
//                boolean termsAndConditionsValue = termsAndConditions.isChecked();
//                if (!termsAndConditionsValue) {
//                    Toast.makeText(MainActivity.this, getString(R.string.error_t_and_c), Toast.LENGTH_LONG).show();
//                    return;
//                }
//
//                result.setText(getString(R.string.result, emailValue, phoneValue, String.valueOf(termsAndConditionsValue)));
//            }
//        });

        Spinner spinner = findViewById(R.id.spinner);

        List<String> dataSource = getSource();

        ArrayAdapter<String> arrayAdapter = getAdapter(dataSource);

        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MainActivity", "onItemSelected: " + dataSource.get(position));
                Toast.makeText(MainActivity.this, getString(R.string.spinner_selected, dataSource.get(position)), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("MainActivity", "onNothingSelected");
            }
        });
    }

    private List<String> getSource() {
        List<String> androidVersions = new ArrayList<String>();

        androidVersions.add("Cupcake");
        androidVersions.add("Donut");
        androidVersions.add("Eclair");
        androidVersions.add("KitKat");
        androidVersions.add("Pie");

        return androidVersions;
    }

    private ArrayAdapter<String> getAdapter(List<String> dataSource) {
        return new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataSource);
    }

}