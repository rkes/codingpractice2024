package coding.java8;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {
    public static void main(char [] chs){

    }
    public static void main(String[]args) {
        Set s = new TreeSet();
        s.add(1);
        s.add("2");
        Dog d = new Dog2();
        d.test();
      //  String s = "455";
      //  s.concat("1");
        System.out.println();
        List<String> strings = new LinkedList<>();
        strings.add("a");
        List<String> a = strings;
        strings.clear();;
        float []m = {1,3,4};
        int x[]=new int[4];
        int b[];
        b=x;
        a.add("b");
        System.out.println(strings);
        List<Integer> lst = Arrays.asList(1,4,5);
        Iterator<Integer> integerIterator = lst.iterator();

        //lst.removeAll()
        System.out.println(lst);
        System.out.println(lst);


                Predicate<String> predicate = String::isEmpty;
        BiFunction<Integer,Integer,Integer> biFunction = Integer::sum;
        System.out.println(biFunction.apply(15,6));
       // System.out.println(predicate.test(s));
        School school = new School();
        Car []cars1 = {new Car("HM"),new Car("GM"),new Car("Ferrai")};
        Car []cars2 = {new Car("Toyota"),new Car("GM"),new Car("Ferrai")};
        Car []cars3 = {new Car("Cameri"),new Car("GM"),new Car("HM")};

        Car []techcars1 = {new Car("HM"),new Car("GM"),new Car("Tata")};
        Car []techcars2 = {new Car("Toyota"),new Car("Maruti"),new Car("Ferrai")};
        Car []techcars3 = {new Car("Cameri"),new Car("GM"),new Car("Tata")};


        Student [] students = {new Student("a",10,new ArrayList<>(Arrays.asList(cars1))),
                new Student("b",10,new ArrayList<>(Arrays.asList(cars2))),
                new Student("c",10,new ArrayList<>(Arrays.asList(cars3)))};

        Teacher [] teachers = {new Teacher("t1a", new ArrayList<>(Arrays.asList(techcars1))),
                new Teacher("t1b",new ArrayList<>(Arrays.asList(techcars2))),
                new Teacher("t1c",new ArrayList<>(Arrays.asList(techcars3)))};


        school.setStudentList(new ArrayList<>(Arrays.asList(students)));

        List<Car> cars =
                school.getStudentList().stream().flatMap(p->p.getCars().stream()).collect(Collectors.toList());
        HashMap<String,List<Student>> mp = new HashMap<>();

        HashMap<String,ArrayList<Student>> resMap = new HashMap<>();
         school.getStudentList().stream().map(p-> {
            for(Car c:p.getCars()){
                ArrayList<Student> studentsLst = resMap.getOrDefault(c.name,new ArrayList<Student>());
                studentsLst.add(p);
                resMap.put(c.name,studentsLst);
            }
            return resMap;
        });
        //System.out.println(cars.size());
    }
    static class Dog  {

        //@Override
        public void demo() {

        }
        private void test(){
            System.out.println("Parent dog");
        }
    }
    static class Dog2 extends Dog {
        public void test(){
            System.out.println("Child dog");
        }
    }


    static class School{
        String name;
        List<Student> studentList = new ArrayList<>();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Student> getStudentList() {
            return studentList;
        }

        public void setStudentList(List<Student> studentList) {
            this.studentList = studentList;
        }

        public List<Teacher> getTeacherList() {
            return teacherList;
        }

        public void setTeacherList(List<Teacher> teacherList) {
            this.teacherList = teacherList;
        }

        List<Teacher> teacherList = new ArrayList<>();
    }
    static class Teacher{
        public Teacher(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Teacher(String name,List<Car> cars) {
            this.cars = cars;
            this.name = name;
        }

        List<Car> cars = new ArrayList<>();

        public List<Car> getCars() {
            return cars;
        }

        public void setCars(List<Car> cars) {
            this.cars = cars;
        }

        String name;
    }
    static class Student{
        public Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Student(String name, int marks, List<Car> cars) {
            this.name = name;
            this.marks = marks;
            this.cars = cars;
        }

        String name;
        int marks;
        List<Car> cars = new ArrayList<>();

        public int getMarks() {
            return marks;
        }

        public void setMarks(int marks) {
            this.marks = marks;
        }

        public List<Car> getCars() {
            return cars;
        }

        public void setCars(List<Car> cars) {
            this.cars = cars;
        }
    }
    static class Car{
        String name;

        public Car(String name) {
            this.name = name;
        }
    }
}