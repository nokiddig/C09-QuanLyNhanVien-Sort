import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class QuanLyNhanVien{
    private List<NhanVien> dsNhanVien = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void show() {
        System.out.println("Danh sach " + dsNhanVien.size() + " nhan vien:");
        for (int i = 0; i < dsNhanVien.size(); i++) {
            System.out.println(dsNhanVien.get(i).toString());
        }
    }

    public void add() {
        NhanVien newNhanVien = new NhanVien();
        newNhanVien.inputInfo();
        dsNhanVien.add(newNhanVien);
    }

    public int findIndexById(int id) {
        for (int i = 0; i < dsNhanVien.size(); i++) {
            if (dsNhanVien.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void edit(){
        System.out.println("Nhap id can sua: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = findIndexById(id);
        if (index == -1) {
            System.out.println("Khong tim thay!");
        }
        else {
            dsNhanVien.get(index).inputInfo();
        }
    }

    public void deleteById(){
        System.out.println("Nhap id can xoa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = findIndexById(id);
        if (index == -1) {
            System.out.println("Khong tim thay!");
        }
        else {
            dsNhanVien.remove(index);
        }
    }

    public ArrayList<NhanVien> findByName(String name){
        ArrayList<NhanVien> list = new ArrayList<NhanVien>();
        for (int i = 0; i < dsNhanVien.size(); i++) {
            if (dsNhanVien.get(i).getName().equals(name)) {
                list.add(dsNhanVien.get(i));
            }
        }
        return list;
    }

    public void sortBySalary() {
//        for (int i = 0; i < dsNhanVien.size(); i++) {
//            int indexMax = i;
//            for (int j = i+1; j < dsNhanVien.size(); j++) {
//                if (dsNhanVien.get(j).getSalary() > dsNhanVien.get(indexMax).getSalary())
//                    indexMax = j;
//            }
//            NhanVien tmp = dsNhanVien.get(i);
//            dsNhanVien.set(i, dsNhanVien.get(indexMax));
//            dsNhanVien.set(indexMax, tmp);
//        }
        dsNhanVien.sort(NhanVien::compareTo);
    }
    public void top3Salary() {
        if (dsNhanVien.size() < 3) {
            System.out.println("?");
            return;
        }
        this.sortBySalary();
        System.out.println(dsNhanVien.get(0).toString());
        System.out.println(dsNhanVien.get(1).toString());
        System.out.println(dsNhanVien.get(2).toString());
    }

    public static void main(String[] args) {
        String menu = "1.Show\n" +
                "2.Add new\n" +
                "3.Delete by id\n" +
                "4.Edit by id\n" +
                "5.Find by name\n" +
                "6.Top 3 salary\n" +
                "7.Exit\n" +
                "Input your choice here: \n";
        Scanner scanner = new Scanner(System.in);
        int choice;
        QuanLyNhanVien quanLyNhanVien = new QuanLyNhanVien();
        while (true) {
            System.out.println(menu);
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    quanLyNhanVien.show();
                    break;
                case 2:
                    quanLyNhanVien.add();
                    break;
                case 3:
                    quanLyNhanVien.deleteById();
                    break;
                case 4:
                    quanLyNhanVien.edit();
                    break;
                case 5:
                    System.out.println(quanLyNhanVien.findByName("sy"));
                    break;
                case 6:
                    quanLyNhanVien.top3Salary();
                    break;
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }
}
