//package assignment2_000123456;
/*
*This code uses JOptionPane to show a dialog that welcomes the user to Parrot Craft game
*It also simulates a simple parrot game where user can choose to feed, hit, or play with a parrot. 
*The parrot's state such as health, tamed, crackercrumbs, and number of hearts are affected by the user's actions. 
*The main method of the ParrotCraft class is where the user can interact with the parrot by calling different methods of the Parrot class.
*The user can also exit the game at any time.
 */

/**
 *
 * @author User
 */
import java.util.Scanner;
import javax.swing.JOptionPane;

// Parrot class
class Parrot {
    // name of the parrot
    private String nameOfParrot;
    //health of the parrot
    private int health;
    // no of hearts the parrot has
    private int hearts;
    // amount of cracker crumbs 
    private double crackercrumbs;
    // parrot is tamed or untamed 
    private boolean tamed;
    // parrot is dead or alive 
    private boolean dead;
    // parrot is flying or sitting
    private boolean flying;
    
        // constructor for parrot class
    public Parrot() {
        nameOfParrot = "Willis";
        health = 3;
        crackercrumbs = 0.1;
        tamed = false;
        flying = true;
    }

    // This method increases the parrot's hearts and crackercrumbs
    public void feed(double amount) {
        this.crackercrumbs += amount;
        this.hearts++;
        if (this.hearts > 3) {
            this.hearts = 3;
        }
        // Checks if the parrot is getting sick
        if (this.crackercrumbs >= 2.5) {
            this.hearts -= 2;
            if (this.hearts <= 0) {
                this.dead = true;
            }
        }
        // Checking if the parrot gets tamed
        double chance = 20 * this.crackercrumbs;
        if (chance >= Math.random() * 100) {
            this.tamed = true;
        }
    }

    // Stay Method for making the parrot to sit
    public void sit() {
        if (tamed) {
            flying = false;
        }
    }

    // Method for making the parrot to fly
    public void fly() {
        if (tamed) {
            flying = true;
        }
    }

    // play with another parrot and untame them both
    public void play(Parrot parrot) {
        if (tamed && parrot.isTamed()) {
            tamed = false;
            parrot.untame();
        }
    }

    //Method for hitting the parrot
    public void hit() {
        health--;
        if (health <= 0) {
            health = 0;
        }
        tamed = false;
    }

    //Method to check if the parrot is dead or alive
    public boolean isDead() {
        return health <= 0;
    }
    
    //Method to get the number of crackercrumbs for the parrots
    public double getCrackerCrumbs() {
    return this.crackercrumbs;
    }
    
    //Method to get the number of hearts for the parrots
    public int getNoOfHearts(){
        return this.hearts;
    }
    
        //Method to return the number of hearts for the parrots
    public void setNoOfHearts(int hearts) {
        this.hearts = hearts;
    }

    //Method to get the nameOfParrots for the parrots
    public String getNameOfParrot() {
    return nameOfParrot;
    }

    //Method to return the nameOfParrots of the parrots
    public void setName(String nameOfParrot) {
        this.nameOfParrot = nameOfParrot;
    }

    //Method to return the amount of crackercrumbs for the parrots
    public void setCrackersCrumbs(double crackercrumbs) {
        this.crackercrumbs = crackercrumbs;
    }

    //Method to untame the parrot
    public void untame() {
        tamed = false;
    }

    //Method to check status of the parrot whether it is flying or sitting
    public boolean isFlying(){
        return flying;
    }
    //Method to check if the parrot is tamed or untamed
    public boolean isTamed() {
        return tamed;
    }

    //Method to return details of the parrots
    public String toString() {
    String status = "";
    if (this.isDead()) {
        status = "DEAD";
    } else {
        status = "Alive";
    }
    if (this.tamed) {
        status += " Tamed ";
    } else {
        status += " Untamed ";
    }
    if (this.flying) {
        status += "Flying ";
    } else {
        status += "Sitting ";
    }

    return this.nameOfParrot + ": " + status + this.crackercrumbs + "kg crackercrumbs, " + this.health + " hearts";
}
}

// ParrotCraft class
class ParrotCraft {
    public static void main(String[] args) {
        // Create a new parrot name Willis
        Parrot parrot1 = new Parrot();
        parrot1.setName("Willis");
        parrot1.setCrackersCrumbs(2.1);
        //Hit the parrot Willis
        parrot1.hit();
        parrot1.hit();
        parrot1.hit();
        // Create a new parrot name Nancy
        Parrot parrot2 = new Parrot();
        parrot2.setName("Nancy");
        parrot2.setCrackersCrumbs(0.6);
        parrot2.setNoOfHearts(2);
        parrot2.fly();
        // Create a new parrot name John
        Parrot parrot3 = new Parrot();
        parrot3.setName("John");
        parrot3.setCrackersCrumbs(1.0);
        // Feed the parrot John
        parrot3.feed(1);
        // Make the parrot John sit
        parrot3.sit();
// Display welcome to parrotcraft world message to users 
               JOptionPane.showMessageDialog(null, "WELCOME TO"+"\n"+"PARROTCRAFT WORLD");
        Scanner scan = new Scanner(System.in);
        OUTER:
        while (true) {
            System.out.println("1. Tamed DEAD Parrot " + parrot1.getNameOfParrot() + ": " + parrot1.getCrackerCrumbs() + "kg crackercrumbs, " + parrot1.getNoOfHearts() + " hearts");
            System.out.println("2. Untamed Parrot " + parrot2.getNameOfParrot() + ": " + parrot2.getCrackerCrumbs() + "kg crackercrumbs, " + parrot2.getNoOfHearts() + " hearts, " + (parrot2.isFlying() ? "flying" : "sitting"));
            System.out.println("3. Tamed Parrot " + parrot3.getNameOfParrot() + ": " + parrot3.getCrackerCrumbs() + "kg carckercrumbs, " + parrot3.getNoOfHearts() + " hearts, " + (parrot3.isFlying() ? "flying" : "sitting"));
            System.out.println("1. Feed 2. Command 3. Play 4. Hit 5. Quit");
            System.out.print("Choice: ");
            int choice = scan.nextInt();
//Feed the parrot
            switch (choice) {
                case 1:
                    {
                        System.out.print("Which parrot? ");
                        int parrotChoice = scan.nextInt();
                        if (parrotChoice == 1 && !parrot1.isDead()) {
                            System.out.print("How much? ");
                            double amount = scan.nextDouble();
                            parrot1.feed(amount);
                            if (parrot1.isTamed()) {
                                // Display the action done in a dialog box
                                JOptionPane.showMessageDialog(null,"You tamed " + parrot1.getNameOfParrot() + "!");
System.out.println("You tamed " + parrot1.getNameOfParrot() + "!");
                            }
                            System.out.println(parrot1.toString());
                        } else if (parrotChoice == 2 && !parrot2.isDead()) {
                            System.out.print("How much? ");
                            double amount = scan.nextDouble();
                            parrot2.feed(amount);
                            if (parrot2.isTamed()) {
                                // Display the action done in a dialog box
                                JOptionPane.showMessageDialog(null,"You tamed " + parrot2.getNameOfParrot() + "!");
                                System.out.println("You tamed " + parrot2.getNameOfParrot() + "!");
                            }
                            System.out.println(parrot2.toString());
                        } else if (parrotChoice == 3 && !parrot3.isDead()) {
                            System.out.print("How much? ");
                            double amount = scan.nextDouble();
                            parrot3.feed(amount);
                            if (parrot3.isTamed()) {
                                // Display the action done in a dialog box
                                JOptionPane.showMessageDialog(null,"You tamed " + parrot3.getNameOfParrot() + "!");
                                System.out.println("You tamed " + parrot3.getNameOfParrot() + "!");
                            }
                            System.out.println(parrot3.toString());
                        } else {
                            System.out.println("It's dead");
                        }
//Command the parrot to fly or sit
                        break;
                    }
                case 2:
                    {
                        System.out.print("Which parrot? ");
                        int parrotChoice = scan.nextInt();
                        if (parrotChoice == 1 && !parrot1.isDead()) {
                            System.out.print("Fly or Sit? ");
                            String command = scan.next();
                            if (command.equalsIgnoreCase("sit")) {
                                parrot1.sit();
                            } else if (command.equalsIgnoreCase("fly")) {
                                parrot1.fly();
                            } else {
                                System.out.println("Invalid command");
                            }
                        } else if (parrotChoice == 2 && !parrot2.isDead()) {
                            System.out.print("Fly or Sit? ");
                            String command = scan.next();
                            if (command.equalsIgnoreCase
                ("sit")) {
                                parrot2.sit();
                            } else if (command.equalsIgnoreCase("fly")) {
                                parrot2.fly();
                            } else {
                                System.out.println("Invalid command");
                            }
                        } else if (parrotChoice == 3 && !parrot3.isDead()) {
                            System.out.print("Fly or Sit? ");
                            String command = scan.next();
                            if (command.equalsIgnoreCase("sit")) {
                                parrot3.sit();
                            } else if (command.equalsIgnoreCase("fly")) {
                                parrot3.fly();
                            } else {
                                System.out.println("Invalid command");
                            }
                        } else {
                            System.out.println("It's dead");
                        }
// Play with the parrot
                        break;
                    }
                case 3:
                    System.out.print("Which parrot? ");
                    int parrotChoice1 = scan.nextInt();
                    System.out.print("Which parrot to play with? ");
                    int parrotChoice2 = scan.nextInt();
                    if (parrotChoice1 == 1 && parrotChoice2 == 2 && !parrot1.isDead() && !parrot2.isDead()) {
                        parrot1.play(parrot2);
                    } else if (parrotChoice1 == 1 && parrotChoice2 == 3 && !parrot1.isDead() && !parrot3.isDead()) {
                        parrot1.play(parrot3);
                    } else if (parrotChoice1 == 2 && parrotChoice2 == 1 && !parrot2.isDead() && !parrot1.isDead()) {
                        parrot2.play(parrot1);
                    } else if (parrotChoice1 == 2 && parrotChoice2 == 3 && !parrot2.isDead() && !parrot3.isDead()) {
                        parrot2.play(parrot3);
                    } else if (parrotChoice1 == 3 && parrotChoice2 == 1 && !parrot3.isDead() && !parrot1.isDead()) {
                        parrot3.play(parrot1);
                    } else if (parrotChoice1 == 3 && parrotChoice2 == 2 && !parrot3.isDead() && !parrot2.isDead()) {
                        parrot3.play(parrot2);
                    } else {
                        System.out.println("It's dead");
                    }
//Hit the parrot
                    break;
                case 4:
                    {
                        System.out.print("Which parrot? ");
                        int parrotChoice = scan.nextInt();
                        if (parrotChoice == 1 && !parrot1.isDead()) {
                            parrot1.hit();
                            JOptionPane.showMessageDialog(null,"Ouch!");
                            System.out.println("Ouch!");
                        } else if (parrotChoice == 2 && !parrot2.isDead()) {
                            parrot2.hit();
                            JOptionPane.showMessageDialog(null,"Ouch!");
                            System.out.println("Ouch!");
                        } else if (parrotChoice == 3 && !parrot3.isDead()) {
                            parrot3.hit();
                            JOptionPane.showMessageDialog(null,"Ouch!");
                            System.out.println("Ouch!");
                        } else {
                            System.out.println("It's dead");
                        }
// Exit the game
                        break;
                    }
                case 5:
                    break OUTER;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
}
}
