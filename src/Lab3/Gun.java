package Lab3;

public class Gun extends Weapon{
    private final int maxBullets;

    @Override
    public void shoot() {
        if (getAmmo()) {
            System.out.println("Бах!");
        } else {
            System.out.println("Клац!");
        }
    }

    public Gun() {
        super(0);
        this.maxBullets = 30;
    }

    public Gun(int maxBullets) {
        super(0);
        this.maxBullets = maxBullets;
    }

    public void getMaxBullets () {
        System.out.println("Максимальное кол-во патронов = " + maxBullets);
    }

    @Override
    public int load(int ammo) {
        if (ammo < 0) {
            System.out.println("Не может быть отрицательного числа патронов.");
            return 0;
        }

        if (ammo > maxBullets) {
            super.load(maxBullets);
            return ammo - maxBullets;
        }

        super.load(ammo);

        return 0;
    }

    public int unload () {
        int returnBullets = ammo();
        load(0);
        return returnBullets;
    }

    public void getBullets () {
        System.out.println("Сейчас в пистолете " + ammo() + " патронов.");
    }

    public void isLoaded () {
        if (ammo() > 0) {
            System.out.println("Пистолет заряжен.");
        }
        else {
            System.out.println("Пистолет разряжен.");
        }
    }

    @Override
    public String toString() {
        return ("Пистолет с максимумом " + maxBullets + " патронов, заряженный на " + ammo() + " пуль.");
    }
}
