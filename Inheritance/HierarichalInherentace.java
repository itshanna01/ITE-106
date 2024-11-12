 class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public String speak() {
        return "Animal sound";
    }
}

class Dog extends Animal {
    String breed;

    public Dog(String name, String breed) {
        super(name);  
        this.breed = breed;
    }

    @Override
    public String speak() {
        return "Bark";  
    }
}

class Cat extends Animal {
    String color;

    public Cat(String name, String color) {
        super(name);  
        this.color = color;
    }

    @Override
    public String speak() {
        return "Meow";  
    }
}

class Bird extends Animal {
    String species;

    public Bird(String name, String species) {
        super(name); 
        this.species = species;
    }

    @Override
    public String speak() {
        return "Chirp"; 
    }
}

public class Main {
    public static void HierarichalInherentace(String[] args) {
      
        Dog dog = new Dog("Buddy", "Golden Retriever");
        Cat cat = new Cat("Whiskers", "Black");
        Bird bird = new Bird("Tweety", "Canary");

        System.out.println(dog.name + " says: " + dog.speak()); 
        System.out.println(cat.name + " says: " + cat.speak());  
        System.out.println(bird.name + " says: " + bird.speak()); 
    }
}