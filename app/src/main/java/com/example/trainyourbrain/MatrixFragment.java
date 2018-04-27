package com.example.trainyourbrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MatrixFragment extends Fragment {

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    int pageNumber;

    static MatrixFragment newInstance(int page) {
        MatrixFragment matrixFragment = new MatrixFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        matrixFragment.setArguments(arguments);
        return matrixFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_matrix, null);

        TextView tvPage = (TextView) view.findViewById(R.id.displayText);
        ImageView ivPage = (ImageView) view.findViewById(R.id.displayImage);
        Button bPage = (Button) view.findViewById(R.id.displayButton);

        if (pageNumber == 0) {
            tvPage.setText("В течении 3 секунд несколько квадратов будут закрашены. Вам необходимо запомнить, какие квадраты закрашены.");
            ivPage.setImageResource(R.drawable.full);
            bPage.setVisibility(View.GONE);
        } else if (pageNumber == 1) {
            tvPage.setText("Вам нужно нажать на те квадраты, которые были закрашены");
            ivPage.setImageResource(R.drawable.empty);
            bPage.setVisibility(View.GONE);
        }
        bPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Matrix.class);
                startActivity(intent);
            }
        });
        return view;
    }
}