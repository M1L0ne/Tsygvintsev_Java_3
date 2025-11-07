package Lab3;

public class Automate extends Gun{
    private final int speed;

    public Automate() {
        this.speed = 30;
    }

    public Automate(int maxBullets) {
        super(maxBullets);
        this.speed = maxBullets / 2;
    }

    public Automate(int maxBullets, int speed) {
        super(maxBullets);
        this.speed = speed;
    }

    @Override
    public void shoot() {
        for (int i = 0; i < speed; i++) {
            super.shoot();
        }
    }

    public void longFire(int time) {
        for (int i = 0; i < (time*speed); i++) {
            super.shoot();
        }
    }
}
