// Product
class Hamburger{
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

    public Hamburger(String doughType, double sizeCm, String topping1, String topping2, String topping3, String vegetable1, String vegetable2, String vegetable3, String vegetable4, String vegetable5, boolean ischeese, String cheeseType, double cheeseG, boolean ketchup, boolean mustard, boolean mayonnaise, String sauce){
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
        String hamburger ="Hamburger : " + this.doughType + " bread, size " + this.sizeCm + "cm with " + this.topping1 + ", "; 
        if(this.topping2 != null) hamburger+=this.topping2 + ", ";
        if(this.topping3 != null) hamburger+=this.topping3 + ", ";
        if(this.vegetable1 != null) hamburger+=this.vegetable1 + ", ";
        if(this.vegetable2 != null) hamburger+=this.vegetable2 + ", ";
        if(this.vegetable3 != null) hamburger+=this.vegetable3 + ", ";
        if(this.vegetable4 != null) hamburger+=this.vegetable4 + ", ";
        if(this.vegetable5 != null) hamburger+=this.vegetable5 + ", ";
        if(this.ischeese) hamburger+="with " + this.cheeseType +" cheese " + this.cheeseG +" gram, ";
        if(this.ketchup) hamburger+="with ketchup, ";
        if(this.mustard) hamburger+="with mustard, ";
        if(this.mayonnaise) hamburger+="with mayonnaise, ";
        if(this.sauce != null) hamburger+="with " + this.sauce;

        return hamburger;
    }
}

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
        String sandwich = "Sandwich:" + this.doughType + " bread, size " + this.sizeCm + "cm with " + this.topping1 + ", ";
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

abstract class Builder{
    protected String doughType;
    protected double sizeCm;
    protected String topping1;
    protected String topping2;
    protected String topping3;
    protected String vegetable1;
    protected String vegetable2;
    protected String vegetable3;
    protected String vegetable4;
    protected String vegetable5;

    public boolean ischeese;
    protected String cheeseType;
    protected double cheeseG;

    protected boolean ketchup;
    protected boolean mustard;
    protected boolean mayonnaise;
    protected String sauce;

    public Builder addDoughType(String doughType){
        this.doughType = doughType;
        return this;
    }

    public Builder addTopping1(String topping){
        this.topping1 = topping;
        return this;
    }

    public Builder addTopping2(String topping){
        this.topping2 = topping;
        return this;
    }

    public Builder addTopping3(String topping){
        this.topping3 = topping;
        return this;
    }

    public Builder addVegetable1(String vegetable){
        this.vegetable1 = vegetable;
        return this;
    }

    public Builder addVegetable2(String vegetable){
        this.vegetable2 = vegetable;
        return this;
    }

    public Builder addVegetable3(String vegetable){
        this.vegetable3 = vegetable;
        return this;
    }

    public Builder addVegetable4(String vegetable){
        this.vegetable4 = vegetable;
        return this;
    }

    public Builder addVegetable5(String vegetable){
        this.vegetable5 = vegetable;
        return this;
    }

    public Builder addCheese(){
        this.ischeese = true;
        return this;
    }

    public Builder noCheese(){
        this.ischeese = false;
        return this;
    }

    public Builder switchCheese(String cheeseType){
        this.cheeseType = cheeseType;
        return this;
    }

    public Builder addKetchup(){
        this.ketchup = true;
        return this;
    }

    public Builder noKetchup(){
        this.ketchup = false;
        return this;
    }

    public Builder addMustard(){
        this.mustard = true;
        return this;
    }

    public Builder noMustard(){
        this.mustard = false;
        return this;
    }

    public Builder addMayo(){
        this.mayonnaise = true;
        return this;
    }

    public Builder noMayo(){
        this.mayonnaise = false;
        return this;
    }

    public Builder addSauce(String sauce){
        this.sauce = sauce;
        return this;
    }

    public Builder setSize(double size){
        this.sizeCm = size;
        return this;
    }

    public Builder setCheeseAmount(double gram){
        this.cheeseG = gram;
        return this;
    }


}

class HamburgerBuilder extends Builder{
    private final static String DEFAULT_DOUGH = "Buns";
    private final static String DEFAULT_TOPPING1 = "Putty";
    private final static double DEFAULT_SIZE_CM = 13.4;
    private final static String DEFAULT_CHEESETYPE = "sliced";
    private final static double DEFAULT_CHEESEG = 36.0;

    public HamburgerBuilder(){
        this.reset();
    }

    public Hamburger build(){
        Hamburger s = new Hamburger(
            this.doughType, this.sizeCm, this.topping1, this.topping2, this.topping3,
            this.vegetable1, this.vegetable2, this.vegetable3, this.vegetable4, this.vegetable5,
            this.ischeese, this.cheeseType, this.cheeseG, this.ketchup, this.mustard, this.mayonnaise, this.sauce
        );
        this.reset();
        return s;
    }

    public HamburgerBuilder reset(){
        this.doughType = this.DEFAULT_DOUGH;
        this.sizeCm = this.DEFAULT_SIZE_CM;
        this.topping1 = this.DEFAULT_TOPPING1;
        this.topping2 = null;
        this.topping3 = null;
        this.vegetable1 = null;
        this.vegetable2 = null;
        this.vegetable3 = null;
        this.vegetable4 = null;
        this.vegetable5 = null;

        this.ischeese = true;
        this.cheeseType = this.DEFAULT_CHEESETYPE;
        this.cheeseG = this.DEFAULT_CHEESEG;

        this.ketchup = false;
        this.mustard = false;
        this.mayonnaise = false;
        this.sauce = null;
        return this;
    }
}

class SandwichBuilder extends Builder{
    private final static String DEFAULT_DOUGH = "Wheat";
    private final static String DEFAULT_TOPPING1 = "Ham";
    private final static double DEFAULT_SIZE_CM = 15.24;
    private final static String DEFAULT_CHEESETYPE = "sliced";
    private final static double DEFAULT_CHEESEG = 36.0;

    public SandwichBuilder(){
        this.reset();
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
enum HamburgerMenu{
    BIG_MAC,
    DOUBLE_CHEESE,
    TERIYAKI,
    CHICKEN_FILET,
    SHRIMP_FILET
}

enum SandwichMenu{
    CHICKEN_AND_BACON,
    STEAK_AND_CHEESE,
    SPICY_ITALIAN,
    TUNA_AND_EGG,
}

enum Size{
    S,
    M,
    L
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
class FairyWorldDirector{
    public static HamburgerBuilder bigMac(HamburgerBuilder builder){
        builder.addDoughType("BigMacBuns").addTopping1("Patty")
                    .addTopping2("Patty").addSauce("BigMacSauce")
                    .addVegetable1("Lettuce").addVegetable2("Lettuce")
                    .addVegetable3("Onions").addCheese();
        return builder;
    }

    public static HamburgerBuilder doubleCheese(HamburgerBuilder builder){
        // あとで
        return builder;
    }

    public static HamburgerBuilder teriyaki(HamburgerBuilder builder){
        //
        return builder;
    }

    public static HamburgerBuilder checkenFilet(HamburgerBuilder builder){
        //
        return builder;
    }

    public static HamburgerBuilder shrimpFilet(HamburgerBuilder builder){
        //
        return builder;
    }

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
    public Hamburger orderHamburger(HamburgerMenu item, Size itemSize, CheeseType cheeseType, CheeseAmount cheeseAmount){
        HamburgerBuilder hamburgerBuilder = new HamburgerBuilder();

        switch(item){
            case BIG_MAC: FairyWorldDirector.bigMac(hamburgerBuilder); break;
            case DOUBLE_CHEESE: FairyWorldDirector.doubleCheese(hamburgerBuilder); break;
            case TERIYAKI: FairyWorldDirector.teriyaki(hamburgerBuilder); break;
            case CHICKEN_FILET: FairyWorldDirector.checkenFilet(hamburgerBuilder); break;
            case SHRIMP_FILET: FairyWorldDirector.shrimpFilet(hamburgerBuilder); break;
        }

        switch(itemSize){
            case S: hamburgerBuilder.setSize(15.24); break;
            case M: hamburgerBuilder.setSize(30.48); break;
            case L: hamburgerBuilder.setSize(45.72); break;
        }

        switch(cheeseType){
            case SLICED: hamburgerBuilder.addCheese().switchCheese("sliced"); break;
            case NATURAL: hamburgerBuilder.addCheese().switchCheese("natural"); break;
            case NONE: hamburgerBuilder.noCheese(); break;
        }

        if (hamburgerBuilder.ischeese){
            switch(cheeseAmount){
                case HALF: hamburgerBuilder.setCheeseAmount(18.0); break;
                case DEFAULT: hamburgerBuilder.setCheeseAmount(36.0); break;
                case DOUBLE: hamburgerBuilder.setCheeseAmount(54.0); break;
            }
        }

        return hamburgerBuilder.build();
    }

    public Sandwich orderSandwich(SandwichMenu item, Size itemSize, CheeseType cheeseType, CheeseAmount cheeseAmount){
        SandwichBuilder sandwichBuilder = new SandwichBuilder();

        // オブジェクトのbuild
        switch(item){
            case CHICKEN_AND_BACON: FairyWorldDirector.chickenAndBacon(sandwichBuilder); break;
            case STEAK_AND_CHEESE: FairyWorldDirector.steakAndCheese(sandwichBuilder); break;
            case SPICY_ITALIAN: FairyWorldDirector.spicyItalian(sandwichBuilder); break;
            case TUNA_AND_EGG: FairyWorldDirector.tunaAndEgg(sandwichBuilder); break;
        }

        switch(itemSize){
            case S: sandwichBuilder.setSize(15.24); break;
            case M: sandwichBuilder.setSize(30.48); break;
            case L: sandwichBuilder.setSize(45.72); break;
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
        String endl = System.lineSeparator();

        Hamburger bigMac = fairyWorld.orderHamburger(HamburgerMenu.BIG_MAC, Size.L, CheeseType.SLICED, CheeseAmount.DOUBLE);
        Sandwich chickenAndBacon = fairyWorld.orderSandwich(SandwichMenu.CHICKEN_AND_BACON, Size.M, CheeseType.NATURAL, CheeseAmount.DEFAULT);

        System.out.println(bigMac + endl);
        System.out.println(chickenAndBacon + endl);    
    }
}