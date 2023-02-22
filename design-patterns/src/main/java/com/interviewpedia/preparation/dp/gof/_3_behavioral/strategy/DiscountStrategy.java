package com.interviewpedia.preparation.dp.gof._3_behavioral.strategy;

public interface DiscountStrategy {
    double NEW_YEAR_DISCOUNT = 5;
    double DIWALI_DISCOUNT = 10;
    double HOLI_DISCOUNT = 6;

    double apply(double amount);

    static DiscountStrategy diwaliDiscount() {
        return amount -> amount * DIWALI_DISCOUNT / 100;
    }

    static DiscountStrategy newYearDiscount() {
        return amount -> amount * NEW_YEAR_DISCOUNT / 100;
    }

    static DiscountStrategy holiDiscount() {
        return amount -> amount * HOLI_DISCOUNT / 100;
    }
}
