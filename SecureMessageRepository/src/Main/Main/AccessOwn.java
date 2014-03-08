package Main;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by nschell
 */
@XmlRootElement(name = "Own Access")
public class AccessOwn {

    private String own;
    @XmlElement(name = "own")
    private List<AccessOwn> listown = null;

    public String getOwn() {
        return own;
    }

    public void setOwn(String own) {
        this.own = own;
    }

    public List<AccessOwn> getListown() {
        return listown;
    }

    public void setListown(List<AccessOwn> listown) {
        this.listown = listown;
    }
}