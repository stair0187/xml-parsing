public class Spill {
    private Integer volume;
    private PackageMaterial packageMaterial;

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public PackageMaterial getPackageMaterial() {
        return packageMaterial;
    }

    public void setPackageMaterial(PackageMaterial packageMaterial) {
        this.packageMaterial = packageMaterial;
    }

    @Override
    public String toString() {
        return "Spill{" +
                "volume=" + volume +
                ", packageMaterial=" + packageMaterial +
                '}';
    }
}
