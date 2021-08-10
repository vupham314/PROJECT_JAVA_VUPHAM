package VU_INFORMATION;

public abstract class Account {

    protected final String nameLog;
    protected String password;
    protected final String email;
    protected Information information;

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public Account(String nameLog, String password, String email) {
        this.nameLog = nameLog;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return  information.toString();
    }

    public String getNameLog() {
        return nameLog;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

}
