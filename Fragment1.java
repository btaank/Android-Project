package com.example.bharti.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by bharti on 10/11/2016.
 */

public class Fragment1 extends Fragment {
    Button btnAdd ;
    EditText name;
    EditText quantity;
    LoginDBadapter loginDBadapter;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_1, container, false);
        btnAdd = (Button)v.findViewById(R.id.button);
        name = (EditText)v.findViewById(R.id.editText3);
        quantity = (EditText)v.findViewById(R.id.editText4);
        final String Name = name.getText().toString();
        final String Quantity = quantity.getText().toString();
        loginDBadapter = new LoginDBadapter(getActivity());
        loginDBadapter = loginDBadapter.open();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.length()==0){
                    Toast.makeText(getActivity(), "Enter name", Toast.LENGTH_SHORT).show();
                }
                else if (quantity.length()==0)
                    Toast.makeText(getActivity(), "Enter quantity", Toast.LENGTH_SHORT).show();
                else{
                    loginDBadapter.insertGrocery(Name, Quantity);
                    Toast.makeText(getActivity(),"Successfully added.",Toast.LENGTH_SHORT).show();
                    loginDBadapter.setGname(Name);
                    loginDBadapter.setgQuantity(Quantity);

                }

            }
        });

        return v;
    }
}
