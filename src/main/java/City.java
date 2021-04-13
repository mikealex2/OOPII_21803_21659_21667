import java.util.*;
import org.json.*;
import org.jsoup.*;
import java.net.*;
import java.io.*;

public class City{
    private String name,string="";
    int add=0;
    private int[] terms_vector=new int[10];
    private float[] geodesic_vector=new float[2];
    private JSONObject jsonObject;
    Scanner scanner;
    public City(){}
    public City(String name){
        this.name=name;
        try{geodesic_vector[0]=openWeather(name).getJSONObject("coordinates").getFloat("lon");
            geodesic_vector[1]=openWeather(name).getJSONObject("coordinates").getFloat("lat");}
        catch(Exception exception){}
    }
    public City(int[] terms_vector,String name){
        this.terms_vector=terms_vector;
        this.name=name;
        try{geodesic_vector[0]=openWeather(name).getJSONObject("coordinates").getFloat("lon");
            geodesic_vector[1]=openWeather(name).getJSONObject("coordinates").getFloat("lat");
        }catch(Exception exception){}
    }
    public City(int[] terms_vector,float[] geodesic_vector,String name){
        this.terms_vector=terms_vector;
        this.geodesic_vector=geodesic_vector;
        this.name=name;
    }
    public int[] getTerms_vector(){
        return terms_vector;
    }
    public void setTerms_vector(int[] terms_vector){
        this.terms_vector=terms_vector;
    }
    public int get_add_terms_vector(){
        for(int i=0;i<terms_vector.length;i++)
            add+=i;
        return add;
    }
    public float[] getGeodesic_vector(){
        return geodesic_vector;
    }
    public void setGeodesic_vector(float[] geodesic_vector){
        this.geodesic_vector=geodesic_vector;
    }
    public JSONObject getJsonObject() {
        return jsonObject;
    }
    public void setJsonObject(JSONObject jsonObject){
        this.jsonObject=jsonObject;
    }
    public String mediaWiki(String city){
        String s="https://en.wikipedia.org/w/api.php?action=query&prop=extracts&titles="+
                city+"&format=json&format_version=2";
        scanner=null;
        try{URL url=new URL(s.replace(" ","%20"));
            scanner=new Scanner(url.openStream());
        }catch(IOException e){}
        while (scanner.hasNext())
            string+=scanner.nextLine();
        String value=null;
        JSONObject obj=new JSONObject(string);
        try{value=Jsoup.parse(obj.getJSONObject("query").
                getJSONArray("pages").getJSONObject(0).getString("extract")).text();
        }catch(Exception ignored){}
        return value;
    }
    private JSONObject openWeather(String city){
        String s="http://api.openweathermap.org/data/2.5/weather?q="+city+"&app_id=2d7d2a563ef20bc9da529359e9e52a0e";
        scanner=null;
        try{URL url=new URL(s.replace(" ","%20"));
            scanner=new Scanner(url.openStream());
        }catch(IOException e){}
        String str="";
        try{while(scanner.hasNext())
                str+=scanner.nextLine();
        }catch(Exception ignored){}
        return new JSONObject(str);
    }
    @Override
    public String toString(){
        return "City{ terms_vector="+Arrays.toString(terms_vector)+
                ", geodesic_vector="+Arrays.toString(geodesic_vector)+'}';
    }
}