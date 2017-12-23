import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;

public class SaxParser {
    public static void main(String[] args) throws Exception {
        SAXParserFactory parserFactor = SAXParserFactory.newInstance();
        SAXParser parser = parserFactor.newSAXParser();
        SAXHandler handler = new SAXHandler();
        parser.parse(ClassLoader.getSystemResourceAsStream("lager.xml"),
                handler);
        Beer beer = handler.getBeer();
        System.out.println(beer);
}

   static class SAXHandler extends DefaultHandler {

    Beer beer = null;
    ArrayList <Ingredient> ingredients = null;
    Chars chars = null;
    Spill spill = null;
        String content = null;
        @Override
        //Triggered when the start of tag is found.
        public void startElement(String uri, String localName,
                                 String qName, Attributes attributes)
                throws SAXException {

            switch(qName){
                case "Beer":
                    beer = new Beer();
                    beer.setAlcohol(Boolean.parseBoolean(attributes.getValue("alcohol")));
                    break;
                case "Ingredients":
                    ingredients = new ArrayList<>();
                        break;
                case "Chars":
                    chars = new Chars();
                    break;
                case "Spill":
                    spill = new Spill();
                    break;

            }
        }

        @Override
        public void endElement(String uri, String localName,
                               String qName) throws SAXException {
            switch(qName){
                case "Name":
                    beer.setName(content);
                    break;
                case "Manufacturer":
                    beer.setManufacturer(content);
                    break;
                case "Type":
                    beer.setType(Type.valueOf(content.toUpperCase()));
                    break;
                case "Spill":
                    chars.setSpill(spill);
                    break;
                case "Chars":
                    beer.setChars(chars);
                    break;
                case "Alco":
                    chars.setAlco(Float.parseFloat(content));
                    break;
                case "Transparency":
                    chars.setTransparency(Float.parseFloat(content));
                    break;
                case"NutritionalValue":
                    chars.setNutritionalValue(Integer.parseInt(content));
                    break;
                case "Volume":
                    spill.setVolume(Integer.parseInt(content));
                    break;
                case "PackageMaterial":
                    spill.setPackageMaterial(PackageMaterial.valueOf(content.toUpperCase()));
                    break;
                case "Ingredient":
                    Ingredient ingredient = new Ingredient();
                    ingredient.setName(content);
                    ingredients.add(ingredient);
                    break;
                case "Ingredients":
                    beer.setIngredients(ingredients);
                    break;



            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            content = String.copyValueOf(ch, start, length).trim();
        }

       public Beer getBeer() {
           return beer;
       }
   }}
