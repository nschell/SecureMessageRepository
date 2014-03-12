
package edu.uml.nschell;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Administrator on 2/19/14.
 */


public class TestXMLParse {

    @Test
    public void XMLParseTest() throws ParseException, FileNotFoundException {


        /*Set Values*/
        SecureDocument d = new SecureDocument();
        String creationDate = "December 12, 2013";
        Date createDate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(creationDate);
        d.setCreateDate(createDate);
        String modificationDate = "December 12, 2013";
        Date modifyDate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(modificationDate);
        d.setModifiedDate(modifyDate);
        d.setUsername("nschell");
        d.setSubject("Confidential Info");
        d.setInformation("Jack Bauer on his way to England, thwarting a terrorist attack for 24 Live Another Day");
        d.setAccessControl(false);


        /*Expected values */
        String creationDateExpected = "December 12, 2013";
        Date createDateExpected = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(creationDateExpected);
        String modificationDateExpected = "December 12, 2013";
        Date modifyDateExpected = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(modificationDateExpected);
        String usernameExpected = "nschell";
        String subjectExpected = "Confidential Info";
        String documentExpected = "Jack Bauer on his way to England, thwarting a terrorist attack for 24 Live Another Day";
        Boolean accesscontrolExpected = false;

        XMLParse.objectToXML(d, "C:\\test\\test.xml");
        SecureDocument testDoc = XMLParse.XMLToObject("C:\\test\\test.xml");

        Assert.assertEquals(createDateExpected, testDoc.getCreateDate());
        Assert.assertEquals(modifyDateExpected, testDoc.getCreateDate());
        Assert.assertEquals(usernameExpected, testDoc.getUsername());
        Assert.assertEquals(subjectExpected, testDoc.getSubject());
        Assert.assertEquals(documentExpected, testDoc.getInformation());
        Assert.assertEquals(accesscontrolExpected, testDoc.getAccessControl());
    }
}
