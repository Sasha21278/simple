import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    private static final Logger logger = LoggerFactory.getLogger(ExcelReader.class);

    public void processFile(String filePath) {
        logger.info("Zahajuji čtení souboru: {}", filePath);

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                Cell cell = row.getCell(1);

                if (cell == null) {
                    continue;
                }

                Long value = extractLongFromCell(cell);

                if (value != null && value > 0) {
                    if (PrimeChecker.isPrime(value)) {
                        logger.info(String.valueOf(value));
                    }
                }
            }

        } catch (IOException e) {
            logger.error("Chyba při čtení souboru: {}", e.getMessage());
        } catch (Exception e) {
            logger.error("Neočekávaná chyba: {}", e.getMessage());
        }
    }

    private Long extractLongFromCell(Cell cell) {
        try {
            switch (cell.getCellType()) {
                case NUMERIC:
                    double dVal = cell.getNumericCellValue();
                    if (dVal == Math.floor(dVal) && !Double.isInfinite(dVal)) {
                        return (long) dVal;
                    }
                    break;
                case STRING:
                    return Long.parseLong(cell.getStringCellValue().trim());
                default:
                    break;
            }
        } catch (NumberFormatException e) {
        }
        return null;
    }
}