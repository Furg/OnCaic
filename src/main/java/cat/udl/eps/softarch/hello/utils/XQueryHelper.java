package cat.udl.eps.softarch.hello.utils;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.xquery.*;

/**
 * Created by http://rhizomik.net/~roberto/
 */
public class XQueryHelper {
    private static final Logger  log = Logger.getLogger(XQueryHelper.class.getName());

    private XQPreparedExpression expr;
    private XQConnection         conn;

    private JAXBContext          jaxbContext;
    private Unmarshaller         jaxbUnmarshaller;

    static final String apiURL   = "http://aba8.hol.es/RTCBI_ST-TO5_curt.xml";
    static final String hostingsXQ =
             "declare variable $doc external;\n"
            +"for $r in $doc//objRegistral\n"
            + "return\n"
            + "<hostingXML>\n"
            + "<name>{$r//retol/text()}</name>\n"
            + "<email>{$r//email/text()}</email>\n"
            + "<utm_x>{$r//utm_x/text()}</utm_x>\n"
            + "<utm_y>{$r//utm_y/text()}</utm_y>\n"
            + "</hostingXML>";

    @XmlRootElement
    public static class HostingXML {
        @XmlElement String name;
        @XmlElement String email;
        @XmlElement String utm_x;
        @XmlElement String utm_y;
        double[] latlong;

        @Override
        public String toString() {
            return "Name: "+name+"\n"+"Email: "+email+"\n"+"UTM X: "+utm_x+"\n"+"UTM Y: "+utm_y+"\n"+"Lat: "+latlong[0]+"\n"+"Long: "+latlong[1]+"\n";
        }

        public String getName(){
            return name;
        }

        public double[] getLatlong(){
            return latlong;
        }

        public String getEmail(){
            return email;
        }
    }

    XQueryHelper(String xquery, URL url)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, XQException, IOException, JAXBException {
        URLConnection urlconn = url.openConnection();
        urlconn.setReadTimeout(50000);
        XQDataSource xqds = (XQDataSource) Class.forName("net.sf.saxon.xqj.SaxonXQDataSource").newInstance();
        this.conn = xqds.getConnection();
        this.expr = conn.prepareExpression(xquery);
        this.expr.bindDocument(new javax.xml.namespace.QName("doc"), urlconn.getInputStream(), null, null);

        this.jaxbContext = JAXBContext.newInstance(HostingXML.class);
        this.jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    }

    ArrayList<HostingXML> getHostingXML() {
        ArrayList<HostingXML> hostingsXML = new ArrayList<HostingXML>();
        try {
            XQResultSequence rs = this.expr.executeQuery();
            while (rs.next()) {
                XQItem item = rs.getItem();
                HostingXML hostingXML = (HostingXML) jaxbUnmarshaller.unmarshal(item.getNode());
                CoordinateConversion coord = new CoordinateConversion();
                hostingXML.latlong = coord.utm2LatLon("31 31 "+hostingXML.utm_x+" "+hostingXML.utm_y);
                hostingsXML.add(hostingXML);
            }
        }
        catch (Exception e) {
            log.log(Level.SEVERE, e.getMessage());
        }
        finally { close(); }
        return hostingsXML;
    }

    private void close() {
        try {
            this.expr.close();
            this.conn.close();
        } catch (XQException e) {
            log.log(Level.SEVERE, e.getMessage());
        }
    }

    public static ArrayList<HostingXML> intent1() {
        try {
            XQueryHelper xQueryHelper = new XQueryHelper(hostingsXQ, new URL(apiURL));
            ArrayList<HostingXML> hostingsXML = xQueryHelper.getHostingXML();
            for (HostingXML hostingXML : hostingsXML) {
                System.out.println(hostingXML);
            }
            return hostingsXML;
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<HostingXML>();
        }
    }

    public static void main(String[] args) {
        try {
            XQueryHelper xQueryHelper = new XQueryHelper(hostingsXQ, new URL(apiURL));
            ArrayList<HostingXML> hostingsXML = xQueryHelper.getHostingXML();
            for (HostingXML hostingXML : hostingsXML)
                System.out.println(hostingXML);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}