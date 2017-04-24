import Services.Database.DB;
import UI.Swing.MainFrame;

public class Main {
    private static DB db;

    public static void main(String[] args) {
        System.out.println("Connecting to database");
        try{
            db=new DB("sa","123456", "1432","localhost");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Connecting to database was no successful");
            System.out.println("Exiting");
            return;
        }
        System.out.println("Connected");

        MainFrame f = new MainFrame();
    }
}
