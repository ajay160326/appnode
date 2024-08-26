public class MealBuilder {
    public Meal prepareVeg() {
        Meal veg = new Meal();
        veg.addItem((Item) new VegBurger());
        veg.addItem(new Coke());

        return veg;
    }

    public Meal prepareNonVeg() {
        Meal nonveg = new Meal();
        nonveg.addItem((Item) new CBurger());
        nonveg.addItem(new Pepsi());

        return nonveg;
    }
}