package com.solution.lld.designpat.strategy;

public class Runner {
  public static void main(String[] args) {
    //
      PricingEngine dynamicPricingEngine = new PricingEngine(new DynamicPricingStrategy());
      dynamicPricingEngine.calculatePrice(10, 20);

      PricingEngine fixedPricingEngine = new PricingEngine(new FixedPricingStrategy());
      fixedPricingEngine.calculatePrice(10, 20);
  }
}
