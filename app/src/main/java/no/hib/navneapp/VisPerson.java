package no.hib.navneapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class VisPerson extends Fragment {

    Person person;

    public VisPerson() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String argString = getArguments().getString("id");
        person = ((MainActivity)getActivity()).findPerson(argString);
        TextView tv = (TextView) getView().findViewById(R.id.visPersonTextView);
        ImageView iv = (ImageView) getView().findViewById(R.id.visPersonImageView);
        tv.setText(person.getNavn());
        iv.setImageDrawable(person.getBilde());

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vis_person, container, false);
    }



}
