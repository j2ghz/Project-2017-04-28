import Domain.Management.Administration;
import Domain.Management.UserManager;
import Domain.Reservation.ReservationManager;
import Services.Database.DB;
import UI.Swing.LoginUI;

public class Main {

    public static void main(String[] args) {
        System.out.println("Connecting to database");
        DB db;
        try {
            db = new DB("sa", "123456789", "1434", "localhost");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Connecting to database was not successful");
            System.err.println("Exiting");
            return;
        }
        System.out.println("Connected");
        System.out.println("Creating Managers");
        UserManager um = new UserManager(db);
        ReservationManager rm = new ReservationManager(db);
        Administration adm = new Administration(db);
        System.out.println("Starting login");
        LoginUI.main(rm, um, adm);
        System.out.println("Goodbye");
    }
}
