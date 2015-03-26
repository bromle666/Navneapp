package no.hib.navneapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class Bildequiz extends Fragment {

    private int score;
    private int counter;
    private List<Person> personliste;
    private List<String> navneListe;
    private Person currentPerson;
    private ImageView imageView;
    private Spinner spinner;
    private Button button;

    public Bildequiz() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View returnView = inflater.inflate(R.layout.fragment_bildequiz, container, false);

        score = 0;
        counter = 0;
        personliste = ((MainActivity)getActivity()).getPersonListe();
        navneListe = ((MainActivity)getActivity()).getNames();
        imageView = (ImageView) returnView.findViewById(R.id.quizImageView);
        spinner = (Spinner) returnView.findViewById(R.id.quizSpinner);
        button = (Button) returnView.findViewById(R.id.quizButton);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1, navneListe);
        spinner.setAdapter(adapter);

        currentPerson = personliste.get(counter);
        imageView.setImageDrawable(currentPerson.getBilde());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinner.getSelectedItem().equals(currentPerson.getNavn())) {
                    Toast.makeText(getActivity(), "Riktig",Toast.LENGTH_SHORT).show();
                    score++;
                }
                else {
                    Toast.makeText(getActivity(), "Galt",Toast.LENGTH_SHORT).show();
                }
                counter++;


                if (counter < personliste.size()) {
                    currentPerson = personliste.get(counter);
                    imageView.setImageDrawable(currentPerson.getBilde());
                }
                else {
                    Toast.makeText(getActivity(), "Din score ble " + score ,Toast.LENGTH_LONG).show();
                }
            }
        });


        return returnView;
    }


}
