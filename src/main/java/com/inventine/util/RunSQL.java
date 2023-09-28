package com.inventine.util;

import com.inventine.conf.DBManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RunSQL {

    public static void main(String[] args) throws SQLException {

        Connection conn = DBManager.getConnection();
        Statement stmt = conn.createStatement();
        RunSQL runner = new RunSQL();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter sql file name: ");
        String filename = scan.nextLine();
        stmt.executeUpdate(runner.read(filename));

        System.out.println("Query exected successfully!");

    }

    public String read(String filename){

        String query = "";

        try {
            File myObj = new File("sql/"+filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if(line == "" || Character.compare(line.charAt(0),'#') == 0){
                    continue;
                }
                query += line;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("SQL file not found in a given path!");
            e.printStackTrace();
        }

        return query;

    }

}
