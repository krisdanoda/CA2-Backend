import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import dtos.ChampsDTO;
import entities.Champion;
import entities.RenameMe;
import entities.User;
import utils.EMF_Creator;
import utils.HttpUtils;

import javax.json.Json;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {
    public static void main(String[] args) throws IOException {

        String string = HttpUtils.fetchData("http://ddragon.leagueoflegends.com/cdn/12.21.1/data/en_US/champion.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("C:\\Users\\Kristofer\\Programming\\Java\\CA2_Backend_league\\src\\main\\java\\output.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray employeeList = (JSONArray) obj;
            System.out.println(employeeList);

            //Iterate over employee array
            employeeList.forEach( emp -> parseChamp( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }


    public static void parseChamp(JSONObject champ){
        System.out.println(champ.get("name").toString() + champ.get("key").toString());
        Champion champion = new Champion(champ.get("name").toString(),champ.get("key").toString() );
        System.out.println(champion);

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(champion);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
