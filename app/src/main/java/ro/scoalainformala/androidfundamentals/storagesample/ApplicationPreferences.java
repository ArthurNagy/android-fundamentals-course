package ro.scoalainformala.androidfundamentals.storagesample;

import android.content.Context;
import android.content.SharedPreferences;

public class ApplicationPreferences {

    private final SharedPreferences sharedPreferences;
    private static final String APP_PREFERENCES = "app_shared_pref";

    public ApplicationPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }

    public void setString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, "");
    }

    public void delete(String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    public void deleteAll() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
