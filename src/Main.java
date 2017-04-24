import Domain.Management.UserManager;
import Services.Database.DB;
import UI.Swing.LoginUI;
import UI.Swing.MainFrame;

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

        UserManager userManager = new UserManager(db);

        MainFrame f = new MainFrame();

        LoginUI loginUI = new LoginUI(f);
        loginUI.setVisible(true);
        //if login bad exit

    }
}
