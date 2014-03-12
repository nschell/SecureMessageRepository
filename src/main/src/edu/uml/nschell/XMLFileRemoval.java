package edu.uml.nschell;

import java.io.File;

/**
 * Created by Administrator on 2/28/14.
 */

//Action that can be taken by the file Owner to remove the Message and Access Metadata from disk

public class XMLFileRemoval {

    public static Boolean deleteXML(String path) {
        File file = new File(path);
        String path2 = "Access" + path;
        File access = new File(path2);
        Boolean deleteFile;
        Boolean deleteAccess;

        //Ensure that the XML file itself is deleted, returns a false code if undeletable

        if(file.delete()) {
            deleteFile = true;
        } else {
            deleteFile = false;
        }

        //Ensure that the Access Value file itself is deleted, returns a false code if undeletable

        if(access.delete()) {
            deleteAccess = true;
        } else {
            deleteAccess = false;
        }

        //Returns true if both the file and access file are deleted

        if((deleteFile = true) && (deleteAccess = true)) {
            return true;
        } else {
            return false;
        }



    }

}
