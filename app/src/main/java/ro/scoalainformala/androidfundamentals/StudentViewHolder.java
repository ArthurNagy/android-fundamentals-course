package ro.scoalainformala.androidfundamentals;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private final TextView firstName;
    private final TextView lastName;


    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);

        firstName = itemView.findViewById(R.id.first_name);
        lastName = itemView.findViewById(R.id.last_name);
    }

    public void bindStudent(Student student) {
        int backgroundColorRes = (getBindingAdapterPosition() % 2 == 0) ? R.color.white : R.color.light_grey;
        itemView.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), backgroundColorRes));
        firstName.setText(student.getFirstName());
        lastName.setText(student.getLastName());
    }
}
