import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class InitialUsers {
    private Map<Integer, LocalDateTime> theMap = new HashMap<>();

    public InitialUsers(int numberOfUsers) {
        makeUsers(numberOfUsers);
    }

    private void makeUsers(int numberOfUsers){
        int counter = 1;
        RandomHulp r = new RandomHulp();
        for (int j = 0; j < numberOfUsers ; j++) {

            //System.out.println(theMap.size() +" - "+ numberOfUsers);
            //int amount = r.randomValueBetween(1,3);
            //System.out.println(amount);
            //for (int i = 0; i < amount; i++) {
                theMap.put(j+1, LocalDateTime.of(
                        2018,
                        r.randomValueBetween(7,8),
                        r.randomValueBetween(1,30),
                        r.randomValueBetween(0,23),
                        r.randomValueBetween(0,59),
                        r.randomValueBetween(0,59)));
            //}
        }

    }

    public Map<Integer, LocalDateTime> getTheMap() {
        //System.out.println(theMap);
        return theMap;
    }
}
