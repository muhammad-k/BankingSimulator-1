package bank;

import sqliteDatabase.SQLiteDatabase;

public class Bank {
    private SQLiteDatabase sqliteDatabase;
    private static int BANK_FUNDS = 1000000;
    //Operation Times
    //Days Open

    //public void Bank()
    public Bank (SQLiteDatabase sqliteDatabase){
        this.sqliteDatabase = sqliteDatabase;
    }

    //This method will create our database in the local folder
    public void connectToDatabase(){

//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter checking account ID: ");
//        checkingAccountID = scan.nextInt();
//        System.out.println("Enter checking balance: ");
//        checkingBalance = scan.nextDouble();

        sqliteDatabase.connect();
        sqliteDatabase.createsNewCheckingAccountTable();
        sqliteDatabase.createsNewUserAccountsTable();
        sqliteDatabase.createsNewTransactionsTable();
        sqliteDatabase.createsNewSavingsAccount();
        sqliteDatabase.createsNewAvailableFundsTable();
        sqliteDatabase.insertIntoAvailableFunds(BANK_FUNDS);
//        database.insertIntoCheckingAccount(checkingAccountID,checkingBalance);
    }

}