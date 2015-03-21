package no.hib.navneapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


public class Navneliste extends Fragment {
    ListView nameList;


    public Navneliste() {
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
        View returnView = inflater.inflate(R.layout.fragment_navneliste, container, false);

        nameList = (ListView) returnView.findViewById(R.id.navneliste);
        nameList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = nameList.getItemAtPosition(position).toString();
                System.out.println(str);
                Bundle bundle = new Bundle();

                bundle.putString("id", str);
                VisPerson visPerson = new VisPerson();
                visPerson.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, visPerson).commit();

            }
        });

        List<String> list = ((MainActivity)getActivity()).getNames();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1, list);


        nameList.setAdapter(adapter);
        return returnView;
    }



}
