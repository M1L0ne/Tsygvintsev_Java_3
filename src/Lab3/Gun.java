package Lab3;

public class Gun {
    private final int maxBullets;
    protected int bullets;

    public Gun() {
        this.maxBullets = 30;
    }

    public Gun(int maxBullets) {
        this.maxBullets = maxBullets;
    }

    public void getMaxBullets () {
        System.out.println("Максимальное кол-во патронов = " + maxBullets);
    }

    public int reload (int bullets) {
        if (bullets < 0) {
            System.out.println("Не может быть отрицательного числа патронов.");
            return 0;
        }

        if (bullets > maxBullets) {
            this.bullets = maxBullets;
            return bullets - maxBullets;
        }

        this.bullets = bullets;

        return 0;
    }

    public int unload () {
        int returnBullets = this.bullets;
        this.bullets = 0;
        return returnBullets;
    }

    public void getBullets () {
        System.out.println("Сейчас в пистолете " + this.bullets + " патронов.");
    }

    public void isLoaded () {
        if (bullets > 0) {
            System.out.println("Пистолет заряжен.");
        }
        else {
            System.out.println("Пистолет разряжен.");
        }
    }

    public void fire() {
        if (bullets > 0) {
            bullets--;
            System.out.println("Бах!");
        }
        else {
            System.out.println("Клац!");
        }
    }

    @Override
    public String toString() {
        return ("Пистолет с максимумом " + maxBullets + " патронов, заряженный на " + bullets + " пуль.");
    }
}
