import java.io.*;
import java.util.*;

class Student {
    int Id_studenta;
    String Fam;
    String Name;
    String Groupa;
    String Department;
    String discipline;
    int mark;
    String NameTeacher;
    
    Student(int Id_studenta, String Fam, String Name, String Groupa, 
            String Department, String discipline, int mark, String NameTeacher) {
        this.Id_studenta = Id_studenta;
        this.Fam = Fam;
        this.Name = Name;
        this.Groupa = Groupa;
        this.Department = Department;
        this.discipline = discipline;
        this.mark = mark;
        this.NameTeacher = NameTeacher;
    }
}

public class Lab7 {
    public static void main(String[] args) throws Exception {
        ArrayList<Student> list = new ArrayList<>();
        
        list.add(new Student(1, "Иванов", "Иван", "И-01", "ИТ", "Программирование", 5, "Петров"));
        list.add(new Student(2, "Петров", "Петр", "И-01", "ИТ", "Базы данных", 4, "Сидоров"));
        
        PrintWriter pw = new PrintWriter("students.txt");
        for (Student s : list) {
            pw.println(s.Id_studenta + ";" + s.Fam + ";" + s.Name + ";" + s.Groupa + ";" + 
                      s.Department + ";" + s.discipline + ";" + s.mark + ";" + s.NameTeacher);
        }
        pw.close();
        System.out.println("Сохранено в файл");
        
        list.clear();
        
        BufferedReader br = new BufferedReader(new FileReader("students.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] p = line.split(";");
            Student s = new Student(Integer.parseInt(p[0]), p[1], p[2], p[3], p[4], p[5], Integer.parseInt(p[6]), p[7]);
            list.add(s);
        }
        br.close();
        
        System.out.println("Загружено из файла:");
        for (Student s : list) {
            System.out.println(s.Id_studenta + " " + s.Fam + " " + s.Name + " " + s.Groupa + " " + s.mark);
        }
    }
}