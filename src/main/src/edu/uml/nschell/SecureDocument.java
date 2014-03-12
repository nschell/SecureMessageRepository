package edu.uml.nschell;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Administrator on 2/19/14.
 */


@XmlRootElement
public class SecureDocument {

    private Date createDate;
    private String username;
    private Date modifiedDate;
    private String Subject;
    private String Information;
    private Boolean accessControl;


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDateValue) {
        this.createDate = createDateValue;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String usernameValue) {
        this.username = usernameValue;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDateValue) {
        this.modifiedDate = modifiedDateValue;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String SubjectValue) {
        this.Subject = SubjectValue;
    }

    public String getInformation() {
        return Information;
    }

    public void setInformation(String InformationValue) {
        this.Information = InformationValue;
    }

    public Boolean getAccessControl() {
        return accessControl;
    }

    public void setAccessControl(Boolean accessControlValue) {
        this.accessControl = accessControlValue;
    }

}
