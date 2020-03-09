package main;

import java.io.File;
import java.io.FileOutputStream;

public class ToCSV implements ConvertIT {
    @Override
    public void convert(File file) throws Exception {

        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(Converter.CSVFormat.getBytes());
        outputStream.close();

    }
}
