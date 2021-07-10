package ro.scoalainformala.androidfundamentals;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {

    public static final int REQUEST_ACTIVITY_2 = 1;
    public static final String RESULT_KEY = "resultKey";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_sample);

        Button send = findViewById(R.id.send);
        EditText messageInput = findViewById(R.id.message_input);

        send.setOnClickListener(v -> {
            // When the user presses SEND the text from messageInput is sent to Activity2 through our Intent that starts Activity2
            Intent activity2Intent = new Intent(Activity1.this, Activity2.class);
            activity2Intent.putExtra(Activity2.MESSAGE_KEY, messageInput.getText().toString());

            // Since we expect a result from Activity2 we start Activity2 with: startActivityForResult
            startActivityForResult(activity2Intent, REQUEST_ACTIVITY_2);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // In case Activity2 set a result and returned to Activity1 we check if the result we receive is indeed from Activity2 through REQUEST_ACTIVITY_2
        // If it is and the result is RESULT_OK and we have data in our Intent, we can read the result sent from Activity2 and display it on the UI
        if (requestCode == REQUEST_ACTIVITY_2 && resultCode == Activity.RESULT_OK && data != null) {
            TextView resultLabel = findViewById(R.id.result_label);
            TextView resultMessage = findViewById(R.id.result_message);

            resultLabel.setText(R.string.result_received);
            resultMessage.setText(data.getStringExtra(RESULT_KEY));
        }
    }
}
