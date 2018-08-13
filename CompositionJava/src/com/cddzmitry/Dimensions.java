package com.cddzmitry;

public class Dimensions {
    private int width;
    private int heigth;
    private int depth;

    public Dimensions(int width, int heigth, int depth) {
        this.width = width;
        this.heigth = heigth;
        this.depth = depth;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
