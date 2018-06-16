import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.zip.DataFormatException;

public class Janda {

    private List<String> colNames;
    private Map<String, List<String>> df;

    public Janda(String filePath, boolean hasColumnNames, List<String> colNames) {
        try {
            Scanner sc = new Scanner(new File(filePath));
            // if no next line then file is empty
            if(!sc.hasNext())
                throw new DataFormatException();
                // if csv already has column names
            if(hasColumnNames) {
                makeDataFrameFromCSV(sc);
            }
            // csv has no column names
            else {
                // user has not specified colNames
                if(colNames == null) {
                    // Make colnames 1..n for dataframe
                }
                else {
                    this.colNames = colNames;
                }
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch(DataFormatException e) {
            System.out.println("File is empty");
        }
    }

    private void makeDataFrameFromCSV(Scanner sc) {
        this.colNames = getColNamesFromCSV(sc);
        while(sc.hasNextLine()) {
            String row = sc.nextLine();
            // TODO : determine how to save different types of data
        } 
    }

    private List<String> getColNamesFromCSV(Scanner sc) {
        String[] extractedCols = sc.nextLine().split(",");
        return Arrays.asList(extractedCols);
    }

    public Janda(String filePath, boolean hasColumnNames) {
        this(filePath, hasColumnNames, null);
    }

    public Janda(String filePath) {
        this(filePath, true, null);
    }

    public Janda(String filePath, List<String> colNames) {
        this(filePath, false, colNames);
    }

    private boolean isDouble(String s) {
        // TODO : implement if string is double
        return false;
    }

    private boolean isInteger(String s) {
        // TODO : implement if string is int
        return false;
    }
}