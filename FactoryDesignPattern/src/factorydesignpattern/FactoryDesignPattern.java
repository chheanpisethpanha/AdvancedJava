package factorydesignpattern;

public class FactoryDesignPattern {

    public static void main(String[] args) {
       OSFactory osf = new OSFactory();
       OS obj = osf.getInstance("Android");
       obj.spec();
    }
    
}
