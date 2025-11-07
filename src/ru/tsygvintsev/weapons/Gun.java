package ru.tsygvintsev.weapons;

public class Gun extends Weapon {
    private final int maxBullets;

    public Gun() {
        super(0);
        this.maxBullets = 30;
    }

    public Gun(int maxBullets) {
        super(0);
        this.maxBullets = maxBullets;
    }

    public int getMaxBullets () {
        return maxBullets;
    }

    @Override
    public void shoot() {
        if (getAmmo()) {
            System.out.println("Бах!");
        } else {
            System.out.println("Клац!");
        }
    }

    @Override
    public int load(int bullets) {
        if (bullets < 0) {
            System.out.println("Не может быть отрицательного числа патронов.");
            return 0;
        }

        if (bullets > maxBullets) {
            ammo = maxBullets;
            return bullets - maxBullets;
        }

        ammo = bullets;

        return 0;
    }

    public int unload() {
        int returnBullets = ammo;
        ammo = 0;
        return returnBullets;
    }

    public int getBullets() {
        return ammo;
    }

    public boolean isLoaded() {
        return ammo > 0;
    }

    @Override
    public String toString() {
        return ("Пистолет с максимумом " + maxBullets + " патронов, заряженный на " + ammo + " пуль.");
    }
}
