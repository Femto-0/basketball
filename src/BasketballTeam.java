public class BasketballTeam {
/*
All the variables
 */
    public  String teamName;
    public int wins;
    public int losses;
    /*
    getter and setter classes
     */

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
    /*
    Constructor class
     */
    public BasketballTeam(String teamName, int wins, int losses){
        this.losses=losses;
        this.wins=wins;
        this.teamName=teamName;
    }
/*
to String class
 */
    public String toString(){
        return "Team Name: "+ teamName+", No. of wins: "+ wins+", No.of loses: "+ losses;
    }
}
