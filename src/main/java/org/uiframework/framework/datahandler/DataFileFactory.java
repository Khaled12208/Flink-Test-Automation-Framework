package org.uiframework.framework.datahandler;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import java.util.HashMap;

public class DataFileFactory {

    private String resourceFilePath;
    private DataFileType type;
    private Class<?> Class;
    protected static final Logger logger = LogManager.getLogger(DataFileFactory.class);

    // Constructor to inti the current class to read the directory
    public DataFileFactory(Class<?> Class) {
        logger.debug("Class : " +Class.getName() + "initialized successful in the data factory ");
        this.Class = Class;
    }
    // Function to set Data file type
    public DataFileFactory DataFileType(DataFileType type) {
        logger.debug("Data File Type is : " +type );
        this.type = type;
        return this;
    }
    // Resource File Name Setting
    public DataFileFactory FromResourceFile(String resourceFilePath) {
        logger.debug("Data resources file File Type is : " +resourceFilePath );
        this.resourceFilePath = resourceFilePath;
        return this;
    }

    // This function to read the data as hashmap for properties file only
    public HashMap<String, String> asHashMap() throws Exception {
        if (type == DataFileType.JSON) {
            throw new RuntimeException("File type JSON cannot be loaded as Hashmap");

        }
        DataFile Object = null;
        Object = new Prop(resourceFilePath, Class);
        Object.ReadData();
        logger.debug("Reading Data form "+resourceFilePath+"as properties file in class path "+ Class.getName());

        return (HashMap<String, String>) Object.getData();

    }

    // This function to read the data as JSON Object for Json file only
    public JSONObject asJSONObject() throws Exception {
        if (type == DataFileType.PROP) {
            throw new RuntimeException("File type PROP cannot be loaded as JSONObject");

        }
        DataFile Object = null;
        Object = new Json(resourceFilePath, Class);
        Object.ReadData();
        logger.debug("Reading Data form "+resourceFilePath+"as JSON file in class path "+ Class.getName());
        return (JSONObject) Object.getData();


    }


}
