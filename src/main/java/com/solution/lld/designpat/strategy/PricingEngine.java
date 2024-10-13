package com.solution.lld.designpat.strategy;

public class PricingEngine {
    private PricingStrategy pricingStrategy;

    public PricingEngine(PricingStrategy pricingStrategy){
        this.pricingStrategy = pricingStrategy;
    }

    public float calculatePrice(float distance, float duration){
        return pricingStrategy.calculatePrice(distance, duration);
    }
}
