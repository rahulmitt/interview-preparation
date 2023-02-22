package com.interviewpedia.preparation.dp.gof._2_structural.bridge;

import com.interviewpedia.preparation.dp.gof._2_structural.bridge.color.BlueColor;
import com.interviewpedia.preparation.dp.gof._2_structural.bridge.color.RedColor;
import com.interviewpedia.preparation.dp.gof._2_structural.bridge.shape.Shape;
import com.interviewpedia.preparation.dp.gof._2_structural.bridge.shape.Square;
import com.interviewpedia.preparation.dp.gof._2_structural.bridge.shape.Triangle;

/**
 * Decouples the functional abstraction from the implementation so that the two can vary independently
 *
 * Advantage of Bridge Pattern
 *     It enables the separation of implementation from the interface.
 *     It improves the extensibility.
 *     It allows the hiding of implementation details from the client.
 *
 * Usage of Bridge Pattern
 *     When you don't want a permanent binding between the functional abstraction and its implementation.
 *     When both the functional abstraction and its implementation need to extended using sub-classes.
 *     It is mostly used in those places where changes are made in the implementation does not affect the clients.
 *
 *     https://www.baeldung.com/java-bridge-pattern
 */
public class BridgePatternMain {
    public static void main(String[] args) {
        Shape triangle = new Triangle(new RedColor());
        Shape square = new Square(new BlueColor());

        System.out.println(triangle.draw());
        System.out.println(square.draw());
    }
}
