import java.util.*;

public class MiddleTraveller extends Traveller implements Comparable{
    public MiddleTraveller(){
        super();
    }
    public MiddleTraveller(int[] terms_vector,String name,String city){
        super(terms_vector,name,city);
    }
    public MiddleTraveller(int[] terms_vector,String name,String city,String timestamp){
        super(terms_vector,name,city,timestamp);
    }
    public MiddleTraveller(int[] terms_vector,String name,String city,String timestamp,String visit){
        super(terms_vector,name,city,timestamp,visit);
    }
    public MiddleTraveller(int[] terms_vector,float[] geodesic_vector,String name,String city,String timestamp){
        super(terms_vector,geodesic_vector,name,city,timestamp);
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
    public float[] getGeodesic_vector() {
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
        double d=0.0,a=0.0,b=0.0,distance;
        for(int i=0;i<geodesic_vector.length;i++){
            d+=this.getGeodesic_vector()[i]*geodesic_vector[i];
            a+=Math.pow(this.geodesic_vector[i],2);
            b+=Math.pow(geodesic_vector[i],2);
        }
        distance=d/(Math.sqrt(a)*Math.sqrt(b));
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
    public String getTimestamp(){
        return super.getTimestamp();
    }
    @Override
    public void setTimestamp(String timestamp){
        super.setTimestamp(timestamp);
    }
    @Override
    public String toString(){
        return super.toString();
    }
    @Override
    public int compareTo(Traveller traveller){
        return Integer.compare(Integer.parseInt(this.timestamp),Integer.parseInt(traveller.getTimestamp()));
    }
    @Override
    public int compareTo(Object o){
        return 0;
    }
}