import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NoReproductionTest {

    @Test
    public void testNoReproduction() {
        Location location = new Location();
        Animal parent1 = new Rabbit();

        location.addAnimal(parent1);

        parent1.reproduce(location);

        assertEquals(1, location.getAnimals().size(), "Reproduction should not occur with only one animal");
    }
}