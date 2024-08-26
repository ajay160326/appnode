public abstract class Burger implements Item {

    @Override
    public abstract float price();

    @Override
    public Wrapper packing() {
        return new Wrapper();
    }
    
}