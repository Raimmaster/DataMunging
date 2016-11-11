import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FootballData {
      
    public static String findSmallestGoalDifferenceTeam() throws IOException {
        FileReader file = new FileReader("football.dat");
        BufferedReader buffer = new BufferedReader(file);
        List<TeamData> teams = new ArrayList();
        FileParser.parseFile(buffer, teams, FILE_WRAPPER_TYPES.FOOTBALL, " -");                
        buffer.close();
        file.close();
        
        TeamData lowestDiffTeam = getTeamWithLowestDifference(teams);
        return lowestDiffTeam.getName();
    }
    
    public static void addTeamToList(String[] fileLine, List teams) throws NumberFormatException {
        TeamData team = new TeamData(fileLine[0],
                fileLine[1], Integer.parseInt(fileLine[2]),
                Integer.parseInt(fileLine[3]), Integer.parseInt(fileLine[4]),
                Integer.parseInt(fileLine[5]), Integer.parseInt(fileLine[6]),
                Integer.parseInt(fileLine[7]), Integer.parseInt(fileLine[8]));
        teams.add(team);
    }
    
    private static TeamData getTeamWithLowestDifference(List<TeamData> teams){
        Collections.sort(teams); 
        
        return teams.get(0);
    }
}
