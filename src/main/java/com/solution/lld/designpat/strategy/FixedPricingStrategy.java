package com.solution.lld.designpat.strategy;

public class FixedPricingStrategy implements PricingStrategy{
    @Override
    public float calculatePrice(float distance, float duration) {
        return 20 * distance;
    }
}
