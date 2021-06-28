package ro.scoalainformala.androidfundamentals;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button dialButton = findViewById(R.id.dial);

        dialButton.setOnClickListener(v -> {
            Uri webpage = Uri.parse("http://www.google.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

//            Intent dialIntent = new Intent(Intent.ACTION_VIEW);
//            dialIntent.setData(Uri.parse());

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        });

        if (savedInstanceState.containsKey("Key")) {
            String savedState = savedInstanceState.getString("Key");
        }

//        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//
//        RecyclerView recyclerView = findViewById(R.id.recycler);
//
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        MoviesDataSource dataSource = new MoviesDataSource();
//
//        MoviesAdapter adapter = new MoviesAdapter(dataSource.getMovies());
//
//        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("Key", "Value");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}