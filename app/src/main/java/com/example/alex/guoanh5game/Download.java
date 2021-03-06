/* -*- Mode: Java; c-basic-offset: 4; tab-width: 4; indent-tabs-mode: nil; -*-
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package com.example.alex.guoanh5game;

import android.os.Parcel;
import android.os.Parcelable;

public class Download implements Parcelable {
    public static final Creator<Download> CREATOR = new Creator<Download>() {

        @Override
        public Download createFromParcel(Parcel source) {
            return new Download(
                    source.readString(),
                    source.readString(),
                    source.readString(),
                    source.readString(),
                    source.readLong(),
                    source.readString());
        }

        @Override
        public Download[] newArray(int size) {
            return new Download[size];
        }
    };

    private final String url;
    private final String contentDisposition;
    private final String mimeType;
    private final long contentLength;
    private final String userAgent;
    private final String destinationDirectory;

    public Download(String url, String userAgent, String contentDisposition, String mimeType, long contentLength,
                    String destinationDirectory) {
        this.url = url;
        this.userAgent = userAgent;
        this.contentDisposition = contentDisposition;
        this.mimeType = mimeType;
        this.contentLength = contentLength;
        this.destinationDirectory = destinationDirectory;
    }

    /**
     * @return a Environment.DIRECTORY_* constant.
     */
    public String getDestinationDirectory() {
        return destinationDirectory;
    }

    public String getUrl() {
        return url;
    }

    public String getContentDisposition() {
        return contentDisposition;
    }

    public String getMimeType() {
        return mimeType;
    }

    public long getContentLength() {
        return contentLength;
    }

    public String getUserAgent() {
        return userAgent;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(userAgent);
        dest.writeString(contentDisposition);
        dest.writeString(mimeType);
        dest.writeLong(contentLength);
        dest.writeString(destinationDirectory);
    }
}
