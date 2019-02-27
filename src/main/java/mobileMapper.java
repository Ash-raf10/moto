import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.HashMap;

public class mobileMapper implements mobileService {

    //mulitimap that allows multiple values assigned to single key
    private Multimap<String,Brand> samMap;

    //hashmap(single key,single value) to keep track of model
    private  HashMap<String,Brand> modelMap;

    public mobileMapper() {
        samMap = ArrayListMultimap.create();
        modelMap = new HashMap<>();
    }

    @Override
    public void addBrand(Brand brand){
        //putting brand as key in multimap
        samMap.put(brand.getBrand(),brand);
        //putting model as key in hashmap
        modelMap.put(brand.getModel(),brand);
    }
    @Override
   public Brand getModel(String model){
        //getting a particular model
       return modelMap.get(model);

    }

    @Override
    //collections of a particular brand
    public Collection<Brand> getBrands(String br) {
        return samMap.get(br);
    }

    @Override
    //check if a particular brand exists
    public boolean brandExist(String br){
        return samMap.containsKey(br);
    }

    @Override
    //check if a particular model exist
    public boolean modelExist(String model){
        return modelMap.containsKey(model);
    }
}
