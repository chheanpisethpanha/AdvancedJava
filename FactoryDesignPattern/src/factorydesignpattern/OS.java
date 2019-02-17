package factorydesignpattern;

public interface OS {
    public void spec();
}

class Android implements OS{
    @Override
    public void spec(){
        System.out.println("Hello from Android...");
    }
}

class IOS implements OS{
    @Override
    public void spec(){
        System.out.println("Hello from IOS...");
    }
}

class Windows implements OS{
    @Override
    public void spec(){
        System.out.println("Hello from Windows...");
    }
}



