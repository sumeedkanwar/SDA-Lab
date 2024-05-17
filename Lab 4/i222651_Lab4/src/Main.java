import java.io.*;
import java.sql.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
     File file = new File("data.txt");
     try{
         BufferedWriter writer = new BufferedWriter(new FileWriter(file));

         writer.write("Sumeed Jawad Kanwar");
         writer.newLine();
         writer.write("20/08/2003");
         writer.newLine();
         writer.write("Islamabad, Pakistan");
         writer.newLine();
         writer.write("CGPA: " + 4);
         writer.newLine();
         writer.write("22i-2651");
         writer.newLine();
         writer.close();
     }
     catch(IOException e){
         e.printStackTrace();
     }

     try{
         BufferedReader reader = new BufferedReader(new FileReader(file));

         String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
     }
     catch(IOException e){
         e.printStackTrace();
     }


     Connection myconn = null;
     Statement mystmt = null;
     ResultSet myRs = null;
        try{
            myconn = DriverManager.getConnection("jdbc:mysql://localhost:3306/task2","root","root");
            System.out.println("Database Connection Successful");
            mystmt = myconn.createStatement();
            String createTable = "CREATE TABLE IF NOT EXISTS student (id INT PRIMARY KEY, name VARCHAR(255), age INT, grade VARCHAR(255))";
            mystmt.executeUpdate(createTable);
            System.out.println("Table Created Successfully");
            String insertData = "INSERT INTO student (id, name, age, grade) VALUES (1, 'Sumeed', 20, 'A')";
            mystmt.executeUpdate(insertData);
            insertData = "INSERT INTO student (id, name, age, grade) VALUES (2, 'Rafay', 20, 'A')";
            mystmt.executeUpdate(insertData);
            insertData = "INSERT INTO student (id, name, age, grade) VALUES (3, 'Huziafa', 19, 'A')";
            mystmt.executeUpdate(insertData);
            System.out.println("Data Inserted Successfully");
            String showData = "SELECT * FROM student";
            myRs = mystmt.executeQuery(showData);
            while(myRs.next()){
                System.out.println(myRs.getString("name") + ", " + myRs.getInt("age") + ", " + myRs.getString("grade"));
            }
            String deleteData = "DELETE FROM student WHERE id = 3";
            mystmt.executeUpdate(deleteData);
            System.out.println("Data Deleted Successfully");
            showData = "SELECT * FROM student";
            myRs = mystmt.executeQuery(showData);
            while(myRs.next()){
                System.out.println(myRs.getString("name") + ", " + myRs.getInt("age") + ", " + myRs.getString("grade"));
            }
            String updateData = "UPDATE student SET grade = 'B' WHERE id = 2";
            mystmt.executeUpdate(updateData);
            System.out.println("Data Updated Successfully");
            showData = "SELECT * FROM student";
            myRs = mystmt.executeQuery(showData);
            while(myRs.next()) {
                System.out.println(myRs.getString("name") + ", " + myRs.getInt("age") + ", " + myRs.getString("grade"));
            }
            mystmt.close();
            myconn.close();
            myRs.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}