package Main;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by nschell
 */
@XmlRootElement(name = "Write Access")
public class AccessWrite {

        private String write;
        @XmlElement(name = "write")
        private List<AccessWrite> listwrite = null;

        public String getWrite() {
            return write;
        }

        public void setWrite(String write) {
            this.write = write;
        }

        public List<AccessWrite> getListwrite() {
            return listwrite;
        }

        public void setListwrite(List<AccessWrite> listwrite) {
            this.listwrite = listwrite;
        }
}
