package org.uiframework.framework.datahandler;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.uiframework.framework.helpers.ReadFilesFromResources;

/*This Class for handling reading data from external json File*/

public class Json extends DataFile {

    // global variables
    private ReadFilesFromResources FileReader;
    private final String resourceFilePath;
    private final Class<?> Class;

    // Constructor to init the class path and file path and super data type as JSON
    public Json(String resourceFilePath, Class<?> Class) {
        this.resourceFilePath = resourceFilePath;
        this.Class = Class;
        super.Type = DataFileType.JSON;


    }

    // Function to read the data as Json object
    @Override
    protected DataFile ReadData() throws Exception {
        FileReader = new ReadFilesFromResources();

        try {
            String Body = FileReader.readFileAsString(resourceFilePath, Class);
            JSONParser parser = new JSONParser();
            jsonBody = (JSONObject) parser.parse(Body);
            logger.debug(" Data loaded " );

        } catch (Exception e) {
            logger.error("couldn't read data as JSON ! " );
            throw new Exception("Error! : Couldn't Find JSON File: " + resourceFilePath, e);

        }
        return this;
    }


}
