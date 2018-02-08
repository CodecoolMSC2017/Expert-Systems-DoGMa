package codecool.Fact;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Fact {
    String id;
    String description;

    HashMap<String, Boolean> genres;

    public Fact(String id, String description, HashMap<String, Boolean> genres) {
        this.id = id;
        this.description = description;
        this.genres = genres;
    }

    public Set<String> getIdSet() {
        Set<String> idSet = new HashSet<String>();

        for (String id : genres.keySet()) {
            idSet.add(id);
        }

        return idSet;
    }

    public HashMap<String, Boolean> getGenres () {
        return genres;
    }

    public void setFactValueByID(String id, boolean value) {

        for (String key : genres.keySet()) {
            if (key.equals(id)) {
                genres.put(key, value);
            }
        }
    }

    public boolean getValueById(String id) {

        boolean valueById = true;

        for (Map.Entry<String, Boolean> entry : genres.entrySet()) {
            if (entry.getKey().equals(id)) {
                valueById = entry.getValue();
            }
        }
        return valueById;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isEqual(Fact fact){
        if(!id.equals(fact.getId())){
            return false;
        }else if (!description.equals(fact.getDescription())) {
            return false;
        }
        for (Map.Entry<String,Boolean> genre :genres.entrySet()){
            if(genre.getValue()!=fact.getValueById(genre.getKey())){
                return false;
            }
        }
        return  true;
    }


}
