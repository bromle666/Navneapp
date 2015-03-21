package no.hib.navneapp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
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
    TextView tv;
    ImageView iv;
    Drawable d;



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
        View returnView = inflater.inflate(R.layout.fragment_vis_person, container, false);

        String argString = getArguments().getString("id");
        person = ((MainActivity)getActivity()).findPerson(argString);
        tv = (TextView) returnView.findViewById(R.id.visPersonTextView);
        iv = (ImageView) returnView.findViewById(R.id.visPersonImageView);
        tv.setText(person.getNavn());
        d = person.getBilde();
        iv.setImageDrawable(d);

        // Inflate the layout for this fragment
        return returnView;
    }



}
