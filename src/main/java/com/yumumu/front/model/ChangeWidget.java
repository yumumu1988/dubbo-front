package com.yumumu.front.model;

import java.io.Serializable;

public class ChangeWidget implements Serializable {
    private Integer widgetNumber;

    public ChangeWidget(Integer widgetNumber) {
        this.widgetNumber = widgetNumber;
    }

    @Override
    public String toString() {
        return widgetNumber.toString();

    }
}
