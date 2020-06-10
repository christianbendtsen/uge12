package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonReader {


    public static void jsonReader() {

        JSONParser jsonParser = new JSONParser();


        try (FileReader fileReader = new FileReader("unece.json")){

            Object obj = jsonParser.parse(fileReader);
            JSONArray jsonArray = (JSONArray) obj;

            JSONObject jsonObject1 = (JSONObject) jsonArray.get(0);

            System.out.println("Antal keys i Json filne: " + jsonObject1.keySet().size());

            System.out.println("print alle  keys ud i keysættet" + jsonObject1.keySet());

            JSONObject jsonObject2 = (JSONObject) jsonArray.get(1);

            System.out.println("Print en specifik key ud på object 0 (Country): "+jsonObject2.get("Country"));
            System.out.println("Print en specifik key ud på object 0 (Year): "+jsonObject2.get("Year"));
            System.out.println("Print en specifik key ud på object 0 (Population): "+jsonObject2.get("Total population"));

            JSONArray worldInfo = new JSONArray();

            for (Object o: jsonArray) {
                JSONObject worldObject = new JSONObject();
                JSONObject jsonObject = (JSONObject) o;



                worldObject.put("Country", jsonObject.get("Country"));

                worldObject.put("Total population", jsonObject.get("Total population"));

                worldObject.put("Year", jsonObject.get("Year"));

                worldInfo.add(worldObject);
            }

            System.out.println(worldInfo.get(0));

            FileWriter file = new FileWriter("WriteJsonFile.json");
            file.write(worldInfo.toJSONString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }




    }
}
