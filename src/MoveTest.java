import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MoveTest {

    @Test
    public void testAnimalMove() {
        int islandWidth = 10;
        int islandHeight = 10;
        Location[][] island = new Location[islandWidth][islandHeight];

        // Инициализация острова
        for (int i = 0; i < islandWidth; i++) {
            for (int j = 0; j < islandHeight; j++) {
                island[i][j] = new Location();
            }
        }

        // Добавляем животное на начальную локацию
        int startX = 5;
        int startY = 5;
        Animal animal = new Rabbit();
        island[startX][startY].addAnimal(animal);

        // Перемещаем животное
        animal.move(island, startX, startY);

        // Проверяем, что животное больше не на начальной локации
        assertFalse(island[startX][startY].getAnimals().contains(animal), "Animal should not be on the start location after move");

        // Проверяем, что животное находится на новой локации
        boolean found = false;
        for (int i = 0; i < islandWidth; i++) {
            for (int j = 0; j < islandHeight; j++) {
                if (island[i][j].getAnimals().contains(animal)) {
                    found = true;
                    break;
                }
            }
        }
        assertTrue(found, "Animal should be found on a new location after move");
    }
}