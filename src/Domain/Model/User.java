package Domain.Model;


public class User {
    private String group;
    private String login;
    private String password;
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public User(String group, String login, String password, Employee employee) {
        this.group = group;
        this.login = login;
        this.password = password;
        this.employee = employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
