import java.util.*;

public class YoungTraveller extends Traveller{
    public YoungTraveller(){
        super();
    }
    public YoungTraveller(int[] terms_vector,String name,String city){
        super(terms_vector,name,city);
    }
    public YoungTraveller(int[] terms_vector,float[] geodesic_vector,String name,String city){
        super(terms_vector,geodesic_vector,name,city);
    }
    @Override
    public int[] getTerms_vector(){
        return super.getTerms_vector();
    }
    @Override
    public void setTerms_vector(int[] terms_vector){
        super.setTerms_vector(terms_vector);
    }
    @Override
    public float[] getGeodesic_vector(){
        return super.getGeodesic_vector();
    }
    @Override
    public void setGeodesic_vector(float[] geodesic_vector){
        super.setGeodesic_vector(geodesic_vector);
    }
    @Override
    public City compare_cities(ArrayList<City> cities){
        return super.compare_cities(cities);
    }
    @Override
    public City calculate_similarity(City city){
        float[] geodesic_vector=city.getGeodesic_vector();
        float x=geodesic_vector[0];
        float y=geodesic_vector[1];
        double distance=1/(1+Math.sqrt((y-this.geodesic_vector[1])*(y-this.geodesic_vector[1])
                +(x-this.geodesic_vector[0])*(x-this.geodesic_vector[1])));
        if(distance<10000)
            return city;
        return null;
    }
    @Override
    public City compare_cities(int a){
        return super.compare_cities(a);
    }
    @Override
    public String getCity() {
        return super.getCity();
    }
    @Override
    public void setCity(String city){
        super.setCity(city);
    }
    @Override
    public String getName(){
        return super.getName();
    }
    @Override
    public void setName(String name){
        super.setName(name);
    }
    @Override
    public String toString(){
        return super.toString();
    }
}