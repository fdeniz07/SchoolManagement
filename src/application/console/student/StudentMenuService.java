package application.console.student;

import business.abstracts.MenuService;
import entities.abstracts.User;
import entities.concretes.Students;

import java.util.List;
import java.util.Scanner;

public class StudentMenuService extends MenuService {

    Students std = new Students();
    Scanner scanner = new Scanner(System.in);



    //Id = Kimlik No
    //OgrenciNo = suffix + kimlikNo(son 3 hane) + counter


    @Override
    public void add() {
        System.out.println("Lütfen adinizi giriniz: ");
        std.setFirstName(scanner.nextLine());

        System.out.println("Lütfen soyadinizi giriniz: ");
        std.setLastName(scanner.nextLine());

        System.out.println("Lütfen kimlik numaranizi giriniz: ");
        std.setId(scanner.nextInt());

        System.out.println("Lütfen yasinizi giriniz: ");
        std.setAge(scanner.nextInt());

        System.out.println("Lütfen sinifinizi giriniz: ");
        std.setGrade(scanner.next());

        System.out.println("Ögrenci Numaraniz: ");
        std.setAge(scanner.nextInt());

    }

    @Override
    public void search() {

    }

    @Override
    public void list() {

    }

    @Override
    public void delete() {

    }


    private String studentIdMaker(String suffix, int id){
        suffix = "Std-";
        int counter = 100;

        //String idx = std.getId()

        //Buradan devam edilecek



        return "";

    }

}
