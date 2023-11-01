package task03;

import java.util.Scanner;

class Bankdetail {
    User logInUser;
    User user[] = new User[100];
    String name, pass;
    int index = 0;
    static int accNo = 1870000891;
    double amtd, preTrans, amt;
    //double balance;
    Scanner scanner = new Scanner(System.in);
    User u = logInUser;

    public void menu2() {
        boolean c = true;
        int choice = 0;
        while (c) {
            System.out.println("\nWelcome, please proceed :");
            System.out.println("1. Create New Account");
            System.out.println("2. Log in existing user ");
            System.out.println("3. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("enter Name :");
                    name = scanner.next();
                    System.out.println("enter password :");
                    pass = scanner.next();
                    user[index++] = new User(name, pass, 0);
                    System.out.println("Account created Successfully" + "\nName : " + name + "\npass : " + pass + "\nAccount number Generated : " + accNo++);
                    break;
                case 2:
                    u = logInUser;
                    System.out.println("Enter Name :");
                    name = scanner.next();
                    System.out.println("Enter Password:");
                    pass = scanner.next();
                    boolean us = false;
                    for (int i = 0; i < index; i++) {
                        if (name.equals(user[i].getUserName()) && pass.equals(user[i].getUserPass())) {
                            System.out.println("Welcome " + name + " to MAHARASHTRA bank \nYour Login Successfully......!");
                            logInUser = user[i];
                            menu();
                            us = true;
                            break;
                        }
                    }
                    if (!us) {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Thank You \n   our services always with you.......");
                    c = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choose a valid option");
                    break;
            }
        }
    }

    public void deposite(double amount) {
        u = logInUser;
        if (amount > 0) {
            u.balance = amount + u.balance;
            preTrans = +amount;
            System.out.println("amount deposited to " + name + "'s account");
            System.out.println("your balance :" + u.getBalance());
        }
    }

    public void withdraw(double amount) {
        u = logInUser;
        if (amount > 0 && u.balance >= amount) {
            u.balance -= amount;
            preTrans = -amount;
            System.out.println("amount withdrawn successful");
            System.out.println("balance :" + u.balance);
        } else if (u.balance < amount) {
            System.out.println("Balance is Insufficient");
        }
    }

    public void transferMoney(User sender, User receiver, double amount) {
        u = sender;
        if (amount > 0 && sender != null && receiver != null) {
            if (amount <= sender.getBalance()) {
                u.balance = sender.getBalance() - amount;
                //u.balance=-(u.balance-preTrans);
                preTrans = -amount;

                // preTrans=receiver.getBalance()+amount;
                System.out.println("your balance is : " + u.balance);
                receiver.balance = amount + receiver.balance;
                System.out.println("transfer " + amount + " rs. Successful on " + receiver.UserName + "'s account from " + sender.UserName + "'s account");
            } else {
                System.out.println("Insufficient balance in sender's account");
            }
        } else {
            System.out.println("Invalid amount or sender/receiver information");
        }
    }

    public void preTrans() {
        u = logInUser;
        if (preTrans > 0) {
            System.out.println("Credited: " + preTrans + " rs.");
        } else if (preTrans < 0) {
            System.out.println("Debited: " + (-preTrans) + " rs.");
        } else {
            System.out.println("No previous transaction found.");
        }
    }

    public void menu() {
        u = logInUser;
        char option;
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        while (b) {
            System.out.println("\nchoose Transaction option");
            System.out.println("1) check balance");
            System.out.println("2) withdraw money");
            System.out.println("3) Deposit money");
            System.out.println("4) transfer money");
            System.out.println("5) Previous Transaction");
            System.out.println("6) exit");

            System.out.println("Choose option");
            option = sc.next().charAt(0);

            switch (option) {
                case '1':
                    u = logInUser;
                    System.out.println("Account Balance:" + u.getBalance());
                    System.out.println();
                    break;
                case '2':
                    System.out.println("Enter the amount :");
                    amt = sc.nextDouble();
                    withdraw(amt);
                    System.out.println();
                    break;
                case '3':
                    System.out.println("Enter the amount :");
                    amtd = sc.nextDouble();
                    deposite(amtd);
                    System.out.println();
                    break;
                case '4':
                    System.out.println("Enter sender's name: ");
                    String senderName = scanner.next();
                    System.out.println("Enter sender's password: ");
                    String senderPass = scanner.next();
                    System.out.println("Enter receiver's name: ");
                    String receiverName = scanner.next();
                    System.out.println("Enter amount to transfer: ");
                    double transferAmt = scanner.nextDouble();
                    User sender = null;
                    User receiver = null;
                    for (int i = 0; i < index; i++) {
                        if (senderName.equals(user[i].getUserName()) && senderPass.equals(user[i].getUserPass())) {
                            sender = user[i];
                        }
                        if (receiverName.equals(user[i].getUserName())) {
                            receiver = user[i];
                        }
                    }
                    transferMoney(sender, receiver, transferAmt);
                    break;
                case '5':
                    preTrans();
                    break;
                case '6':
                    b = false;
                    menu2();
                    break;
                default:
                    System.out.println(" choose other option");
                    break;
            }
        }
    }
}