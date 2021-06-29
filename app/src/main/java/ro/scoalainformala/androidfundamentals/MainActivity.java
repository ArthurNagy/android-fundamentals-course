package ro.scoalainformala.androidfundamentals;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
//    protected void onResume() {
//        super.onResume();
//
//        HelloFragment helloFragment = (HelloFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
//
//        if (helloFragment != null) {
//            helloFragment.passArguments("Name Method", 6);
//        }
//    }

    @Override
    public void add(int first, int second) {
        FragmentB fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.fragment_b);

        if (fragmentB != null) {
            fragmentB.addTwoNumbers(first, second);
        }
    }
}