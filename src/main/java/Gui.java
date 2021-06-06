import javax.swing.*;
import java.awt.*;
import java.text.*;
import java.util.*;

public class Gui extends JFrame{
    WrongNameException wrongNameException=new WrongNameException("Wrong name!");
    Thread thread=new Thread(wrongNameException);
    JTextField name,age,currentCity,newCity,coffee,sea,museums,restaurants,
            stadiums,parks,monuments,stores,bars,clubs;
    Traveller traveller;
    JButton jButton=new JButton("Travel");;
    JFrame jFrame;
    JPanel jPanel=new JPanel();
    JLabel jLabelResult=new JLabel();
    String timeStamp;
    City city;
    ArrayList<Traveller> travellerArrayList=new ArrayList<>();//Polymorphism
    LinkedList<Traveller> travellerLinkedList=new LinkedList<>();//Traveller object collection
    HashMap<String,City> cityHashMap=new HashMap<>();//City objects map collection
    ArrayList<City> cityArrayList=new ArrayList<>();
    String Sname,ScurrentCity,SnewCity;
    int Iage,Icoffee,Isea,Imuseums,Irestaurants,Istadiums,Iparks,Imonuments,Istores,Ibars,Iclubs;
    public Gui(){
        JLabel jLabel=new JLabel("Welcome to traveller App!");
        JLabel jLabel1=new JLabel("Give your name:");
        name=new JTextField(10);
        JLabel jLabel2=new JLabel("Give you age:");
        age=new JTextField(10);
        JLabel jLabel3=new JLabel("Give current city:");
        currentCity=new JTextField(10);
        JLabel jLabel4=new JLabel("Give the city that you want to travel in:");
        newCity=new JTextField(10);
        JLabel jLabel5=new JLabel("From 1 to 10 give how much do you want the city to have on of those:");
        JLabel jLabel6=new JLabel("Coffee:");
        coffee=new JTextField(10);
        JLabel jLabel7=new JLabel("Sea:");
        sea=new JTextField(10);
        JLabel jLabel8=new JLabel("Museums:");
        museums=new JTextField(10);
        JLabel jLabel9=new JLabel("Restaurants:");
        restaurants=new JTextField(10);
        JLabel jLabel10=new JLabel("Stadiums:");
        stadiums=new JTextField(10);
        JLabel jLabel11=new JLabel("Parks:");
        parks=new JTextField(10);
        JLabel jLabel12=new JLabel("Monuments:");
        monuments=new JTextField(10);
        JLabel jLabel13=new JLabel("Stores:");
        stores=new JTextField(10);
        JLabel jLabel14=new JLabel("Bars:");
        bars=new JTextField(10);
        JLabel jLabel15=new JLabel("Clubs:");
        clubs=new JTextField(10);
        jPanel.add(jLabel);
        jPanel.add(jLabel1);
        jPanel.add(name);
        jPanel.add(jLabel2);
        jPanel.add(age);
        jPanel.add(jLabel3);
        jPanel.add(currentCity);
        jPanel.add(jLabel4);
        jPanel.add(newCity);
        jPanel.add(jLabel5);
        jPanel.add(jLabel6);
        jPanel.add(coffee);
        jPanel.add(jLabel7);
        jPanel.add(sea);
        jPanel.add(jLabel8);
        jPanel.add(museums);
        jPanel.add(jLabel9);
        jPanel.add(restaurants);
        jPanel.add(jLabel10);
        jPanel.add(stadiums);
        jPanel.add(jLabel11);
        jPanel.add(parks);
        jPanel.add(jLabel12);
        jPanel.add(monuments);
        jPanel.add(jLabel13);
        jPanel.add(stores);
        jPanel.add(jLabel14);
        jPanel.add(bars);
        jPanel.add(jLabel15);
        jPanel.add(clubs);
        jPanel.add(jButton);
        jPanel.add(jLabelResult);
        jLabelResult.setText("<html><h2></h2></html>");
        jPanel.setLayout(new FlowLayout());
        jFrame=new JFrame("Traveller App");
        jFrame.getContentPane().add(jPanel);
        jFrame.setSize(800,300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jButton.addActionListener(e->{
            try{Sname=name.getText();
                Iage=Integer.parseInt(age.getText());
                ScurrentCity=currentCity.getText();
                SnewCity=newCity.getText();
                Icoffee=Integer.parseInt(coffee.getText());
                Isea=Integer.parseInt(sea.getText());
                Imuseums=Integer.parseInt(museums.getText());
                Irestaurants=Integer.parseInt(restaurants.getText());
                Istadiums=Integer.parseInt(stadiums.getText());
                Iparks=Integer.parseInt(parks.getText());
                Imonuments=Integer.parseInt(monuments.getText());
                Istores=Integer.parseInt(stores.getText());
                Ibars=Integer.parseInt(bars.getText());
                Iclubs=Integer.parseInt(clubs.getText());
                int[] terms_vector={Icoffee,Isea,Imuseums,Irestaurants,Istadiums,Iparks,Imonuments,Istores,Ibars,Iclubs};
                if(Sname.isEmpty())
                    thread.start();
                timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
                if(Iage>16&&Iage<25)
                    traveller=new YoungTraveller(terms_vector,Sname,ScurrentCity,timeStamp,SnewCity);
                else if(Iage<60)
                    traveller=new MiddleTraveller(terms_vector,Sname,ScurrentCity,timeStamp,SnewCity);
                else
                    traveller=new ElderTraveller(terms_vector,Sname,ScurrentCity,timeStamp,SnewCity);
                jLabelResult.setText("Traveller Added!");
                travellerArrayList.add(traveller);
                travellerLinkedList.add(traveller);
                city=new City(SnewCity);
                cityHashMap.put(city.getName(),city);
                cityArrayList.add(city);
                try{Traveller.writeJson(travellerArrayList);
                }catch(Exception exception){}
            }catch(Exception exception){}
        });
    }
}