package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesManger {
    private Properties props = new Properties();
    private String filePath;

    public PropertiesManger(String filePath) {
        this.filePath = filePath;
    }


    public Properties getProps() {
        try {
            File file = new File(this.filePath);
            FileInputStream fileInputStream = new FileInputStream(file);
            this.props.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception var3) {
            System.out.println("arquivo não encontrado");
        }

        return this.props;
    }
}
