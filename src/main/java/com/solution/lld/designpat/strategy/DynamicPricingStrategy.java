package com.solution.lld.designpat.strategy;

public class DynamicPricingStrategy implements PricingStrategy{
    @Override
    public float calculatePrice(float distance, float duration) {
        return 10 * distance;
    }
}
