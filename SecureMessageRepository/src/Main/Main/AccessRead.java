package Main;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by nschell
 */
@XmlRootElement(name = "Read Access")
public class AccessRead {
    private String read;
    @XmlElement(name = "read")
    private List<String> listread = null;

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }

    public List<String> getListread() {
        return listread;
    }

    public void setListread(List<String> listread) {
        this.listread = listread;
    }

}
