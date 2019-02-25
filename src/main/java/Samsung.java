public class Samsung {
    private String id;
    private String model;
    private String ram;
    private String hdd;

    public Samsung(String id, String model, String ram, String hdd) {
        this.id = id;
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }
}
