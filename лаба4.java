abstract class Body {
    protected String name;
    
    public Body(String name) {
        this.name = name;
    }
    
    public abstract double getVolume();
    public abstract double getSurfaceArea();
}

interface Series {
    void vyvodHarakteristik();
}

class Parallelepiped extends Body implements Series {
    double length, width, height;
    
    public Parallelepiped(String name, double length, double width, double height) {
        super(name);
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    public double getVolume() {
        return length * width * height;
    }
    
    public double getSurfaceArea() {
        return 2 * (length * width + length * height + width * height);
    }
    
    public void vyvodHarakteristik() {
        System.out.println("Параллелепипед: " + name);
        System.out.println("Объем: " + getVolume());
        System.out.println("Площадь: " + getSurfaceArea());
    }
}

class Cone extends Body implements Series {
    double radius, height;
    
    public Cone(String name, double radius, double height) {
        super(name);
        this.radius = radius;
        this.height = height;
    }
    
    public double getVolume() {
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }
    
    public double getSurfaceArea() {
        double slant = Math.sqrt(radius * radius + height * height);
        return Math.PI * radius * (radius + slant);
    }
    
    public void vyvodHarakteristik() {
        System.out.println("Конус: " + name);
        System.out.println("Объем: " + getVolume());
        System.out.println("Площадь: " + getSurfaceArea());
    }
}

class Ball extends Body implements Series {
    double radius;
    
    public Ball(String name, double radius) {
        super(name);
        this.radius = radius;
    }
    
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }
    
    public double getSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }
    
    public void vyvodHarakteristik() {
        System.out.println("Шар: " + name);
        System.out.println("Объем: " + getVolume());
        System.out.println("Площадь: " + getSurfaceArea());
    }
}

public class Main {
    public static void main(String[] args) {
        Parallelepiped p = new Parallelepiped("Куб", 5, 5, 5);
        Cone c = new Cone("Конус", 3, 7);
        Ball b = new Ball("Шар", 4);
        
        p.vyvodHarakteristik();
        System.out.println();
        c.vyvodHarakteristik();
        System.out.println();
        b.vyvodHarakteristik();
        
        System.out.println("\nОбъем параллелепипеда: " + p.getVolume());
        System.out.println("Площадь конуса: " + c.getSurfaceArea());
        System.out.println("Объем шара: " + b.getVolume());
    }
}