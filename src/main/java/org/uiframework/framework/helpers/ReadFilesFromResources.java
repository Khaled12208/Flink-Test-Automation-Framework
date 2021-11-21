package org.uiframework.framework.helpers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.uiframework.framework.datahandler.DataFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

// This helper class is used to read all types of file as(File , FileReader, InputStream and string)

public class ReadFilesFromResources {

    // Test resource file path
    private String TestResourceFilePath;
    protected static final Logger logger = LogManager.getLogger(DataFile.class);

    // This Function to read files as File Reader
    public FileReader readResourcesAsFileReader(String TestResourceFile, Class<?> Class) throws Exception {

        FileReader file = null;
        TestResourceFilePath = BuildPath(Class, TestResourceFile);
        try {
            file = new FileReader(TestResourceFilePath);
            System.out.println(file);
            logger.debug("reading data from: " + TestResourceFilePath + " As FileReader ");
            return file;
        } catch (Exception e) {
            logger.debug("Couldn't read data from : " +TestResourceFilePath + " As File" );
            throw new Exception("couldn't Load File as FileReader ", e);
        }
    }
    // This Function to read files as File Input Stream
    public FileInputStream readResourcesAsFileInputStream(String TestResourceFile, Class<?> Class) throws Exception {

        FileInputStream file = null;
        TestResourceFilePath = BuildPath(Class, TestResourceFile);
        try {
            file = new FileInputStream(TestResourceFilePath);
            logger.debug("reading data from: " + TestResourceFilePath + " As InputStream ");
            return file;

        } catch (Exception e) {
            logger.debug("Couldn't read data from : " +TestResourceFilePath + " As File" );
            throw new Exception("couldn't Load File as Input Stream ", e);
        }
    }
    // This Function to read files as File
    public File readResourcesAsFile(String TestResourceFile, Class<?> Class) throws Exception {

        File file = null;
        TestResourceFilePath = BuildPath(Class, TestResourceFile);
        try {
            file = new File(TestResourceFilePath);
            logger.debug("reading data from: " + TestResourceFilePath + " As File ");

            return file;
        } catch (Exception e) {
            logger.debug("Couldn't read data from : " +TestResourceFilePath + " As File" );
            throw new Exception("couldn't Load File as Input Stream ", e);

        }

    }

    // This Function to read files as String
    public String readFileAsString(String file, Class<?> Class) throws Exception {
        TestResourceFilePath = BuildPath(Class, file);
        logger.debug("reading data from: " + TestResourceFilePath + " As String ");
        return new String(Files.readAllBytes(Paths.get(TestResourceFilePath)));
    }


    // This Function to Build the File Path based on the class path
    private String BuildPath(Class<?> Class, String TestResourceFile) {

        String ClassName = Class.getName();
        String[] Path = ClassName.split("\\.");
        StringBuffer sb = new StringBuffer();
        sb.append("src/test/resources/");
        for (int i = 0; i < Path.length - 1; i++) {
            sb.append(Path[i] + "/");
        }
        sb.append(TestResourceFile);
        this.TestResourceFilePath = sb.toString();
        logger.debug("Data Full Path is : " + TestResourceFilePath);
        return sb.toString();

    }


}
