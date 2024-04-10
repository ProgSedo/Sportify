package Models;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Team {
    
    private int matchesPlayed = 0;
    private int matchesWon = 0;
    private int matchesLost = 0;
    private int size;

    private String name;
    private String aboutTeam;

    private SportType sportType;
    private ImageIcon logo;

    private ArrayList<User> players;

    public Team(int size, String name, String aboutTeam, SportType sportType){
        this.size = size;
        this.name = name;
        this.sportType = sportType;
        this.aboutTeam = aboutTeam;

        players = new ArrayList<>();
    }

    //getters
    public int getCurrentSize(){
        return players.size();
    }

    //FIND SOME WAY TO FIND ALL PLAYERS LIST
    public boolean addPlayer(ArrayList<User> allPlayers, User player){
        if(allPlayers.contains(player) && !players.contains(player)){
            System.out.println(player.getName() + " added to the team " + getTeamName() + " succesfully");
            players.add(player);
            return true;
        }
        else{
            System.out.println(player.getName() + " couldnt be found in userlist");
            return false;
        }
    }

    public boolean removePlayer(User player){
        if(players.contains(player)){
            System.out.println(player.getName() + " removed from the team succesfully");
            players.remove(player);
            return true;
        }
        else{
            System.out.println(player.getName() + " couldnt be found in " + this.getTeamName());
            return false;
        }
    }

    public String getTeamName(){
        return this.name;
    }
    
    public String getAboutTeam(){
        return this.aboutTeam;
    }

    public SportType getSportType(){
        return this.sportType;
    }

    public ArrayList<User> getPlayersList(){
        return this.players;
    }

    public ImageIcon getLogo(){
        return this.logo;
    }

    public int getMatchesPlayed(){
        return this.matchesPlayed;
    }

    public int getMatchesWon(){
        return this.matchesWon;
    }

    public int getMatchesLost(){
        return this.matchesLost;
    }

    public double getWinRate(){
        return this.matchesWon / this.matchesPlayed * 100;
    }

    public String teamPlayersString(){
        String playersStr = "";
        for (int i = 0; i < players.size(); i++) {
            playersStr += "Player " + (i+1) + players.get(i).getName() + " " + players.get(i).getSurname() + " " + players.get(i).getAge() + "\n";
        }
        return playersStr;
    }

    //setters
    public int setSize(int newSize){
        return this.size = newSize;
    }

    public String setTeamName(String newName){
        return this.name = newName;
    }
    
    public String setAboutTeam(String newAboutTeam){
        return this.aboutTeam = newAboutTeam;
    }

    public ArrayList<User> setPlayersList(ArrayList<User> newPlayers){
        return this.players = newPlayers;
    }

    public ImageIcon setLogo(ImageIcon newLogo){
        return this.logo = newLogo;
    }

    public void increaseMatchPlayed(boolean isWon){
        matchesPlayed++;
        if(isWon){
            matchesWon++;
        }
        else{
            matchesLost++;
        }
    }

}
