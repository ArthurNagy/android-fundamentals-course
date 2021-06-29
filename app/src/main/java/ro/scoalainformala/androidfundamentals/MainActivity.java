package ro.scoalainformala.androidfundamentals;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity /*implements Listener*/ {

//    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabs = findViewById(R.id.tabs);
        ViewPager pager = findViewById(R.id.pager);

        PagerAdapter adaptor = new PagerAdapter(getSupportFragmentManager());

        pager.setAdapter(adaptor);
        tabs.setupWithViewPager(pager);

//        DrawerLayout drawerLayout = findViewById(R.id.drawer);
//        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
//
//        drawerLayout.addDrawerListener(drawerToggle);
//        drawerToggle.syncState();
//
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }

//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

//        HelloFragment helloFragment = new HelloFragment();

//        Bundle bundle = new Bundle();
//        bundle.putString("nameKey", "Name");
//        bundle.putInt("courseNrKey", 6);
//
//        helloFragment.setArguments(bundle);

//        fragmentTransaction.replace(R.id.fragment_container, helloFragment);
//
//        fragmentTransaction.commit();

//        helloFragment.passArguments("Name Method", 6);
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        Log.d("MainActivity", "onOptionsItemSelected: " + item);
//        return drawerToggle.onOptionsItemSelected(item);
//    }

    //    @Override
//    protected void onResume() {
//        super.onResume();
//
//        HelloFragment helloFragment = (HelloFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
//
//        if (helloFragment != null) {
//            helloFragment.passArguments("Name Method", 6);
//        }
//    }

//    @Override
//    public void add(int first, int second) {
//        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragment_b);
//
//        if (fragmentB != null) {
//            fragmentB.addTwoNumbers(first, second);
//        }
//    }
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//    }
}