package com.example.fragment2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link textfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class textfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public String nam;
    public static final String arg_name="name";



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public textfragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment textfragment.
     */
    // TODO: Rename and change types and number of parameters
    public static textfragment newInstance(String name) {
        textfragment fragment = new textfragment();
        Bundle args = new Bundle();
        args.putString("name",name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        if (bundle != null) {
            nam=bundle.getString(arg_name);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup conainer,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.textfragment, conainer, false);
        TextView tv=v.findViewById(R.id.cont_tv);
        tv.setText(nam);
        return v;
    }
}