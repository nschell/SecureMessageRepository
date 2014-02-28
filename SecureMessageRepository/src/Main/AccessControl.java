package Main;

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

    public void setReadControl(Boolean readControl) {
        this.readControl = readControl;
    }

    public String[] getReadControlList() {
        return readControlList;
    }

    public void setReadControlList(String[] readControlList) {
        this.readControlList = readControlList;
    }

    public Boolean getWriteControl() {
        return writeControl;
    }

    public void setWriteControl(Boolean writeControl) {
        this.writeControl = writeControl;
    }

    public String[] getWriteControlList() {
        return writeControlList;
    }

    public void setWriteControlList(String[] writeControlList) {
        this.writeControlList = writeControlList;
    }

    public Boolean getOwnControl() {
        return ownControl;
    }

    public void setOwnControl(Boolean ownControl) {
        this.ownControl = ownControl;
    }

    public String[] getOwnControlList() {
        return ownControlList;
    }

    public void setOwnControlList(String[] ownControlList) {
        this.ownControlList = ownControlList;
    }






}
