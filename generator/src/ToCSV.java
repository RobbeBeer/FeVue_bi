import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ToCSV {
    PrintWriter pw;
    StringBuilder sb;

    public void open() throws FileNotFoundException {
         pw = new PrintWriter(new File("D:\\KdG\\output\\test.csv"));
         sb = new StringBuilder();
    }

    public void addText(String text){
        sb.append(text);
        sb.append('\n');
    }

    public  void toFile(){
        pw.write(sb.toString());
        pw.close();
    }
}

