
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.*;
public class Driver {

    public static void main(String[] args) {

        boolean quit = false;
        //public Player (String firstName, String lastName, int dobMonth, int dobDay, int dobYear, int moneyBalance)
        int gamblers = 1; // initialize player count at zero
        int machines = 3; // starting count of machines
        int choice = 0;
        //menu strings
        String playerMenu;
        String playerInput;
        String machineInput;
        String slotMenu;
        String driverMenu;
        // initialize player choice
        int playerChoice = -1;
        int machineChoice = -1;

        ArrayList<Player> players = new <Player>ArrayList(50); //initialize array to hold players
        ArrayList<SlotMachine> slotMachines = new <SlotMachine>ArrayList(50); // initialize array to hold slot machines
        // default player
        players.add(new Player("Charlie", "A", "Uncle", 5, 20, 1992, 50)); // default player
        //default machines
        slotMachines.add(new SlotMachine("Lucky 7", 5000, 10000, 5000, 0, 10, 5, 0, 0));
        slotMachines.add(new SlotMachine("Lucky Lotto", 55000, 100000, 75000, 0, 50, 25, 0, 0));
        slotMachines.add(new SlotMachine("Purple People Eater", 1000, 50, 40, 0, 5, 2, 0, 0));


        while(quit!=true){
            driverMenu = JOptionPane.showInputDialog(null, "Main Menu " +
                    "\n 1. Build a new player (use console)" +
                    "\n 2. Build a new machine (use console)" +
                    "\n 3. Play Slots" +
                    "\n 4. Exit", JOptionPane.OK_OPTION);

            choice = Integer.parseInt(driverMenu);

            switch (choice) {

                case 1:

                    if(gamblers < 50) {
                        // create JTextField table for data entry
                        JTextField firstName = new JTextField(25);
                        JTextField middleInitial = new JTextField(25);
                        JTextField lastName = new JTextField(25);
                        JTextField dobMonth = new JTextField(25);
                        JTextField dobYear = new JTextField(25);
                        JTextField dobDay = new JTextField(25);
                        JTextField moneyBalance = new JTextField(25);

                        JPanel myPanel = new JPanel(new GridLayout(8, 1, 5, 5));
                        // create UI table for data entry
                        myPanel.add(new JLabel("First Name: "));
                        myPanel.add(firstName); // get firstname
                        myPanel.add(new JLabel("Middle Initial: "));
                        myPanel.add(middleInitial); // get middle Initial
                        myPanel.add(new JLabel("Last Name: "));
                        myPanel.add(lastName); // get last name
                        myPanel.add(new JLabel("Month of Birth: "));
                        myPanel.add(dobMonth); // get date of birth month
                        myPanel.add(new JLabel("Day of Birth: "));
                        myPanel.add(dobDay); // get date of birth day
                        myPanel.add(new JLabel("Year of Birth: "));
                        myPanel.add(dobYear); // get date of birth Year
                        myPanel.add(new JLabel("Starting Balance: "));
                        myPanel.add(moneyBalance); // get user starting balance
                        myPanel.add(new JLabel( "\t \tIs all the information provided correct?"));

                        // accept user input
                        int result = JOptionPane.showConfirmDialog(null, myPanel,
                                "Provide Player Information", JOptionPane.YES_NO_OPTION);
                        // parse input to create new player
                        // if any rules of creation are violated this will report to console.
                        if (result == JOptionPane.YES_OPTION) {

                            String lastName1 = lastName.getText();
                            String firstName1 = firstName.getText();
                            String middleInitial1 = middleInitial.getText();
                            int dobMonth2 = Integer.parseInt(dobMonth.getText());
                            int dobDay2 = Integer.parseInt(dobDay.getText());
                            int dobYear2 = Integer.parseInt(dobYear.getText());
                            int moneyBalance2 = Integer.parseInt(moneyBalance.getText());

                            Player player = new Player(firstName1, middleInitial1, lastName1, dobMonth2, dobDay2,
                                    dobYear2, moneyBalance2);
                            players.add(player);

                            gamblers++; // track count of players create

                        } //allow user to back out of player creation
                        else if (result == JOptionPane.NO_OPTION){
                            break;
                        }
                    }break;

                // allow user to create machines
                case 2:

                    if(machines <= 49) {
                        //setup Jtextfield to hold user input
                        JTextField machineName = new JTextField(15);
                        JTextField balance = new JTextField(10);
                        JTextField jpCount = new JTextField(5);
                        JTextField jpPayout = new JTextField(10);
                        JTextField regCount = new JTextField(5);
                        JTextField regPayout = new JTextField(10);
                        //setup graphical UI for machine creation
                        JPanel myPanel1 = new JPanel(new GridLayout(6,1,5,5));
                        myPanel1.add(new JLabel("Machine Name: "));
                        myPanel1.add(machineName);
                        myPanel1.add(new JLabel("Starting Balance: "));
                        myPanel1.add(balance);
                        myPanel1.add(new JLabel("# of times to hit JP: "));
                        myPanel1.add(jpCount);
                        myPanel1.add(new JLabel("$ value of Jackpot: "));
                        myPanel1.add(jpPayout);
                        myPanel1.add(new JLabel("# of times to hit Regular Win: "));
                        myPanel1.add(regCount);
                        myPanel1.add(new JLabel("$ value of Regular Win: "));
                        myPanel1.add(regPayout);

                        int result3 = JOptionPane.showConfirmDialog(null, myPanel1,
                                "Provide Machine Information", JOptionPane.YES_NO_OPTION);
                        //On hit okay parse the user input to create the machine
                        if (result3 == JOptionPane.YES_OPTION) {

                            String machineName1 = machineName.getText();
                            int balance2 = Integer.parseInt(balance.getText());
                            int jpPayout2 = Integer.parseInt(jpPayout.getText());
                            int jpCount2 = Integer.parseInt(jpCount.getText());
                            int regCount2 = Integer.parseInt(regCount.getText());
                            int regPayout2 = Integer.parseInt(regPayout.getText());

                            // counts start at zero for wins/plays
                            int jpPayoutCount = 0;
                            int regPayoutCount = 0;
                            int playCount = 0;

                            SlotMachine slotmachine = new SlotMachine(machineName1, balance2, jpCount2, jpPayout2, jpPayoutCount,
                                    regCount2, regPayout2, regPayoutCount, playCount);
                            slotMachines.add(slotmachine);
                            machines++;// track lotto machine count
                            //allow user to back out of machine creation
                        }
                        else if(result3 == JOptionPane.NO_OPTION) {
                           break;
                        }
                        // end machine creation after successful entry
                    }break;

                case 3: // slot play menu

                    do{
                            // define menu setup
                        playerMenu = "0. Quit" + "\n" + "1. " + players.get(0).getPlayerName() + " balance: $"
                                + players.get(0).getMoneyBalance();
                            // iterate over the array of players of the amount of players added to create UI
                            for (int i = 1; i < gamblers; i++) {
                            playerMenu = playerMenu + "\n" + (i + 1) + ". " + players.get(i).getPlayerName() + " balance: $"
                                    + players.get(i).getMoneyBalance();
                            }
                            // accept player Input
                            playerInput = JOptionPane.showInputDialog(playerMenu, "Select Player");
                            playerChoice = Integer.parseInt(playerInput);
                            // set player input to matching Index in Array

                            int playerIndex = playerChoice - 1;

                            if (playerChoice != 0) {

                                if (players.get(playerIndex).isBroke() == false) {
                                    //setup slot machine menu template
                                    slotMenu = "0. Quit" + "\n" + "1. " + slotMachines.get(0).getName();
                                    // iterate over array of machines for the amount of machines to build menu
                                    for (int i = 1; i < machines; i++) {
                                        slotMenu = slotMenu + "\n" + (i + 1) + ". " + slotMachines.get(i).getName();
                                    }


                                    // menu for slot selection
                                    machineInput = JOptionPane.showInputDialog(slotMenu, "Select Slot");
                                    machineChoice = Integer.parseInt(machineInput);
                                    if (machineChoice != 0) {
                                        //set user input to matching index value
                                        int machineIndex = machineChoice - 1;

                                        // user player to play slot and reduce balance by one
                                        players.get(playerIndex).playSlot();
                                        // increment play count on machine and balance by 1 for play
                                        slotMachines.get(machineIndex).machinePlayed();
                                        //check if play was a win or Jackpot
                                        if (slotMachines.get(machineIndex).checkJpWin() == true) {
                                            //update user balance by JACKPOT win amount and reduce machine balance by win amount
                                            players.get(playerIndex).setMoneyBalance(players.get(playerIndex).getMoneyBalance() + slotMachines.get(machineIndex).getJpPayout());
                                        } else if (slotMachines.get(machineIndex).checkRegWin() == true) {
                                            //update user balance by REGULAR win amount and reduce machine balance by win amount
                                            players.get(playerIndex).setMoneyBalance(players.get(playerIndex).getMoneyBalance() + slotMachines.get(machineIndex).getRegPayout());
                                        } else {
                                            JOptionPane.showMessageDialog(null, "You did not win. TRY AGAIN");
                                        }
                                        // Provide results in UI
                                        JOptionPane.showMessageDialog(null,
                                                "Player: " + players.get(playerIndex).getPlayerName() +
                                                        "\n" + "Current Balance $" + players.get(playerIndex).getMoneyBalance() +
                                                        "\n" + "Machine: " + slotMachines.get(machineIndex).getName() +
                                                        "\n" + "Current Balance of the slot machine: " + slotMachines.get(machineIndex).getBalance() +
                                                        "\n" + "Current play count for machine: " + slotMachines.get(machineIndex).getPlayCount());


                                        // Start loop for continuous slot play
                                        if (players.get(playerIndex).isBroke() == true) {
                                            int you_are_broke = JOptionPane.showConfirmDialog(null, "This player does not have enough funds to keep playing", "You are Broke", JOptionPane.OK_CANCEL_OPTION);
                                            if (you_are_broke == JOptionPane.OK_CANCEL_OPTION)
                                                break;
                                        }else if (players.get(playerIndex).isBroke() == false) {
                                            int playAgain = 0;
                                            playAgain = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Play Again?",
                                                    JOptionPane.YES_NO_OPTION);

                                            if (playAgain == JOptionPane.NO_OPTION) {
                                                break;
                                            }

                                            while (playAgain == JOptionPane.YES_OPTION) {
                                                players.get(playerIndex).playSlot();
                                                slotMachines.get(machineIndex).machinePlayed();

                                                if (slotMachines.get(machineIndex).checkJpWin() == true) {
                                                    players.get(playerIndex).setMoneyBalance(players.get(playerIndex).getMoneyBalance() + slotMachines.get(machineIndex).getJpPayout());
                                                } else if (slotMachines.get(machineIndex).checkRegWin() == true) {
                                                    players.get(playerIndex).setMoneyBalance(players.get(playerIndex).getMoneyBalance() + slotMachines.get(machineIndex).getRegPayout());
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "You did not win. TRY AGAIN");
                                                }

                                                JOptionPane.showMessageDialog(null,
                                                        "Player: " + players.get(playerIndex).getPlayerName() +
                                                                "\n" + "Current Balance $" + players.get(playerIndex).getMoneyBalance() +
                                                                "\n" + "Machine: " + slotMachines.get(machineIndex).getName() +
                                                                "\n" + "Current Balance of the slot machine: " + slotMachines.get(machineIndex).getBalance() +
                                                                "\n" + "Current play count for machine: " + slotMachines.get(machineIndex).getPlayCount());
                                                playAgain = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Play Again?",
                                                        JOptionPane.YES_NO_OPTION);
                                            }
                                        }

                                        } // end machine slot play loop

                                    else{
                                            int want_to_quit = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Confirm Quit",
                                                    JOptionPane.YES_NO_OPTION);
                                            if (want_to_quit == JOptionPane.YES_OPTION)
                                                break;
                                    }

                                }// end of loop for money balance validation

                                else{
                                    int amBroke = JOptionPane.showConfirmDialog(null, "This player does not have enough funds", "You are Broke",JOptionPane.OK_OPTION);
                                    if (amBroke == JOptionPane.YES_OPTION)
                                        break;
                                }

                            }

                    }while(playerChoice != 0);
                     break;

                case 4:
                    int result2 = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Confirm Quit",
                            JOptionPane.YES_NO_CANCEL_OPTION);
                    if (result2 == JOptionPane.YES_OPTION)
                        quit=true;
            }
        }
    }
}
