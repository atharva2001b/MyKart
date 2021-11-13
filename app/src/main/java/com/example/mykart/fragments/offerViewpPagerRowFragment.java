package com.example.mykart.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mykart.R;
import com.example.mykart.models.Offer;

public class offerViewpPagerRowFragment extends Fragment {

    private Offer mOffer;
    private ImageView mOfferImg;

    public static offerViewpPagerRowFragment newInstance(Offer offer) {
        offerViewpPagerRowFragment fragment = new offerViewpPagerRowFragment();

        if(offer != null){
            Bundle args = new Bundle();
            args.putParcelable("offer" , offer);
            fragment.setArguments(args);
        }
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            mOffer = getArguments().getParcelable("offer");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_offer_viewp_pager_row, container, false);


        mOfferImg = view.findViewById(R.id.imgv_offer);

        if (mOffer != null) {
            RequestOptions options = new RequestOptions().placeholder(R.drawable.ic_bag);
            Glide.with(getActivity())
                    .applyDefaultRequestOptions(options)
                    .load(mOffer.getImageId())
                    .into(mOfferImg);
        }


        // Inflate the layout for this fragment
        return view;
    }


}