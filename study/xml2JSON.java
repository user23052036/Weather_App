import org.json.JSONObject;
import org.json.XML;

/**
 * Demonstrates how to convert XML data to JSON format using the org.json library.
 * This class shows XML-to-JSON conversion by parsing an XML string and
 * converting it to a JSONObject, then displaying it as a JSON string.
 * 
 * Purpose: Educational example for beginners learning XML to JSON conversion.
 * Expected Output: Prints JSON representation of the XML data.
 */
class xml2JSON
{
    /**
     * Main method that demonstrates XML to JSON conversion.
     * Takes an XML string containing website information and converts it to JSON format.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) 
    {
        // Sample XML string with website information including addresses, server details, and contact info
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><website><address><area>Mumbai</area><plot>53</plot><type>office</type><sector>20</sector></address><address><area>Navi Mumbai</area><plot>35</plot><type>hq</type><sector>10</sector></address><serverDetails><hostingStatus>active</hostingStatus><serverOS>Linux</serverOS></serverDetails><phone>12345</phone><phone>54321</phone><phone>098765</phone><phone>999888</phone><author>Zartab Nakhwa</author><name>1LineCode</name><url>www.1LineCode.com</url></website>";
        
        // Convert XML string to JSONObject
        JSONObject obj = XML.toJSONObject(xml);
        
        // Convert JSONObject to a formatted JSON string
        String json = obj.toString();
        
        // Print the resulting JSON
        System.out.println(json);
    }
}