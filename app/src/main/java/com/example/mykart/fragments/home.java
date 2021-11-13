package com.example.mykart.fragments;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;

import com.example.mykart.R;
import com.example.mykart.adapters.DealsRecyclerAdapter;
import com.example.mykart.adapters.OfferViewPagerAdapter;
import com.example.mykart.adapters.TestAdapter;
import com.example.mykart.animatorClasses.ZoomInTransformer;
import com.example.mykart.models.Deals;
import com.example.mykart.models.Offer;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;


public class home extends Fragment {

    ViewPager2 vpOffer;
    TabLayout mOfferTabLayout;
    LinearLayout offerGradientBg;
    int prevColor = Color.parseColor("#ffffff");
    ValueAnimator gradientAnim;
    boolean firstAnimeSaveSwitch = true;

    ArrayList<ValueAnimator> offerAnimators = new ArrayList<>();

    Bitmap offerImg;

    Handler offerSlideHandler = new Handler();
    //Handler offerAnimHandler = new Handler();


    //todaysDeals
    RecyclerView rv_deals;
    DealsRecyclerAdapter dealsRecyclerAdapter;
    GridLayoutManager dealsGridLayoutManager;
    ArrayList<Deals> deals = new ArrayList<>();



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
        offerGradientBg = view.findViewById(R.id.offer_gradient_layout);

        initOffers();

        //todaysdeals
        deals.add(new Deals("","",0,R.drawable.img_deals_phones));
        deals.add(new Deals("","",1, R.drawable.img_deals_earphones));
        deals.add(new Deals("","",2, R.drawable.img_deals_macbook));
        deals.add(new Deals("","",3, R.drawable.img_deals_suit));

        rv_deals = view.findViewById(R.id.rv_todaysdeals);
        dealsGridLayoutManager = new GridLayoutManager(getContext(), 2);
        dealsRecyclerAdapter = new DealsRecyclerAdapter(getContext(), deals);
        rv_deals.setLayoutManager(dealsGridLayoutManager);
        rv_deals.setAdapter(dealsRecyclerAdapter);


        // Inflate the layout for this fragment
        return view;

    }

    void createPelleteAsync( Bitmap bitmap){
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {

                if(firstAnimeSaveSwitch){
                    prevColor = palette.getDominantColor(0x000000);
                    firstAnimeSaveSwitch = false;
                }

                ValueAnimator gradientAnim = ValueAnimator.ofObject(new ArgbEvaluator(), prevColor , palette.getDominantColor(0x000000));
                gradientAnim.addUpdateListener(animation -> offerGradientBg.getBackground().setColorFilter((Integer)animation.getAnimatedValue(), PorterDuff.Mode.SRC_ATOP));
                //gradientAnim.setDuration();
                offerAnimators.add(gradientAnim);
                //offerGradientBg.getBackground().setColorFilter(palette.getDominantColor(0x000000), PorterDuff.Mode.SRC_ATOP);
                prevColor = palette.getDominantColor(0x000000);
            }
        });

    }

    private void initOffers() {

        ArrayList<Fragment> offerFragments= new ArrayList<>();
        Offer offers[] = {new Offer(R.drawable.img_offer_mac),
                new Offer(R.drawable.img_offer_boat),
                new Offer(R.drawable.img_offers_bag),
                new Offer(R.drawable.img_offers_choths),};

        for(Offer offer: offers){
            offerViewpPagerRowFragment offerRowFrag = offerViewpPagerRowFragment.newInstance(offer);
            //pellete to background gradient
            offerImg = BitmapFactory.decodeResource(getResources(), offer.getImageId());
            createPelleteAsync(offerImg);

            offerFragments.add(offerRowFrag);
        }

        OfferViewPagerAdapter offerViewPagerAdapter = new OfferViewPagerAdapter(getChildFragmentManager(), getLifecycle(),offerFragments);
        vpOffer.setAdapter(offerViewPagerAdapter);
        vpOffer.setOffscreenPageLimit(3);
        vpOffer.setClipToPadding(false);
        vpOffer.setClipChildren(false);
        vpOffer.setPageTransformer(new ZoomInTransformer());
        new TabLayoutMediator(mOfferTabLayout, vpOffer, (tab, position) -> {}).attach();


        vpOffer.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                offerAnimators.get(position).start();

                //System.out.println("DebugApp: " + vpOffer.getCurrentItem());
                if( vpOffer.getCurrentItem() == offerViewPagerAdapter.getItemCount() - 1){
                    offerSlideHandler.removeCallbacks(slideRunnable);
                    offerSlideHandler.removeCallbacks(slideRunnable0);
                    offerSlideHandler.postDelayed(slideRunnable0, 3000);


                }else{
                    offerSlideHandler.removeCallbacks(slideRunnable);
                    offerSlideHandler.removeCallbacks(slideRunnable0);
                    offerSlideHandler.postDelayed(slideRunnable, 3000);

                }

            }
        });

    }

    private Runnable slideRunnable = new Runnable() {
        @Override
        public void run() {
                vpOffer.setCurrentItem(vpOffer.getCurrentItem() + 1);
        }
    };

    private Runnable slideRunnable0 = new Runnable() {
        @Override
        public void run() {
            vpOffer.setCurrentItem(0);
        }
    };


}