package no.hib.navneapp;

import android.app.Activity;
import android.graphics.drawable.Drawable;
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


public class Bildeliste extends Fragment {

    ListView picList;

    public Bildeliste() {
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
        View returnView = inflater.inflate(R.layout.fragment_bildeliste, container, false);

        picList = (ListView) returnView.findViewById(R.id.bildeliste);
        picList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = picList.getItemAtPosition(position).toString();

                

                Bundle bundle = new Bundle();

                bundle.putString("id", str);
                bundle.putBoolean("isName", false);
                VisPerson visPerson = new VisPerson();
                visPerson.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, visPerson).addToBackStack(null).commit();

            }
        });

        List<Drawable> list = ((MainActivity)getActivity()).getPictures();


        MyCustomAdapter adapter = new MyCustomAdapter(getActivity(), list);



        picList.setAdapter(adapter);
        return returnView;
    }



}
