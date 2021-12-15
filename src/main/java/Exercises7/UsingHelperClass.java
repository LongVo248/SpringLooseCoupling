package Exercises7;

import java.io.File;

public class UsingHelperClass {
    public static void main(String[] args) {
        FileParserHelper fileParserHelper = new FileParserHelper();
        fileParserHelper.parseFile(new File("edi_format.txt"));
    }
}

class FileParserHelper {
    public File parseFile(File input) {
        Parser1 parser = new EdiFileParse1();
        return parser.parse(input);
    }
}

interface Parser1 {
    public File parse(File inputFile);
}

class EdiFileParse1 implements Parser1 {
    public File parse(File inputFile) {
        File output = new File("edi_to_CSV.csv");
        System.out.println("Parsing Edi file format to CSV");
        return output;
    }
}

class FixedWidthFileParse1 implements Parser1 {
    public File parse(File inputFile) {
        File output = new File("fix_width_to_CSV.csv");
        System.out.println("Parsing Fixed Width file format to CSV");
        return output;
    }
}