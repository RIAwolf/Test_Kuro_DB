package com.company.DB_Darbai;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by PauliusJ on 2017.05.31.
 */
public class Ivedimas extends JDBC_Communication {

    private Scanner sc = new Scanner(System.in);
    private boolean _rezultatas;


    // USER PRISIJUNGIMAS

    public boolean userPrisijungimas() {
        System.out.println("Pasirinkite is veiksmu:\n" +
                "1 - naujas vartotojas\n" +
                "2 - esamas vartotojas");
        int userPasirinkimas = sc.nextInt();
        boolean arNaujasOK = false;
        boolean arEsamasOK = false;
        switch (userPasirinkimas) {
            case 1:
                arNaujasOK = userNaujasPrisijungimas();
                arEsamasOK = userEsamoPrisijungimas();
                break;
            case 2:
                arEsamasOK = userEsamoPrisijungimas();
                if (arEsamasOK) {
                    arNaujasOK = true;
                }
                break;
            default:
                System.out.println("Neatpazintas pasirinkimas");
                break;
        }
        if (arNaujasOK && arEsamasOK) {
            return true;
        } else {
            return false;
        }
    }

    private boolean userNaujasPrisijungimas() {
        boolean flag = true;
        while (flag) {
            System.out.println("Iveskite nauja vartotojo varda: ");
            String newUserName = sc.nextLine();
            System.out.println("Iveskite nauja slaptazodi: ");
            String newUserPassword = sc.nextLine();
            // papildomai patikrinti ar jau bazej neegzistuoja toks vartotojas/slaptazodis
            String uzklausa1 = "SELECT EXISTS(SELECT 1 FROM `users` WHERE `userName` = '" + newUserName + "')";
            // grazins "1" jei egzistuoja toks vartotojas/password ir "0" jei ne
            _rezultatas = super.vykdykVeiksma(uzklausa1);
            if (uzklausa1 != "1") {
                String uzklausa2 = "SELECT EXISTS(SELECT 1 FROM `users` WHERE `userPassword` = '" + newUserPassword + "')";
                _rezultatas = super.vykdykVeiksma(uzklausa2);
                if (uzklausa2 != "1") {
                    System.out.println("Sekmingai sukurtas naujas vartotojas su slaptazodziu");
                    flag = false;
                } else {
                    System.out.println("Toks vartotojo slaptazodis jau egzistuoja, bandykite dar karta");
                }
            } else {
                System.out.println("Toks vartotojo vardas jau egzistuoja, bandykite dar karta");
            }
        }
        return true;
    }

    private boolean userEsamoPrisijungimas() {
        boolean flag = true;
        while (flag) {
            System.out.println("Iveskite vartotojo varda: ");
            String userName = sc.nextLine();
            System.out.println("Iveskite vartotojo slaptazodi");
            String userPassword = sc.nextLine();
            String uzklausa1 = "SELECT EXISTS(SELECT 1 FROM `users` WHERE `userName` = '" + userName + "')";
            // grazins "1" jei egzistuoja toks vartotojas/password ir "0" jei ne
            _rezultatas = super.vykdykVeiksma(uzklausa1);
            if (uzklausa1 == "1") {
                String uzklausa2 = "SELECT EXISTS(SELECT 1 FROM `users` WHERE `userPassword` = '" + userPassword + "')";
                _rezultatas = super.vykdykVeiksma(uzklausa2);
                if (uzklausa2 == "1") {
                    System.out.println("Sekmingai prisijungta");
                    flag = false;
                } else {
                    System.out.println("Blogai ivestas slaptazodis");
                }
            } else {
                System.out.println("Tokio vartotojo vardo nerasta, bandykite dar karta");
            }
        }
        return true;
    }


    // ADMIN PRISIJUNGIMAS - be naujo admin ivedimo, tarkim tik bazej galim sukurti nauja

    public boolean adminPrisijungimas() {
        if(adminEsamoPrisijungimas()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean adminEsamoPrisijungimas() {
        boolean flag = true;
        while (flag) {
            System.out.println("Iveskite admin varda:");
            String adminName = sc.nextLine();
            System.out.println("Iveskite admin slaptazodi");
            String adminPassword = sc.nextLine();
            String uzklausa1 = "SELECT EXISTS(SELECT 1 FROM `admins` WHERE `adminName` = '" + adminName + "')";
            _rezultatas = super.vykdykVeiksma(uzklausa1);
            if (uzklausa1 == "1") {
                String uzklausa2 = "SELECT EXISTS(SELECT 1 FROM `admins` WHERE `adminPassword` = '" + adminPassword + "')";
                _rezultatas = super.vykdykVeiksma(uzklausa2);
                if (uzklausa2 == "1") {
                    System.out.println("Sekmingai prisijungta");
                    flag = false;
                } else {
                    System.out.println("Blogai ivestas slaptazodis");
                }
            } else {
                System.out.println("Tokio admin vardo nerasta, bandykite dar karta");
            }
        }
        return true;
    }

    public void userIvedimas() {
        System.out.println("Naujos keliones duomenu ivedimas");
        System.out.println();
        System.out.println("Pasirinkite 1, 2 ar 3 transporto priemone");
        int transportoNo = sc.nextInt();
        System.out.println("Datos uzklausimas");
        System.out.println("Irasykite metus");
        int metai = sc.nextInt();
        System.out.println("Irasykite menesi nuo 1 iki 12");
        int menesis = sc.nextInt();
        while(menesis <1 && menesis > 12) {
            System.out.println("Blogai irasete, pasirinkite menesi dar karta:");
            menesis = sc.nextInt();
        }
        int diena = sc.nextInt();
        while(menesis <1 && menesis > 12) {
            System.out.println("Blogai irasete, pasirinkite menesi dar karta:");
            diena = sc.nextInt();
        }

//
//        LocalDate localDate = LocalDate.of()
//
//        String uzklausa = "INSERT INTO `students`(`name`, `surname`, `phone`, `email`)" +
//                " VALUES('" + vardas + "','" + pavarde + "','" + telefonas + "','" + email + "')";
//        _rezultatas = super.vykdykVeiksma(uzklausa);

    }

    public void atvaizdavimas() {
        if (_rezultatas) {
            System.out.println("Pavyko irasyti");
        } else {
            System.out.println("Nepavyko irasyti");
        }
    }
}
