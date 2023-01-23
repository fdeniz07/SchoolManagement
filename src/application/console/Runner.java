package application.console;

import application.console.student.StudentMenuService;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Runner {




    public static void main(String[] args) {

        start();
    }

    public static void start() {

        StudentMenuService stdMenuService = new StudentMenuService();

        Scanner scanner = new Scanner(System.in);

        int select;

        do {
            String message = "===== Okul Yönetim Uygulamamiza Hos Geldiniz =====";
            slowPrint(message, 30);
            System.out.println("==================================================================");
            System.out.println("ÖGRENCI VE ÖGRETMEN YÖNETIM PANELI");
            System.out.println("==================================================================");
            System.out.println("1-ÖGRENCI ISLEMLERI");
            System.out.println("2-ÖGRETMEN ISLEMLERI");
            System.out.println("0-CIKIS");

            select = scanner.nextInt();

            switch (select) {

                case 1:
                    stdMenuService.getSelectionMenu();
                    break;
                case 2:
                    //Ögrenci islemleri
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Hatali Giris Yaptiniz...!");
            }

        } while (select != 0);

        System.out.println("Iyi günler, tekrar bekleriz...");
    }

    public static void slowPrint(String message, int delay) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

