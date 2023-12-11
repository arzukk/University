package Enums;


public enum BasicFreightType {

    GAS_RR_CAR("GasRrCar"),
    LIQUID_RR_CAR("LiquidRrCar"),
    REFRIGERATOR_RR_CAR("RefrigeratorRrCar");

    private final String name;

    BasicFreightType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

