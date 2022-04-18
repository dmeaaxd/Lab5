package dmeaaxd.ParserXML;


import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "root")

/*
  This class is needed in order to get the elements of the XML file
 */

public class XMLRoot {

    @ElementList(inline = true)
    private List<XMLHumanBeing> list;

    public List<XMLHumanBeing> getProperties() {
        return list;
    }
}
