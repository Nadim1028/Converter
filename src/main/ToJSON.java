package main;

import java.io.File;
import java.io.FileOutputStream;

public class ToJSON implements ConvertIT {
    @Override
    public void convert(File file) throws Exception {

        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(Converter.JSONFormat.getBytes());
        outputStream.close();

    }
}
