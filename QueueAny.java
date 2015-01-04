import java.util.LinkedList;
import java.util.Date;
import java.util.*;

// An animal shelter holds only dogs and cats, and operates on a
// strictly "first in, first out" basis. People must adopt either
// the "oldest" (based on arrival time) of all animals at the shelter,
// or they can select whether they would prefer a dog or a cat
// (and will receive the oldest animal of that type). They cannot
// select which specificanimal they would like. Create the data
// structures to maintain this system and implement operations such
// as enqueue, dequeueAny, dequeueDog and dequeueCat.You mayusethe
// built-in LinkedList data structure.

public class QueueAny {

    private class Animal {
        private String name;
        private Date arrivalTime;

        public Animal(String name, Date time) {
            this.name = name;
            this.arrivalTime = time;
        }
    }

    public class Cat extends Animal {

        public Cat() {
            super("Cat", null);
        }

        public Cat(String name, Date time) {
            super(name, time);
        }
    }

    public class Dog extends Animal {

        public Dog() {
            super("Dog", null);
        }

        public Dog(String name, Date time) {
            super(name, time);
        }
    }

    public class AnimalShelter {
        private LinkedList<Animal> cats;
        private LinkedList<Animal> dogs;

        public AnimalShelter() {
            cats = new LinkedList<Animal>();
            dogs = new LinkedList<Animal>();
        }

        public void enqueue(Animal animal) {
            //animal.arrivalTime = new Date();
            if (animal instanceof Cat) {
                System.out.print("Cat enqueued at ");
                cats.addLast(animal);
            }
            else if (animal instanceof Dog) {
                System.out.print("Dog enqueued at ");
                dogs.addLast(animal);
            }
            System.out.println(animal.arrivalTime.toString());
        }

        public Animal dequeueAny() {
            if (dogs.size() == 0 ||
                (cats.size() != 0 && cats.peekFirst().arrivalTime.before(dogs.peekFirst().arrivalTime))) {
                return dequeueCat();
            }
            else {
                return dequeueDog();
            }
        }

        public Animal dequeueCat() {
            return cats.size() == 0 ? null : cats.removeFirst();
        }

        public Animal dequeueDog() {
            return dogs.size() == 0 ? null : dogs.removeFirst();
        }

        public boolean isEmpty() {
            return cats.size() == 0 && dogs.size() == 0;
        }
    }

    static Cat c1;
    static Cat c2;
    static Cat c3;
    static Dog d1;
    static Dog d2;
    static Dog d3;
    static AnimalShelter shelter;

    public QueueAny() {
        c1 = new Cat("Cat1", new Date(100));
        d1 = new Dog("Dog1", new Date(200));
        c2 = new Cat("Cat2", new Date(400));
        c3 = new Cat("Cat3", new Date(500));
        d2 = new Dog("Dog2", new Date(600));
        d3 = new Dog("Dog3", new Date(800));
        shelter = new AnimalShelter();
    }

    public static void main(String[] args) {
        QueueAny q = new QueueAny();
        Animal animal;

        shelter.enqueue(c1);
        shelter.enqueue(d1);
        shelter.enqueue(c2);
        shelter.enqueue(c3);
        shelter.enqueue(d2);
        shelter.enqueue(d3);

        while (!shelter.isEmpty()) {
            animal = shelter.dequeueAny();
            System.out.println(animal == null ? "NULL" : animal.name);
        }
    }
}
