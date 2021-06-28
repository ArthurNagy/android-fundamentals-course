package ro.scoalainformala.androidfundamentals;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityTwo extends AppCompatActivity {

    public static final String KEY_ACTIVITY_TWO = "keyActivityTwo";
    public static final String TAG = "ActivityTwo";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Log.d(TAG, "onCreate");

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String name = extras.getString(ActivityOne.KEY_ACTIVITY_ONE);

            TextView text = findViewById(R.id.text);

            text.setText(name);

            Button setResult = findViewById(R.id.set_result);

            setResult.setOnClickListener(v -> {
                Intent result = new Intent();

                result.putExtra(KEY_ACTIVITY_TWO, "Hello back to you!");

                setResult(Activity.RESULT_OK, result);

                finish();
            });
        }
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
}
