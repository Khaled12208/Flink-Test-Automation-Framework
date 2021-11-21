package org.uiframework.framework.datahandler;

import org.uiframework.framework.helpers.ReadFilesFromResources;

import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

/*This Class for handling reading data from external properties File*/
public class Prop extends DataFile {

    // global variables
    private ReadFilesFromResources FileReader;
    private Properties prop;
    private final String resourceFilePath;
    private final Class<?> Class;

    // Constructor to init the class path and file path and super data type as Properties file
    public Prop(String resourceFilePath, Class<?> Class) {

        this.resourceFilePath = resourceFilePath;
        this.Class = Class;
        super.Type = DataFileType.PROP;


    }

    // Function to read the data as Properties <Key,Value> and return it in HashMap
    @Override
    protected DataFile ReadData() throws Exception {
        this.prop = new Properties();
        this.FileReader = new ReadFilesFromResources();
        super.Data = new HashMap<>();
        try {
            prop.load(FileReader.readResourcesAsFileInputStream(resourceFilePath, Class));
            Set<Object> keys = prop.keySet();
            HashMap RowData = new HashMap<String, String>();

            for (Object k : keys) {
                String key = (String) k;
                RowData.put(key, prop.getProperty(key));

            }
            logger.debug(" Data loaded " );
            super.Data = RowData;
        } catch (Exception e) {
            logger.error("couldn't read data as Properties ! " );
            throw new Exception("Error : Couldn't Load Properties File: " + resourceFilePath, e);
        }
        return this;
    }


}
