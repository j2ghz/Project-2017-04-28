package Domain.Management;

import Domain.Model.User;
import Services.Database.DB;


public class UserManager {
    private final DB db;
    public User currentUser = null;

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
