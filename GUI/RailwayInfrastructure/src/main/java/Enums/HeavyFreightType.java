package Enums;

public enum HeavyFreightType {
    EXPLOSIVE_RR_CAR("ExplosiveRrCar"),
    TOXIC_RR_CAR("ToxicRrCar"),
    LIQUID_TOXIC_RR_CAR("LiquidToxicRrCar");

    private final String name;

    HeavyFreightType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
