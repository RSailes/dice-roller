import java.util.*;

public class DiceRoller 
{
    private String userIn;
    private int userRolls;
    private int dieType;
    private int currRoll;
    private int rollTotal;

    public void setDie(Scanner scnr) {
        System.out.print("Die Type: ");
        userIn = scnr.next();
    }

    public boolean checkDie () {
        if (userIn.equalsIgnoreCase("d20")) {
            dieType = 20;
            return true;
        }
        else if (userIn.equalsIgnoreCase("d12")) {
            dieType = 12;
            return true;
        }
        else if (userIn.equalsIgnoreCase("d10")) {
            dieType = 10;
            return true;
        }
        else if (userIn.equalsIgnoreCase("d8")) {
            dieType = 8;
            return true;
        }
        else if (userIn.equalsIgnoreCase("d6")) {
            dieType = 6;
            return true;
        }
        else if (userIn.equalsIgnoreCase("d4")) {
            dieType = 4;
            return true;
        }
        else {
            rightDieFormat();
            userIn = "DXX";
            return false;
        }
    }

    public void setRolls(Scanner scnr) {
        System.out.print("Roll Number: ");
        userRolls = scnr.nextInt();
    }

    public void diceRoll(Random rand) {
        rollTotal = 0;
        System.out.println("\nRolling die...");
        switch (dieType) {
            case 20:
            for (int i = userRolls; i > 0; --i) {
                currRoll = rand.nextInt(20) + 1;
                rollTotal += currRoll;
                System.out.println(currRoll);
            }
            break;

            case 12:
            for (int i = userRolls; i > 0; --i) {
                currRoll = rand.nextInt(12) + 1;
                rollTotal += currRoll;
                System.out.println(currRoll);
            }
            break;

            case 10: 
            for (int i = userRolls; i > 0; --i) {
                currRoll = rand.nextInt(10) + 1;
                rollTotal += currRoll;
                System.out.println(currRoll);
            }
            break;

            case 8:
            for (int i = userRolls; i > 0; --i) {
                currRoll = rand.nextInt(8) + 1;
                rollTotal += currRoll;
                System.out.println(currRoll);
            }
            break;

            case 6:
            for (int i = userRolls; i > 0; --i) {
                currRoll = rand.nextInt(6) + 1;
                rollTotal += currRoll;
                System.out.println(currRoll);
            }
            break;

            case 4:
            for (int i = userRolls; i > 0; --i) {
                currRoll = rand.nextInt(4) + 1;
                rollTotal += currRoll;
                System.out.println(currRoll);
            }
            break;

            default:
            currRoll = 0;
            rollTotal = 0;
            break;
        }
    }
    
    public int getRollTotal() {
        return rollTotal;
    }

    public static void rightDieFormat() {
        System.out.println("\nInvalid input. Please enter a valid die type.");
        System.out.println("Valid Die Types:\nD20, D12, D10, D8, D6, D4 [not case sensitive]");
        System.out.println("If you'd like more die types to be added, contact Roman directly.");
        System.out.println("----------------------->\n");    
    }

    public static void menu() {
        System.out.println("\n1. Set your die");
        System.out.println("2. Set your roll number");
        System.out.println("3. Roll your die");
        System.out.println("4. Get roll total");
        System.out.println("5. Exit program\n");
    }
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        boolean continueRolls = true;        

        // First time roll setup
        System.out.println("\nWelcome to Roman's D&D Dice Roller!\n" 
							+ "\nTo use this roller, first enter your die type. (Ex: D20, D12, etc.)"
							+ "\nNext, enter how many rolls you need."
							+ "\nFinally, choose an option from the program's menu when prompted.\n");
		System.out.println("-------------------------------------------------------------------------->");
        
        DiceRoller roll = new DiceRoller();
        roll.setDie(scnr);
        boolean rightDie = roll.checkDie();
        if(rightDie) {
            roll.setRolls(scnr);
            roll.diceRoll(rand);
        } 

        // Loop to continue the program until user wants to exit the program
        do {
            menu();
            System.out.print("Enter your choice: ");
            int choice = scnr.nextInt();
            switch (choice){
                case 1:
                roll.setDie(scnr);
                rightDie = roll.checkDie();
                while (!rightDie) {
                    roll.setDie(scnr);
                    rightDie = roll.checkDie();
                }
                break;

                case 2:
                roll.setRolls(scnr);
                break;
                
                case 3:
                roll.diceRoll(rand);
                break;
                
                case 4:
                System.out.println(roll.getRollTotal());
                break;

                case 5:
                continueRolls = false;
                break;

                default:
                System.out.println("Invalid number entered.\nPlease enter a number option from the menu.\n");
                break;
            }
        } while (continueRolls);

        System.out.println("Thank you for using my dice roller!!");
        scnr.close();

    }
}
