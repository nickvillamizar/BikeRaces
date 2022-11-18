package com.umanizales.bikeraces.model;

public class BikeClaificationDTO {

        private Bike bike;
        private  double time;

        public BikeClaificationDTO(BikeClaificationDTO bikeClaificationDTO) {
        }

    public BikeClaificationDTO(Bike green, int i) {
    }

    public Bike getBike() {
            return bike;
    }

    public double getTime() {
            return time;
    }
}

