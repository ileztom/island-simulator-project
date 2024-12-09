import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReproductionTest {

    @Test
    public void testReproduction() {
        Location location = new Location();
        Animal parent1 = new Rabbit();
        Animal parent2 = new Rabbit();

        location.addAnimal(parent1);
        location.addAnimal(parent2);

        parent1.reproduce(location);

        assertEquals(3, location.getAnimals().size(), "Reproduction should add a new animal to the location");
    }
}