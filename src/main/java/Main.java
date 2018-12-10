import BankOfficers.FinancialAdvisor;
import BankOfficers.Teller;
import Customer.Customer;
import org.joda.time.*;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    private static final int EXIT = 0;
    private static final int TELLER = 1;
    private static final int FINANCIAL_ADVISOR = 2;
    //we might need to have other classes access these data types
    protected static String CUSTOMER_NAME = null;
    protected static String CUSTOMER_DOB = null;

    public static void main(String args[]) throws ParseException {
        int selection = 0;
        Bank bank = new Bank();
        Teller teller = new Teller();
        FinancialAdvisor financialAdvisor = new FinancialAdvisor();
        Customer customer = new Customer();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        LocalDate todaysDate = new LocalDate();
        DateTime firstDate = new DateTime(1996, 4, 9, 0, 0);
        DateTime secondDate = new DateTime();
        Scanner scanner = new Scanner(System.in);
        secondDate.getChronology();

        LocalDateTime currentTime = new LocalDateTime();



        Period period = new Period(firstDate, secondDate);
//        System.out.println(currentTime);
//        System.out.println(secondDate.getDayOfMonth());
//        System.out.println(period.getYears());
        bank.connectToDatabase();
        CUSTOMER_NAME = customer.setCustomerName(scanner);
        CUSTOMER_DOB = customer.setCustomerDOB(scanner,dateFormat);
        selection = displayMenu(scanner);

        switch (selection) {
            case TELLER:
                teller.displayTellerMenu(scanner, CUSTOMER_NAME);
            case FINANCIAL_ADVISOR:
                financialAdvisor.displayFinancialAdvisorMenu(scanner,CUSTOMER_NAME);
                break;
            default:
                System.out.println("oops something went wrong!");
                break;
        }



    }

    //display main menu when user enters the bank
    public static int displayMenu(Scanner scanner){
        int selection = 0;
        boolean validEntry = true;

        do {
            //user is prompted to visit the teller or financial advisor
            System.out.println("Welcome, " + CUSTOMER_NAME + ", to CSI bank simulator.");
            System.out.println("----------------------------------------");
            System.out.println("Please make a selection from the menu:");
            System.out.println("1. Go to teller.");
            System.out.println("2. Go to financial advisor.");
            System.out.println("3. Exit simulator.");
            System.out.println("----------------------------------------");
            System.out.println();
            try {
                selection = scanner.nextInt();
            } catch (Exception e) {
                selection = EXIT;
            }
            scanner.nextLine(); // Clear the input buffer of the extra new line
            System.out.println();
            if(selection > 3 || selection < 1){
                System.out.println("Invalid entry, try again.");
                System.out.println();
                validEntry = false;
            }
            else
                validEntry = true;

        }while(!validEntry);
        return selection;
    }




}
