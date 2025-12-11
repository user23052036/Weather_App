import org.json.JSONObject;
import org.json.JSONArray;
import org.json.XML;

/**
 * Demonstrates how to convert JSON data to XML format using the org.json library.
 * This class shows JSON-to-XML conversion and also demonstrates how to parse
 * nested JSON objects and arrays to extract specific data.
 * 
 * Purpose: Educational example for beginners learning JSON to XML conversion.
 * Expected Output: Prints XML representation of JSON data, then parses and displays address details.
 */
class JSON2xml 
{
    /**
     * Main method that demonstrates JSON to XML conversion and JSON parsing.
     * Converts a complex JSON string to XML format and extracts nested address data.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) 
    {  
        // Sample JSON string with website information including nested objects and arrays
        String json = "{\"website\":{\"address\":[{\"area\":\"Mumbai\",\"plot\":53,\"type\":\"office\",\"sector\":20},{\"area\":\"Navi Mumbai\",\"plot\":35,\"type\":\"hq\",\"sector\":10}],\"serverDetails\":{\"hostingStatus\":\"active\",\"serverOS\":\"Linux\"},\"phone\":[12345,54321,\"098765\",999888],\"author\":\"Zartab Nakhwa\",\"name\":\"1LineCode\",\"url\":\"www.1LineCode.com\"}}";
        
        // Convert JSON string to JSONObject
        JSONObject obj = new JSONObject(json);
        
        // Convert JSONObject to XML string
        String xml = XML.toString(obj);
        System.out.println(xml);
        
        System.out.println("\n\n-------parsing data from JSON file----------\n\n");
        
        // Extract the nested "website" object from the main JSON
        JSONObject obj_web = obj.getJSONObject("website");
        
        // Get the "address" array from the website object
        JSONArray array = obj_web.getJSONArray("address");
        
        System.out.println("ADDRESS");
        
        // Loop through each address object in the array
        for(int i=0; i<array.length(); i++)
        {
            // Get the current address object
            JSONObject sub_obj = array.getJSONObject(i);
            
            // Extract individual fields from the address object
            String area = sub_obj.getString("area");
            int plot = sub_obj.getInt("plot");
            String type = sub_obj.getString("type");
            int sector = sub_obj.getInt("sector");
            
            // Print the extracted address details
            System.out.println("area: "+area+"\nplot: "+plot+"\ntype: "+type+"\nsector: "+sector);
        }
    }
}