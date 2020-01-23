package com.examplex.kirill.myapplication;


import android.animation.LayoutTransition;
import android.app.Fragment;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;

public class item_fragment extends Fragment {
    final int EDIT_TIMER = 1;
    final int DELETE_TIMER = 2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.fragment_item_fragment, container, false);
        retView.findViewById(R.id.rel).setBackgroundResource(R.drawable.card_style_view);
        return retView;
    }
}
