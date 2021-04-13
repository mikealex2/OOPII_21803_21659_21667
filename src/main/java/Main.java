import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        ArrayList<Traveller> travellers=new ArrayList<>();//Polymorphism
        ArrayList<City> cities=new ArrayList<>();
        int[] ints={10,10,10,10,10,10,10,10,10,8,5};
        int[] ints1={10,10,10,10,10,0,0,0,10,8,5};
        travellers.add(new YoungTraveller(ints,"Mike","Athens"));//Polymorphism
        travellers.add(new MiddleTraveller(ints1,"John","Paris"));//Polymorphism
        travellers.add(new ElderTraveller(ints,"Spenser","Los Angeles"));//Polymorphism
        City city=new City(ints,"Athens");
        City city1=new City(ints1,"Rome");
        cities.add(city);
        cities.add(city1);
        for(Traveller traveller:travellers)
            System.out.println(traveller.compare_cities(cities));
        System.out.println("Give your name:");
        String name=scanner.next();
        System.out.println("Give your age:");
        int age=scanner.nextInt();
        System.out.println("Give the city that you are in:");
        String currentCity=scanner.next();
        System.out.println("Give the city that you want to travel in:");
        String newCity=scanner.next();
        System.out.println("From 1 to 10 do you want the city to have coffee shops:");
        int coffee=scanner.nextInt();
        System.out.println("From 1 to 10 do you want the city to have sea view:");
        int sea=scanner.nextInt();
        System.out.println("From 1 to 10 do you want the city to have museums:");
        int museums=scanner.nextInt();
        System.out.println("From 1 to 10 do you want the city to have restaurants:");
        int restaurants=scanner.nextInt();
        System.out.println("From 1 to 10 do you want the city to have stadiums:");
        int stadiums=scanner.nextInt();
        System.out.println("From 1 to 10 do you want the city to have parks:");
        int parks=scanner.nextInt();
        System.out.println("From 1 to 10 do you want the city to have monuments");
        int monuments=scanner.nextInt();
        System.out.println("From 1 to 10 do you want the city to have cloth stores:");
        int stores=scanner.nextInt();
        System.out.println("From 1 to 10 do you want the city to have bars:");
        int bars=scanner.nextInt();
        System.out.println("From 1 to 10 do you want the city to have clubs:");
        int clubs=scanner.nextInt();
        int[] terms_vector={coffee,sea,museums,restaurants,stadiums,parks,monuments,stores,bars,clubs};
        Traveller traveller;
        if(age>16&&age<25)
            traveller=new YoungTraveller(terms_vector,name,currentCity);
        else if(age<60)
            traveller=new MiddleTraveller(terms_vector,name,currentCity);
        else
            traveller=new ElderTraveller(terms_vector,name,currentCity);
        travellers.add(traveller);
        City city2=new City(newCity);
        cities.add(city2);
    }
}