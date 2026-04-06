abstract class TransportnoeSredstvo {
    protected String nazvanie;
    protected int skorost;
    protected int gruzopodemnost;
    
    public TransportnoeSredstvo(String nazvanie, int skorost, int gruzopodemnost) {
        if (skorost < 0 || gruzopodemnost < 0 || nazvanie == null || nazvanie.isEmpty()) {
            throw new IllegalArgumentException("Неккоректные данные");
        }
        this.nazvanie = nazvanie;
        this.skorost = skorost;
        this.gruzopodemnost = gruzopodemnost;
        System.out.println("Конструтктор Транспортное средства");
    }
    
    public void pechat() {
        System.out.println(nazvanie + ", скорость: " + skorost + ", грузоподьемность: " + gruzopodemnost);
    }
    
    public void ochistit() {
        System.out.println("Деструктор: " + nazvanie);
    }
    
    public abstract void dvigatsya();
}

class Avtomobil extends TransportnoeSredstvo {
    public Avtomobil(String nazvanie, int skorost, int gruzopodemnost) {
        super(nazvanie, skorost, gruzopodemnost);
        System.out.println("Конструтор Автомобиль");
    }
    
    public void dvigatsya() {
        System.out.println(nazvanie + " едет");
    }
}

class Gruzovik extends Avtomobil {
    public Gruzovik(String nazvanie, int skorost, int gruzopodemnost) {
        super(nazvanie, skorost, gruzopodemnost);
        System.out.println("Конструктор Грузовик");
    }
    
    public void dvigatsya() {
        System.out.println(nazvanie + " везет груз");
    }
}

class Parohod extends TransportnoeSredstvo {
    public Parohod(String nazvanie, int skorost, int gruzopodemnost) {
        super(nazvanie, skorost, gruzopodemnost);
        System.out.println("Конструктор Пароход");
    }
    
    public void dvigatsya() {
        System.out.println(nazvanie + " плывет");
    }
}

class Samolet extends TransportnoeSredstvo {
    public Samolet(String nazvanie, int skorost, int gruzopodemnost) {
        super(nazvanie, skorost, gruzopodemnost);
        System.out.println("Конструктор самолет");
    }
    
    public void dvigatsya() {
        System.out.println(nazvanie + " летит");
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Avtomobil a = new Avtomobil("Toyota", 180, 500);
            Gruzovik g = new Gruzovik("KamAZ", 90, 5000);
            Parohod p = new Parohod("Titanik", 40, 10000);
            Samolet s = new Samolet("Boeing", 900, 50000);
            
            System.out.println("\n--- Печать ---");
            a.pechat();
            g.pechat();
            p.pechat();
            s.pechat();
            
            System.out.println("\n--- Двигается ---");
            a.dvigatsya();
            g.dvigatsya();
            p.dvigatsya();
            s.dvigatsya();
            
            System.out.println("\n--- Ошибка ---");
            Avtomobil a2 = new Avtomobil("", -10, -100);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Isklyuchenie: " + e.getMessage());
        } finally {
            System.out.println("\n--- Деструтивный ---");
            Avtomobil a3 = new Avtomobil("Test", 100, 200);
            a3.ochistit();
        }
    }
}