package Domain.Management;

import Services.Database.DB;

/**
 * Created by j200g on 24.04.2017.
 */
public class UserManager {
    private DB db;
    public UserManager(DB db){
        this.db=db;
    }

    public boolean login(String user, String pass){
        db.getUsers(/**/);
    }
}
