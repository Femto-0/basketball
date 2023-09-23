import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BasketballApplication {
    private static String fileName="src/Team.txt";
    private static List<BasketballPlayer> basketballPlayers= new LinkedList<>();
static BasketballTeam bt= null;

    public static void printDetails() throws IOException {
        /*
        reading the text file
         */
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while((line=br.readLine())!=null){
            String[] list= line.split(", ");
            String basketballTeamName= list[0];
            int wins= Integer.parseInt(list[1]);
            int loss=Integer.parseInt(list[2]);
            bt= new BasketballTeam(basketballTeamName,wins,loss);
            String line1;
            while((line1=br.readLine())!=null){ //skipping the first line since we already read and used it
                String []playerList= line1.split(", ");
                String playerName= playerList[0];
                int playerNumber= Integer.parseInt(playerList[1]);
                int pointsScored= Integer.parseInt(playerList[2]);
                int rebounds = Integer.parseInt(playerList[3]);
                int blocks= Integer.parseInt(playerList[4]);
                BasketballPlayer bp= new BasketballPlayer(playerName,playerNumber,pointsScored,rebounds,blocks);
                basketballPlayers.add(bp);

            }
              /*
              printing the details of the team
               */
            System.out.println(bt.toString());
        }
        /*
        printing the details of each player in a new line
         */
        for(BasketballPlayer playerDetails: basketballPlayers){
            System.out.println(playerDetails);
        }
        br.close();
    }

    public static void updateDetails() throws IOException {
        BufferedWriter basketballPlayerWriter = new BufferedWriter(new FileWriter(fileName));

        basketballPlayerWriter.write(bt.getTeamName() + ", " + bt.getWins() + ", " + bt.getLosses());
        basketballPlayerWriter.newLine();//starting on a new line

        for (BasketballPlayer teamDetails : basketballPlayers) {
            basketballPlayerWriter.write(teamDetails.getPlayerName() + ", " + teamDetails.getPlayerNumber() + ", " + teamDetails.getPointScored() + ", " + teamDetails.getRebounds() + ", " + teamDetails.getBlocks());
            basketballPlayerWriter.newLine();//starting on a new line
        }
        basketballPlayerWriter.close();
        basketballPlayers.clear();  //clears the existing stats
    }

public static BasketballPlayer findPlayer(String playerName){
    for(BasketballPlayer name: basketballPlayers){
    if(name.getPlayerName().equalsIgnoreCase(playerName)){
        return name;
    }
    }
    return null; //player not found
}



    public static void main(String[] args) throws IOException {
        printDetails(); //call method to read and print details of the team
                Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("What would you like to do:");
            System.out.println("1 --> Update Team name");
            System.out.println("2 --> Update Team Wins");
            System.out.println("3 --> Update Team Loss");
            System.out.println("4 --> Update Player Stats");
            System.out.println("5 --> Exit");
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Insert the new Team name: ");
                String name=scanner.nextLine();
                bt.setTeamName(name);
                updateDetails();  //updating the details
                 printDetails();
                    break;
                case 2:
                    System.out.println("New Number of wins: ");
                    int noOfWins=scanner.nextInt();
                    bt.setWins(noOfWins);
                    updateDetails();
                    printDetails();
                    break;
                case 3:
                    System.out.println("New number of loss: ");
                    int noOfLosses=scanner.nextInt();
                    bt.setLosses(noOfLosses);
                    updateDetails();
                    printDetails();
                    break;
                case 4:
                    System.out.println("Enter player's name: ");
                    String playerName= scanner.nextLine();
                    BasketballPlayer foundPlayer=findPlayer(playerName);
                    if(foundPlayer!=null) {
                        System.out.println("What detail would you like to update: ");
                        System.out.println(   "1---> Player Name" );
                        System.out.println(  "2--> Player Number" );
                        System.out.println( "3--> Points Scored");
                        System.out.println(  "4-->Rebounds" );
                        System.out.println(  "5--> Blocks" );
                        System.out.println(  "6--> exit");
                        int request = scanner.nextInt();
                        scanner.nextLine();
                        switch (request) {
                            case 1:
                                System.out.println("Enter new player name");
                                String updatedPlayerName = scanner.nextLine();
                                foundPlayer.setPlayerName(updatedPlayerName);
                                updateDetails();
                                printDetails();
                                break;
                            case 2:
                                System.out.println("Enter player Number: ");
                                int updatedPlayerNumber = scanner.nextInt();
                                foundPlayer.setPlayerNumber(updatedPlayerNumber);
                                updateDetails();
                                printDetails();
                                break;
                            case 3:
                                System.out.println("Enter points scored: ");
                                int updatedPoints = scanner.nextInt();
                                foundPlayer.setPointScored(updatedPoints);
                                updateDetails();
                                printDetails();
                                break;
                            case 4:
                                System.out.println("Enter new no. of rebounds: ");
                                int updatedRebounds = scanner.nextInt();
                                foundPlayer.setRebounds(updatedRebounds);
                                updateDetails();
                                printDetails();
                                break;
                            case 5:
                                System.out.println("Enter no. of new blocks: ");
                                int updatedBlocks = scanner.nextInt();
                                foundPlayer.setBlocks(updatedBlocks);
                                printDetails();
                                break;
                            case 6:
                                System.out.println("Exiting...");
                                scanner.close();
                                System.exit(0);
                                break;

                            default:
                                System.out.println("Invalid option. Please select a valid option.");
                                break;

                        }
                    }else {
                        System.out.println("Didn't find player");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please select a valid option.");
                    break;

            }
        }
    }



    }



