import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.util.ArrayList;

public class StaxParser {
    public static void main(String[] args) throws Exception {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader =
                factory.createXMLStreamReader(
                        ClassLoader.getSystemResourceAsStream("lager.xml"));
        Beer beer = null;
        ArrayList<Ingredient> ingredients = null;
        Chars chars = null;
        Spill spill = null;
        String content = null;
        while (reader.hasNext()) {
            int event = reader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    switch (reader.getLocalName()) {
                        case "Beer":
                            beer = new Beer();
                            beer.setAlcohol(Boolean.parseBoolean(reader.getAttributeValue(0)));
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
                    break;

                case XMLStreamConstants.CHARACTERS:
                    content = reader.getText().trim();
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    switch (reader.getLocalName()) {
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
                        case "NutritionalValue":
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


        }
        System.out.println(beer);
    }


}
