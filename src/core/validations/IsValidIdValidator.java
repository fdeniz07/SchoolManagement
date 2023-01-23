package core.validations;

import java.util.Scanner;

public class IsValidIdValidator {

    public String isValid() {

        Scanner scanner = new Scanner(System.in);
        String id = "";

        do {
            id = scanner.next();
            String x = id.replaceAll("[\\d]", "");

            if (!x.isEmpty()) {
                System.out.println("Sayi disinda karakter girmeyiniz!");
                System.out.println("Tekrar deneyiniz");
            }

           else if (id.length() != 11) {
                System.out.println("TC kimlik numarasi 11 karakterden olusmalidir");
                System.out.println("Tekrar deneyiniz");
            }
           else{
               break;
            }


        } while (true);

        return id;
    }
}
