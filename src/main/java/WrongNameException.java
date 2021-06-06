public class WrongNameException extends Exception implements Runnable{
    public WrongNameException(String string){
        super(string);
    }
    @Override
    public String getMessage(){
        return super.getMessage();
    }
    @Override
    public void run(){
        System.out.println(super.getLocalizedMessage());
    }
    @Override
    public String toString(){
        return super.toString();
    }
}