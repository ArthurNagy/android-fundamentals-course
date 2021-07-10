package ro.scoalainformala.androidfundamentals;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.open_website).setOnClickListener(v -> {
            EditText websiteInput = findViewById(R.id.website_input);

            // Build the implicit intent to handle opening a webpage
            Uri webpage = Uri.parse(websiteInput.getText().toString());

            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });

        findViewById(R.id.open_location).setOnClickListener(v -> {
            EditText locationInput = findViewById(R.id.location_input);

            // Build the implicit intent to handle opening a location query
            Uri locationQuery = Uri.parse("geo:0,0?q=" + locationInput.getText().toString());

            Intent intent = new Intent(Intent.ACTION_VIEW, locationQuery);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });

        findViewById(R.id.share_text).setOnClickListener(v -> {
            EditText shareTextInput = findViewById(R.id.share_input);

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, shareTextInput.getText().toString());
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        });

        findViewById(R.id.dial).setOnClickListener(v -> {
            EditText dialInput = findViewById(R.id.dial_input);

            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + dialInput.getText().toString()));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });
    }

}