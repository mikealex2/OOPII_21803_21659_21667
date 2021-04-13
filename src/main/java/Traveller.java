import org.json.*;
import java.io.*;
import java.net.URL;
import java.util.*;

public abstract class Traveller{
    protected int[] terms_vector=new int[10];
    protected float[] geodesic_vector=new float[2];
    protected String name,city,string="";
    Scanner scanner;
    public Traveller(){}
    public Traveller(int[] terms_vector,String name,String city){
        this.name=name;
        this.city=city;
        this.terms_vector=terms_vector;
        try{geodesic_vector[0]=openWeather(name).getJSONObject("coordinates").getFloat("lon");
            geodesic_vector[1]=openWeather(name).getJSONObject("coordinates").getFloat("lat");
        }catch(Exception exception){}
    }
    public Traveller(int[] terms_vector,float[] geodesic_vector,String name,String city){
        this.name=name;
        this.city=city;
        this.terms_vector=terms_vector;
        this.geodesic_vector=geodesic_vector;
    }
    public City compare_cities(ArrayList<City> cities){
        /*int max=cities.get(0).get_add_terms_vector();
        for(City city:cities)
            if(city.get_add_terms_vector()>max)
                max=city.get_add_terms_vector();
        return cities.get(cities.indexOf(max));*/
        ArrayList<Integer> integers=new ArrayList<>();
        int j=0,max=0;
        for (City city:cities){
            integers.add(city.get_add_terms_vector());
            j++;
        }
        for (int i=0;i<j;i++)
            if (integers.get(i)>max)
                max=integers.get(i);
        return cities.get(integers.indexOf(max));
    }
    public City compare_cities(int a){
        return null;
    }
    public abstract City calculate_similarity(City city);
    public int[] getTerms_vector(){
        return terms_vector;
    }
    public void setTerms_vector(int[] terms_vector){
        this.terms_vector=terms_vector;
    }
    public float[] getGeodesic_vector(){
        return geodesic_vector;
    }
    public void setGeodesic_vector(float[] geodesic_vector){
        this.geodesic_vector=geodesic_vector;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city=city;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    private JSONObject openWeather(String city){
        String s="http://api.openweathermap.org/data/2.5/weather?q="+city+"&app_id=2d7d2a563ef20bc9da529359e9e52a0e";
        scanner=null;
        try{URL url=new URL(s.replace(" ","%20"));
            scanner=new Scanner(url.openStream());
        }catch(IOException e){}
        try{while(scanner.hasNext())
            string+=scanner.nextLine();
        }catch(Exception ignored){}
        return new JSONObject(string);
    }
    @Override
    public String toString(){
        return "Traveller{ terms_vector="+Arrays.toString(terms_vector)+
                ", geodesic_vector="+Arrays.toString(geodesic_vector)+'}';
    }
}