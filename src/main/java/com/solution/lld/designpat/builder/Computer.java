package com.solution.lld.designpat.builder;

public class Computer {
    private String hdd;
    private String ram;

    //optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    public Computer(ComputerBuilder computerBuilder){
        this.hdd = computerBuilder.hdd;
        this.ram = computerBuilder.ram;
    }
    public static class ComputerBuilder{
        private String hdd;
        private String ram;

        //optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public void setHdd(String hdd) {
            this.hdd = hdd;
        }

        public void setRam(String ram) {
            this.ram = ram;
        }

        public ComputerBuilder setGraphicsCardEnabled(boolean graphicsCardEnabled) {
            isGraphicsCardEnabled = graphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean bluetoothEnabled) {
            isBluetoothEnabled = bluetoothEnabled;
            return this;
        }

        public ComputerBuilder(String hdd, String ram){
            this.hdd = hdd;
            this.ram = ram;
        }

        public Computer build(){
            return new Computer(this);
        }
    }
}
