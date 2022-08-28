import java.util.*;

public class Fixture {
    public static void main(String[] args) {

        Random random_method = new Random();

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of teams: ");
        int teamCount = input.nextInt();

        List<String> teams = new ArrayList<>();
        List<String> tempTeams = new ArrayList<>();
        String[] teamsArr = new String[teamCount];

        for (int i=0; i<teamCount; i++) {
            System.out.println("Enter team name: ");
            String team = input.next();
            teams.add(team);
            teamsArr[i] = team;
        }

        if (teamCount%2 != 0) {
            teams.add("PASS");
            teamCount +=1;
        }

        int matchCount =  teamCount * (teamCount - 1);

        String[] matches = new String[matchCount];

        int count = 0;


        List<String> matchesList = new ArrayList<>();


        for (int i = 1; i <= teamCount-1; i++) {

            for (int k = 0; k < teamsArr.length; k++) {
                tempTeams.add(teamsArr[k]);
            }

            for(int j = 1; j <= teamCount / 2; j++) {

                int home = random_method.nextInt(tempTeams.size());
                int away;
                while (true) {
                    away = random_method.nextInt(tempTeams.size());
                    if (away != home) break;
                }

                if (matchesList.contains(tempTeams.get(home) + " vs " + tempTeams.get(away))) { j--; continue;}
                else {
                    matches[count] = tempTeams.get(home) + " vs " + tempTeams.get(away);
                    matches[count + matchCount/2] = tempTeams.get(away) + " vs " + tempTeams.get(home);
                    matchesList.add(tempTeams.get(home) + " vs " + tempTeams.get(away));
                    matchesList.add(tempTeams.get(away) + " vs " + tempTeams.get(home));
                    count++;
                }

                if (home > away) {
                    tempTeams.remove(tempTeams.get(home));
                    tempTeams.remove(tempTeams.get(away));
                }
                else {
                    tempTeams.remove(tempTeams.get(away));
                    tempTeams.remove(tempTeams.get(home));
                }

            }

        }
        int printCount = 0;

        for (int i = 1; i <= (teamCount-1)*2; i++) {
            System.out.println("Round " + i);
            for (int j = 0; j < 2; j++) {
                System.out.println(matches[printCount]);
                printCount++;
            }
        }


    }
}