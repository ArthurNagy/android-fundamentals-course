package ro.scoalainformala.androidfundamentals.pager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import ro.scoalainformala.androidfundamentals.R;

public class PagerSampleAdapter extends FragmentStateAdapter {

    public PagerSampleAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // For each page we create an instance of our SampleFragment passing them our name and image arguments
        switch (SamplePages.values()[position]) {
            case MOVIE:
                return SampleFragment.newInstance(R.string.movie_name, R.drawable.img_movie_poster);
            case PET:
                return SampleFragment.newInstance(R.string.pet, R.drawable.img_pet);
            case FOOD:
                return SampleFragment.newInstance(R.string.food, R.drawable.img_food);
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        // We tell the adapter that we will ahve 3 pages
        return SamplePages.values().length;
    }

    // Enum class to represent the pages that we want to display
    enum SamplePages {
        MOVIE,
        PET,
        FOOD
    }
}
