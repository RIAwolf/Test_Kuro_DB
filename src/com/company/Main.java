package com.company;

import com.company.DB_Darbai.*;

import java.util.Scanner;

public class Main {

    // Paklausti vartotojo 1 iki 3
    // jei 1 paprasyti ivesti studento varda, pavarde, telefona, email, issaugoti duombazeje
    // jei 2 paprasyti ivesti studento id ir pagal ivesta id istrinti studenta is duombazes
    // jei 3 atvaizduoti visa studentu lentele
    // programos nebaigti kol vartotojas neiveda 0 paklausime
    // bonus parent class
    public static void main(String[] args) {
        // programa suksis kol true
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Pasirinkite is veiksmu:\n" +
                    "0 - baigti programa,\n" +
                    "1 - studento informacijos ivedimas,\n" +
                    "2 - studento istrynimas is lenteles,\n" +
                    "3 - studentu lenteles atvaizdavimas,\n" +
                    "4 - lenteles is failo nuskaitymas i baze\n" +
                    "5 - lenteles is bazes irasymas i faila");
            int pasirinkimas = sc.nextInt();
            switch (pasirinkimas) {
                case 0:
                    return;
                case 1:
                    // paklausti studento info
                    Ivedimas objektas1 = new Ivedimas();
                    objektas1.pasisveikinimas();
                    objektas1.vykdymas();
                    objektas1.atvaizdavimas();
                    break;
                case 2:
                    // paklausti studento id
                    new Trynimas();
                    break;
                case 3:
                    // atvaizduoti lentele
                    new Atvaizdavimas();
                    break;
                case 4:
                    // nuskaitymas is failo ir irasymas i duombaze
                    new NuskaitymasIsFailo();
                    break;
                case 5:
                    // nuskaitymas is duombazes ir irasymas i faila
                    new IrasymasIFaila();
                    break;
                default:
                    System.out.println("Klaida: neatpazintas veiksmas");
                    break;
            }

        }
    }
}

