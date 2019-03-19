import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class dom {
	public static void main(String[] args) {
		try {
			int i;
			File xml_file = new File("reed.xml");
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(xml_file);
			document.getDocumentElement().normalize();
			NodeList n_list = document.getElementsByTagName("course");
			int length = n_list.getLength();
			System.out.println("Titles of all MATH courses that are taught in room LIB 204");
			for(i=0;i < length; i ++ ) {
				Node n = n_list.item(i);
				Element e = (Element) n;
				String subj = e.getElementsByTagName("subj").item(0).getTextContent();
				if(subj.equals("MATH")) {
					NodeList place_list = e.getElementsByTagName("place");
					String location = place_list.item(0).getTextContent();
					if(location.equals("LIB204")) {
						System.out.println(e.getElementsByTagName("title").item(0).getTextContent());
					}
				}
					}
		}
		catch (Exception e) {
	         e.printStackTrace();
	      }
}
}

