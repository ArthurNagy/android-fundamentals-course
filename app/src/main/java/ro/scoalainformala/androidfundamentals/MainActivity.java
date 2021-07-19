package ro.scoalainformala.androidfundamentals;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresPermission;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingPermission")
    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    // Permission is granted. Continue the action or workflow in your
                    // app.
                    displayCurrentUserLocation();
                } else {
                    // Explain to the user that the feature is unavailable because the
                    // features requires a permission that the user has denied. At the
                    // same time, respect the user's decision. Don't link to system
                    // settings in an effort to convince the user to change their
                    // decision.
                    handlePermissionDenied();
                }
            });
    private FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        // Header layout
        View headerView = navigationView.getHeaderView(0);
        ImageView headerImage = headerView.findViewById(R.id.avatar);
        TextView headerName = headerView.findViewById(R.id.name);
        TextView headerMail = headerView.findViewById(R.id.email);
        headerImage.setImageResource(R.drawable.ic_person_outline_24dp);
        headerName.setText("Arthur Nagy");
        headerMail.setText("arthur.nagy@outlook.com");

        // When pressing the menu icon on the toolbar we open the nav drawer
        toolbar.setNavigationOnClickListener(v -> {
            drawerLayout.open();
        });

        // Listener used to handle menu items being selected from the navigation drawer
        navigationView.setNavigationItemSelectedListener(item -> {
            Toast.makeText(MainActivity.this, "Navigation drawer: onNavigationItemSelected: " + item.getTitle(), Toast.LENGTH_LONG).show();
            drawerLayout.close();
            return true;
        });


        CoordinatorLayout coordinator = findViewById(R.id.coordinator);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> Snackbar.make(coordinator, "FAB was clicked", Snackbar.LENGTH_INDEFINITE).show());


        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Request location permission
            requestPermissionLauncher.launch(Manifest.permission.ACCESS_COARSE_LOCATION);
        } else {
            // We already have location
            displayCurrentUserLocation();
        }
    }

    @RequiresPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
    private void displayCurrentUserLocation() {
        fusedLocationClient.getLastLocation().addOnSuccessListener(this, location -> {
            // Got last known location. In some rare situations this can be null.
            if (location != null) {
                // Logic to handle location object
                TextView locationText = findViewById(R.id.location);
                locationText.setText(location.toString());
            }
        });
    }

    private void handlePermissionDenied() {
        CoordinatorLayout coordinator = findViewById(R.id.coordinator);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        Snackbar.make(coordinator, R.string.no_location_error, Snackbar.LENGTH_LONG)
                .setAnchorView(bottomNavigationView)
                .show();
    }

}