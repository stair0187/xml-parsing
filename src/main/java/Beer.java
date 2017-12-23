import java.util.ArrayList;

public class Beer {
    private Boolean alcohol;
    private String name;
    private Type type;
    private String manufacturer;
    private ArrayList <Ingredient> ingredients;
    private Chars chars;

    public void setAlcohol(boolean alcohol) {
        this.alcohol = alcohol;
    }

    public Boolean getAlcohol() {
        return alcohol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Chars getChars() {
        return chars;
    }

    public void setChars(Chars chars) {
        this.chars = chars;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "alcohol=" + alcohol +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", manufacturer='" + manufacturer + '\'' +
                ", ingredients=" + ingredients +
                ", chars=" + chars +
                '}';
    }
}
