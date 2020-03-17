package com.bb.movielist.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TransportObj implements Parcelable {

    private MovieListResult movieListResult;

    public TransportObj(MovieListResult movieListResult) {
        this.movieListResult = movieListResult;
    }

    protected TransportObj(Parcel in) {
    }

    public static final Creator<TransportObj> CREATOR = new Creator<TransportObj>() {
        @Override
        public TransportObj createFromParcel(Parcel in) {
            return new TransportObj(in);
        }

        @Override
        public TransportObj[] newArray(int size) {
            return new TransportObj[size];
        }
    };

    public MovieListResult getMovieListResult() {
        return movieListResult;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
