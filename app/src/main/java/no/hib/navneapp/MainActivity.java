package no.hib.navneapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {

    private List<Person> personListe;

    public List<Person> getPersonListe() {
        return personListe;
    }

    private void populatePersonListe() {
        Person cat = new Person("cat", getResources().getDrawable(R.drawable.cat));
        Person dog = new Person("dog", getResources().getDrawable(R.drawable.dog));
        Person fish = new Person("fish", getResources().getDrawable(R.drawable.fish));
        personListe.add(cat);
        personListe.add(dog);
        personListe.add(fish);
    }

    public Person findPerson(String id) {
        Person returnPerson = null;
        for (Person p : personListe) {
            if (id.equals(p.getNavn())) {
               returnPerson = p;
            }
        }

        return returnPerson;
    }

    public Person findPersonFromPic(String id) {
        Person returnPerson = null;
        for (Person p : personListe) {
            if (id.equals(p.getBilde().toString())) {
                returnPerson = p;
            }
        }

        return returnPerson;
    }



    public List<Drawable> getPictures() {
        List<Drawable> returnList = new ArrayList<Drawable>();
        for (Person tempPerson : personListe) {
            returnList.add(tempPerson.getBilde());
        }
        return returnList;
    }

    public List<String> getNames() {
        List<String> returnList = new ArrayList<String>();
        for (Person tempPerson : personListe) {
            returnList.add(tempPerson.getNavn());
        }
        return returnList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personListe = new ArrayList<Person>();
        populatePersonListe();



        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            WelcomeScreen welcomeScreen = new WelcomeScreen();
            getFragmentManager()
                    .beginTransaction()
                        .add(R.id.fragment_container, welcomeScreen)
                    .commit();
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            Log.i("MainActivity", "popping backstack");
            fm.popBackStackImmediate();
        } else {
            Log.i("MainActivity", "nothing on backstack, calling super");
            super.onBackPressed();
        }
    }
}
