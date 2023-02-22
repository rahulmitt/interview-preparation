package com.interviewpedia.preparation.dp.gof._3_behavioral.strategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StrategyPatternMain {
    public static void main(String[] args) {

        List<Integer> pricesOfProductInCart = Arrays.asList(100, 200, 300, 400, 500);
        List<Double> applicableDiscounts = pricesOfProductInCart.stream()
                .map(price -> DiscountStrategy.diwaliDiscount().apply(price))
                .collect(Collectors.toList());

        System.out.println(pricesOfProductInCart);
        System.out.println(applicableDiscounts);

    }
}
