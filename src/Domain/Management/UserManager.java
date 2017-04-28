package Domain.Management;

import Domain.Model.User;
import Services.Database.DB;

import java.text.DateFormat;


public class UserManager {
    public User currentUser = null;
    private DB db;

    public UserManager(DB db) {
        this.db = db;
    }

    public boolean login(String user, String pass) {
        currentUser = db.getUser(user);
        return currentUser != null;
    }

    public void logout() {
        currentUser = null;
    }

}
