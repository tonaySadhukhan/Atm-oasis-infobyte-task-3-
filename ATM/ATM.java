package Atm;

import java.util.Scanner;
import java .util.ArrayList;
import java.time.LocalDate;
import java.util.Formatter;

public class ATM {
    static ArrayList<String[]> arr=new ArrayList<>();
    static String id="233 784 1234";
   static int pin=4567;
  static   int currentBal=0;
static Scanner sc=new Scanner(System.in);

protected ATM(){
    try {
        Interface();
    }catch (Exception e){
        System.out.println(e);
    }
}
    private static void Interface() throws Exception {
        int i=0;
        System.out.println("**********......Welcome to SBT ATM......***********");
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your id");
        String id=sc.nextLine();
        System.out.println("Enter your pin");
        int pin=sc.nextInt();
        System.out.println("Confirm? y/n");
        String m=sc.next();
        if(m.equals("y")) {
            if (ATM.id.equals(id) && ATM.pin == pin) {
                while (i != 5) {
                    System.out.println("1.Tranction History\n2.Withdraw\n3.Deposite\n4.Transfer\n5.Quit");
                    System.out.println("Enter your choice:");
                    i = sc.nextInt();

                    if (i == 1) {
                        tranctionHistory();
                    } else if (i == 2) {
                        Withdraw();

                    } else if (i == 3) {
                        Deposite();
                    } else if (i == 4) {
                        Transfer();
                    }
                }
                System.out.println("Thanks for using us");
            } else {
                System.out.println("Wrong ID or Pin please Re-enter");
               Interface();
            }
        }
        else{
            Interface();
        }
    }
   private static void tranctionHistory() throws Exception{
        Formatter fm=new Formatter();
        fm.format("%15s%22s%15s%15s%15s%20s\n","Date","Initial Balance","Withdraw","Deposite","Transfer","Cutrrent Balance");
       // System.out.println("Date     "+"Initial balance    "+"Withdraw    "+"Deposite    "+"Current balance    ");
        for(int i=0;i<arr.size(); i++) {
            String[] a=arr.get(i);
           fm.format("%18s%15s%15s%15s%15s%15s\n",a[0],a[1],a[2],a[3],a[4],a[5]);

        }
        System.out.println(fm);
    }
   private static void Withdraw() {
       System.out.println("Enter amount");
       int a = sc.nextInt();
       System.out.println("Confirm? y/n");
       String m = sc.next();
       if (m.equals("y")){
           if (currentBal <= a)
               System.out.println("There is not enough balance");
           else {
               int k = currentBal;
               currentBal = currentBal - a;
               System.out.println("withdrawl successful..");
               System.out.println("your current balance " + currentBal+"/-");
               String[] th = new String[6];
               th[0] = date().toString();
               th[1] = Integer.toString(k);
               th[2] = Integer.toString(a);
               th[3] = "-";
               th[4]="-";
               th[5] = Integer.toString(currentBal);

               arr.add(th);
           }
   }
       else{
           Withdraw();
       }

   }
    private static void Deposite(){
        System.out.println("Enter amount to be deposite");
        int a=sc.nextInt();
        System.out.println("Confirm? y/n");
        String m=sc.next();
        if(m.equals("y")) {
            int k = currentBal;
            currentBal = currentBal + a;
            System.out.println("Amount deposited");
            System.out.println("Current Balance"+currentBal+"/-");
            String[] th = new String[6];
            th[0] = date().toString();
            th[1] = Integer.toString(k);
            th[2] = "";
            th[3] = Integer.toString(a);
            th[4]="-";
            th[5] = Integer.toString(currentBal);

            arr.add(th);
        }
        else{
            Deposite();
        }
    }
   private static void Transfer() {
        System.out.println("Enter the mode of transfer");
        System.out.println("1.Domestic Account\n2.Card to Card");
        int m = sc.nextInt();

        if (m == 1) {
            System.out.println("Enter a/c number of reciever");
            String a = sc.next();
        } else {
            System.out.println("Eneter the card number of the reciever");
            String a = sc.next();
        }
        System.out.println("Confirm? y/n");
        String xy = sc.next();
        if (xy.equals("y")) {
            System.out.println("Enter amount");
            int amt = sc.nextInt();
            if (amt >= currentBal) {
                System.out.println("No enough balance");
            }
            int p = currentBal;
            currentBal = currentBal - amt;
            System.out.println("Transfer successful");
            String[] th = new String[6];
            th[0] = date().toString();
            th[1] = Integer.toString(p);
            th[2] = "-";
            th[3] = "-";
            th[4] = Integer.toString(amt);
            th[5] = Integer.toString(currentBal);

            arr.add(th);
        } else {
            Transfer();
        }

        }



    protected static LocalDate date(){
       LocalDate ld= LocalDate.now();
       return ld;

    }
}

