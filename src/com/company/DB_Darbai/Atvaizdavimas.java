package com.company.DB_Darbai;

import java.sql.ResultSet;

/**
 * Created by PauliusJ on 2017.05.31.
 */
public class Atvaizdavimas extends JDBC_Communication {
    // pasisveikinimas
    // pasiimti visa lentele
    // atvaizduoti
    private ResultSet _rezultatai;

    public Atvaizdavimas() {
        pasisveikinimas();
        vykdymas();
        atvaizdavimas();
    }

    public void pasisveikinimas() {
        System.out.println("Visi studentai kiek yra:");

    }

    public void vykdymas() {
        String uzklausa = "SELECT * FROM `students`;";
        _rezultatai = super.vykdykUzklausa(uzklausa);
    }

    public void atvaizdavimas() {
        try {
            super.spausdinkLentele(_rezultatai);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}