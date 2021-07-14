import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Wissen_technology {

    public static void main(String[] args) {
        List<Employee> list = new LinkedList<Employee>();
//        Employee employee = new Employee();

        List<String> random_designation = Arrays.asList("lvl1","lvl2","lvl3","lvl4","lvl5","lvl6","lvl7","lvl8");
        List<String> random_department = Arrays.asList("Finance","Marketing","HR","Sales","Operations","Shipping");
//        List<String> random_department = Arrays.asList("Finance","Marketing");
        List<String> random_gender = Arrays.asList("Male","Female");
        int suffix=1;
        Random rand = new Random();
        String randomElement = random_designation.get(rand.nextInt(random_designation.size()));
        for(int i=0; i<10;i++)
        list.add(new Employee(suffix,"Jackson"+suffix++, ThreadLocalRandom.current().nextInt(21, 50),
                ThreadLocalRandom.current().nextInt(1000000, 10000000),
                random_designation.get(rand.nextInt(random_designation.size())),
                random_department.get(rand.nextInt(random_department.size())),
                random_gender.get(rand.nextInt(random_gender.size()))));
        System.out.println("------------------------------Listing all Employees------------------------------------------------------------------------------------------------");

        Iterator itr = list.iterator();
        while(itr.hasNext())
        System.out.println(itr.next());

//        Optional<Employee> emp = list.stream()
//                .collect(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)));
//                OptionalInt max_sal = list.stream().mapToInt(e->e.getSalary()).max();
//        System.out.println(emp);
        System.out.println("------------------------------Printing 2nd Max salary---------------------------------------------------------------------------------------------");


        int max_sal1 = list.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).skip(1).findFirst().get().getSalary();
        System.out.println(max_sal1);
        System.out.println("------------------------------FInd number of males and female Employees---------------------------------------------------------------------------");

        Map<Boolean,Long> map  = list.stream().collect(Collectors.partitioningBy(e1->e1.getGender().equals("Male"),Collectors.counting()));
        System.out.println("Number of Male Employees: "+map.get(true)+ "\nNumber of Female Employees: " +map.get(false));

        System.out.println("------------------------------Find Expensive Department-------------------------------------------------------------------------------------------");

        Map<String, Integer> map1 = list.stream().collect(Collectors.groupingBy(emp1->emp1.getDepartment(), Collectors.summingInt(emp-> emp.getSalary())));
        String expensive_dept = Collections.max(map1.entrySet(),Comparator.comparingInt(Map.Entry::getValue)).getKey();
        System.out.println(map1);
        System.out.println(expensive_dept);

        System.out.println("------------------------------Designation wise total salary----------------------------------------------------------------------------------------");

        Map<String,Integer> map2 = list.stream().collect(Collectors.groupingBy(employee -> employee.getDesignation(),Collectors.summingInt(employee->employee.getSalary())));
        System.out.println(map2);
    }

}

class Employee{

    private int eid;
    private String name;
    private int age;
    private int salary;
    private String designation;
    private String department;
    private String gender;


    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Employee() {
    }

    public Employee(int eid, String name, int age, int salary, String designation, String department, String gender) {
        this.eid = eid;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.designation = designation;
        this.department = department;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", designation='" + designation + '\'' +
                ", department='" + department + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
