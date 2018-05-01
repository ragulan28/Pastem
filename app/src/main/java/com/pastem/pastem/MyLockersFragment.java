package com.pastem.pastem;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Ragulan on 3/19/2018.
 */

public class MyLockersFragment extends Fragment{

    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        dataModels= new ArrayList<>();

        dataModels.add(new DataModel("Colombo", " ", " ","September 23, 2008"));
        dataModels.add(new DataModel("Kelaniya", " ", " ","February 9, 2009"));
        dataModels.add(new DataModel("Kandy", " ", " ","April 27, 2009"));
        dataModels.add(new DataModel("Moratuwa"," "," ","September 15, 2009"));
        dataModels.add(new DataModel("Sigiriya", " ", " ","October 26, 2009"));
        dataModels.add(new DataModel("Galle Face", " ", " ","May 20, 2010"));
        adapter= new CustomAdapter(dataModels,this.getContext());

        return inflater.inflate(R.layout.fragment_my_lockers,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        listView =view.findViewById(R.id.lockersListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), MyCabinetActivity.class));
                DataModel dataModel= dataModels.get(position);

                Snackbar.make(view, dataModel.getName()+"\n"+dataModel.getType()+" API: "+dataModel.getVersion_number(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
    }
}
