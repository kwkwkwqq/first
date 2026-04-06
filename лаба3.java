class EVM {
    protected String name;
    protected int year;
    
    public EVM(String name, int year) {
        this.name = name;
        this.year = year;
    }
        public void info() {
        System.out.println("ЭВМ: " + name + ", год: " + year);
    }
    
    public void turnOn() {
        System.out.println(name + " включается");
    }
}

class Mobilny extends EVM {
    protected double weight;
    
    public Mobilny(String name, int year, double weight) {
        super(name, year);
        this.weight = weight;
    }
    
    @Override
    public void info() {
        System.out.println("Мобильный: " + name + ", год: " + year + ", вес: " + weight + " кг");
    }
    
    @Override
    public void turnOn() {
        System.out.println(name + " (мобильный) включается от батареи");
    }
    
    public void charge() {
        System.out.println("Зарядка " + name);
    }
}

class Stacionarny extends EVM {
    protected int power;
    
    public Stacionarny(String name, int year, int power) {
        super(name, year);
        this.power = power;
    }
    
    @Override
    public void info() {
        System.out.println("Стационарный: " + name + ", год: " + year + ", мощность: " + power + " Вт");
    }
    
    @Override
    public void turnOn() {
        System.out.println(name + " (стационарный) включается от розетки");
    }
    
    public void upgrade() {
        System.out.println("Апгрейд " + name);
    }
}

class Planchet extends Mobilny {
    private boolean hasStylus;
    
    public Planchet(String name, int year, double weight, boolean hasStylus) {
        super(name, year, weight);
        this.hasStylus = hasStylus;
    }
    
    @Override
    public void info() {
        System.out.println("Планшет: " + name + ", год: " + year + ", вес: " + weight + " кг, стилус: " + (hasStylus ? "да" : "нет"));
    }
    
    @Override
    public void turnOn() {
        System.out.println(name + " (планшет) включается касанием экрана");
    }
    
    public void draw() {
        if (hasStylus) {
            System.out.println("Рисование на планшете " + name);
        } else {
            System.out.println("Для рисования нужен стилус");
        }
    }
}

class Noutbuk extends Mobilny {
    private int batteryLife;
    
    public Noutbuk(String name, int year, double weight, int batteryLife) {
        super(name, year, weight);
        this.batteryLife = batteryLife;
    }
    
    @Override
    public void info() {
        System.out.println("Ноутбук: " + name + ", год: " + year + ", вес: " + weight + " кг, батарея: " + batteryLife + " ч");
    }
    
    @Override
    public void turnOn() {
        System.out.println(name + " (ноутбук) включается открытием крышки");
    }
    
    public void closeLid() {
        System.out.println("Закрытие крышки " + name);
    }
}

class Server extends Stacionarny {
    private int hddCount;
    
    public Server(String name, int year, int power, int hddCount) {
        super(name, year, power);
        this.hddCount = hddCount;
    }
    
    @Override
    public void info() {
        System.out.println("Сервер: " + name + ", год: " + year + ", мощность: " + power + " Вт, HDD: " + hddCount + " шт");
    }
    
    @Override
    public void turnOn() {
        System.out.println(name + " (сервер) включается удаленно");
    }
    
    public void startService() {
        System.out.println("Запуск служб на сервере " + name);
    }
}

class Smartfon extends Mobilny {
    private int cameraMP;
    
    public Smartfon(String name, int year, double weight, int cameraMP) {
        super(name, year, weight);
        this.cameraMP = cameraMP;
    }
    
    @Override
    public void info() {
        System.out.println("Смартфон: " + name + ", год: " + year + ", вес: " + weight + " кг, камера: " + cameraMP + " МП");
    }
    
    @Override
    public void turnOn() {
        System.out.println(name + " (смартфон) включается кнопкой");
    }
    
    public void call() {
        System.out.println("Звонок со смартфона " + name);
    }
}

class Monoblock extends Stacionarny {
    private int screenSize;
    
    public Monoblock(String name, int year, int power, int screenSize) {
        super(name, year, power);
        this.screenSize = screenSize;
    }
    
    @Override
    public void info() {
        System.out.println("Моноблок: " + name + ", год: " + year + ", мощность: " + power + " Вт, экран: " + screenSize + "\"");
    }
    
    @Override
    public void turnOn() {
        System.out.println(name + " (моноблок) включается кнопкой на корпусе");
    }
    
    public void touchScreen() {
        System.out.println("Сенсорный экран моноблока " + name);
    }
}

public class Lab3 {
    public static void main(String[] args) {
                
        System.out.println("1. Создание объектов\n");
        
        // Объекты основных классов
        Planchet ipad = new Planchet("iPad Pro", 2022, 0.68, true);
        Noutbuk lenovo = new Noutbuk("Lenovo ThinkPad", 2021, 1.8, 12);
        Server dell = new Server("Dell PowerEdge", 2023, 500, 8);
        Monoblock imac = new Monoblock("iMac 24", 2022, 150, 24);
        Smartfon iphone = new Smartfon("iPhone 15", 2023, 0.17, 48);
        
        System.out.println("Объекты созданы:\n");
        
        
        System.out.println("2. Вывод информации об объектах\n");
        
        ipad.info();
        lenovo.info();
        dell.info();
        imac.info();
        iphone.info();
        
        
        System.out.println("\n3. Демонстрация полиморфизма\n");
        
        EVM[] devices = {ipad, lenovo, dell, imac, iphone};
        
        System.out.println("Полиморфный вызов метода info():");
        for (EVM device : devices) {
            device.info();
        }
        
        System.out.println("\nПолиморфный вызов метода turnOn():");
        for (EVM device : devices) {
            device.turnOn();
        }
        
        System.out.println("\n4. Вызов специфических методов\n");
        
        ipad.draw();
        lenovo.closeLid();
        dell.startService();
        imac.touchScreen();
        iphone.call();
                
        System.out.println("\n5. Анализ характеристик (цикл + условие)\n");
        
        for (EVM device : devices) {
            if (device.year % 2 == 0) {
                System.out.println(device.name + " - четный год выпуска (" + device.year + ")");
            } else {
                System.out.println(device.name + " - нечетный год выпуска (" + device.year + ")");
            }
        }
                
        System.out.println("\n 6. Подсчет устройств по типам\n");
        
        int mobilnyCount = 0;
        int stacionarnyCount = 0;
        
        for (EVM device : devices) {
            if (device instanceof Mobilny && !(device instanceof Planchet) && !(device instanceof Noutbuk)) {
                mobilnyCount++;
            }
            if (device instanceof Stacionarny && !(device instanceof Server) && !(device instanceof Monoblock)) {
                stacionarnyCount++;
            }
        }
        
        System.out.println("Количество мобильных устройств (без планшетов/ноутбуков): " + mobilnyCount);
        System.out.println("Количество стационарных устройств (без серверов/моноблоков): " + stacionarnyCount);
                System.out.println("Программа завершена");
    }
}