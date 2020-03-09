package main;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileNotFoundException;

public class Controller {

    @FXML
    Text chooseFile;
    @FXML
    CheckBox isXML, isJSON, isCSV;
    File selectedFile;

    public void chooseFile()
    {
        FileChooser fileChooser = new FileChooser();
        selectedFile = fileChooser.showOpenDialog(null);

        if(selectedFile!=null)
        {
            try {
                Converter.takeInputFromTextFileAndParse(selectedFile);
                chooseFile.setText(selectedFile.getName());
            } catch (FileNotFoundException e) {
               chooseFile.setText("Can't read file!");
            }
        }

    }

    public void convert() throws Exception {
        if(isXML.isSelected())
            new ToXML().convert(new File(selectedFile.getAbsolutePath() + "_output.XML"));
        if(isJSON.isSelected())
            new ToJSON().convert(new File(selectedFile.getAbsolutePath() + "_output.JSON"));
        if(isCSV.isSelected())
            new ToCSV().convert(new File(selectedFile.getAbsolutePath() + "_output.CSV"));

        chooseFile.setText("Converted");
    }

}
