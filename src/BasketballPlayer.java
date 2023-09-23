public class BasketballPlayer {
    /*
    variables
     */
    public String playerName;
    public int playerNumber;
    public int pointScored;
    public int rebounds;
    public int blocks;

/*
getter and setter class
 */
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public int getPointScored() {
        return pointScored;
    }

    public void setPointScored(int pointScored) {
        this.pointScored = pointScored;
    }

    public int getRebounds() {
        return rebounds;
    }

    public void setRebounds(int rebounds) {
        this.rebounds = rebounds;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }
    /*
       constructor class
        */
    public  BasketballPlayer(String playerName, int playerNumber, int pointScored, int rebounds, int blocks){
        this.blocks=blocks;
        this.playerName=playerName;
        this.playerNumber=playerNumber;
        this.pointScored=pointScored;
        this.rebounds=rebounds;
    }
    /*
    to String method
     */
    public  String toString(){
        return "Player name: "+ playerName+ ", Player number: "+ playerNumber+ ", Points scored: "+ pointScored+ ", Rebounds: "+ rebounds+ ", Blocks: "+ blocks;
    }


}
