// derived class

class MountainBike extends Bicycle
{
  // the MountainBike subclass adds one more fields
  public int seatHeight;

  public MountainBike(int gear, int speed, int seatHeight)
  {
   // involving base-class (Bicycle) constructor
    super(gear, speed);
    seatHeight = startHeight;
  }
  
   // the MountainBike subclass adds one more method
  public void setHeight(int newValue)
  {
    seatHeight = newValue;
  }

  //overriding toString() method
  //of Bicycle to print more info
  @Override public string toString()
  {
    return (super.toString() + "\nseat height is "
            + seatHeight);
  } 
}
