package com.company.DB_Darbai;

import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by PauliusJ on 2017.05.31.
 */
public class Ivedimas extends JDBC_Communication {

    // pasisveikinimas
    // parasyti ko reikia
    // susirinkti is vartotojo su Scanner
    // Irasyti i db su INSERT

    String vardas;
    String pavarde;
    String telefonas;
    String email;
    private boolean _rezultatas;

    public void pasisveikinimas() {

        System.out.println("Iveskite studento duomenis, jie bus issaugoti duombazeje");

    }

    public void vykdymas() {
        // INSERT INTO table_name
        // VALUES (value1, value2, value3, ...);
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite studento varda");
        vardas = sc.nextLine();
        System.out.println("Iveskite studento pavarde");
        pavarde = sc.nextLine();
        System.out.println("Iveskite studento telefona");
        telefonas = sc.nextLine();
        System.out.println("Iveskite studento email");
        email = sc.nextLine();

        String uzklausa = "INSERT INTO `students`(`name`, `surname`, `phone`, `email`)" +
                " VALUES('" + vardas + "','" + pavarde + "','" + telefonas + "','" + email + "')";
        _rezultatas = super.vykdykVeiksma(uzklausa);
    }

    public void atvaizdavimas() {
        if (_rezultatas) {
            System.out.println("Pavyko irasyti");
        } else {
            System.out.println("Nepavyko irasyti");
        }
    }
}
