import com.sun.org.apache.xpath.internal.SourceTree;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Parser {
    public static void main(String[] args) {
        try {
//            ClassLoader classLoader = Parser.class.getClassLoader();
//            File file = new File(classLoader.getResource("").getFile());
            File file = new File("c:/lager.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(file);
            Element beerElement = doc.getDocumentElement();
            System.out.println("Root element :" + beerElement.getNodeName());

            boolean isAlcohol = Boolean.valueOf(beerElement.getAttribute("alcohol"));
            System.out.println(isAlcohol);

            Node name = doc.getElementsByTagName("Name").item(0);
            System.out.println(name.getFirstChild().getTextContent());

            NodeList ingredients = doc.getElementsByTagName("Ingredient");
            for (int i = 0; i < ingredients.getLength(); i++) {
                Element ingredient = (Element) ingredients.item(i);
                System.out.println(ingredient.getFirstChild().getTextContent());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
