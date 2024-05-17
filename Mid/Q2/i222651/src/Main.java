package jdbcExample;

import java.sql.*;

/* Entities and Attributes:
Patients Table:
Attributes: patientId (primary key), name, age, contactInformation

Doctors Table:
Attributes: doctorId (primary key), name, specialization, contactInformation

Appointments Table:
Attributes: appointmentId (primary key), patientId (foreign key referencing Patients table), doctorId (foreign key referencing Doctors table), appointmentDate, appointmentTime, reasonForVisit

DoctorSchedule Table:
Attributes: scheduleID (primary key), doctorID (foreign key referencing Doctors table), day, schedule
*/

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/q2", user, password);
            System.out.println("Connected Successfully");

            statement = connection.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS Patients (patientId INT PRIMARY KEY, name VARCHAR(50), age INT, contactInformation VARCHAR(50))");
            statement.execute("CREATE TABLE IF NOT EXISTS Doctors (doctorId INT PRIMARY KEY, name VARCHAR(50), specialization VARCHAR(50), contactInformation VARCHAR(50))");
            statement.execute("CREATE TABLE IF NOT EXISTS Appointments (appointmentId INT PRIMARY KEY, patientId INT, doctorId INT, appointmentDate DATE, appointmentTime TIME, reasonForVisit VARCHAR(255), FOREIGN KEY (patientId) REFERENCES Patients(patientId), FOREIGN KEY (doctorId) REFERENCES Doctors(doctorId))");
            statement.execute("CREATE TABLE IF NOT EXISTS DoctorSchedule (scheduleId INT PRIMARY KEY, doctorId INT, day VARCHAR(20), schedule VARCHAR(255), FOREIGN KEY (doctorId) REFERENCES Doctors(doctorId))");


            statement.execute("INSERT INTO Patients (name, age, contactInformation) VALUES ('Will', 35, '+923001234567')");
            statement.execute("INSERT INTO Doctors (name, specialization, contactInformation) VALUES ('Dr. Lecter', 'Neurology', '+923007654321'), ('Dr. Bloom', 'Internal Medicine', '+923009876543')");
            statement.execute("INSERT INTO DoctorSchedule (doctorId, day, schedule) VALUES (1, 'Monday', '8:00 AM - 4:00 PM')");
            statement.execute("INSERT INTO DoctorSchedule (doctorId, day, schedule) VALUES (2, 'Wednesday', '10:00 AM - 6:00 PM')");

            statement.execute("INSERT INTO Appointments (patientId, doctorId, appointmentDate, appointmentTime, reasonForVisit) VALUES (1, 1, '2024-03-25', '08:00:00', 'Persistent headaches')");
            statement.executeUpdate("DELETE FROM Appointments WHERE patientId = 1");

            statement.executeUpdate("UPDATE Doctors SET contactInformation = '+923009513567' WHERE name = 'Dr. Bloom'");
            statement.executeUpdate("UPDATE DoctorSchedule SET schedule = '1:00 PM - 9:00 PM' WHERE doctorId = 2 AND Day = 'Wednesday'");

            statement.close();
            connection.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
