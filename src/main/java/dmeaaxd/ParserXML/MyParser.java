package dmeaaxd.ParserXML;

import dmeaaxd.collection.*;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;

/**
 * Parser class
 *
 * @author Maksim Ushakov
 */

public class MyParser {

    /**
     * The method translates bytes (BufferedInputStream) into text
     * @param path_to_file The path to file
     * @return XML file text
     */

    public String readXML(String path_to_file) throws IOException {
        File file = new File(path_to_file);
        BufferedReader br = new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), StandardCharsets.UTF_8));
        String line;
        StringBuilder xmlText = new StringBuilder("");
        while ((line = br.readLine()) != null) {
            xmlText.append(line);
        }
        return xmlText.toString();
    }

    /**
     * The method receives the text of the XML file and extracts the values ​​for HumanBeing from it
     * @param path_to_file The path to file
     * @return collection from file
     */

    public ArrayList<HumanBeing> parse(String path_to_file) throws Exception {
        Serializer serializer = new Persister();
        XMLRoot root = serializer.read(XMLRoot.class, readXML(path_to_file));
        ArrayList<HumanBeing> collecion = new ArrayList<>();


        for (XMLHumanBeing xmlHumanBeing : root.getProperties()){

            Long id = Long.parseLong(xmlHumanBeing.getId());

            String name = xmlHumanBeing.getName();

            Integer x = Integer.parseInt(xmlHumanBeing.getCoordinates().getX());

            Double y = Double.parseDouble(xmlHumanBeing.getCoordinates().getY());

            Coordinates coordinates = new Coordinates(x, y);

            java.util.Date creationDate = new Date(Long.parseLong(xmlHumanBeing.getCreationDate()));

            Boolean realHero = Boolean.parseBoolean(xmlHumanBeing.getRealHero());

            Boolean hasToothpick = Boolean.parseBoolean(xmlHumanBeing.getHasToothpick());

            Long impactSpeed = Long.parseLong(xmlHumanBeing.getImpactSpeed());

            WeaponType weaponType = WeaponType.valueOf(xmlHumanBeing.getWeaponType());

            Mood mood = Mood.valueOf(xmlHumanBeing.getMood());

            Boolean cool = Boolean.parseBoolean(xmlHumanBeing.getCar());

            Car car = new Car(cool);

            HumanBeing humanBeing = new HumanBeing(id, name, coordinates, creationDate, realHero, hasToothpick, impactSpeed, weaponType, mood, car);

            collecion.add(humanBeing);
        }
        return collecion;
    }
}
