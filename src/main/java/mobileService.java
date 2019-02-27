

import java.util.Collection;

//interface for implementing CRUD operations
public interface mobileService {
    public void addBrand(Brand brand);
    public Collection<Brand> getBrands(String br);

    public Brand getModel(String model);

  //  public void deleteModels(String id);

    public boolean brandExist(String brand);

    public boolean modelExist(String model);
}
