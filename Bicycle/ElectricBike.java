class ElectricBike extends Bicycle {
    // the ElectricBike subclass adds one more field
    private int batteryLevel;

    public ElectricBike(int gear, int speed, int batteryLevel) {
        // invoking base-class (Bicycle) constructor
        super(gear, speed);
        this.batteryLevel = batteryLevel;
    }

    // the ElectricBike subclass adds one more method
    public void setBatteryLevel(int newBatteryLevel) {
        batteryLevel = newBatteryLevel;
    }

    // overriding toString() method of Bicycle to print more info
    @Override
    public String toString() {
        return (super.toString() + "\nBattery level is " + batteryLevel + "%");
    }
}
