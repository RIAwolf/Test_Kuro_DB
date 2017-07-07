package com.company;

import com.company.DB_Darbai.*;

import java.util.Scanner;

public class Main {

    /* Paklausti kas prisijunge vartotojas ar admin
    VARTOTOJAS prisijungimas
    paklausti ar tai esantis vartotojas ar naujas
        jei naujas paprasyti ivesti varda ir slaptazodi ir issaugoti bazej ir nukreipti vel i prisijungima
        jei esantis paprasyti vartotojo vardo ir jei rado bazej ivesti slaptazodi ir jei tinka eiti toliau
    VARTOTOJAS kai prisijunge
    menu ka nori daryti:
        0 - iseiti is programos
        1 - pasirinkti transporto priemone pagal id perziurai
        2 - ivesti naujus turimos transporto priemones keliones duomenis

   ADMIN prisijungimas
        paprasyti admin vardo ir password
    ADMIN jei isejo prisijungti
    menu ka nori daryti:
        0 - iseiti is programos
        1 - pasirinkti vartotoja perziurai
        2 - pasirinkti menesi perziurai
        3 - pasirinkti vartotoja ir menesi su apskaiciuotomis kuro sanaudomis

    Pagal uzduoti reikes siu lenteliu:
    users
    admins
    kuro normos (pagal turimas transporto priemones)
    kelioniu ataskaita
    */

    public static void main(String[] args) {
        System.out.println("Sveiki atvyke i DataDog test programele - " +
                " transporto priemoniu ivedimas ir sunaudojamo kuro nustatymas");
        System.out.println();
        // programa suksis kol true
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Pasirinkite is veiksmu:\n" +
                    "0 - iseiti is programos\n" +
                    "1 - jus esate vartotojas\n" +
                    "2 - jus esate administratorius");
            int pasirinkimas1 = sc.nextInt();
            switch (pasirinkimas1) {
                case 0:
                    return;
                case 1:
                    Ivedimas vartotojas = new Ivedimas();
                    if (vartotojas.userPrisijungimas()) {
                        System.out.println("Pasirinkite is veiksmu:\n" +
                                "0 - baigti programa,\n" +
                                "1 - pasirinkti transporto priemone ir ivesti keliones duomenis");
                        int pasirinkimas1_1 = sc.nextInt();
                        switch (pasirinkimas1_1) {
                            case 0:
                                return;
                            case 1:
                                vartotojas.userIvedimas();
                                vartotojas.atvaizdavimas();
                                break;

                            default:
                                System.out.println("Klaida: neatpazintas veiksmas");
                                break;
                        }
                    }
                case 2:
                    Ivedimas admin = new Ivedimas();
                    if (admin.adminPrisijungimas()) {
                        System.out.println("Pasirinkite is veiksmu:\n" +
                                "0 - baigti programa,\n" +
                                "1 - pasirinkti vartotoja perziurai,\n" +
                                "2 - pasirinkti menesi perziurai,\n" +
                                "3 - pasirinkti vartotoja ir menesi su apskaiciuotomis kuro sanaudomis");
                        int pasirinkimas2_1 = sc.nextInt();
                        switch (pasirinkimas2_1) {
                            case 0:
                                return;
                            case 1:
                                Atvaizdavimas adminAtvaizdavimas = new Atvaizdavimas();
                                // metodai admino uzklausoms

                                break;
                            case 2:

                                break;
                            case 3:

                                break;
                            default:
                                System.out.println("Klaida: neatpazintas veiksmas");
                                break;
                        }
                    }


            }


        }


    }
}


