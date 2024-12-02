import java.util.Random;

abstract class Animal {
    protected int weight;
    protected int maxOnCell;
    protected int speed;
    protected double foodNeeded;
    protected double satiety;

    public Animal(int weight, int maxOnCell, int speed, double foodNeeded) {
        this.weight = weight;
        this.maxOnCell = maxOnCell;
        this.speed = speed;
        this.foodNeeded = foodNeeded;
        this.satiety = foodNeeded / 2; // Начальное состояние сытости
    }

    public void eat(Location location) {
        if (this instanceof Herbivore) {
            if (!location.getPlants().isEmpty()) {
                location.removePlant(location.getPlants().get(0));
                System.out.println(this.getClass().getSimpleName() + " ест траву");
            }
        } else if (this instanceof Predator) {
            for (Animal animal : location.getAnimals()) {
                if (animal != this && tryToEat(animal, getEatProbability(animal))) {
                    location.removeAnimal(animal);
                    System.out.println(this.getClass().getSimpleName() + " ест " + animal.getClass().getSimpleName());
                    break;
                }
            }
        }
    }

    public void reproduce(Location location) {
        if (location.getAnimals().size() < maxOnCell && location.getAnimals().stream().filter(a -> a.getClass() == this.getClass()).count() >= 2) {
            try {
                Animal newAnimal = this.getClass().getConstructor().newInstance();
                location.addAnimal(newAnimal);
                System.out.println(this.getClass().getSimpleName() + " размножается");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void move(Location[][] island, int x, int y);

    protected boolean tryToEat(Animal prey, double probability) {
        Random random = new Random();
        if (random.nextDouble() * 100 < probability) {
            satiety += prey.weight;
            return true;
        }
        return false;
    }

    protected double getEatProbability(Animal prey) {
        // Здесь можно добавить логику для вычисления вероятности еды в зависимости от типа животного
        return 50; // По умолчанию 50%
    }
}

abstract class Herbivore extends Animal {
    public Herbivore(int weight, int maxOnCell, int speed, double foodNeeded) {
        super(weight, maxOnCell, speed, foodNeeded);
    }
}

abstract class Predator extends Animal {
    public Predator(int weight, int maxOnCell, int speed, double foodNeeded) {
        super(weight, maxOnCell, speed, foodNeeded);
    }
}