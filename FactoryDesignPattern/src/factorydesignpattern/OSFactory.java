package factorydesignpattern;

public class OSFactory {
    public static OS getInstance(String str){
        if(str.equals("Android")){
            return new Android();
        }
        else if(str.equals("ios")){
            return new IOS();
        }
        else{
            return new Windows();
        }
    }
}
