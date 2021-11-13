package com.example.mykart.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mykart.models.Offer;

import java.util.ArrayList;

public class OfferViewPagerAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> offerFragments;


    public OfferViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle, ArrayList<Fragment> offerFragments) {
        super(fragmentManager, lifecycle);
        this.offerFragments = offerFragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return offerFragments.get(position);
    }

    @Override
    public int getItemCount() {
        return offerFragments.size();
    }
}
