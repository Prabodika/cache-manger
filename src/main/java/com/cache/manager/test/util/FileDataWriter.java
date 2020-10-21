package com.cache.manager.test.util;


import com.cache.manager.test.domain.CacheDomain;
import com.cache.manager.test.exception.FileException;

import java.io.*;

public class FileDataWriter {


    private static  FileDataWriter fileDataWriter=null;

    private FileDataWriter(){ }

    public static FileDataWriter getInstance(){

        if(fileDataWriter==null){
            fileDataWriter=new FileDataWriter();
        }
        return fileDataWriter;
    }


    /**
     * @param fileName
     * @param domain
     */
    public void writeToFile(String fileName, CacheDomain domain) {

        try {
            String file = getFileName(fileName);

            FileOutputStream fileOutputStream = new FileOutputStream(new File(file));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            // Write objects to file
            objectOutputStream.writeObject(domain);

            fileOutputStream.close();
            objectOutputStream.close();


        }
        //todo: need to implement exception hierarchy
        catch (Exception  e) {
            throw new FileException(e.getMessage());
        }
    }


    /**
     * This
     *
     * @param fileName
     * @return
     */
    public CacheDomain readFile(String fileName) {

        CacheDomain data = null;

        try {
            String file = getFileName(fileName);

            FileInputStream fileinputStream = new FileInputStream(new File(file));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileinputStream);

            // Read objects
            data = (CacheDomain) objectInputStream.readObject();
            objectInputStream.close();
            fileinputStream.close();


        }
        //todo: need to implement exception hierarchy
        catch (Exception  e) {
            throw new FileException(e.getMessage());
        }
        return data;
    }

    /**
     * This method delete the
     *
     * @param fileName
     * @return
     */
    public boolean deleteFile(String fileName) {

        String fileNameFull = getFileName(fileName);
        File file = new File(fileNameFull);
        return file.delete();
    }

    /**
     * This return the file name
     *
     * @param fileName
     * @return
     */
    private String getFileName(String fileName) {

        StringBuilder fileNameBuilder = new StringBuilder();
        fileNameBuilder.append(fileName);
        fileNameBuilder.append(".txt");
        return fileNameBuilder.toString();

    }


}
