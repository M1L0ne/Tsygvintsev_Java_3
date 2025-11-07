package Lab3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int taskNum = 0;
        int returnBullets = 0;
        String contactName = "";
        String result = "";
        String[] arrResult;

        System.out.println("Для выхода введите '-1'");
        do {
            int choice = 0;
            System.out.println("Введите номер задачи (от 1 до 8): ");
            Scanner sc = new Scanner(System.in);
            try {
                taskNum = sc.nextInt();

                switch (taskNum) {
                    case 1:
                        System.out.println("Введите макс. кол-во патронов:");
                        int bullets = sc.nextInt();
                        Gun gun = new Gun(bullets);
                        do {
                            System.out.println("1 - выстрел, 2 - перезарядка, 3 - разрядка, 4 - узнать кол-во патронов," +
                                    " 5 - узнать макс. кол-во патронов, 6 - узнать если пистолет заряжен, 0 - выйти.");
                            choice = sc.nextInt();
                            switch (choice) {
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
                            System.out.println("Выберите действие: 1 - добавить новую пару 'телефон - имя', 2 - удалить пару, 3 - получить пару," +
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