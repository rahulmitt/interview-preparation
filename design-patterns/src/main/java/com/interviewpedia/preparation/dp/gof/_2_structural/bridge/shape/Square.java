package com.interviewpedia.preparation.dp.gof._2_structural.bridge.shape;

import com.interviewpedia.preparation.dp.gof._2_structural.bridge.color.Color;

public class Square extends Shape{
    public Square(Color color) {
        this.color = color;
    }

    @Override
    public String draw() {
        return "Square drawn : " + color.fill();
    }
}
