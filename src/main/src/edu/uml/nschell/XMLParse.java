package edu.uml.nschell;

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

    public static void AccessControlObjToXML(CurrentUser currentUser, String filePath) throws FileNotFoundException {
        try {
            JAXBContext context = JAXBContext.newInstance(CurrentUser.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            QName qName = new QName("main.java", "s");
            JAXBElement<CurrentUser> root = new JAXBElement<CurrentUser>(qName, CurrentUser.class, currentUser);
            marshaller.marshal(currentUser, new FileOutputStream(filePath));

        } catch (JAXBException e) {
            e.printStackTrace();

        }

    }

    public static CurrentUser AccessControlXMLToObj(String filePath) {

        try {
            JAXBContext context = JAXBContext.newInstance(CurrentUser.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            CurrentUser currentUser = (CurrentUser) unmarshaller.unmarshal(new File(filePath));
            return currentUser;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;


    }

    public static void AuthenticationObjectToXML(UsernamePassword usernamePassword, String filePath) throws FileNotFoundException {
        try {
            JAXBContext context = JAXBContext.newInstance(UsernamePassword.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            QName qName = new QName("main.java", "s");
            JAXBElement<UsernamePassword> root = new JAXBElement<UsernamePassword>(qName, UsernamePassword.class, usernamePassword);
            marshaller.marshal(usernamePassword, new FileOutputStream(filePath));

        } catch (JAXBException e) {
            e.printStackTrace();

        }

    }

    public static UsernamePassword AuthenticationXMLToObject(String filePath) {

        try {
            JAXBContext context = JAXBContext.newInstance(UsernamePassword.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            UsernamePassword usernamePassword = (UsernamePassword) unmarshaller.unmarshal(new File(filePath));
            return usernamePassword;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;


    }

}
