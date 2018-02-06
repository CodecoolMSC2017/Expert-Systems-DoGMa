package codecool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fact {
    String id;
    String description;

    Map<String, Boolean> genres;

    public Fact(String id, String description, HashMap<String, Boolean> genres) {
        this.id = id;
        this.description = description;
        this.genres = genres;
    }

    public Set<String> getIdSet(){
        return null;
    }
    public void setFactValueByID(String id,boolean value){

    }

    public boolean getValueById(String id){
        return true;
    }
    public String getId () {
        return id;
    }
    public String getDescription(){
        return description;
    }

    public void printGenres () {
        for (Map.Entry<String, Boolean> genre : genres.entrySet()) {
            System.out.println(genre.getKey() + (genre.getValue() ? "true" : "false"));
        }
    }
}
