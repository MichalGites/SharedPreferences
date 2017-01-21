package pl.akademiakodu.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // pole SharedPreferences
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // inicjalizacja poniżej, Mode_Private oznacza ze tylko nasze activity ma do tego dostep
        preferences = getSharedPreferences("loginData", Activity.MODE_PRIVATE);
    }

    // obsluga - metoda do zapisywania danych
    private void saveData(){
        // zapisujemy na edytorze
        SharedPreferences.Editor editor = preferences.edit();
        // zapisujemy tak jak w hashmapie - klucz i wartość
        editor.putString("login", "michal");
        editor.putString("password", "mojehaslo");
        // editor.remove(); - usuwa dany klucz
        // commit() zapisuje na dysku telefonu
        editor.commit();
        // editor.apply(); - zapisanie danych do tła
    }

    // obsluga - odczyt danych
    private void loadData(){
        // podajemy klucz i wartość domyślną jeśli nie znajdzie klucza, czyli np brakLoginu
        String login = preferences.getString("login", "BrakLoginu");
        String password = preferences.getString("password", "BrakHasla");
        Log.e("debug", login + " : "+password);
    }

    @OnClick(R.id.save)
    public void onClickSave(){
        saveData();
    }
    @OnClick(R.id.load)
    public void onClickLoad(){
        loadData();
    }

}
