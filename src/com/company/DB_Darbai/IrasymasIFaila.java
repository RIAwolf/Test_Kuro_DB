package com.company.DB_Darbai;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * Created by PauliusJ on 2017.06.01.
 */
public class IrasymasIFaila extends JDBC_Communication {

    private ResultSet _rezultatai;

    public IrasymasIFaila() {
        paklausimas();
        irasymasIFaila();
        atvaizdavimas();
    }

    private String _failoVardas;
    private Scanner _sc = new Scanner(System.in);
    private FileWriter _out = null;
    private boolean _arPavyko;


    public void paklausimas() {
        System.out.println("Iveskite naujo failo pavadinimą sukurimui");
        _failoVardas = _sc.nextLine();
        try{
            _out = new FileWriter(_failoVardas);
            String uzklausa = "SELECT * FROM `students`;";
            _rezultatai = super.vykdykUzklausa(uzklausa);

        }catch(Exception e){
            e.getMessage();
        }


    }

    public void irasymasIFaila() {
        try {
            _out = new FileWriter(_failoVardas);
            while (_rezultatai.next()) {
                String tekstas = _rezultatai.getString("name")+" ";
                tekstas+=_rezultatai.getString("surname")+" ";
                tekstas+=_rezultatai.getString("email")+" ";
                tekstas+=_rezultatai.getString("phone")+"";
                _out.write(tekstas);
                _out.write('\n');

            }
            _out.close();
            _arPavyko = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void atvaizdavimas(){
        if(_arPavyko){
            System.out.println("Viskas OK");
        }else{
            System.out.println("Crap");
        }

    }
}


