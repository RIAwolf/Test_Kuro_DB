package com.company.DB_Darbai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by PauliusJ on 2017.06.01.
 */
public class NuskaitymasIsFailo extends JDBC_Communication {

    public NuskaitymasIsFailo() {
        paklausimas();
        atidarytiFaila();
        skaitymasIsFailoIBaze();
        atvaizdavimas();
    }

    private String _failoVardas;
    private Scanner _sc = new Scanner(System.in);
    private FileReader _in = null;
    private BufferedReader _bufferis;
    public String eilute;
    private boolean _rezultatas;


    public void paklausimas() {
        System.out.println("Iveskite failo pavadinimą is kurio norite skaityti");
        _failoVardas = _sc.nextLine();
    }

    public void atidarytiFaila() {
        try {
            _in = new FileReader(_failoVardas);
            _bufferis = new BufferedReader(_in);
        } catch (Exception e) {

        }
    }

    public void skaitymasIsFailoIBaze() {
        try {
            eilute = _bufferis.readLine();
            while (eilute != null) {
                String[] zodziai = eilute.split(" ");
                String uzklausa = "INSERT INTO `students`(`name`, `surname`, `phone`, `email`)" +
                        " VALUES('" + zodziai[0] + "','" + zodziai[1] + "','" + zodziai[2] + "','" + zodziai[3] + "')";
                _rezultatas = super.vykdykVeiksma(uzklausa);
                eilute = _bufferis.readLine();
            }

            _bufferis.close();
            _in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void atvaizdavimas() {
        if (_rezultatas) {
            System.out.println("Pavyko irasyti");
        } else {
            System.out.println("Nepavyko irasyti");
        }
    }
}





