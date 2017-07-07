package com.company.DB_Darbai;

import java.sql.ResultSet;

/**
 * Created by PauliusJ on 2017.05.31.
 */
public class Atvaizdavimas extends JDBC_Communication {

    // user ir admin uzklausu vykdymas ir atvaizdavimas

    private ResultSet _rezultatai;
    public String uzklausa;

    public void adminUzklausa() {
        while(true) {
            System.out.println("Pasirinkite transporto id");
        }

    }




    public void vykdymas() {
        String uzklausa = "SELECT * FROM `students`;";
        _rezultatai = super.vykdykUzklausa(uzklausa);
        try {
            super.spausdinkLentele(_rezultatai);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
//    SELECT `students`.*
//    FROM ((`students`
//            INNER JOIN `student_address` ON `students`.`id` = `student_address`.`student_id`)
//    INNER JOIN `student_marks` ON `student_address`.`student_id` = `student_marks`.`student_id`)
//    WHERE `students`.`surname` LIKE '%as'
//    AND `student_address`.`city` = 'Kaunas'




}