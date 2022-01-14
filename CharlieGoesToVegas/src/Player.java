import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private Name playerName;
    private Date birthday;
    protected int moneyBalance;


    public Player(Name playerName, Date birthday, int moneyBalance)
    {
        this.playerName = playerName;
        this.birthday = birthday;
        setMoneyBalance(moneyBalance);
    }
    public Player(String firstName, String mI, String lN, int dobMonth, int dobDay, int dobYear, int moneyBalance)
    {
        this.playerName = new Name(firstName, mI, lN);
        this.birthday = new Date(dobMonth, dobDay, dobYear);
        setMoneyBalance(moneyBalance);
    }

    public Player (String firstName, String lastName, int dobMonth, int dobDay, int dobYear, int moneyBalance)
    {
        this.playerName = new Name(firstName, lastName);
        this.birthday = new Date(dobMonth, dobDay, dobYear);
        setMoneyBalance(moneyBalance);
    }


    public void setMoneyBalance(int moneyBalance)
    {
        this.moneyBalance = moneyBalance;
    }

    public int getMoneyBalance()
    {
        return moneyBalance;
    }

    public boolean isBroke(){
        int isBroke = moneyBalance;

        if(isBroke <= 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void playSlot(){
        this.moneyBalance --;
    }

    public Name getPlayerName()
    {
        return playerName;
    }

    @Override
    public String toString()
    {
        String result;
        result = playerName + " DOB: " + birthday + " money balance: $" + moneyBalance;
        System.out.println(result);
        return result;
    }
}






