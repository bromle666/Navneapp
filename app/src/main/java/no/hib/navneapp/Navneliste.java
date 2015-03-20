package no.hib.navneapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


public class Navneliste extends Fragment {

    public Navneliste() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView nameList = (ListView) getActivity().findViewById(R.id.navneliste);
        List<String> list = ((MainActivity)getActivity()).getNames();

        System.out.println(this.getActivity());
        System.out.println(android.R.layout.simple_list_item_1);
        System.out.println(list.size());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1, list);
        nameList.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navneliste, container, false);
    }



}
