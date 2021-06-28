package ro.scoalainformala.androidfundamentals;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityOne extends AppCompatActivity {

    public static final int REQUEST_CODE = 255;
    public static final String KEY_ACTIVITY_ONE = "keyActivityOne";
    public static final String TAG = "ActivityOne";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_one);

        Button goToNext = findViewById(R.id.go_to_next);

        goToNext.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityOne.this, ActivityTwo.class);

            intent.putExtra(KEY_ACTIVITY_ONE, "Hello Group 4!");

            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            if (data != null && data.getExtras() != null) {
                String result = data.getStringExtra(ActivityTwo.KEY_ACTIVITY_TWO);

                TextView resultText = findViewById(R.id.result_text);

                resultText.setText(result);
            }
        }
    }
}
