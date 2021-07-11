package ro.scoalainformala.androidfundamentals.pager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import ro.scoalainformala.androidfundamentals.R;

/**
 * Sample fragment that will be used for all 3 pages in our ViewPager to display a title and an image.
 * We will have 3 instances of this fragment, one for our favourite movie, one for our favourite pet and one for our favourite food
 */
public class SampleFragment extends Fragment {

    private static final String NAME_KEY = "nameKey";
    private static final String IMAGE_KEY = "imageKey";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Retrieve the resource arguments send and display them in our views
        if (getArguments() != null) {
            TextView title = view.findViewById(R.id.title);
            ImageView image = view.findViewById(R.id.image);

            title.setText(getArguments().getInt(NAME_KEY));
            Glide.with(this).load(getArguments().getInt(IMAGE_KEY)).into(image);
        }
    }


    public static SampleFragment newInstance(@StringRes int name, @DrawableRes int image) {
        SampleFragment sampleFragment = new SampleFragment();

        Bundle args = new Bundle();
        args.putInt(NAME_KEY, name);
        args.putInt(IMAGE_KEY, image);
        sampleFragment.setArguments(args);

        return sampleFragment;
    }
}
