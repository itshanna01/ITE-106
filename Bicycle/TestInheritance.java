//driver class
public class TestInheritance 
{
    public static void main(String[] args) 
    {
        // Create an instance of MountainBike
        MountainBike mb = new MountainBike(3, 100, 25);
        System.out.println(mb.toString());
        
        // Create an instance of RoadBike
        RoadBike rb = new RoadBike(5, 120, "Drop");
        System.out.println(rb.toString());
        
        // Create an instance of ElectricBike
        ElectricBike eb = new ElectricBike(7, 80, 85);
        System.out.println(eb.toString());
    }
}
