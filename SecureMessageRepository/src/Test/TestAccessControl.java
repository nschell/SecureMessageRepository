package Test;
import Main.SecureDocument;
import Main.AccessControl;
import Main.XMLParse;
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
 * Created by Administrator on 2/20/14.
 */

//Writes the Access Control type to an XML file

public class TestAccessControl {

    public void AccessControlTest() throws ParseException, FileNotFoundException {

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

        SecureDocument e = new SecureDocument();
        String creationDatee = "December 12, 2013";
        Date createDatee = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(creationDatee);
        e.setCreateDate(createDatee);
        String modificationDatee = "December 12, 2013";
        Date modifyDatee = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(modificationDatee);
        e.setModifiedDate(modifyDatee);
        e.setUsername("nschell");
        e.setSubject("Confidential Info");
        e.setInformation("Jack Bauer on his way to England, thwarting a terrorist attack for 24 Live Another Day");
        e.setAccessControl(true);

        SecureDocument f = new SecureDocument();
        String creationDatef = "December 12, 2013";
        Date createDatef = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(creationDatef);
        f.setCreateDate(createDatef);
        String modificationDatef = "December 12, 2013";
        Date modifyDatef = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(modificationDatef);
        f.setModifiedDate(modifyDate);
        f.setUsername("nschell");
        f.setSubject("Confidential Info");
        f.setInformation("Jack Bauer on his way to England, thwarting a terrorist attack for 24 Live Another Day");
        f.setAccessControl(true);

        SecureDocument g = new SecureDocument();
        String creationDateg = "December 12, 2013";
        Date createDateg = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(creationDateg);
        g.setCreateDate(createDateg);
        String modificationDateg = "December 12, 2013";
        Date modifyDateg = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(modificationDateg);
        g.setModifiedDate(modifyDate);
        g.setUsername("nschell");
        g.setSubject("Confidential Info");
        g.setInformation("Jack Bauer on his way to England, thwarting a terrorist attack for 24 Live Another Day");
        g.setAccessControl(true);

        AccessControl h = new AccessControl();
        Boolean readControl = true;
        String readControlList[] = {"eschell", "vschell", "sschell"};
        Boolean writeControl = false;
        String writeControlList[] = {};
        Boolean ownControl = true;
        String ownControlList[] = {"nschell"};
        h.setReadControl(readControl);
        h.setReadControlList(readControlList);
        h.setWriteControl(writeControl);
        h.setWriteControlList(writeControlList);
        h.setOwnControl(ownControl);
        h.setOwnControlList(ownControlList);

        AccessControl i = new AccessControl();
        Boolean ireadControl = true;
        String ireadControlList[] = {"sschell"};
        Boolean iwriteControl = true;
        String iwriteControlList[] = {"eschell"};
        Boolean iownControl = true;
        String iownControlList[] = {"nschell"};
        i.setReadControl(ireadControl);
        i.setReadControlList(ireadControlList);
        i.setWriteControl(iwriteControl);
        i.setWriteControlList(iwriteControlList);
        i.setOwnControl(iownControl);
        i.setOwnControlList(iownControlList);

        AccessControl j = new AccessControl();
        Boolean jreadControl = true;
        String jreadControlList[] = {"eschell", "vschell", "sschell"};
        Boolean jwriteControl = false;
        String jwriteControlList[] = {};
        Boolean jownControl = true;
        String jownControlList[] = {"nschell"};
        j.setReadControl(jreadControl);
        j.setReadControlList(jreadControlList);
        j.setWriteControl(jwriteControl);
        j.setWriteControlList(jwriteControlList);
        j.setOwnControl(jownControl);
        j.setOwnControlList(jownControlList);

        XMLParse.objectToXML(d, "c:\\test\\test1.xml");
        XMLParse.objectToXML(e, "c:\\test\\test2.xml");
        XMLParse.objectToXML(f, "c:\\test\\test3.xml");
        XMLParse.objectToXML(g, "c:\\test\\test4.xml");

        XMLParse.SecureobjectToXML(h, "c:\\test\\Accesstest2.xml");
        XMLParse.SecureobjectToXML(i, "c:\\test\\Accesstest3.xml");
        XMLParse.SecureobjectToXML(j, "c:\\test\\Accesstest4.xml");

    }

}
