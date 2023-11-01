package task03;

class User{
    String UserName;
    String userPass;
    double balance;


    public String getUserName() {
        return UserName;
    }
    public String getUserPass() {
        return userPass;
    }
    public double getBalance() {
        return balance;
    }


    public User(String userName, String userPass,double balance) {//
        this.UserName = userName;
        this.userPass = userPass;
        this.balance=balance;
    }
}