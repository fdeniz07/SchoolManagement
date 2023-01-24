package application.console.teacher;

import business.abstracts.IdMaker;
import business.abstracts.MenuService;
import core.validations.IsValidAgeValidator;
import core.validations.IsValidIdValidator;
import core.validations.IsValidNameValidator;
import entities.concretes.Teachers;

import java.util.Scanner;

public class TeacherMenuService extends MenuService implements IdMaker {


    Teachers tch = new Teachers();
    Scanner scanner = new Scanner(System.in);

    public static int counter = 100;

    //Validation
    IsValidIdValidator isValidTC = new IsValidIdValidator();
    IsValidNameValidator isValidName = new IsValidNameValidator();
    IsValidAgeValidator isValidAge = new IsValidAgeValidator();


    @Override
    public void add() {
        System.out.println("Lütfen adinizi giriniz: ");
        tch.setFirstName(isValidName.isValidFirstName());

        System.out.println("Lütfen soyadinizi giriniz: ");
        tch.setLastName(isValidName.isValidLastName());

        System.out.println("Lütfen kimlik numaranizi giriniz: ");
        tch.setId(isValidTC.isValid());

        System.out.println("Lütfen yasinizi giriniz: ");
        tch.setAge(isValidAge.isAValidAge());

        System.out.println("Lütfen departmaninizi giriniz: ");
        tch.setDepartment(scanner.next());

        tch.setRegistrationNumber(idMaker(tch.getId()));

        tch.fillTeacherList();
        counter++;
        System.out.println("Ögretmen başarıyla eklenmiştir...");
        list();
        scanner.nextLine();//dummy
        System.out.println();
    }

    @Override
    public void search() {
        System.out.println("Lütfen aradığınız ögretmenin kimlik numarasını giriniz: ");
        String id = scanner.next();
        int flag = 0;

        for (Teachers w: tch.teachersList){

            if (w.getId().equals(id)){
                System.out.printf("%-15s  %-15s  %-3s  %-15s  %-15s  %-15s \n","Name","Surname","Age","Department","ID","Registration No");
                System.out.printf("%-15s  %-15s  %-3s  %-15s  %-15s  %-15s \n","----------","-----------","---","--------------","-----------","-------------------");
                System.out.printf("%-15s  %-15s  %-3s  %-15s  %-15s  %-15s \n",w.getFirstName(),w.getLastName(),w.getAge(),w.getDepartment(),w.getId(),w.getRegistrationNumber());
                flag++;
                break;
            }
        }
        if (flag==0){
            System.out.println("Girilen kimlik numarası ile eşleşen ögretmen bulunamamıştır");
            System.out.println();
        }else {
            System.out.println("Ögretmen başarıyla bulunmuştur");
            System.out.println();
        }
        scanner.nextLine();//dummy
    }

    @Override
    public void list() {
        System.out.printf("%-15s  %-15s  %-3s  %-15s  %-15s  %-15s \n","Name","Surname","Age","Department","ID","Registration No");
        System.out.printf("%-15s  %-15s  %-3s  %-15s  %-15s  %-15s \n","----------","-----------","---","--------------","-----------","-------------------");

        for (Teachers w: tch.teachersList){
            System.out.printf("%-15s  %-15s  %-3s  %-15s  %-15s  %-15s \n",w.getFirstName(),w.getLastName(),w.getAge(),w.getDepartment(),w.getId(),w.getRegistrationNumber());
        }
    }

    @Override
    public void delete() {
        System.out.println("Silmek istediginiz ögretmenin kimlik numarasini giriniz: ");
        String deletedId = scanner.next();
        int flag = 0;

        for (Teachers w: tch.teachersList){

            if (w.getId().equals(deletedId)){
                tch.teachersList.remove(w);
                flag++;
                break;
            }
        }

        if (flag==0){
            System.out.println("Girdiğiniz kimlik numarası ile eşleşen ögretmen bulunamadi.");
        }else {
            System.out.println("Öğretmen başarıyla sistemden silinmiştir.");
            list();
        }
    }

    @Override
    public String idMaker( String number) {

        String suffix = "TCH";

        number = number.substring(number.length()-3);

        return suffix + number  +  counter ;
    }
}
