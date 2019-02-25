import java.util.Collection;

public interface mobileService {
    public void addModel(Samsung samsung);
    public Collection<Samsung> getModels();

    public Samsung getModel(String model);

  //  public void deleteModels(String id);

    public boolean modelExist(String model);
}
