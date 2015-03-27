package no.hib.navneapp.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.InstrumentationTestCase;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.ListView;

import no.hib.navneapp.Bildeliste;
import no.hib.navneapp.MainActivity;
import no.hib.navneapp.Navneliste;
import no.hib.navneapp.R;

/**
 * Created by Endre on 26-Mar-15.
 */
public class NavnelisteTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity mainActivity;
    Button goToNavneliste;

    public NavnelisteTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainActivity = getActivity();
        goToNavneliste = (Button) mainActivity.findViewById(R.id.navnelisteButton);
    }

    @SmallTest
    public void testListView(){

        TouchUtils.clickView(this, goToNavneliste);

        ListView mListView = (ListView) mainActivity.findViewById(R.id.navneliste);

        assertNotNull(mListView);

    }
}
