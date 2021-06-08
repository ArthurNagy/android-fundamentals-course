package ro.scoalainformala.androidfundamentals;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String ANDROID_DEVELOPER_URL = "https://developer.android.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_spinner);

        Spinner spinner = findViewById(R.id.spinner);

        List<String> dataSource = getSource();

        ArrayAdapter<String> arrayAdapter = getAdapter(dataSource);

        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("MainActivity", "onItemSelected: " + dataSource.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("MainActivity", "onNothingSelected");
            }
        });

//        WebView webView = findViewById(R.id.web_view);
//
//        WebSettings webSettings = webView.getSettings();
//
//        webSettings.setJavaScriptEnabled(true);
//
//        webView.loadUrl(ANDROID_DEVELOPER_URL);
    }

    private List<String> getSource() {
        List<String> androidVersions = new ArrayList<String>();

        androidVersions.add("Cupcake");
        androidVersions.add("Oreo");
        androidVersions.add("Lollipop");
        androidVersions.add("KitKat");
        androidVersions.add("Jellybean");
        androidVersions.add("Marshmallow");

        return androidVersions;
    }

    private ArrayAdapter<String> getAdapter(List<String> dataSource) {
        return new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dataSource);
    }
}