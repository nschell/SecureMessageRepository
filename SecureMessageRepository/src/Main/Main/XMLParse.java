package Main;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2/19/14.
 */
public class XMLParse {

    public XMLParse() {

    }

    public static void objectToXML(SecureDocument securedocument, String filePath) throws FileNotFoundException {
        try {
            JAXBContext context = JAXBContext.newInstance(SecureDocument.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            QName qName = new QName("main.java", "securedocument");
            JAXBElement<SecureDocument> root = new JAXBElement<SecureDocument>(qName, SecureDocument.class, securedocument);
            marshaller.marshal(securedocument, new FileOutputStream(filePath));

        } catch (JAXBException e) {
            e.printStackTrace();

        }
    }

    public static SecureDocument XMLToObject(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(SecureDocument.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SecureDocument securedocument = (SecureDocument) unmarshaller.unmarshal(new File(filePath));
            return securedocument;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void SecureobjectToXML(AccessControl accesscontrol, String filePath) throws FileNotFoundException {
        try {
            JAXBContext context = JAXBContext.newInstance(AccessControl.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            QName qName = new QName("main.java", "s");
            JAXBElement<AccessControl> root = new JAXBElement<AccessControl>(qName, AccessControl.class, accesscontrol);
            marshaller.marshal(accesscontrol, new FileOutputStream(filePath));

        } catch (JAXBException e) {
            e.printStackTrace();

        }
    }

    public static AccessControl SecureXMLToObject(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(AccessControl.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            AccessControl accesscontrol = (AccessControl) unmarshaller.unmarshal(new File(filePath));
            return accesscontrol;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
