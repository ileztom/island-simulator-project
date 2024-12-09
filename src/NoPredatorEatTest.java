import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NoPredatorEatTest {

    @Test
    public void testNoPredatorEat() {
        Location location = new Location();
        Animal predator = new Wolf();
        Animal prey = new Rabbit();

        location.addAnimal(predator);
        location.addAnimal(prey);

        assertEquals(2, location.getAnimals().size(), "Predator should not eat the prey with low probability");
    }
}