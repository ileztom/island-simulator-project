import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IslandSimulation {
    private static final int ISLAND_WIDTH = 100;
    private static final int ISLAND_HEIGHT = 20;
    private static final int TICK_DURATION = 1; // Время одного такта в секундах
    private static final int MAX_ANIMALS_ON_ISLAND = 100; // Максимальное количество животных на острове

    private Location[][] island;
    private ScheduledExecutorService scheduler;
    private Lock islandLock = new ReentrantLock();

    public IslandSimulation() {
        island = new Location[ISLAND_WIDTH][ISLAND_HEIGHT];
        for (int i = 0; i < ISLAND_WIDTH; i++) {
            for (int j = 0; j < ISLAND_HEIGHT; j++) {
                island[i][j] = new Location();
            }
        }

        // Добавляем животных и растения для начала
        island[0][0].addAnimal(new Wolf());
        island[0][0].addAnimal(new Snake());
        island[0][0].addAnimal(new Fox());
        island[0][0].addAnimal(new Bear());
        island[0][0].addAnimal(new Eagle());
        island[0][0].addAnimal(new Horse());
        island[0][0].addAnimal(new Deer());
        island[0][0].addAnimal(new Rabbit());
        island[0][0].addAnimal(new Mouse());
        island[0][0].addAnimal(new Goat());
        island[0][0].addAnimal(new Sheep());
        island[0][0].addAnimal(new Boar());
        island[0][0].addAnimal(new Buffalo());
        island[0][0].addAnimal(new Duck());
        island[0][0].addAnimal(new Caterpillar());
        //
        island[0][0].addAnimal(new Wolf());
        island[0][0].addAnimal(new Snake());
        island[0][0].addAnimal(new Fox());
        island[0][0].addAnimal(new Bear());
        island[0][0].addAnimal(new Eagle());
        island[0][0].addAnimal(new Horse());
        //
        island[0][0].addPlant(new Plant(1, 200));

        scheduler = Executors.newScheduledThreadPool(2);
        scheduler.scheduleAtFixedRate(this::growPlants, 0, TICK_DURATION, TimeUnit.SECONDS);
        scheduler.scheduleAtFixedRate(this::animalLifeCycle, 0, TICK_DURATION, TimeUnit.SECONDS);
    }

    private void growPlants() {
        islandLock.lock();
        try {
            Random random = new Random();
            for (int i = 0; i < ISLAND_WIDTH; i++) {
                for (int j = 0; j < ISLAND_HEIGHT; j++) {
                    Location location = island[i][j];
                    if (location.getPlants().size() < 200 && random.nextDouble() < 0.1) { // Вероятность роста растений
                        location.addPlant(new Plant(1, 200));
                        System.out.println("Трава размножается на (" + i + ", " + j + ")");
                    }
                }
            }
        } finally {
            islandLock.unlock();
        }
    }

    private void animalLifeCycle() {
        islandLock.lock();
        try {
            int totalAnimals = 0;
            for (int i = 0; i < ISLAND_WIDTH; i++) {
                for (int j = 0; j < ISLAND_HEIGHT; j++) {
                    totalAnimals += island[i][j].getAnimals().size();
                }
            }

            if (totalAnimals >= MAX_ANIMALS_ON_ISLAND) {
                System.out.println("Достигнуто максимальное количество животных на острове. Остановка симуляции.");
                scheduler.shutdown();
                return;
            }

            for (int i = 0; i < ISLAND_WIDTH; i++) {
                for (int j = 0; j < ISLAND_HEIGHT; j++) {
                    Location location = island[i][j];
                    for (Animal animal : location.getAnimals()) {
                        animal.eat(location);
                        animal.move(island, i, j);
                        animal.reproduce(location);
                    }
                }
            }
            printStatistics();
        } finally {
            islandLock.unlock();
        }
    }

    private void printStatistics() {
        int totalAnimals = 0;
        int totalPlants = 0;

        islandLock.lock();
        try {
            for (int i = 0; i < ISLAND_WIDTH; i++) {
                for (int j = 0; j < ISLAND_HEIGHT; j++) {
                    totalAnimals += island[i][j].getAnimals().size();
                    totalPlants += island[i][j].getPlants().size();
                }
            }
        } finally {
            islandLock.unlock();
        }

        System.out.println("Total Animals: " + totalAnimals);
        System.out.println("Total Plants: " + totalPlants);
    }

    public static void main(String[] args) {
        new IslandSimulation();
    }
}