package Lab3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int taskNum = 0;
        int returnBullets = 0;
        int action = 0;
        System.out.println("Для выхода введите '-1'");
        do {
            System.out.println("Введите номер задачи (от 1 до 8): ");
            Scanner sc = new Scanner(System.in);
            try {
                taskNum = sc.nextInt();

                switch (taskNum) {
                    case 1:
                        System.out.println("Введите макс. кол-во патронов:");
                        int bullets = sc.nextInt();
                        Gun gun = new Gun(bullets);
                        System.out.println("1 - выстрел, 2 - перезарядка, 3 - разрядка, 4 - узнать кол-во патронов," +
                                " 5 - узнать макс. кол-во патронов, 6 - узнать если пистолет заряжен, 0 - выйти.");
                        do {
                            action = sc.nextInt();
                            switch (action) {
                                case 1:
                                    gun.fire();
                                    break;
                                case 2:
                                    System.out.println("Введите число патронов для перезарядки:");
                                    int reloadBullets = sc.nextInt();
                                    returnBullets = gun.reload(reloadBullets);
                                    System.out.println("Вам вернулась " + returnBullets + " пуля.");
                                    break;
                                case 3:
                                    returnBullets = gun.unload();
                                    System.out.println("Вам вернулось " + returnBullets + " пуль.");
                                    break;
                                case 4:
                                    gun.getBullets();
                                    break;
                                case 5:
                                    gun.getMaxBullets();
                                    break;
                                case 6:
                                    gun.isLoaded();
                                    break;
                                case -1:
                                    System.out.println("В меню...");
                                    break;
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                            }
                        } while (action != -1);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case -1:
                        System.out.println("Выход...");
                        break;
                    default:
                        System.out.println("Ошибка: введено число вне диапазона");

                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введено не число");
            }
        } while (taskNum != -1);
    }
}