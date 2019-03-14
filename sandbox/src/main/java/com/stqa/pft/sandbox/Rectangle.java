package com.stqa.pft.sandbox;

public class Rectangle {

    public double sideALength;
    public double sideBLength;

    public Rectangle (double sideALength, double sideBLength) {
        this.sideALength = sideALength;
        this.sideBLength = sideBLength;
    }

    public double area () {
        return this.sideALength * this.sideBLength;
    }

}
