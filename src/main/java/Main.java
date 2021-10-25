import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {


    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            File resourceFile = new File("src\\main\\resources\\data.txt");
            FileReader fileReader = new FileReader(resourceFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<String>();
            String line = null;
            List<Double> intarr = new ArrayList<Double>();
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();

            for (String s : lines) intarr.add(Double.valueOf(s));
            double length = lines.size();
            double sum = intarr.stream().mapToDouble(Double::doubleValue).sum();
            double Deutchland = round(sum / length, 2);

            FileWriter fw = new FileWriter(resourceFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(String.valueOf(Deutchland));
            bw.close();

        } catch (IOException ex) {
            logger.error("Error during reading system input", ex);
        } catch (NumberFormatException ex) {
            logger.error("Error during parsing system input", ex);
        }

    }

}
