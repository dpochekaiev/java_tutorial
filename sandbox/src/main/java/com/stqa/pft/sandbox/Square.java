package com.stqa.pft.sandbox;

public class Square {

    public double sideLength;

    public Square(double sideLength){
        this.sideLength = sideLength;
    }

    public double area () {
        return this.sideLength * this.sideLength;
    }

}
