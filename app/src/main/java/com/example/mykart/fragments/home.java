package com.example.mykart.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.example.mykart.R;
import com.example.mykart.adapters.OfferViewPagerAdapter;
import com.example.mykart.adapters.TestAdapter;
import com.example.mykart.models.Offer;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;


public class home extends Fragment {

    OfferViewPagerAdapter offerViewPagerAdapter;
    ViewPager2 vpOffer;
    TabLayout mOfferTabLayout;


    public home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        vpOffer = view.findViewById(R.id.viewpager_offer);
        mOfferTabLayout = view.findViewById(R.id.tabl_offer);

        initOffers();

        // Inflate the layout for this fragment
        return view;

    }

    private void initOffers() {

        ArrayList<Fragment> offerFragments= new ArrayList<>();
        Offer offers[] = {new Offer(R.drawable.img_offer_headphones),
                new Offer(R.drawable.img_offers_choths),
                new Offer(R.drawable.img_offers_bag) };

        for(Offer offer: offers){
            offerViewpPagerRowFragment offerRowFrag = offerViewpPagerRowFragment.newInstance(offer);
            offerFragments.add(offerRowFrag);
        }

        OfferViewPagerAdapter offerViewPagerAdapter = new OfferViewPagerAdapter(getChildFragmentManager(), getLifecycle(),offerFragments);
        vpOffer.setAdapter(offerViewPagerAdapter);
        new TabLayoutMediator(mOfferTabLayout, vpOffer, (tab, position) -> {}).attach();

    }
}