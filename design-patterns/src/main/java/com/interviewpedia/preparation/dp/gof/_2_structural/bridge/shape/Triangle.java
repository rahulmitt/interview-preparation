package com.interviewpedia.preparation.dp.gof._2_structural.bridge.shape;

import com.interviewpedia.preparation.dp.gof._2_structural.bridge.color.Color;

public class Triangle extends Shape{
    public Triangle(Color color) {
        this.color = color;
    }

    @Override
    public String draw() {
        return "Triangle drawn : " + color.fill();
    }
}
