public class TeamData implements Comparable<TeamData> {
    private String position;
    private String name;
    private int matches;
    private int wins;
    private int losses;
    private int draws;
    private int goalsInFavor;
    private int goalsAgainst;
    private int totalPoints;
    private int differenceInGoals;
    
    public TeamData(String position, String name, int matches, int wins, int losses,
            int draws, int goalsInFavor, int goalsAgainst, int totalPoints){
        this.position = position;
        this.name = name;
        this.matches = matches;
        this.wins = wins;
        this.losses = losses;
        this.draws = draws;
        this.goalsInFavor = goalsInFavor;
        this.goalsAgainst = goalsAgainst;
        this.totalPoints = totalPoints;
        this.differenceInGoals = goalsInFavor - goalsAgainst;
    }
    
    public String getPosition() {
        return position;
    }
    
    public String getName() {
        return name;
    }
   
    public int getDifferenceInGoals() {
        return differenceInGoals;
    }
    
    @Override
    public int compareTo(TeamData opposingTeam) {
        int myDifference = this.getDifferenceInGoals();
        int rivalDifference = opposingTeam.getDifferenceInGoals();
        
        if (myDifference == rivalDifference) 
            return 0;
        else if (myDifference > rivalDifference) 
            return 1;
        else 
            return -1; 
    }
}
