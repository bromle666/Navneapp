package no.hib.navneapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class WelcomeScreen extends Fragment {


    public WelcomeScreen() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View returnView = inflater.inflate(R.layout.fragment_welcome_screen, container, false);

        Button navneListeButton = (Button) returnView.findViewById(R.id.navnelisteButton);
        navneListeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navneliste navneliste = new Navneliste();
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, navneliste).commit();
            }
        });

        return returnView;
    }





}
