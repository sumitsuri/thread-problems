package com.solution.lld.designpat.builder;

public class Runner {

  public static void main(String[] args) {
    //
      Computer computer = new Computer.ComputerBuilder("qw","test")
              .setBluetoothEnabled(true)
              .setGraphicsCardEnabled(true)
              .build();
  }
}
