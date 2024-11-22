class RoadBike extends Bicycle {
    // the RoadBike subclass adds one more field
    private String handlebarType;

    public RoadBike(int gear, int speed, String handlebarType) {
        // invoking base-class (Bicycle) constructor
        super(gear, speed);
        this.handlebarType = handlebarType;
    }

    // the RoadBike subclass adds one more method
    public void setHandlebarType(String newHandlebarType) {
        handlebarType = newHandlebarType;
    }

    // overriding toString() method of Bicycle to print more info
    @Override
    public String toString() {
        return (super.toString() + "\nHandlebar type is " + handlebarType);
    }
}
