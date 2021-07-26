package ro.scoalainformala.androidfundamentals.storagesample;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = Word.class, version = 1, exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {

    abstract WordDao getWordDao();

    private static volatile WordDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static WordDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (WordDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, WordDatabase.class, "word_database")
                            .addCallback(ROOM_DATABASE_CALLBACK)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Override the onOpen method to populate the database.
     * For this sample, we clear the database every time it is created or opened.
     * <p>
     * If you want to populate the database only when the database is created for the 1st time,
     * override RoomDatabase.Callback()#onCreate
     */
    private static final RoomDatabase.Callback ROOM_DATABASE_CALLBACK = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            EXECUTOR.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                WordDao dao = INSTANCE.getWordDao();
                dao.deleteAll();

                Word word = new Word("Hello");
                dao.insertWord(word);
                word = new Word("World");
                dao.insertWord(word);
            });
        }
    };

}
