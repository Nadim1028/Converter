package main;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Converter {

    private static ArrayList<Parser> parsers = new ArrayList<>();
    public static String JSONFormat;
    public static String XMLFormat;
    public static String CSVFormat;

    public static void takeInputFromTextFileAndParse(File file) throws FileNotFoundException
    {
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
            Parser parser = new Parser();
            String[] line;
            String value;

            line = sc.nextLine().split("=");
            value = line[1];
            parser.setName(value);

            line = sc.nextLine().split("=");
            value = line[1];
            parser.setEmail(value);

            line = sc.nextLine().split("=");
            value = line[1];
            parser.setPassword(value);

            line = sc.nextLine().split("=");
            value = line[1];
            parser.setPhoneNumber(value);

            parsers.add(parser);

        }

        convert();
    }

    public static void convert()
    {
        JSONArray jsonArray = new JSONArray();

        try {

            for (Parser parser : parsers) {

                JSONObject details = new JSONObject();

                details.put("Name", parser.getName());
                details.put("Email", parser.getEmail());
                details.put("Password", parser.getPassword());
                details.put("Phone Number", parser.getPhoneNumber());

                jsonArray.put(details);

            }

            JSONFormat = jsonArray.toString();
            XMLFormat = XML.toString(jsonArray);
            CSVFormat = CDL.toString(jsonArray);

        } catch (Exception e) {
            System.out.println("Faild to Parse Text File! error: " + e.getMessage());
        }

    }

}