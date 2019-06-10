package com.example.mvcstructure.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvcstructure.R;

public class MainFragment extends Fragment {

    int someVar;
    int x,y,z;

    TextView tvHello;

   public static MainFragment newInstance(int someVar){
       MainFragment fragment = new MainFragment();
       Bundle args = new Bundle();
       args.putInt("someVar",someVar);
       fragment.setArguments(args);
       return fragment;
   }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        someVar= getArguments().getInt("someVar");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_main,
            container,
            false);
    initInstance(rootView);
    return rootView;
    }
    private void initInstance(View roorView){
       //findviewbyid everything
       tvHello = roorView.findViewById(R.id.tvHello);
    }
    public void setText(String text){
       tvHello.setText(text);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //care null
        if(savedInstanceState!=null){
            //restore here
        }
    }

}
