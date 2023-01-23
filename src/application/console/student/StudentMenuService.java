package application.console.student;

import business.abstracts.IdMaker;
import business.abstracts.MenuService;
import core.validations.IsValidAgeValidator;
import core.validations.IsValidIdValidator;
import core.validations.IsValidNameValidator;
import entities.concretes.Students;
import java.util.Scanner;

public class StudentMenuService extends MenuService implements IdMaker {

    Students std = new Students();
    Scanner scanner = new Scanner(System.in);

    public static int counter = 100;

    //Validation
    IsValidIdValidator isValidTC = new IsValidIdValidator();
    IsValidNameValidator isValidName = new IsValidNameValidator();
    IsValidAgeValidator isValidAge = new IsValidAgeValidator();


    @Override
    public void add() {
        System.out.println("Lütfen adinizi giriniz: ");
        std.setFirstName(isValidName.isValidFirstName());

        System.out.println("Lütfen soyadinizi giriniz: ");
        std.setLastName(isValidName.isValidLastName());

        System.out.println("Lütfen kimlik numaranizi giriniz: ");
        std.setId(isValidTC.isValid());

        System.out.println("Lütfen yasinizi giriniz: ");
        std.setAge(isValidAge.isAValidAge());

        System.out.println("Lütfen sinifinizi giriniz: ");
        std.setGrade(scanner.next());

        std.setNumber(idMaker(std.getId()));

        std.fillStudentList();
        counter++;
        System.out.println("Öğrenci başarıyla eklenmiştir...");
        list();
        scanner.nextLine();//dummy

    }

    @Override
    public void search() {
        System.out.println("Lütfen aradığınız öğrencinin kimlik numarasını giriniz: ");
        String id = scanner.next();
        int flag = 0;

        for (Students w:std.studentsList){

            if (w.getId().equals(id)){
                System.out.printf("%-15s  %-15s  %-3s  %-5s  %-15s  %-10s \n","Name","Surname","Age","Grade","ID","Student No");
                System.out.printf("%-15s  %-15s  %-3s  %-5s  %-15s  %-10s \n","----------","-----------","---","-----","-----------","----------");
                System.out.printf("%-15s  %-15s  %-3s  %-5s  %-15s  %-10s \n",w.getFirstName(),w.getLastName(),w.getAge(),w.getGrade(),w.getId(),w.getNumber());
                flag++;
                break;
            }
        }
        if (flag==0){
            System.out.println("Girilen kimlik numarası ile eşleşen öğrenci bulunamamıştır");
            System.out.println();
        }else {
            System.out.println("Öğrenci başarıyla bulunmuştur");
            System.out.println();
        }
        scanner.nextLine();//dummy
    }

    @Override
    public void list() {
        System.out.printf("%-15s  %-15s  %-3s  %-5s  %-15s  %-10s \n","Name","Surname","Age","Grade","ID","Student No");
        System.out.printf("%-15s  %-15s  %-3s  %-5s  %-15s  %-10s \n","----------","-----------","---","-----","-----------","----------");

        for (Students w:std.studentsList){
            System.out.printf("%-15s  %-15s  %-3s  %-5s  %-15s  %-10s \n",w.getFirstName(),w.getLastName(),w.getAge(),w.getGrade(),w.getId(),w.getNumber());
        }
    }

    @Override
    public void delete() {
        System.out.println("Silmek istediginiz öğrencinin kimlik numarasini giriniz: ");
        String deletedId = scanner.next();
        int flag = 0;

        for (Students w:std.studentsList){

            if (w.getId().equals(deletedId)){
                std.studentsList.remove(w);
                flag++;
                break;
            }
        }

        if (flag==0){
            System.out.println("Girdiğiniz kimlik numarası ile eşleşen öğrenci bulunamadi.");
        }else {
            System.out.println("Öğrenci başarıyla sistemden silinmiştir.");
            list();
        }
    }

    @Override
    public String idMaker( String number) {

         String suffix = "Std";

        number = number.substring(number.length()-3);

        return suffix + number  +  counter ;
    }
}
