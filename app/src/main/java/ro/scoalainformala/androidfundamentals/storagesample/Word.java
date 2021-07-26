package ro.scoalainformala.androidfundamentals.storagesample;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @ColumnInfo(name = "word")
    @NonNull
    private final String value;

    public Word(@NonNull String value) {
        this.value = value;
    }

    @NonNull
    public String getValue() {
        return value;
    }
}
