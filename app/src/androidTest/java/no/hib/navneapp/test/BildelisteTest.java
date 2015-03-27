package no.hib.navneapp.test;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.ListView;

import no.hib.navneapp.Bildeliste;
import no.hib.navneapp.MainActivity;
import no.hib.navneapp.R;

/**
 * Created by Endre on 26-Mar-15.
 */
public class BildelisteTest extends ActivityInstrumentationTestCase2<MainActivity> {


    MainActivity mainActivity;
    Button goToBildeliste;

    public BildelisteTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainActivity = getActivity();
        goToBildeliste = (Button) mainActivity.findViewById(R.id.bildelisteButton);
    }

    @SmallTest
    public void testListView(){

        TouchUtils.clickView(this, goToBildeliste);

        ListView mListView = (ListView) mainActivity.findViewById(R.id.bildeliste);

        assertNotNull(mListView);

    }
}
