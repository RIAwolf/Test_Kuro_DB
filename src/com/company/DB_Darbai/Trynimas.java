package com.company.DB_Darbai;

import java.util.Scanner;

/**
 * Created by PauliusJ on 2017.05.31.
 */
public class Trynimas extends JDBC_Communication {
    // pasisveikinimas
    // ivesti studento id
    // trinti pagal id
    private boolean _rezultatas = false;

    public Trynimas() {
        pasisveikinimas();
        vykdymas();
        atvaizdavimas();
    }

    public void pasisveikinimas() {
        System.out.println("Iveskite studento numeri");

    }

    public void vykdymas() {
        Scanner sc = new Scanner(System.in);
        int studento_id = sc.nextInt();
        String uzklausa = "DELETE FROM `students` WHERE `students`.`id` = " + studento_id + ";";
        super.vykdykVeiksma(uzklausa);
    }

    public void atvaizdavimas() {
        if (_rezultatas == false) {
            System.out.println("Pavyko istrinti");
        } else {
            System.out.println("Nepavyko istrinti");
        }
    }

}
