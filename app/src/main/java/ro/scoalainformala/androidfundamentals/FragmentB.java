package ro.scoalainformala.androidfundamentals;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    public void addTwoNumbers(int first, int second) {
        int result = first + second;

        if (getView() != null) {
            TextView resultText = getView().findViewById(R.id.text_b);

            resultText.setText(String.valueOf(result));
        }
    }
}
