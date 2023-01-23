package core.validations;

import java.util.Scanner;

public class IsValidNameValidator {

    Scanner scan = new Scanner(System.in);


    public String isValidFirstName() {

        String firstName = "";

        do {

            firstName = scan.nextLine();

            String s = firstName.replaceAll("[a-zA-Z]", "");

            if (!s.isEmpty()) {
                System.out.println("Harf disinda bir karakter girmeyiniz!");
            } else if (firstName.length() < 2 || firstName.length() > 20) {
                System.out.println("Isminiz en az iki harf ve en fazla 20 harf  icermelidir!");
            } else {
                break;
            }

        } while (true);

        return firstName;
    }

    public String isValidLastName() {

        String lastName = "";

        do {

            lastName = scan.nextLine();

            String s = lastName.replaceAll("[a-zA-Z]", "");

            if (!s.isEmpty()) {
                System.out.println("Harf disinda bir karakter girmeyiniz!");
            } else if (lastName.length() < 2 || lastName.length() > 20) {
                System.out.println("Isminiz en az iki harf ve en fazla 20 harf  icermelidir!");
            } else {
                break;
            }

        } while (true);

        return lastName;

    }
}
