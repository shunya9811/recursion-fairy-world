class Sandwich{
    private String doughType;
    private double sizeCm;

    private String topping1;
    private String topping2;
    private String topping3;
    private String vegetable1;
    private String vegetable2;
    private String vegetable3;
    private String vegetable4;
    private String vegetable5;
    
    public boolean ischeese;
    private String cheeseType;
    private double cheeseG;

    private boolean ketchup;
    private boolean mustard;
    private boolean mayonnaise;
    private String sauce;

    public Sandwich(String doughType, double sizeCm, String topping1, String topping2, String topping3, String vegetable1, String vegetable2, String vegetable3, String vegetable4, String vegetable5, boolean ischeese, String cheeseType, double cheeseG, boolean ketchup, boolean mustard, boolean mayonnaise, String sauce){
        this.doughType = doughType;
        this.sizeCm = sizeCm;
        this.topping1 = topping1;
        this.topping2 = topping2;
        this.topping3 = topping3;
        this.vegetable1 = vegetable1;
        this.vegetable2 = vegetable2;
        this.vegetable3 = vegetable3;
        this.vegetable4 = vegetable4;
        this.vegetable5 = vegetable5;
        this.ischeese = ischeese;
        this.cheeseType = cheeseType;
        this.cheeseG = cheeseG;
        this.ketchup = ketchup;
        this.mustard = mustard;
        this.mayonnaise = mayonnaise;
        this.sauce = sauce;
    }

    public String toString(){
        String sandwich = this.doughType + " bread, size " + this.sizeCm + "cm with " + this.topping1 + ", ";
        if(this.topping2 != null) sandwich+=this.topping2 + ", ";
        if(this.topping3 != null) sandwich+=this.topping3 + ", ";
        if(this.vegetable1 != null) sandwich+=this.vegetable1 + ", ";
        if(this.vegetable2 != null) sandwich+=this.vegetable2 + ", ";
        if(this.vegetable3 != null) sandwich+=this.vegetable3 + ", ";
        if(this.vegetable4 != null) sandwich+=this.vegetable4 + ", ";
        if(this.vegetable5 != null) sandwich+=this.vegetable5 + ", ";
        if(this.ischeese) sandwich+="with " + this.cheeseType +" cheese " + this.cheeseG +" gram, ";
        if(this.ketchup) sandwich+="with ketchup, ";
        if(this.mustard) sandwich+="with mustard, ";
        if(this.mayonnaise) sandwich+="with mayonnaise, ";
        if(this.sauce != null) sandwich+="with " + this.sauce;

        return sandwich;
    }
}

class SandwichBuilder{
    private final static String DEFAULT_DOUGH = "Wheat";
    private final static String DEFAULT_TOPPING1 = "Ham";
    private final static double DEFAULT_SIZE_CM = 15.24;
    private final static String DEFAULT_CHEESETYPE = "sliced";
    private final static double DEFAULT_CHEESEG = 36.0;


    private String doughType;
    private double sizeCm;
    private String topping1;
    private String topping2;
    private String topping3;
    private String vegetable1;
    private String vegetable2;
    private String vegetable3;
    private String vegetable4;
    private String vegetable5;

    public boolean ischeese;
    private String cheeseType;
    private double cheeseG;

    private boolean ketchup;
    private boolean mustard;
    private boolean mayonnaise;
    private String sauce;

    public SandwichBuilder(){
        this.reset();
    }

    public SandwichBuilder addDoughType(String doughType){
        this.doughType = doughType;
        return this;
    }

    public SandwichBuilder addTopping1(String topping){
        this.topping1 = topping;
        return this;
    }

    public SandwichBuilder addTopping2(String topping){
        this.topping2 = topping;
        return this;
    }

    public SandwichBuilder addTopping3(String topping){
        this.topping3 = topping;
        return this;
    }

    public SandwichBuilder addVegetable1(String vegetable){
        this.vegetable1 = vegetable;
        return this;
    }

    public SandwichBuilder addVegetable2(String vegetable){
        this.vegetable2 = vegetable;
        return this;
    }

    public SandwichBuilder addVegetable3(String vegetable){
        this.vegetable3 = vegetable;
        return this;
    }

    public SandwichBuilder addVegetable4(String vegetable){
        this.vegetable4 = vegetable;
        return this;
    }

    public SandwichBuilder addVegetable5(String vegetable){
        this.vegetable5 = vegetable;
        return this;
    }

    public SandwichBuilder addCheese(){
        this.ischeese = true;
        return this;
    }

    public SandwichBuilder noCheese(){
        this.ischeese = false;
        return this;
    }

    public SandwichBuilder switchCheese(String cheeseType){
        this.cheeseType = cheeseType;
        return this;
    }

    public SandwichBuilder addKetchup(){
        this.ketchup = true;
        return this;
    }

    public SandwichBuilder noKetchup(){
        this.ketchup = false;
        return this;
    }

    public SandwichBuilder addMustard(){
        this.mustard = true;
        return this;
    }

    public SandwichBuilder noMustard(){
        this.mustard = false;
        return this;
    }

    public SandwichBuilder addMayo(){
        this.mayonnaise = true;
        return this;
    }

    public SandwichBuilder noMayo(){
        this.mayonnaise = false;
        return this;
    }

    public SandwichBuilder addSauce(String sauce){
        this.sauce = sauce;
        return this;
    }

    public SandwichBuilder setSize(double size){
        this.sizeCm = size;
        return this;
    }

    public SandwichBuilder setCheeseAmount(double gram){
        this.cheeseG = gram;
        return this;
    }

    public Sandwich build(){
        Sandwich s = new Sandwich(
            this.doughType, this.sizeCm, this.topping1, this.topping2, this.topping3,
            this.vegetable1, this.vegetable2, this.vegetable3, this.vegetable4, this.vegetable5,
            this.ischeese, this.cheeseType, this.cheeseG, this.ketchup, this.mustard, this.mayonnaise, this.sauce
        );
        this.reset();
        return s;
    }

    public SandwichBuilder reset(){
        this.doughType = SandwichBuilder.DEFAULT_DOUGH;
        this.sizeCm = SandwichBuilder.DEFAULT_SIZE_CM;
        this.topping1 = SandwichBuilder.DEFAULT_TOPPING1;
        this.topping2 = null;
        this.topping3 = null;
        this.vegetable1 = null;
        this.vegetable2 = null;
        this.vegetable3 = null;
        this.vegetable4 = null;
        this.vegetable5 = null;

        this.ischeese = true;
        this.cheeseType = SandwichBuilder.DEFAULT_CHEESETYPE;
        this.cheeseG = SandwichBuilder.DEFAULT_CHEESEG;

        this.ketchup = false;
        this.mustard = false;
        this.mayonnaise = false;
        this.sauce = null;
        return this;
    }
}

// builderのためのメニュー
enum SandwichMenu{
    CHICKEN_AND_BACON,
    STEAK_AND_CHEESE,
    SPICY_ITALIAN,
    TUNA_AND_EGG,
}

enum SandwichSize{
    FOOTLONG,
    HALF_FOOTLONG,
}

enum CheeseType{
    SLICED,
    NATURAL,
    NONE
}

enum CheeseAmount{
    HALF,
    DEFAULT,
    DOUBLE
}

// 全てのdirectorメソッドを持つ、directorクラス
class FairyWorldSandwichDirector{
    public static SandwichBuilder chickenAndBacon(SandwichBuilder builder){
        builder.addDoughType("Italian").addTopping1("Chicken")
                    .addTopping2("Bacon").addSauce("Ranch")
                    .addVegetable1("Lettuce").addVegetable2("Red Onions")
                    .addVegetable3("Tomato").addCheese();
        return builder;
    }

    public static SandwichBuilder steakAndCheese(SandwichBuilder builder){
        builder.addDoughType("Wheat").addTopping1("Steak")
                    .addTopping2("Steak")
                    .addVegetable1("Green Peppers").addVegetable2("Red Onions")
                    .addCheese();
        return builder;
    }

    public static SandwichBuilder spicyItalian(SandwichBuilder builder){
        builder.addDoughType("Wheat").addTopping1("Pepperoni")
                    .addTopping2("Salami")
                    .addVegetable1("Lettuce").addVegetable2("Red Onions").addVegetable3("Tomato").addVegetable4("Cucumbers").addVegetable5("Jalapeno")
                    .addMayo();
        return builder;
    }

    public static SandwichBuilder tunaAndEgg(SandwichBuilder builder){
        builder.addDoughType("Italian Herbs").addTopping1("Tuna")
                    .addTopping2("Eggs")
                    .addVegetable1("Lettuce").addVegetable2("Red Onions")
                    .addMayo();
        return builder;
    }
}

class FairyWorld{
    public Sandwich orderSandwich(SandwichMenu item, SandwichSize itemSize, CheeseType cheeseType, CheeseAmount cheeseAmount){
        SandwichBuilder sandwichBuilder = new SandwichBuilder();

        // オブジェクトのbuild
        switch(item){
            case CHICKEN_AND_BACON: FairyWorldSandwichDirector.chickenAndBacon(sandwichBuilder); break;
            case STEAK_AND_CHEESE: FairyWorldSandwichDirector.steakAndCheese(sandwichBuilder); break;
            case SPICY_ITALIAN: FairyWorldSandwichDirector.spicyItalian(sandwichBuilder); break;
            case TUNA_AND_EGG: FairyWorldSandwichDirector.tunaAndEgg(sandwichBuilder); break;
        }

        switch(itemSize){
            case FOOTLONG: sandwichBuilder.setSize(15.24); break;
            case HALF_FOOTLONG: sandwichBuilder.setSize(30.48); break;
        }

        switch(cheeseType){
            case SLICED: sandwichBuilder.addCheese().switchCheese("sliced"); break;
            case NATURAL: sandwichBuilder.addCheese().switchCheese("natural"); break;
            case NONE: sandwichBuilder.noCheese(); break;
        }

        if (sandwichBuilder.ischeese){
            switch(cheeseAmount){
                case HALF: sandwichBuilder.setCheeseAmount(18.0); break;
                case DEFAULT: sandwichBuilder.setCheeseAmount(36.0); break;
                case DOUBLE: sandwichBuilder.setCheeseAmount(54.0); break;
            }
        }

        return sandwichBuilder.build();
    }
}

class Main{
    public static void main(String[] args){
        FairyWorld fairyWorld = new FairyWorld();

        Sandwich chickenAndBacon = fairyWorld.orderSandwich(SandwichMenu.CHICKEN_AND_BACON, SandwichSize.FOOTLONG, CheeseType.NATURAL, CheeseAmount.DEFAULT);

        String endl = System.lineSeparator();
        System.out.println(chickenAndBacon + endl);
        //System.out.println(fairyWorld.orderSandwich(SandwichMenu.STEAK_AND_CHEESE, SandwichSize.FOOTLONG) + endl);
        //System.out.println(fairyWorld.orderSandwich(SandwichMenu.SPICY_ITALIAN, SandwichSize.HALF_FOOTLONG) + endl);
        //System.out.println(fairyWorld.orderSandwich(SandwichMenu.TUNA_AND_EGG, SandwichSize.FOOTLONG) + endl);
    }
}