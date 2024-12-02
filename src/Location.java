import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Location {
    private List<Animal> animals;
    private List<Plant> plants;
    private Lock lock = new ReentrantLock();

    public Location() {
        this.animals = new ArrayList<>();
        this.plants = new ArrayList<>();
    }

    public List<Animal> getAnimals() {
        lock.lock();
        try {
            return new ArrayList<>(animals);
        } finally {
            lock.unlock();
        }
    }

    public List<Plant> getPlants() {
        lock.lock();
        try {
            return new ArrayList<>(plants);
        } finally {
            lock.unlock();
        }
    }

    public void addAnimal(Animal animal) {
        lock.lock();
        try {
            animals.add(animal);
        } finally {
            lock.unlock();
        }
    }

    public void removeAnimal(Animal animal) {
        lock.lock();
        try {
            animals.remove(animal);
        } finally {
            lock.unlock();
        }
    }

    public void addPlant(Plant plant) {
        lock.lock();
        try {
            plants.add(plant);
        } finally {
            lock.unlock();
        }
    }

    public void removePlant(Plant plant) {
        lock.lock();
        try {
            plants.remove(plant);
        } finally {
            lock.unlock();
        }
    }
}