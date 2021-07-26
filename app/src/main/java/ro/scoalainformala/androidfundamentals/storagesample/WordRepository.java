package ro.scoalainformala.androidfundamentals.storagesample;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private final WordDao wordDao;

    public WordRepository(WordDao wordDao) {
        this.wordDao = wordDao;
    }

    LiveData<List<Word>> getWords() {
        return wordDao.getAlphabetizedWords();
    }

    void insert(Word word) {
        WordDatabase.EXECUTOR.execute(() -> wordDao.insertWord(word));
    }
}
