import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length < 1) {
            logger.error("Nebyly zadány vstupní parametry.");
            System.exit(1);
        }
        ExcelReader reader = new ExcelReader();
        reader.processFile(args[0]);
    }
}