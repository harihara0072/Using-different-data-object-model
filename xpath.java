import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class xpath {
	public static void main(String[] args) {
		try {
			int i;
			int j;
			int k;
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = builder.parse(new File("reed.xml"));
			document.getDocumentElement().normalize();
			XPath xpath =  XPathFactory.newInstance().newXPath();
			String first = "/root/course[subj='MATH']/place[building='LIB' and room=204]/../title/text()";
			String second = "/root/course[subj='MATH' and crse=412]/instructor/text()";
			String  third = "/root/course[instructor='Wieting']/title/text()";
			System.out.println("First Question:");
			NodeList n_list1 = (NodeList) xpath.compile(first).evaluate(
					document, XPathConstants.NODESET);
			int length1 = n_list1.getLength();
			for(i=0;i < length1; i ++ ) {
				System.out.println(n_list1.item(i).getNodeValue());
				 				}
			System.out.println("\nSecond Question:");
			NodeList n_list2 = (NodeList) xpath.compile(second).evaluate(
					document, XPathConstants.NODESET);
			int length2 = n_list2.getLength();
			for(j=0;j < length2; j ++ ) {
				System.out.println(n_list2.item(j).getNodeValue());
				 				}
			
			System.out.println("\nThird Question:");
			NodeList n_list3 = (NodeList) xpath.compile(third).evaluate(
					document, XPathConstants.NODESET);
			int length3 = n_list3.getLength();
			for(k=0;k < length3; k ++ ) {
				System.out.println(n_list3.item(k).getNodeValue());
				 				}

				
		}
		catch (ParserConfigurationException e) {
	         e.printStackTrace();
	  }  catch (SAXException e) {
	         e.printStackTrace();
	  } catch (IOException e) {
	             e.printStackTrace();
	  } catch (XPathExpressionException e) {
	             e.printStackTrace();

}
}
}