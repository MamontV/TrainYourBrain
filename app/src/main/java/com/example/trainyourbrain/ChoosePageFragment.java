package com.example.trainyourbrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ChoosePageFragment extends Fragment {

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;
    Button one, two;

    static ChoosePageFragment newInstance(int page) {
        ChoosePageFragment pageFragment = new ChoosePageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_choose, null);
        one = (Button) view.findViewById(R.id.one);
        two = (Button) view.findViewById(R.id.two);

        if (pageNumber == 0) {
            one.setBackgroundResource(R.drawable.imagematrix);
            one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click();
                }
            });
            two.setVisibility(View.GONE);
        }
        else if (pageNumber == 1) {
            one.setBackgroundResource(R.drawable.imagetable);
            one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click();
                }
            });
            two.setBackgroundResource(R.drawable.imageplanes);
            two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nextClick();
                }
            });
        }
        else if (pageNumber == 2) {
            one.setBackgroundResource(R.drawable.imagecolors);
            one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    click();
                }
            });
            two.setVisibility(View.GONE);
        }
        return view;
    }

    public void click() {
        switch (pageNumber) {
            case 0:
                Intent intent = new Intent(getActivity(), MatrixInfo.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(getActivity(), TableInfo.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(getActivity(), ColoursInfo.class);
                startActivity(intent);
                break;
        }
    }

    public void nextClick() {
        Intent intent = new Intent(getActivity(), PlanesInfo.class);
        startActivity(intent);
    }
}