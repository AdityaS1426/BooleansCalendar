
package com.booleans.calendar.FRQ.Yasaswi;
import org.springframework.web.servlet.resource.CachingResourceResolver;
import java.sql.Driver;
import java.util.ArrayList;

public class Inheritance {
    public static class School {
        private String name;
        private int teachers;
        private int students;
        public School(String name, int teachers, int students) {
            this.name = name;
            this.teachers = teachers;
            this.students = students;
        }
        public String getName() {
            return name;
        }
        public int getNumTeachers() {
            return teachers;
        }
        public int getNumStudents() {
            return students;
        }
        public String summary() {
            return "Name: " + name + ", Number of Teachers: " + teachers + ", Number of Students: " + students;
        }
        public String toString() {
            return "Name: " + name + ", Number of Teachers: " + teachers + ", Number of Students: " + students;
        }
    }
    public static class DelNorte extends School {
        private int numOfApClasses;

        public DelNorte(int teachers, int students) {
            super("Del Norte", 2500, 120);
            numOfApClasses = 25;
        }

        public static class OVMS extends School {
            private int numOfSciOlyTeams;

            public OVMS(int teachers, int students) {
                super("OVMS", 1400, 60);
                numOfSciOlyTeams = 6;
            }
        }

        public static void main(String[] args) {
            ArrayList<School> schools = new ArrayList<>();

            School Westview = new School("Westview", 2000, 100);
            schools.add(Westview);

            School Poway = new School("Poway", 1500, 110);
            schools.add(Poway);

            schools.forEach((school -> {
                System.out.println(school.summary());
            }));
        }
    }
}
