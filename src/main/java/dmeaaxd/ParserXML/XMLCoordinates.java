package dmeaaxd.ParserXML;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "coordinates")

/*
  This class is needed to get x and y values inside coordinates
 */

public class XMLCoordinates
{
    @Element(name = "x")
    private String x;
    @Element(name = "y")
    private String y;

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }
}
