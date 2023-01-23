package core.validations;

import java.util.Scanner;

public class IsValidAgeValidator {

    Scanner scan = new Scanner(System.in);

    public int isAValidAge(){

       int age = 0;

        do {

            age = scan.nextInt();

            if (age<6 || age>100){
                System.out.println("Yasiniz 0'dan kücük ya da 100'den büyük olamaz.... ");
            }
            else {
                break;
            }

        }while (true);

            return age;

    }
}
