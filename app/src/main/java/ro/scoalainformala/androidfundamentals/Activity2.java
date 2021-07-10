package ro.scoalainformala.androidfundamentals;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    public static final String MESSAGE_KEY = "messageKey";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_sample);

        // In case Activity2 has been started with the extras that we expected we read it from our Intent and display it on our UI
        if (getIntent() != null && getIntent().hasExtra(MESSAGE_KEY)) {
            String message = getIntent().getStringExtra(MESSAGE_KEY);

            TextView resultLabel = findViewById(R.id.result_label);
            TextView resultMessage = findViewById(R.id.result_message);

            resultLabel.setText(R.string.message_received);
            resultMessage.setText(message);
        }

        Button send = findViewById(R.id.send);
        EditText messageInput = findViewById(R.id.message_input);

        send.setOnClickListener(v -> {
            // When pressing SEND we add our message as extra result data
            Intent result = new Intent();
            result.putExtra(Activity1.RESULT_KEY, messageInput.getText().toString());

            // We signal a successful result and then we finish this activity returning to the activity that started it and expects a result
            setResult(Activity.RESULT_OK, result);
            finish();
        });
    }
}
