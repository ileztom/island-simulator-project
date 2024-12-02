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

    public abstract void eat(Location location);
    public abstract void reproduce(Location location);
    public abstract void move(Location[][] island, int x, int y);

    protected boolean tryToEat(Animal prey, double probability) {
        Random random = new Random();
        if (random.nextDouble() * 100 < probability) {
            satiety += prey.weight;
            return true;
        }
        return false;
    }
}