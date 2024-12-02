import java.util.Random;

class Wolf extends Predator {
    public Wolf() {
        super(50, 30, 3, 8);
    }

    @Override
    public void move(Location[][] island, int x, int y) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;
        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length) {
            island[newX][newY].addAnimal(this);
            island[x][y].removeAnimal(this);
            System.out.println("Волк перемещается на (" + newX + ", " + newY + ")");
        }
    }
}

class Snake extends Predator {
    public Snake() {
        super(15, 30, 1, 3);
    }

    @Override
    public void move(Location[][] island, int x, int y) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;
        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length) {
            island[newX][newY].addAnimal(this);
            island[x][y].removeAnimal(this);
            System.out.println("Удав перемещается на (" + newX + ", " + newY + ")");
        }
    }
}

class Fox extends Predator {
    public Fox() {
        super(8, 30, 2, 2);
    }

    @Override
    public void move(Location[][] island, int x, int y) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;
        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length) {
            island[newX][newY].addAnimal(this);
            island[x][y].removeAnimal(this);
            System.out.println("Лиса перемещается на (" + newX + ", " + newY + ")");
        }
    }
}

class Bear extends Predator {
    public Bear() {
        super(500, 5, 2, 80);
    }

    @Override
    public void move(Location[][] island, int x, int y) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;
        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length) {
            island[newX][newY].addAnimal(this);
            island[x][y].removeAnimal(this);
            System.out.println("Медведь перемещается на (" + newX + ", " + newY + ")");
        }
    }
}

class Eagle extends Predator {
    public Eagle() {
        super(6, 20, 3, 1);
    }

    @Override
    public void move(Location[][] island, int x, int y) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;
        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length) {
            island[newX][newY].addAnimal(this);
            island[x][y].removeAnimal(this);
            System.out.println("Орел перемещается на (" + newX + ", " + newY + ")");
        }
    }
}

class Horse extends Herbivore {
    public Horse() {
        super(400, 20, 4, 60);
    }

    @Override
    public void move(Location[][] island, int x, int y) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;
        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length) {
            island[newX][newY].addAnimal(this);
            island[x][y].removeAnimal(this);
            System.out.println("Лошадь перемещается на (" + newX + ", " + newY + ")");
        }
    }
}

class Deer extends Herbivore {
    public Deer() {
        super(300, 20, 4, 50);
    }

    @Override
    public void move(Location[][] island, int x, int y) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;
        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length) {
            island[newX][newY].addAnimal(this);
            island[x][y].removeAnimal(this);
            System.out.println("Олень перемещается на (" + newX + ", " + newY + ")");
        }
    }
}

class Rabbit extends Herbivore {
    public Rabbit() {
        super(2, 150, 2, 0.45);
    }

    @Override
    public void move(Location[][] island, int x, int y) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;
        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length) {
            island[newX][newY].addAnimal(this);
            island[x][y].removeAnimal(this);
            System.out.println("Заяц перемещается на (" + newX + ", " + newY + ")");
        }
    }
}

class Mouse extends Herbivore {
    public Mouse() {
        super((int) 0.05, 500, 1, 0.01);
    }

    @Override
    public void move(Location[][] island, int x, int y) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;
        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length) {
            island[newX][newY].addAnimal(this);
            island[x][y].removeAnimal(this);
            System.out.println("Мышь перемещается на (" + newX + ", " + newY + ")");
        }
    }
}

class Goat extends Herbivore {
    public Goat() {
        super(60, 140, 3, 10);
    }

    @Override
    public void move(Location[][] island, int x, int y) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;
        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length) {
            island[newX][newY].addAnimal(this);
            island[x][y].removeAnimal(this);
            System.out.println("Коза перемещается на (" + newX + ", " + newY + ")");
        }
    }
}

class Sheep extends Herbivore {
    public Sheep() {
        super(70, 140, 3, 15);
    }

    @Override
    public void move(Location[][] island, int x, int y) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;
        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length) {
            island[newX][newY].addAnimal(this);
            island[x][y].removeAnimal(this);
            System.out.println("Овца перемещается на (" + newX + ", " + newY + ")");
        }
    }
}

class Boar extends Herbivore {
    public Boar() {
        super(400, 50, 2, 50);
    }

    @Override
    public void move(Location[][] island, int x, int y) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;
        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length) {
            island[newX][newY].addAnimal(this);
            island[x][y].removeAnimal(this);
            System.out.println("Кабан перемещается на (" + newX + ", " + newY + ")");
        }
    }
}

class Buffalo extends Herbivore {
    public Buffalo() {
        super(700, 10, 3, 100);
    }

    @Override
    public void move(Location[][] island, int x, int y) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;
        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length) {
            island[newX][newY].addAnimal(this);
            island[x][y].removeAnimal(this);
            System.out.println("Буйвол перемещается на (" + newX + ", " + newY + ")");
        }
    }
}

class Duck extends Herbivore {
    public Duck() {
        super(1, 200, 4, 0.15);
    }

    @Override
    public void move(Location[][] island, int x, int y) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;
        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length) {
            island[newX][newY].addAnimal(this);
            island[x][y].removeAnimal(this);
            System.out.println("Утка перемещается на (" + newX + ", " + newY + ")");
        }
    }
}

class Caterpillar extends Herbivore {
    public Caterpillar() {
        super((int)0.01, 1000, 0, 0);
    }

    @Override
    public void move(Location[][] island, int x, int y) {
        Random random = new Random();
        int newX = x + random.nextInt(3) - 1;
        int newY = y + random.nextInt(3) - 1;
        if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length) {
            island[newX][newY].addAnimal(this);
            island[x][y].removeAnimal(this);
            System.out.println("Гусеница перемещается на (" + newX + ", " + newY + ")");
        }
    }
}