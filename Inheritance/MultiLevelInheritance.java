
// Level 1: Base Class/Super Class
class Animal {
	String inheritance = "Hotdog";
	
	public void eat() {
		String someAnimal = "Animal Class\n";
		System.out.println("Animal is eating");
	}
}

// Level 2: Derived Class (Subclass of Animal, Parent Class of Dog)
class Mammal extends Animal {
	// the 'super' keyword pertains or points to the CURRENT PARENT CLASS, not the top-most SUPER CLASS.
	String anotherInheritance = super.inheritance;
	
	public void breathe() {
		String someMammal = "Mammal Class\n";
		System.out.println("Mammal breathes air");
	}
}

// Level 3: Derived Class (Subclass of Mammal, Parent Class of Bulldog)
class Dog extends Mammal {
	String secondInheritance = "Bye bye";
	
	public void bark() {
		String someDog = "Dog Class\n";
		System.out.println("Dog barks");
	}
}

// Level 4: Derived Class (Subclass of Dog, Parent Class of BabyBulldog)
class Bulldog extends Dog {
	// the 'super' keyword pertains or points to the CURRENT PARENT CLASS, not the top-most SUPER CLASS.
	String thirdInheritance = super.secondInheritance;
	
	public void guard() {
		String someBulldog = "Bulldog Class\n";
		System.out.println("Bulldog is guarding the house");
	}
}

// Level 5: Derived Class (Subclass of Bulldog)
class BabyBulldog extends Bulldog {
	public void play() {
		String someBabyBulldog = "Babby Bulldog Class\n";
		System.out.println("Baby Bulldog is playing");
	}
}

public class MultiLevelInheritance {
	public static void main(String[] args) {
		// Create an object of the BabyBulldog class
		BabyBulldog babyBulldog = new BabyBulldog();
		
		// Calling methods from all levels of the inheritance hierarchy
		babyBulldog.eat();        // Inherited from Animal
		babyBulldog.breathe();    // Inherited from Mammal
		babyBulldog.bark();       // Inherited from Dog
		babyBulldog.guard();	  // Inherited from Bulldog
		babyBulldog.play();	  // Inherited from BabyBulldog
	}
}
