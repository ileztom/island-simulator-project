import java.util.Random;

class Rabbit extends Animal {
    public Rabbit() {
        super(2, 150, 2, 0.45);
    }

    @Override
    public void eat(Location location) {
        // Логика питания
    }

    @Override
    public void reproduce(Location location) {
        if (location.getAnimals().size() < maxOnCell && location.getAnimals().stream().filter(a -> a instanceof Rabbit).count() >= 2) {
            location.addAnimal(new Rabbit());
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