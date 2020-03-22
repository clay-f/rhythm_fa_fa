package com.f.util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class CSVHelper {
    public static void writeCVS(List<Map<String, String>> data, File file) {
        requireNonNull(data);
        try (CSVPrinter csvPrinter = CSVFormat.DEFAULT.EXCEL.withHeader(data.get(0).keySet().toArray(new String[0])).print(file, StandardCharsets.UTF_8)) {
            writeBody(data, csvPrinter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeBody(List<Map<String, String>> data, CSVPrinter csvPrinter) throws IOException {
        for (Map<String, String> row : data) {
            int valueIndex = 0;
            String[] valueArray = new String[row.size()];
            for (String currentValue : row.values()) {
                valueArray[valueIndex++] = currentValue;
            }
//            csvPrinter.printRecord(valueArray);
        }
    }
}
