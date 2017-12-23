public class Chars {
    private Float alco;
    private Float transparency;
    private Integer nutritionalValue;
    private Spill spill;

    public Float getAlco() {
        return alco;
    }

    public void setAlco(Float alco) {
        this.alco = alco;
    }

    public Float getTransparency() {
        return transparency;
    }

    public void setTransparency(Float transparency) {
        this.transparency = transparency;
    }

    public Integer getNutritionalValue() {
        return nutritionalValue;
    }

    public void setNutritionalValue(Integer nutritionalValue) {
        this.nutritionalValue = nutritionalValue;
    }

    public Spill getSpill() {
        return spill;
    }

    public void setSpill(Spill spill) {
        this.spill = spill;
    }

    @Override
    public String toString() {
        return "Chars{" +
                "alco=" + alco +
                ", transparency=" + transparency +
                ", nutritionalValue=" + nutritionalValue +
                ", spill=" + spill +
                '}';
    }
}
