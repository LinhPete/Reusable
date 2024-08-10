package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class XInput {

    Scanner scanner = new Scanner(System.in);

    public final String Id(String pattern) {
        String id;
        do {
            id = scanner.nextLine();
            if (id.matches(pattern)) {
                break;
            } else {
                System.out.println("Hay nhap dung mau quy dinh :");
            }
        } while (true);
        return id;
    }

    public final String Id(int i) {
        String id;
        do {
            id = scanner.nextLine();
            if (id.length() <= i) {
                break;
            } else {
                System.out.println("Chi nhap toi da " + i + " ki tu !!! :");
            }
        } while (true);
        return id;
    }

    public final String Id(String pattern, int i) {
        String id;
        do {
            id = scanner.nextLine();
            if (id.length() <= i && id.matches(pattern)) {
                break;
            } else {
                if (id.length() > i) {
                    System.out.println("Chi nhap toi da " + i + " ki tu !!! :");
                }
                if (!id.matches(pattern)) {
                    System.out.println("Hay nhap dung mau quy dinh :");
                }
            }
        } while (true);
        return id;
    }
    
    public final String NewPassword(){
        String pass;
        do{
            pass = scanner.nextLine();
            if(pass.matches("[A-Z]+\\w+\\W+")||pass.matches("\\w+[A-Z]+\\W+")||pass.matches("\\w+\\W+[A-Z]+")||
               pass.matches("[A-Z]+\\W+\\w+")||pass.matches("\\W+[A-Z]+\\w+")||pass.matches("\\W+\\w+[A-Z]+")){
                System.out.println("Mat khau manh");
            }
            else{
                System.out.println("Mat khau chua du manh");
            }
            System.out.println("Nhap lai mat khau:");
            String temp = scanner.nextLine();
            if(temp.equals(pass)){
                System.out.println("Tao mat khau thanh cong !!");
                break;
            }
        }while(true);
        return pass;
    }

    public final String Name() {
        String ten;
        do {
            ten = scanner.nextLine();
            if (ten.matches("[a-zA-Z ]+")) {
                break;
            } else {
                System.out.println("Ten khong hop le, moi nhap lai:");
            }
        } while (true);
        String[] names = ten.toLowerCase().split(" ");
        for (int i = 0; i < names.length; i++) {
            names[i] = Character.toUpperCase(names[i].charAt(0)) + names[i].substring(1);
        }
        ten = String.join(" ", names);
        return ten;
    }

    public final String Email() {
        String email;
        do {
            email = scanner.nextLine();
            if (!email.matches("\\w{1,20}+@\\w{1,5}+(\\.\\w{1,5}){1,2}")) {
                System.out.println("Email khong hop le, hay nhap lai:");
            }
        } while (!email.matches("\\w+@\\w{1,5}+(\\.\\w{1,5}){1,2}"));
        return email;
    }

    public final String Phone() {
        String dt;
        do {
            dt = scanner.nextLine();
            if (!dt.matches("0\\d{9,10}")) {
                System.out.println("So dien thoai khong hop le, hay nhap lai:");
            }
        } while (!dt.matches("0\\d{9,10}"));
        return dt;
    }

    public final String CMND() {
        String cmnd;

        do {
            cmnd = scanner.nextLine();
            if (!cmnd.matches("[0-9]{9,12}")) {
                System.out.println("CMND khong hop le, hay nhap lai:");
            }
        } while (!cmnd.matches("[0-9]{9,12}"));
        return cmnd;
    }

    public final String Birth() {
        String birth;
        do {
            birth = scanner.nextLine();
            if (!birth.matches("[1-9][0-9]{3}/[0-9]{2}/[0-9]{2}")) {
                System.out.println("Nhap theo dinh dang yyyy/mm/dd !!! :");
            } else {
                String[] a = birth.split("/");
                if (Integer.parseInt(a[0]) > 0 && (Integer.parseInt(a[0]) % 400 == 0 || (Integer.parseInt(a[0]) % 4 == 0 && Integer.parseInt(a[0]) % 100 != 0))) {
                    switch (Integer.parseInt(a[1])) {
                        case 1, 3, 5, 7, 8, 10, 12:
                            if (Integer.parseInt(a[2]) > 31) {
                                System.out.println("Ngay khong hop le !!! Hay nhap lai:");
                                continue;
                            } else {
                                break;
                            }
                        case 2:
                            if (Integer.parseInt(a[2]) > 29) {
                                System.out.println("Thang nay chi co 29 ngay !!! Hay nhap lai:");
                                continue;
                            } else {
                                break;
                            }
                        case 4, 6, 9, 11:
                            if (Integer.parseInt(a[2]) > 30) {
                                System.out.println("Thang nay chi co 30 ngay !!! Hay nhap lai:");
                                continue;
                            } else {
                                break;
                            }

                        default:
                            System.out.println("Thang khong hop le!!! Hay nhap lai:");
                            continue;
                    }

                } else if (Integer.parseInt(a[0]) > 0) {
                    switch (Integer.parseInt(a[1])) {
                        case 1, 3, 5, 7, 8, 10, 12:
                            if (Integer.parseInt(a[2]) > 31) {
                                System.out.println("Ngay khong hop le !!! Hay nhap lai:");
                                continue;
                            } else {
                                break;
                            }
                        case 2:
                            if (Integer.parseInt(a[2]) > 28) {
                                System.out.println("Thang nay chi co 28 ngay !!! Hay nhap lai:");
                                continue;
                            } else {
                                break;
                            }
                        case 4, 6, 9, 11:
                            if (Integer.parseInt(a[2]) > 30) {
                                System.out.println("Thang nay chi co 30 ngay !!! Hay nhap lai:");
                                continue;
                            } else {
                                break;
                            }
                        default:
                            System.out.println("Thang khong hop le!!! Hay nhap lai:");
                            continue;
                    }

                } else {
                    System.out.println("Nam sinh khong hop le!! Hay nhap lai:");
                    continue;
                }
                break;
            }
        } while (true);

        return birth;
    }

    public final double Numb() {
        double x;
        do {
            try {
                x = scanner.nextDouble();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Chi nhap thuc: ");
                scanner.nextLine();
            }
        } while (true);

        return x;
    }

    public final int Int() {
        int x;
        do {
            try {
                x = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Chi nhap so nguyen: ");
                scanner.nextLine();
            }
        } while (true);

        return x;
    }

    public final double NegNumb() {
        double x;
        do {
            x = Numb();
            if (x >= 0) {
                System.out.println("Hay nhap so am");
            }
        } while (x >= 0);
        return x;
    }

    public final double NegNumb0() {
        double x;
        do {
            x = Numb();
            if (x > 0) {
                System.out.println("Hay nhap so <= 0");
            }
        } while (x > 0);
        return x;
    }

    public final double PosNumb() {
        double x;
        do {
            x = Numb();
            if (x <= 0) {
                System.out.println("Hay nhap so duong");
            }
        } while (x <= 0);
        return x;
    }

    public final double PosNumb0() {
        double x;
        do {
            x = Numb();
            if (x < 0) {
                System.out.println("Hay nhap so >= 0");
            }
        } while (x < 0);
        return x;
    }

    public final int NegInt() {
        int x;
        do {
            x = Int();
            if (x >= 0) {
                System.out.println("Hay nhap so nguyen am");
            }
        } while (x >= 0);
        return x;
    }

    public final int NegInt0() {
        int x;
        do {
            x = Int();
            if (x > 0) {
                System.out.println("Hay nhap so nguyen <= 0");
            }
        } while (x > 0);
        return x;
    }

    public final int PosInt() {
        int x;
        do {
            x = Int();
            if (x <= 0) {
                System.out.println("Hay nhap so nguyen duong");
            }
        } while (x <= 0);
        return x;
    }

    public final int PosInt(int i) {
        int x;
        do {
            x = Int();
            if (x <= 0 || x > i) {
                System.out.println("Hay nhap so nguyen duong <= " + i);
            }
        } while (x <= 0 || x > i);
        return x;
    }

    public final int PosInt0() {
        int x;
        do {
            x = Int();
            if (x < 0) {
                System.out.println("Hay nhap so nguyen >= 0");
            }
        } while (x < 0);
        return x;
    }

    public final int PosInt0(int i) {
        int x;
        do {
            x = Int();
            if (x < 0 || x > i) {
                System.out.println("Hay nhap so nguyen >= 0 va <= " + i);
            }
        } while (x < 0 || x > i);
        return x;
    }
    
    public final boolean YN(){
        boolean check;
        String state;
        do{
            state = scanner.nextLine();
        if(state.equalsIgnoreCase("Y")){
            check = true;
            break;
        }
        else if(state.equalsIgnoreCase("N")){
            check = false;
            break;
        }
        else{
            System.out.print("Hay nhap Y hoac N : ");
        }
        }while(true);
        return check;
    }

}
