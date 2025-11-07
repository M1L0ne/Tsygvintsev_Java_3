package ru.tsygvintsev.main;

import ru.tsygvintsev.names.Names;
import ru.tsygvintsev.phones.PhoneBook;
import ru.tsygvintsev.weapons.*;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 2) {
            System.out.println(power(args[0], args[1]));
            return;
        }

        int taskNum = 0;
        int returnBullets = 0;
        String contactName = "";
        String result = "";
        String[] arrResult;
        Scanner sc = new Scanner(System.in);
        int bullets;

        System.out.println("Для выхода введите '-1'");
        do {
            int choice = 0;
            System.out.println("Введите номер задачи (от 1 до 8): ");
            System.out.println("1 - Перезарядка пистолета, 2 - Непустые имена, 3 - Желтые страницы");
            System.out.println("4 - Автомат, 5 - Лучший стрелок, 6 - Сравнение точек");
            try {
                taskNum = sc.nextInt();

                switch (taskNum) {
                    case 1:
                        System.out.println("Введите макс. кол-во патронов:");
                        bullets = sc.nextInt();
                        Gun gun = new Gun(bullets);
                        do {
                            System.out.println("Введите действие: 1 - выстрел, 2 - перезарядка, 3 - разрядка, 4 - узнать кол-во патронов," +
                                    " 5 - узнать макс. кол-во патронов, 6 - узнать если пистолет заряжен, 0 - выйти.");
                            choice = sc.nextInt();
                            switch (choice) {
                                case 1:
                                    gun.shoot();
                                    break;
                                case 2:
                                    System.out.println("Введите число патронов для перезарядки:");
                                    int reloadBullets = sc.nextInt();
                                    returnBullets = gun.load(reloadBullets);
                                    System.out.println("Вам вернулась " + returnBullets + " пуля.");
                                    break;
                                case 3:
                                    returnBullets = gun.unload();
                                    System.out.println("Вам вернулось " + returnBullets + " пуль.");
                                    break;
                                case 4:
                                    bullets = gun.getBullets();
                                    System.out.println("Сейчас в пистолете " + bullets + " патронов.");
                                    break;
                                case 5:
                                    int maxBullets = gun.getMaxBullets();
                                    System.out.println("Максимальное кол-во патронов = " + maxBullets);
                                    break;
                                case 6:
                                    boolean isGunLoaded = gun.isLoaded();
                                    if (isGunLoaded) {
                                        System.out.println("Пистолет заряжен.");
                                    }
                                    else {
                                        System.out.println("Пистолет разряжен.");
                                    }
                                    break;
                                case -1:
                                    System.out.println("В меню...");
                                    break;
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                                    break;
                            }
                        } while (choice != -1);
                        break;
                    case 2:
                        System.out.println("Введите через пробел Имя, Отчество, Фамилию:");
                        sc.nextLine();
                        String[] fullName = sc.nextLine().split(" ");
                        switch (fullName.length) {
                            case 1:
                                Names name1 = new Names(fullName[0]);
                                System.out.println(name1);
                                break;
                            case 2:
                                Names name2 = new Names(fullName[0], fullName[1]);
                                System.out.println(name2);
                                break;
                            case 3:
                                Names name3 = new Names(fullName[0], fullName[1], fullName[2]);
                                System.out.println(name3);
                                break;
                            default:
                                System.out.println("Ошибка: введено больше, чем нужно");
                        }
                        break;
                    case 3:
                        PhoneBook phoneBook = new PhoneBook();

                        do {
                            System.out.println("Введите действие: 1 - добавить новую пару 'телефон - имя', 2 - удалить пару, 3 - получить пару," +
                                    " 4 - вывести все пары, 5 - проверить наличие телефона или имени, 6 - узнать кол-во контактов, 7 - получить ... в виде массива," +
                                    " 8 - получить массив всех имён, 0 - выйти");

                            choice = sc.nextInt();

                            switch (choice) {
                                case 1:
                                    System.out.println("Введите через пробел телефон и имя:");
                                    sc.nextLine();
                                    String[] newContact = sc.nextLine().split(" ");
                                    result = phoneBook.addContact(newContact[0], newContact[1]);
                                    if (result != null) {
                                        System.out.println("Старый телефон: " + result);
                                    }
                                    break;
                                case 2:
                                    System.out.println("Введите имя контакта:");
                                    sc.nextLine();
                                    contactName = sc.nextLine();
                                    phoneBook.removeContact(contactName);
                                    break;
                                case 3:
                                    System.out.println("Введите имя контакта:");
                                    sc.nextLine();
                                    contactName = sc.nextLine();
                                    System.out.println(phoneBook.getContact(contactName));
                                    break;
                                case 4:
                                    System.out.println(phoneBook);
                                    break;
                                case 5:
                                    System.out.println("Введите имя или номер контакта:");
                                    sc.nextLine();
                                    String contactNameOrNumber = sc.nextLine();
                                    System.out.println(phoneBook.checkContact(contactNameOrNumber));
                                    break;
                                case 6:
                                    System.out.println("Всего " + phoneBook.countContact() + " контактов.");
                                    break;
                                case 7:
                                    System.out.println("Введите 1 - все пары, 2 - все телефоны, 3 - все имена:");
                                    int arrayChoice = sc.nextInt();
                                    arrResult = phoneBook.getContactArray(arrayChoice);

                                    if (arrResult.length == 0) {
                                        System.out.println("Список пуст");
                                    } else {
                                        for (String contact : arrResult) {
                                            System.out.println(contact);
                                        }
                                    }
                                    break;
                                case 8:
                                    System.out.println("Укажите часть имени:");
                                    sc.nextLine();
                                    contactName = sc.nextLine();
                                    arrResult = phoneBook.contactSearch(contactName);

                                    if (arrResult.length == 0) {
                                        System.out.println("Список пуст");
                                    } else {
                                        for (String contact : arrResult) {
                                            if (contact != null) {
                                                System.out.println(contact);
                                            }
                                        }
                                    }
                                    break;
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                                    break;
                            }
                        } while (choice != -1);
                        break;
                    case 4:
                        Automate automate;
                        System.out.println("Введите через пробел максимальное число патронов, скорострельность. Можно не вводить ничего или ввести только 1 параметр:");
                        sc.nextLine();

                        int[] automateParams;

                        String input = sc.nextLine().trim();

                        if (input.isEmpty()) {
                            automateParams = new int[0];
                        }
                        else {
                            String[] automateParamsString = input.split(" ");

                            automateParams = new int[automateParamsString.length];

                            try {
                                for (int i = 0; i < automateParamsString.length; i++) {
                                    automateParams[i] = Integer.parseInt(automateParamsString[i]);
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Ошибка: введены не числа!");
                                return;
                            }
                        }

                        switch (automateParams.length) {
                            case 0:
                                automate = new Automate();
                                break;
                            case 1:
                                automate = new Automate(automateParams[0]);
                                break;
                            case 2:
                                automate = new Automate(automateParams[0], automateParams[1]);
                                break;
                            default:
                                System.out.println("Ошибка: введено большее число параметров");
                                return;
                        }

                        do {
                            System.out.println("Выберите действие: 1 - стрелять, 2 - стрелять N секунд, 3 - перезарядить, -1 - выход");
                            choice = sc.nextInt();

                            switch (choice) {
                                case 1:
                                    automate.shoot();
                                    break;
                                case 2:
                                    System.out.println("Введите сколько секунд будет стрелять автомат:");
                                    int seconds = sc.nextInt();
                                    automate.longFire(seconds);
                                    break;
                                case 3:
                                    System.out.println("Введите число патронов для перезарядки:");
                                    int reloadBullets = sc.nextInt();
                                    returnBullets = automate.load(reloadBullets);
                                    System.out.println("Вам вернулась " + returnBullets + " пуля.");
                                    break;
                                case -1:
                                    System.out.println("Выход...");
                                default:
                                    System.out.println("Ошибка: введено число вне диапазона");
                            }
                        } while (choice != -1);
                        break;
                    case 5:
                        Shooter shooter1 = new Shooter("Стрелок 1");
                        Shooter shooter2 = new Shooter("Стрелок 2");
                        Shooter shooter3 = new Shooter("Стрелок 3");

                        Gun shooterGun = new Gun(20);
                        shooterGun.load(20);
                        Automate shooterAutomate = new Automate(30);
                        shooterAutomate.load(10);
                        shooter2.setWeapon(shooterGun);
                        shooter3.setWeapon(shooterAutomate);

                        System.out.println("1 стрелок:");
                        shooter1.shoot();
                        System.out.println("2 стрелок:");
                        shooter2.shoot();
                        System.out.println("3 стрелок:");
                        shooter3.shoot();
                        break;
                    case 6:
                        //Не подходит задача
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

    public static double power(String xString, String yString) {
        int x = parseInt(xString);
        int y = parseInt(yString);
        return pow(x, y);
    }
}