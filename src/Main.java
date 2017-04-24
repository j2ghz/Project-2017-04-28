import Services.Database.DB;
import UI.Swing.MainFrame;

public class Main {
    private static DB db;

    public static void main(String[] args) {
        try{
            db=new DB("sa","123456", "1433","localhost");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Connecting to database was no successful");
            System.out.println("Exiting");
            return;
        }
        MainFrame f = new MainFrame();
    }
}
