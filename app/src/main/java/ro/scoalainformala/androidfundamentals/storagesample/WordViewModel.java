package ro.scoalainformala.androidfundamentals.storagesample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private final WordRepository wordRepository;
    private final LiveData<List<Word>> words;

    public WordViewModel(@NonNull Application application) {
        super(application);

        WordDao wordDao = WordDatabase.getInstance(application)
                .getWordDao();

        wordRepository = new WordRepository(wordDao);

        words = wordRepository.getWords();
    }

    public LiveData<List<Word>> getWords() {
        return words;
    }

    public void insert(Word word) {
        wordRepository.insert(word);
    }
}
