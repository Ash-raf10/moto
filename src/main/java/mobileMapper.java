import java.util.Collection;
import java.util.HashMap;

public class mobileMapper implements mobileService {

    private HashMap<String,Samsung> samMap;

    public mobileMapper() {
        samMap = new HashMap<>();
    }

    @Override
    public void addModel(Samsung samsung){
        samMap.put(samsung.getModel(),samsung);
    }
    @Override
    public Samsung getModel(String model){

        return samMap.get(model);

    }

    @Override
    public Collection<Samsung> getModels()
    {
        return samMap.values();
    }

    @Override
    public boolean modelExist(String model){
        return samMap.containsKey(model);
    }
}
