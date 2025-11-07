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
    
        public boolean isLoaded() {
            return ammo > 0;
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
Желтые страницы.
Необходимо разработать сущность ТелефонныйСправочник, который будет использоваться для
создания справочника со списком телефонов и имен, с целью поиска телефона по имени. Будем
считать достаточным хранение пар телефон-строка, например “89003337788 - Вася”.
Состояние сущности описывается набором пар “телефон – имя”, причем и телефон и имя являются
строками. В целях упрощения задачи будем считать, что одному имени всегда соответствует один
телефон, и один телефон соответствует одному имени.
Инициализация сущности выполняется без аргументов.
Поведение сущности описывают следующие действия:
• Добавление новой пары “телефон – имя” (как два отдельных аргумента). Конкретное
местоположение добавленной пары не важно. Если добавляемое имя уже есть в списке, то
имеющийся телефон заменяется на новый, и затем старый телефон возвращается из
метода.
• Удаление значения. Для удаления необходимо указать имя удаляемого контакта, после
чего удаляется вся пара.
• Получение значений. Для получения необходимо указать имя контакта, тогда
возвращается его телефон.
• Может быть приведен к строке. Строка должна представлять собой полный перечень всех
хранимых пар.
• Можно проверить есть ли конкретный телефон или конкретное имя в списке.
• Можно узнать текущее количество контактов.
• Можно запросить в виде массива:
o Все пары
o Все телефоны
o Все имена
• Можно получить массив всех имен, указав часть названия (начиная с первого символа).
Продемонстрируйте работоспособность решения на примерах.
### Алгоритм решения
    package ru.tsygvintsev.phones;
    
    import java.util.HashMap;
    import java.util.Map;
    
    public class PhoneBook {
    private Map<String, String> contacts;
    
        public PhoneBook() {
            this.contacts = new HashMap<>();
        }
    
        public String addContact(String phoneNumber, String name) {
            String previousNumber = null;
    
            for (Map.Entry<String, String> entry: contacts.entrySet()) {
                if (entry.getValue().equals(name)) {
                    previousNumber = entry.getKey();
                    contacts.remove(previousNumber);
                }
            }
    
            contacts.put(phoneNumber, name);
    
            return previousNumber;
        }
    
        public void removeContact(String name) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                if (entry.getValue().equals(name)) {
                    contacts.remove(entry.getKey());
                }
            }
        }
    
        public String getContact(String name) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                if (entry.getValue().equals(name)) {
                    return entry.getKey() + " - " + entry.getValue();
                }
            }
    
            return "Не найдено";
        }
    
        public String checkContact(String text) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                if (entry.getValue().equals(text) || entry.getKey().equals(text)) {
                    return entry.getKey() + " - " + entry.getValue();
                }
            }
    
            return "Не существует";
        }
    
        public int countContact() {
            int count = 0;
    
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                count++;
            }
    
            return count;
        }
    
        public String[] getContactArray(int choice) {
            String[] contactsArray = new String[contacts.size()];
            int i = 0;
    
            switch (choice) {
                case 1:
                    for (Map.Entry<String, String> entry : contacts.entrySet()) {
                        contactsArray[i] = entry.getKey() + " - " + entry.getValue();
                        i++;
                    }
                    break;
                case 2:
                    for (Map.Entry<String, String> entry : contacts.entrySet()) {
                        contactsArray[i] = entry.getKey();
                        i++;
                    }
                    break;
                case 3:
                    for (Map.Entry<String, String> entry : contacts.entrySet()) {
                        contactsArray[i] = entry.getValue();
                        i++;
                    }
                    break;
                default:
                    return contactsArray;
            }
            return contactsArray;
        }
    
        public String[] contactSearch(String namePart) {
            String[] foundContacts = new String[contacts.size()];
            int i = 0;
            String name;
    
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                name = entry.getValue();
                if (name.startsWith(namePart)) {
                    foundContacts[i] = entry.getValue();
                    i++;
                }
            }
    
            return foundContacts;
        }
    
        @Override
        public String toString() {
            String result = "";
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                result = result + entry.getKey() + " - " + entry.getValue() + "; ";
            }
            return result;
        }
    
    }


# Задание 3
## Задача 4
### Текст задачи
Автомат. Создайте такой подвид сущности Пистолет из задачи 2.1.5, которая будет совпадать с
ней во всех отношениях, кроме следующего:
• Имеет скорострельность (целое число, неизменяемое) которое обозначает количество
выстрелов в секунду, поддерживаемое данным автоматом. Скорострельность всегда
положительное число.
• При вызове Стрелять количество выстрелов соответствует скорострельности (например,
при скорострельности 3 выводится три строки с текстом выстрела).
• Умеет Стрелять N секунд, что приводит к количеству выстрелов равному N умноженное
на скорострельность.
• Инициализация может быть выполнены следующими способами:
a) Без параметров. Скорострельность 30, вместимость 30.
b) С указанием максимального числа патронов. Скорострельность будет равна
половине обоймы
c) С указанием максимального количества патронов в обойме и скорострельности.
### Алгоритм решения
    package ru.tsygvintsev.weapons;
    
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
        public void fire() {
            for (int i = 0; i < speed; i++) {
                super.fire();
            }
        }
    
        public void longFire(int time) {
            for (int i = 0; i < (time * speed); i++) {
                super.fire();
            }
        }
    }

# Задание 4
## Задача 1
### Текст задачи
Оружие.
Измените сущность Пистолет, полученную в задаче 2.1.5 таким образом, чтобы она наследовалась
от класса Weapon описанного на рисунке:
abstract class Weapon {
private int ammo;
public Weapon(int ammo) {
    if(ammo<0) throw new RuntimeException();
    this.ammo = ammo;
}
abstract void shoot();
public int ammo() {return ammo;}
public boolean getAmmo() {
    if(ammo==0) return false;
    ammo--;
    return true;
}

public int load(int ammo) {
    if(ammo<0) throw new RuntimeException();
    int tmp=ammo;
    this.ammo=ammo;
    return tmp;
}
### Алгоритм решения
    package ru.tsygvintsev.weapons;
    
    public class Gun extends Weapon{
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
    
        public int getBullets() {
            return ammo;
        }
    
        public boolean isLoaded() {
            return ammo > 0;
        }
    
        @Override
        public String toString() {
            return ("Пистолет с максимумом " + maxBullets + " патронов, заряженный на " + ammo() + " пуль.");
        }
    }

# Задание 5
## Задача 8
### Текст задачи
Лучший стрелок.
Создайте сущность Стрелок, которая описывается:
• Имя, строка
• Оружие, из задачи 2.4.1.
• При создании объекта необходимо указать ему имя
• Имя и оружие можно поменять и получить в любой момент без ограничения.
Основная способность Стрелка - умение стрелять. Если оружие есть, то выстрел происходит по
правилам оружия, если его нет – то выводится текст “не могу участвовать в перестрелке”.
Создайте трех стрелков: одного без оружия, одного с пистолетом и одного с автоматом, и пусть
каждый из них выстрелит.
### Алгоритм решения
    package ru.tsygvintsev.weapons;
    
    public class Shooter {
    private String name;
    private Weapon weapon;
    
        public Shooter(String name) {
            this.name = name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public void setWeapon(Weapon weapon) {
            this.weapon = weapon;
        }
    
        public void shoot() {
            if (this.weapon != null) {
                weapon.shoot();
            } else {
                System.out.println("не могу участвовать в перестрелке");
            }
        }
    }

# Задание 7
## Задача 1
### Текст задачи
Навести порядок.
Данная задача предполагает реорганизацию ранее написанных классов. Расположите все ранее
написанные классы по пакетам таким образом, чтобы логически близкие классы оказались
сгруппированы друг с другом. Имена пакетов должны иметь как минимум трехсоставную форму,
вида: ru.surname.type. Вместо surname следует подставить свою фамилию, а вместо type
подставить название логического блока. Например, классы описывающие точку, линию, ломаную
линию, фигуру, квадрат, треугольник, круг и прямоугольник можно расположить в пакете
ru.surname.geometry.

## Задача 2
### Текст задачи
Главный метод.
Создайте пакет ru.surname.main (вместо surname необходимо подставить собственную
фамилию) в котором расположить класс с точкой входа в исполнение программы (public static void
main). Также следует проверить, что ни в одном другом пакете нет классов имеющих точку входа
в исполнение программы. В этом же пакете необходимо расположить класс (или интерфейс) с
методами из задач блока 2.5 и продемонстрировать их работоспособность.

## Задача 3
### Текст задачи
Возведение в степень.
Создайте метод принимающий две строки, в которых будут записаны числа X и Y. Возвращает
метод результат возведения X в степень Y. Для преобразования строки в число следует
использовать метод Integer.parseInt, а для возведения в степень метод Math.pow. Вызовите
разработанный метод передав туда параметры командной строки полученные точкой входа в
программу. Реализуйте метод так, что бы для возведения в степень и преобразования строки
использовались короткие имена статических методов
### Алгоритм решения
    public static double power(String xString, String yString) {
        int x = parseInt(xString);
        int y = parseInt(yString);
        return pow(x, y);
    }

# Задание 8
## Задача 2
### Текст задачи
Патроны наследникам.
Измените класс Weapon из задачи 2.4.1 таким образом, что бы любой класс наследник мог
непосредственно работать сполем хранящим количество патронов заряженном в оружии.
Обратите внимание, что метод разрядки Пистолет, усложнившийся при решении задачи
2.4.1снова можно упростить
### Алгоритм решения
    package ru.tsygvintsev.weapons;
    
    abstract class Weapon {
    protected int ammo;
    
        public Weapon(int ammo) {
            if(ammo<0) throw new RuntimeException();
            this.ammo = ammo;
        }
        public abstract void shoot();
        public int ammo() {return ammo;}
        public boolean getAmmo() {
            if(ammo==0) return false;
            ammo--;
            return true;
        }
    
        public int load(int ammo) {
            if(ammo<0) throw new RuntimeException();
            int tmp=ammo;
            this.ammo=ammo;
            return tmp;
        }
    }