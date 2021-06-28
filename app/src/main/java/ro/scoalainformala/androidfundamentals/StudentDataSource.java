package ro.scoalainformala.androidfundamentals;

import java.util.ArrayList;
import java.util.List;

public class StudentDataSource {
    private final ArrayList<Student> students = new ArrayList<Student>();

    public StudentDataSource() {
        students.add(new Student("Lilly-Mai", "Garcia"));
        students.add(new Student("Will", "Shepherd"));
        students.add(new Student("Tara", "Fritz"));
        students.add(new Student("Pamela", "Gunn"));
        students.add(new Student("Lawrence", "Burch"));
        students.add(new Student("Elina", "Ortega"));
        students.add(new Student("Anton", "Wang"));
        students.add(new Student("Zeynep", "Burns"));
        students.add(new Student("Kendrick", "Armitage"));
        students.add(new Student("Valentina", "Barajas"));
        students.add(new Student("Dawud", "Gonzalez"));
        students.add(new Student("Connar", "Reeve"));
        students.add(new Student("Timur", "Armstrong"));
        students.add(new Student("Tilly", "Miranda"));
        students.add(new Student("Allison", "Cisneros"));
        students.add(new Student("Maariya", "Schmitt"));
        students.add(new Student("Anderson", "Robins"));
        students.add(new Student("Nelson", "Turner"));
        students.add(new Student("Masuma", "Chaney"));
        students.add(new Student("Irene", "Coulson"));
    }

    public List<Student> getMovies() {
        return students;
    }
}
