# Цыгвинцев Олег Сергеевич Лабораторная №2

# Задание 1
## Задача 5
### Текст задачи
Перезарядка Пистолета.
Измените сущность Пистолет из задачи 1.5.1. Модификация предполагает внесение следующих
дополнительных требований:
• Имеет максимальное количество патронов. Максимальное количество устанавливается во
время создания пистолета и не может быть изменено позднее. У пистолета можно узнать,
какое максимальное количество он вмещает.
• Может быть перезаряжен. Для перезарядки необходимо передать пистолету число,
которое будет означать количество заряжаемых патронов. Если передано отрицательное
число, необходимо выбросить ошибку, объясняющую, что отрицательного числа
патронов быть не может. Если передано слишком большое число патронов – необходимо
лишние вернуть.
• Может быть разряжен. Это приводит к обнулению патронов в пистолете и возврате
нужного числа пользователю.
• Можно узнать сколько сейчас заряжено патронов.
• Можно узнать заряжен он или разряжен.
Создайте пистолет вместимостью 7, зарядите три патрона, выстрелите из него пять раз, затем
зарядите в него 8 патронов, выстрелите еще 2 раза, разрядите его, сделайте контрольный
выстрел.
Если все выполнено верно, то должно быть выведено: Бах! Бах! Бах! Клац! Клац! Бах! Бах! Клац!
### Алгоритм решения
    package ru.tsygvintsev.weapons;
    
    public class Gun {
    private final int maxBullets;
    private int bullets;
    
        public Gun(int maxBullets) {
            this.maxBullets = maxBullets;
        }
    
        public int getMaxBullets() {
            return maxBullets;
        }
    
        public int reload(int bullets) {
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
    
        public int unload() {
            int returnBullets = this.bullets;
            this.bullets = 0;
            return returnBullets;
        }
    
        public int getBullets() {
            return ammo;
        }
    
        public void isLoaded() {
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
            } else {
                System.out.println("Клац!");
            }
        }
    
        @Override
        public String toString() {
            return ("Пистолет с максимумом " + maxBullets + " патронов, заряженный на " + bullets + " пуль.");
        }
    }
## Задача 7
### Текст задачи
Непустые Имена.
Измените сущность Имя из задачи 1.4.5. Гарантируйте, что:
• Как минимум один параметр будет иметь не null значение и не пустую строку.
• Имя неизменяемо.
Продемонстрируйте работоспособность решения на примерах.
### Алгоритм решения
    package ru.tsygvintsev.names;
    
    public final class Names {
    private final String lastName;
    private final String firstName;
    private final String patronymic;
    
        public Names(String firstName) {
            if (firstName == null || firstName.trim().isEmpty()) {
                throw new IllegalArgumentException("Имя не может быть пустым");
            }
            this.firstName = firstName;
            this.lastName = null;
            this.patronymic = null;
        }
    
        public Names(String firstName, String lastName) {
            if ((firstName == null || firstName.trim().isEmpty()) &&
                    (lastName == null || lastName.trim().isEmpty())) {
                throw new IllegalArgumentException("Хотя бы один параметр должен быть заполнен");
            }
            this.firstName = firstName;
            this.lastName = lastName;
            this.patronymic = null;
        }
    
        public Names(String firstName, String lastName, String patronymic) {
            if ((firstName == null || firstName.trim().isEmpty()) &&
                    (lastName == null || lastName.trim().isEmpty()) &&
                    (patronymic == null || patronymic.trim().isEmpty())) {
                throw new IllegalArgumentException("Хотя бы один параметр должен быть заполнен");
            }
            this.firstName = firstName;
            this.lastName = lastName;
            this.patronymic = patronymic;
        }
    
        @Override
        public String toString() {
            String result = firstName;
            if (lastName != null && !lastName.isEmpty()) {
                result += " " + lastName;
            }
            if (patronymic != null && !patronymic.isEmpty()) {
                result += " " + patronymic;
            }
            return result;
        }
    }

# Задание 2
## Задача 3
### Текст задачи
### Алгоритм решения

# Задание 3
## Задача 4
### Текст задачи
### Алгоритм решения

# Задание 4
## Задача 1
### Текст задачи
### Алгоритм решения

# Задание 5
## Задача 8
### Текст задачи
### Алгоритм решения

# Задание 6
## Задача 2
### Текст задачи
### Алгоритм решения

# Задание 7
## Задача 1
### Текст задачи
### Алгоритм решения

# Задание 8
## Задача 2
### Текст задачи
### Алгоритм решения