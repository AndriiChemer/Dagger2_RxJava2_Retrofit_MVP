package com.example.andrii.rxprojectlesson.ui.map.viewmodel;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Value;

@Value
public class CarDetailMapViewModel implements Parcelable {

    private double lat;
    private double lng;
    private String title;

    public CarDetailMapViewModel(double lat, double lng, String title) {
        this.lat = lat;
        this.lng = lng;
        this.title = title;
    }

    private CarDetailMapViewModel(Parcel in) {
        lat = in.readDouble();
        lng = in.readDouble();
        title = in.readString();
    }

    public static final Creator<CarDetailMapViewModel> CREATOR = new Creator<CarDetailMapViewModel>() {
        @Override
        public CarDetailMapViewModel createFromParcel(Parcel in) {
            return new CarDetailMapViewModel(in);
        }

        @Override
        public CarDetailMapViewModel[] newArray(int size) {
            return new CarDetailMapViewModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(lat);
        dest.writeDouble(lng);
        dest.writeString(title);
    }
}
