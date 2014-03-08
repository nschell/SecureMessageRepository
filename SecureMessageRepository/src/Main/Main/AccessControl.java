package Main;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Administrator on 2/28/14.
 */
@XmlRootElement

public class AccessControl {

    private Boolean readControl;
    private String[] readControlList;
    private Boolean writeControl;
    private String[] writeControlList;
    private Boolean ownControl;
    private String[] ownControlList;

    public Boolean getReadControl() {
        return readControl;
    }

    public void setReadControl(Boolean readControlValue) {
        this.readControl = readControlValue;
    }

    @XmlElement(name = "Control List")
    public String[] getReadControlList() {
        return readControlList;
    }

    public void setReadControlList(String[] readControlListValue) {
        this.readControlList = readControlListValue;
    }

    public Boolean getWriteControl() {
        return writeControl;
    }

    public void setWriteControl(Boolean writeControlValue) {
        this.writeControl = writeControlValue;
    }
    @XmlElement(name = "Control List")
    public String[] getWriteControlList() {
        return writeControlList;
    }

    public void setWriteControlList(String[] writeControlListValue) {
        this.writeControlList = writeControlListValue;
    }

    public Boolean getOwnControl() {
        return ownControl;
    }

    public void setOwnControl(Boolean ownControlValue) {
        this.ownControl = ownControlValue;
    }

    public String[] getOwnControlList() {
        return ownControlList;
    }

    public void setOwnControlList(String[] ownControlListValue) {
        this.ownControlList = ownControlListValue;
    }






}
