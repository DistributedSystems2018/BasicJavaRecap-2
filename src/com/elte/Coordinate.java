package com.elte;

public class Coordinate {

    private double x_;
    private double y_;

    public Coordinate(double x, double y){
        x_ = x;
        y_ = y;
    }

    public String toString() {
        return "(" + Double.toString(x_) + "," + Double.toString(y_) + ")";
    }

    double getX(){
        return x_;
    }

    double getY(){
        return y_;
    }

    double getDistanceFrom(Coordinate b){
        return Math.sqrt( Math.pow((double)(b.getX() - x_), 2) + Math.pow((double)(b.getY() - y_), 2));
    }
}

