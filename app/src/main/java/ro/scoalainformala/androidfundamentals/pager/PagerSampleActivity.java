package ro.scoalainformala.androidfundamentals.pager;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import ro.scoalainformala.androidfundamentals.R;

public class PagerSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_sample);

        // Create pur Pager adapter instance
        PagerSampleAdapter adapter = new PagerSampleAdapter(this);

        ViewPager2 pager = findViewById(R.id.pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        // Tie together adapter with our pager
        pager.setAdapter(adapter);

        // Tie together our tabs with our pager
        new TabLayoutMediator(tabLayout, pager, (tab, position) -> {
            tab.setText(PagerSampleAdapter.SamplePages.values()[position].name());
        }).attach();
    }
}
