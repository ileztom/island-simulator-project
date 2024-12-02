import java.util.Random;

class Wolf extends Animal {
    public Wolf() {
        super(50, 30, 3, 8);
    }

    @Override
    public void eat(Location location) {
        for (Animal animal : location.getAnimals()) {
            if (animal instanceof Rabbit && tryToEat(animal, 60)) {
                location.removeAnimal(animal);
                break;
            }
        }
    }

    @Override
    public void reproduce(Location location) {
        if (location.getAnimals().size() < maxOnCell && location.getAnimals().stream().filter(a -> a instanceof Wolf).count() >= 2) {
            location.addAnimal(new Wolf());
        }
    }

    @Override
    public void move(Location[][] island, int x, int y) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;
        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length) {
            island[newX][newY].addAnimal(this);
            island[x][y].removeAnimal(this);
        }
    }
}