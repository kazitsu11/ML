package demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.FileWriter;

public class std {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/Kshitij";
        String user = "root";
        String password = "123456789";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, password);

            Statement stmt = con.createStatement();

            String query = "SELECT * FROM student";
            ResultSet rs = stmt.executeQuery(query);

            // --- PRINT (your existing console output) ---
            System.out.println("Roll No\tName\t\tMarks");
            System.out.println("--------------------------------------");

            // --- CREATE CSV FILE ---
            FileWriter csv = new FileWriter("students.csv");

            // Write header in CSV
            csv.append("roll_no,name,marks\n");

            // --- READ DATA AND SAVE TO CSV ---
            while (rs.next()) {
                int rollNo = rs.getInt("roll_no");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");

                // Print to console
                System.out.printf("%d\t%-20s\t%d\n", rollNo, name, marks);

                // Write to CSV
                csv.append(rollNo + "," + name + "," + marks + "\n");
            }

            // Close CSV file
            csv.flush();
            csv.close();
            System.out.println("\nCSV File Created Successfully: students.csv");

            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
