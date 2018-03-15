import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Writer {

    public static void main(String[] args) {
        final int AANTALDAGEN = 91;
        final int AANTALUSERSBEGIN = 50;

        //
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        ToCSV toCSV = new ToCSV();
        try {
            toCSV.open();
        } catch (Exception e){
            e.printStackTrace();
        }

        toCSV.addText("ID, joined, sent");

        RandomHulp r =new RandomHulp();
        InitialUsers iu = new InitialUsers(AANTALUSERSBEGIN);
        Map<Integer, LocalDateTime> users = iu.getTheMap();

        LocalDateTime today = LocalDateTime.of(2019,9, 1, 0,0,0);


        for (int i = 0; i < AANTALDAGEN; i++) {
            for (int j = 0; j < users.size(); j++) {
                int numberOfMessages = 0;
                if (today.getDayOfWeek().toString().equals("SATURDAY") || today.getDayOfWeek().toString().equals("SUNDAY")){
                    numberOfMessages = r.randomValueBetween(0, 30, 8, 20);
                } else{
                    numberOfMessages = r.randomValueBetween(0, 40, 16, 28);
                }
                for (int k = 0; k < numberOfMessages; k++) {
                    LocalDateTime sent = LocalDateTime.of(today.toLocalDate(), LocalTime.of(
                            r.randomValueBetween(0,23, 17, 19 ),
                            r.randomValueBetween(0,59),
                            r.randomValueBetween(0,59)
                    ));
                    toCSV.addText((j+1)+", "+users.get(j+1).format(formatter)+"01, "+ sent.format(formatter));
                }
            }
            for (int k = 0; k < r.randomValueBetween(1,3); k++) {
                users.put(users.size()+1, LocalDateTime.of(today.toLocalDate(), LocalTime.of(
                        r.randomValueBetween(0,23, 17, 19 ),
                        r.randomValueBetween(0,59),
                        r.randomValueBetween(0,59)
                )));
            }
            today.plusDays(1);
        }
        toCSV.toFile();
        System.out.println("kleir:");
        System.out.println("Aantal users:" + users.size());
    }



}
