package no.hib.navneapp.test;

import android.app.Fragment;
import android.app.FragmentManager;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import no.hib.navneapp.Bildequiz;
import no.hib.navneapp.MainActivity;
import no.hib.navneapp.R;

/**
 * Created by Endre on 27-Mar-15.
 */
public class QuizTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity mainActivity;
    ImageView imageView;
    Spinner spinner;
    Button button;
    Button goToQuiz;
    Fragment currentFragment;
    Bildequiz bildequiz;
    FragmentManager fm;

    public QuizTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mainActivity = getActivity();

        goToQuiz = (Button) mainActivity.findViewById(R.id.bildequizButton);
        fm = mainActivity.getFragmentManager();

    }



    @SmallTest
    public void testScore() {

        TouchUtils.clickView(this, goToQuiz);

        currentFragment = fm.findFragmentById(R.layout.fragment_bildequiz);
        bildequiz = (Bildequiz) currentFragment;

        imageView = (ImageView) mainActivity.findViewById(R.id.quizImageView);
        spinner = (Spinner) mainActivity.findViewById(R.id.quizSpinner);
        button = (Button) mainActivity.findViewById(R.id.quizButton);

        assertNotNull(imageView);
        assertNotNull(spinner);

        assertEquals(0, bildequiz.getScore());

        TouchUtils.clickView(this, button);
        TouchUtils.clickView(this, button);
        TouchUtils.clickView(this, button);

        assertEquals(0, bildequiz.getScore());
    }
}


