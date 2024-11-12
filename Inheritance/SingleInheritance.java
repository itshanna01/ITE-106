
// Level 1: Base Class/Super Class
class Parent {  // Parent class
    // Class attributes (variables)
    String hairType = "Curly";  
    String skinTone = "Fair"; 
    int wealth = 1000000; 

    // Method of Parent class
    public void displayParentDetails() {
        System.out.println("Parent's Hair Type: " + hairType);
        System.out.println("Parent's Skin Tone: " + skinTone);
        System.out.println("Parent's Wealth: " + wealth);
    }
}

// Level 2: Derived Class (Subclass of Parent)
class Child extends Parent {  // Child class inherits from Parent
    // Class attributes (variables) in Child class
    String inheritedHairType = super.hairType;  // Inherited attribute
    String inheritedSkinTone = super.skinTone;  // Inherited attribute
    int inheritedWealth = super.wealth / 2;     // Modified inherited attribute

    // Method of Child class
    public void displayChildDetails() {
        System.out.println("Child's Hair Type: " + inheritedHairType);
        System.out.println("Child's Skin Tone: " + inheritedSkinTone);
        System.out.println("Child's Wealth: " + inheritedWealth);
    }
}

public class SingleInheritance {
    public static void main(String[] args) {
        // Creating an object of the Child class
        Child john = new Child();

        // Calling the method from Parent class
        john.displayParentDetails();  // Parent's details

        // Calling the method from Child class
        john.displayChildDetails();  // Child's details
    }
}
