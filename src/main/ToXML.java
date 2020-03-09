package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ToXML implements ConvertIT {
    @Override
    public void convert(File file) throws Exception {

        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(Converter.XMLFormat.getBytes());
        outputStream.close();

    }
}
