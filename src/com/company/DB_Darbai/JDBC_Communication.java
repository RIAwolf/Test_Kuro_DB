package com.company.DB_Darbai;

import java.sql.*;

/**
 * Created by PauliusJ on 2017.05.31.
 */
public class JDBC_Communication {

    private Connection _connection;

    public JDBC_Communication() {
        try {
            _connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdatadog", "root", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ResultSet vykdykUzklausa(String uzklausa) {
        try {
            Statement statement = _connection.createStatement(); // teiginys kuriuo kreipsis i DB
            return statement.executeQuery(uzklausa);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }



    public boolean vykdykVeiksma(String uzklausa) {
        try {
            Statement statement = _connection.createStatement();
            statement.execute(uzklausa); // insert, delete, update tuo skiriasi nuo executeQuery
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }



    public void spausdinkLentele(ResultSet _rezultatai) {
        try {
            ResultSetMetaData lentelesAprasymas = _rezultatai.getMetaData();// metadata duomenys apie duomenis
            int kiekis = lentelesAprasymas.getColumnCount();// stulpeliu kiekis
            String[] stulpeliuVardai = new String[kiekis];
            for (int i = 1; i <= kiekis; i++) { // sitas for pravaro ir suraso stulpeliu pavadinimus
                stulpeliuVardai[i - 1] = lentelesAprasymas.getColumnName(i);
                System.out.print(stulpeliuVardai[i - 1] + " ");
            }
            System.out.println("");
            while (_rezultatai.next()) {// tikrina kol yra duomenu
                for (int i = 0; i < kiekis; i++) {// sitas for suraso duomenis pagal stulpelius persokdamas gale i vis nauja eilute
                    System.out.print(_rezultatai.getString(stulpeliuVardai[i]));
                    System.out.print(" ");
                }
                System.out.println("");
            }

        } catch (Exception e) {

        }
    }

}

