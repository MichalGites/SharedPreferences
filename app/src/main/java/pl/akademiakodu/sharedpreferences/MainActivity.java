package pl.akademiakodu.sharedpreferences;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // robimy globalne pola i przypisujemy w onCreate zgodnie z zasadami CLEAN CODE zeby nie powtarzac tego w metodach
    // begin() musi byc uruchomione przed kazda transakcja
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // usluga systemowa musi miec swojego managera
        fragmentManager = getFragmentManager();
    }



    // zostawiam stare id przyciskow do fragmentow
    // pilnowac zgodnosci importow FragmentManagera albo support albo zwykly nie mozna mieszac
    @OnClick(R.id.save)
    public void onBackClick(){
        // transkacja wymiany fragmentow
        fragmentTransaction = fragmentManager.beginTransaction();
        // podajemy layout do ktorego wstrzykujemy i konstruktor fragmnetu wstrzykiwanego - pusty wygenerowany automatcznie
        /* wstrzykujemy za pomoca replace (zamienia fragmenty kasujac je - podmienia je ze soba)
        lub add (naklada nowy nie kasujac starego - dlatego przycisk z czerwonego dziala na zielonym*/
        fragmentTransaction.replace(R.id.frameLayout, new GreenFragment());
        // akceptujemy transakcje jeszcze
        fragmentTransaction.commit();
    }
    @OnClick(R.id.load)
    public void onNextClick(){
        // transkacja wymiany fragmentow
        fragmentTransaction = fragmentManager.beginTransaction();
        // podajemy layout do ktorego wstrzykujemy (jego id) i konstruktor fragmnetu wstrzykiwanego - pusty wygenerowany automatcznie
        // podajemy layout do ktorego wstrzykujemy i konstruktor fragmnetu wstrzykiwanego - pusty wygenerowany automatcznie
        /* wstrzykujemy za pomoca replace (zamienia fragmenty kasujac je - podmienia je ze soba)
        lub add (naklada nowy nie kasujac starego - dlatego przycisk z czerwonego dziala na zielonym*/
        fragmentTransaction.replace(R.id.frameLayout, new RedFragment());
        // akceptujemy transakcje jeszcze
        fragmentTransaction.commit();
    }

}
