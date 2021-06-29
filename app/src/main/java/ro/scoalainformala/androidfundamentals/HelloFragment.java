package ro.scoalainformala.androidfundamentals;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HelloFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hello, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView text = view.findViewById(R.id.text);

        Bundle bundle = getArguments();

        if (bundle != null) {
            String name = bundle.getString("nameKey");
            int courseNr = bundle.getInt("courseNrKey");

            text.setText(name + " " + courseNr);
        }
    }

    public void passArguments(String name, int courseNr) {
        if (getView() != null) {
            TextView text = getView().findViewById(R.id.text);

            text.setText(name + " " + courseNr);
        }
    }
}
