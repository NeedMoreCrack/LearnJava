package poker;

public class Users {
    private String account;
    private String password;
    private int errorCount;

    Users(){}

    public Users(String account, String password, int errorCount) {
        this.account = account;
        this.password = password;
        this.errorCount = errorCount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(int errorCount) {
        this.errorCount = errorCount;
    }

    @Override
    public String toString() {
        return "Users{" +
            "account='" + account + '\'' +
            ", password='" + password + '\'' +
            ", errorCount='" + errorCount + '\'' +
            '}';
    }
}
