import javax.swing.*;

    public class SlotMachine {

        private String machineName; // name of the machine
        private int balance; // starting balance of the machine
        private int jpCount; // # of plays to hit jackpot
        private int jpPayout; // how much $$ the jackpot pays out
        private int regCount; // # of plays to get reg payout
        private int regPayout; // how much $$ the reg payout is
        public int regPayoutCount;
        public int playCount; // holds the value of the times a machine has been played
        public int jpPayoutCount;


        public SlotMachine(String machineName, int balance, int jpCount, int jpPayout, int jpPayoutCount,
                           int regCount, int regPayout, int regPayoutCount, int playCount )
        {
            setName(machineName);
            setBalance(balance);
            setJpCount(jpCount);
            setJpPayout(jpPayout);
            setJpPayoutCount(jpPayoutCount);
            setRegCount(regCount);
            setRegPayout(regPayout);
            setRegPayoutCount(regPayoutCount);
            setPlayCount(playCount);

        }


        public void setName(String machineName)
        {
            this.machineName = machineName;
        }

        public String getName()
        {
            return machineName;
        }

        public void setBalance(int balance)
        {
            this.balance = balance;
        }

        public int getBalance()
        {
            return balance;
        }


        public int getJpCount(){
            return jpCount;
        }

        public void setJpCount(int jpCount){
            this.jpCount = jpCount;
        }

        public int getJpPayout(){
            return jpPayout;
        }

        public void setJpPayout(int jpPayout){
            this.jpPayout = jpPayout;
        }

        public int getJpPayoutCount(){
            return jpPayoutCount;
        }

        public void setJpPayoutCount(int jpPayoutCount){
            this.jpPayoutCount = jpPayoutCount;
        }

        public int getRegCount(){
            return regCount;
        }

        public void setRegCount(int regCount){
            this.regCount = regCount;
        }

        public int getRegPayout(){
            return regPayout;
        }

        public void setRegPayout(int regPayout){
            this.regPayout = regPayout;
        }

        public int getRegPayoutCount() {
            return regPayoutCount;
        }

        public void setRegPayoutCount(int regPayoutCount){
            this.regPayoutCount = regPayoutCount;
        }

        public int getPlayCount(){
            return playCount;
        }

        public void setPlayCount(int playCount){
            this.playCount = playCount;
        }

        public void machinePlayed()
        {
            this.playCount ++;
            this.balance ++;
        }



        public boolean checkJpWin()
        {
            int jpWinCheck = playCount % jpCount;

            if(jpWinCheck == 0)
            {
                JOptionPane.showMessageDialog(null, "JACKPOT! You have won $" + jpPayout);
                this.balance = balance - jpPayout;
                jpPayoutCount++;
                return true;

            }
            else
            {
                return false;
            }
        }


        public boolean checkRegWin()
        {
            int regWinCheck = playCount % regCount;

            if(regWinCheck == 0)
            {
                JOptionPane.showMessageDialog(null, "You have won $" + regPayout);
                this.balance = balance - regPayout;
                regPayoutCount++;
                return true;
            }
            else
            {
                return false;
            }
        }

        public String toString()
        {
            String result;
            result =" \n The slot machine's name is " + machineName +
                    " \n the balance is " + balance +
                    " \n the # of plays to hit Jackpot is " + jpCount +
                    " \n the $ value of the jackpot is " + jpPayout +
                    " \n this has been won " + jpPayoutCount + " times." +
                    " \n the # of plays to hit regular prize is " + regCount +
                    " \n the $ value of the regular prize is " + regPayout +
                    " \n this has been won " + regPayoutCount + " times." +
                    " \n the current number of plays on the machine is " + playCount;


            return result;
        }
}
