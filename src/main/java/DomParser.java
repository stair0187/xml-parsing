import com.sun.org.apache.xpath.internal.SourceTree;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class DomParser {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(ClassLoader.getSystemResourceAsStream("lager.xml"));
            Element beerElement = doc.getDocumentElement();
            System.out.println("Root element :" + beerElement.getNodeName());
            Beer beer = new Beer();


            boolean isAlcohol = Boolean.valueOf(beerElement.getAttribute("alcohol"));
            System.out.println(isAlcohol);
            beer.setAlcohol(isAlcohol);

            Node name = doc.getElementsByTagName("Name").item(0);
            System.out.println(name.getFirstChild().getTextContent());
            beer.setName(name.getFirstChild().getTextContent());

            NodeList ingredients = doc.getElementsByTagName("Ingredient");
            ArrayList<Ingredient>ingredientList = new ArrayList<>();
            for (int i = 0; i < ingredients.getLength(); i++) {
                Element ingredient = (Element) ingredients.item(i);
                System.out.println(ingredient.getFirstChild().getTextContent());
                Ingredient ing = new Ingredient();
                ing.setName(ingredient.getFirstChild().getTextContent());
                ingredientList.add(ing);


            }
            beer.setIngredients(ingredientList);

            Node type = doc.getElementsByTagName("Type").item(0);
            System.out.println(type.getFirstChild().getTextContent());
            Type beerType = Type.valueOf(type.getFirstChild().getTextContent().toUpperCase());
            beer.setType(beerType);

            Node manufacturer = doc.getElementsByTagName("Manufacturer").item(0);
            System.out.println(manufacturer.getFirstChild().getTextContent());
            beer.setManufacturer (manufacturer.getFirstChild().getTextContent());

            Element chars = (Element) doc.getElementsByTagName("Chars").item(0);
            Chars beerChars = new Chars();
            NodeList charsChildren  = chars.getChildNodes();
            for (int i = 0; i< charsChildren.getLength(); i++){
                Node charsChild = charsChildren.item(i);

                if (charsChild.getNodeType() == Node.ELEMENT_NODE) {
                    processChars((Element) charsChild, beerChars);
                }

            }
            beer.setChars(beerChars);
            System.out.println(beer);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private static void processChars(Element element, Chars beerChars) {
      String elementName = element.getTagName();
        System.out.println(elementName);
        switch (elementName) {
            case "Alco":
                beerChars.setAlco(Float.valueOf(element.getFirstChild().getTextContent()));
                System.out.println();
                break;
            case "Transparency":
                beerChars.setTransparency (Float.valueOf(element.getFirstChild().getTextContent()));
                System.out.println();
                break;
            case"NutritionalValue":
                beerChars.setNutritionalValue (Integer.valueOf(element.getFirstChild().getTextContent()));
                System.out.println();
                break;
            case "Spill":
                processSpill (element,beerChars);
                System.out.println();
                break;
                default:
                    System.out.println("unknown tag");


        }
    }

    private static void processSpill(Element element, Chars beerChars) {
        Spill spill = new Spill();
        Node volume = element.getElementsByTagName("Volume").item(0);
        System.out.println(volume.getFirstChild().getTextContent());
        spill.setVolume(Integer.valueOf(volume.getFirstChild().getTextContent()));
        Node packageMaterial = element.getElementsByTagName("PackageMaterial").item(0);
        System.out.println(packageMaterial.getFirstChild().getTextContent());
        spill.setPackageMaterial(PackageMaterial.valueOf(packageMaterial.getFirstChild().getTextContent().toUpperCase()));
        beerChars.setSpill(spill);

    }



}
