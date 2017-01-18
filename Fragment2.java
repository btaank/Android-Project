package com.example.bharti.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bharti on 10/11/2016.
 */

public class Fragment2 extends Fragment {
    LoginDBadapter loginDBadapter;
    private List<Grocery> groceryList;
    private RecyclerView recyclerView;
    private GroceryAdapter gAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_2, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        groceryList = new ArrayList<>();
        Grocery g = new Grocery();
        loginDBadapter = new LoginDBadapter(getActivity());
        loginDBadapter = loginDBadapter.open();
        g.setGname(loginDBadapter.getGroceryName());
        g.setgQuantity(loginDBadapter.getGroceryQuantity());
        groceryList.add(g);
        //  updateUI();
        return v;
    }


    private class GroceryHolder extends RecyclerView.ViewHolder {
        private Grocery grocery;
        //public ImageView mImageView;
        public TextView NameTextView;
        public TextView quantityTextView;

        public GroceryHolder(View itemView) {
            super(itemView);
            // mImageView = (ImageView) itemView.findViewById(R.id.imageView);
            NameTextView = (TextView) itemView.findViewById(R.id.textView5);
            quantityTextView = (TextView) itemView.findViewById(R.id.textView6);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),
                            grocery.getGname() + " clicked!", Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }

        public void bindData(Grocery g) {
            grocery = g;
            // mImageView.setImageResource(s.getImageId());
            NameTextView.setText(g.getGname());
            quantityTextView.setText(g.getgQuantity());
        }
    }

    private class GroceryAdapter extends RecyclerView.Adapter<GroceryHolder> {
        public String id;
        public int cPosition;
        Context context;
        private ArrayList<Grocery> groceryList1 = new ArrayList<Grocery>();
        ArrayList<Grocery> groceryList;

        public GroceryAdapter(Context context, ArrayList<Grocery> groceryList) {
            this.groceryList = new ArrayList<Grocery>();
            this.context = context;
            this.groceryList = groceryList;
        }

        @Override
        public GroceryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.grocery_list, null);
            RecyclerView.ViewHolder GroceryHolder = new RecyclerView.ViewHolder(itemLayoutView) {
                @Override
                public String toString() {
                    return super.toString();
                }

            };
            return (Fragment2.GroceryHolder) GroceryHolder;
        }


        @Override
        public void onBindViewHolder(GroceryHolder holder, int position) {
            Log.d("Position", "" + position);
        //    holder.
        //    Grocery g = groceryList.get(position);
        //    holder.bindData(g);
        }
        @Override
        public int getItemCount() {
            return groceryList.size();
        }
    }
}



