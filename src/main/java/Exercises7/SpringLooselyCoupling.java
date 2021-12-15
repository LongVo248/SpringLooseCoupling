package Exercises7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;

@SpringBootApplication
public class SpringLooselyCoupling {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringLooselyCoupling.class, args);
        FileParserHelper2 fileParserHelper2 = applicationContext.getBean(FileParserHelper2.class);
        fileParserHelper2.parseFile(new File("a.txt"));
    }
}

@Component
class FileParserHelper2 {

    @Autowired
    private Parser2 parser2;

    public FileParserHelper2(Parser2 parser2) {
        super();
        this.parser2 = parser2;
    }

    public File parseFile(File input) {
        return parser2.parse(input);
    }
}

interface Parser2 {
    public File parse(File inputFile);
}

@Component
class EdiFileParse2 implements Parser2 {
    public File parse(File inputFile) {
        File output = new File("edi_to_CSV.csv");
        System.out.println("Parsing Edi file format to CSV");
        return output;
    }
}

class FixedWidthFileParse2 implements Parser2 {
    public File parse(File inputFile) {
        File output = new File("fix_width_to_CSV.csv");
        System.out.println("Parsing Fixed Width file format to CSV");
        return output;
    }
}