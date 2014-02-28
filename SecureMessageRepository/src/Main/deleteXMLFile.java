package Main;

import java.io.File;

/**
 * Created by Administrator on 2/28/14.
 */

//Action that can be taken by the file Owner to remove the Message and Access Metadata from disk

public class deleteXMLFile {

    public static Boolean deleteXML(String path) {
        File file = new File(path);
        String path2 = "Access" + path;
        File access = new File(path2);
        Boolean deleteFile;
        Boolean deleteAccess;

        if(file.delete()) {
            deleteFile = true;
        } else {
            deleteFile = false;
        }

        if(access.delete()) {
            deleteAccess = true;
        } else {
            deleteAccess = false;
        }

        if((deleteFile = true) && (deleteAccess = true)) {
            return true;
        } else {
            return false;
        }



    }

}
