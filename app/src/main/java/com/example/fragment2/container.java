package com.example.fragment2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link container#newInstance} factory method to
 * create an instance of this fragment.
 */
public class container extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public String nam;
    private onfragmentclicklistener listener;
    public static final String arg_name="name";

    public container() {
        // Required empty public constructor
    }
    public static container cont(String name)
    {
        Bundle bundle=new Bundle();
        bundle.putString("name",name);
        container container=new container();
        container.setArguments(bundle);
        return container;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment container.
     */
    // TODO: Rename and change types and number of parameters
    public static container newInstance(String param1, String param2) {
        container fragment = new container();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof onfragmentclicklistener)
            listener = (onfragmentclicklistener) context;
        else throw new ClassCastException("Your activity does not implements onfragmentclicklistener ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener=null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle=getArguments();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        if (bundle != null) {
            nam = bundle.getString(arg_name);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_container, container, false);
       RecyclerView rv=v.findViewById(R.id.recycle);
        ArrayList<name> names=new ArrayList<>();
        names.add(new name("mina"));
        names.add(new name("mena"));
        names.add(new name("mina wael"));
        names.add(new name("mena wael"));
        adapter adapter=new adapter(names, new onitemclicklistener() {
            @Override
            public void onitemclicked(name name) {
           listener.onfragmentinter(name);
            }
        });
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }
    public interface onfragmentclicklistener
    {
        void onfragmentinter(name name);
    }
}