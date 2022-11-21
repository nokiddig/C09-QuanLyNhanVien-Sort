import java.time.LocalDate;
import java.util.Scanner;

public class NhanVien implements Comparable<NhanVien>{
    static int genId = 1;
    private int id;
    private String name;
    private double salary;
    private String gender;
    private LocalDate birthday;

    public NhanVien() {
    }

    public NhanVien(int id, String name, double salary, String gender, LocalDate birthday) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.birthday = birthday;
    }

    public void inputInfo() {
        Scanner scanner = new Scanner(System.in);
        if (id <= 0) {
            this.id = NhanVien.genId;
            NhanVien.genId ++;
        }
        System.out.println("Input name: ");
        this.name = scanner.nextLine();

        System.out.println("Input salary: ");
        this.salary = Double.parseDouble(scanner.nextLine());

        System.out.println("Input gender: ");
        this.gender = scanner.nextLine();

        int day, month, year;
        System.out.println("Input day of birth: ");
        day = Integer.parseInt(scanner.nextLine());

        System.out.println("Input month of birth: ");
        month = Integer.parseInt(scanner.nextLine());


        System.out.println("Input year of birth: ");
        year = Integer.parseInt(scanner.nextLine());

        this.birthday = LocalDate.of(year, month, day);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", birthday: " + birthday + ", salary" + salary;
    }

    @Override
    public int compareTo(NhanVien nhanVien) {
        if (this.salary>nhanVien.salary){
            return 1;
        }
        else if (this.salary<nhanVien.salary) {
            return -1;
        }
        else {
            return 0;
        }
//        return this.salary == nhanVien.salary ? 0 : -1;
    }

    //    public static void main(String[] args) {
//        LocalDate test = LocalDate.of(2022, 10, 15);
//        System.out.println(test.getMonthValue());
//    }
}
