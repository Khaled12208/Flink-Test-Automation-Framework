package org.uiframework.framework.datahandler;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;

import java.util.HashMap;

public abstract class DataFile {

    protected HashMap<String, String> Data;
    protected DataFileType Type;
    protected JSONObject jsonBody;
    protected static final Logger logger = LogManager.getLogger(DataFile.class);


    protected abstract DataFile ReadData() throws Exception;

    public Object getData() {

        switch (Type)
        {
            case PROP:
                logger.debug(" properties Data Body is loaded successfully ");
                return Data;
            case JSON:
                logger.debug(" JSON Data Body is loaded successfully ");
                return jsonBody;
            default:
                logger.error("could load data ata Data reader");
                throw new NullPointerException();
        }

    }



}
