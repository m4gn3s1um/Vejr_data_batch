import microsoft.sql.DateTimeOffset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class ReadFile {

    public void ReadFileMethod() throws IOException, SQLException {

        try {Connection connection = DatabaseConnection.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Måling VALUES (?,?,?,?,?,?,?,?,?,?,?,?);");
            connection.setAutoCommit(false);
            Scanner sc = new Scanner(new File("C:/Users/MadMe/IdeaProjects/untitled3/src/USE THIS.csv"));
            sc.useDelimiter("[;\n]");

            while (sc.hasNext()) {
                /*System.out.println("1: " + sc.next());
                System.out.println("2: " + sc.next());
                System.out.println("3: " + sc.next());
                System.out.println("4: " + sc.next());
                System.out.println("5: " + sc.next());
                System.out.println("6: " + sc.next());
                System.out.println("7: " + sc.next());
                System.out.println("8: " + sc.next());
                System.out.println("9: " + sc.next());
                System.out.println("10: " + sc.next());
                System.out.println("11: " + sc.next());
                System.out.println("12: " + sc.next());*/

                pstmt.setString(1, sc.next());
                pstmt.setString(2, sc.next());
                pstmt.setString(3, sc.next());
                pstmt.setString(4, sc.next());
                pstmt.setString(5, sc.next());
                pstmt.setString(6, sc.next());
                pstmt.setString(7, sc.next());
                pstmt.setString(8, sc.next());
                pstmt.setString(9, sc.next());
                pstmt.setString(10, sc.next());
                pstmt.setString(11, sc.next());
                pstmt.setString(12, sc.next());

                pstmt.addBatch();
            }
            sc.close();
            pstmt.executeBatch();
            connection.commit();
            System.out.println("Data was inserted succesfully");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}