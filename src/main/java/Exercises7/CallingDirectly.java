package Exercises7;

import java.io.File;

public class CallingDirectly {
    public static void main(String[] args) {
        Parser parser = new EdiFileParse();
        parser.parse(new File("edi_format.txt"));
    }
}

interface Parser {
    public File parse(File inputFile);
}

class EdiFileParse implements Parser {
    public File parse(File inputFile) {
        File output = new File("edi_to_CSV.csv");
        System.out.println("Parsing Edi file format to CSV");
        return output;
    }
}

class FixedWidthFileParse implements Parser {
    public File parse(File inputFile) {
        File output = new File("fix_width_to_CSV.csv");
        System.out.println("Parsing Fixed Width file format to CSV");
        return output;
    }
}