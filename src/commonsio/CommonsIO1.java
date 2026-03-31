package commonsio;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CommonsIO1 {
    public static void main(String[] args) throws IOException {
        File source = new File("src/commonsio/a.txt");
        File copyToPath = new File("src/commonsio/a/aCopy.txt");
        FileUtils.copyFile(source,copyToPath);
    }
}
