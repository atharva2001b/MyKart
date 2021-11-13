package com.example.mykart.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Offer implements Parcelable {

    public Offer (int imageId){
        this.imageId = imageId;
    }

    private int imageId;

    protected Offer(Parcel in) {
        imageId = in.readInt();
    }

    public static final Creator<Offer> CREATOR = new Creator<Offer>() {
        @Override
        public Offer createFromParcel(Parcel in) {
            return new Offer(in);
        }

        @Override
        public Offer[] newArray(int size) {
            return new Offer[size];
        }
    };

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(imageId);
    }
}
