package com.yumumu.front.model;

import java.io.Serializable;

public class ChangeSlide implements Serializable {
    private String slideName;

    public ChangeSlide(String slideName) {
        this.slideName = slideName;
    }

    @Override
    public String toString() {
        return slideName.toString();
    }
}
