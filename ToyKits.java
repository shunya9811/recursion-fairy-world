import java.util.*;

class Person{
    private String firstName;
    private String lastName;
    private int age;
    private double heightM;
    private double weightKg;
    private String biologicalSex;

    public Person(String firstName, String lastName, int age, double heightM, double weightKg, String biologicalSex){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.heightM = heightM;
        this.weightKg = weightKg;
        this.biologicalSex = biologicalSex;
    }

    public String getName(){
        return this.firstName + " " + this.lastName;
    }

    public String toString(){
        return this.getName();
    }
}

// abstract Factory 
interface HumanoidToyKitfactory{
    abstract public Head createAHumanoidToyKitHead();
    abstract public Body createAHumanoidToyKitBody();
    abstract public LeftArm createAHumanoidToyKitLeftArm();
    abstract public RightArm createAHumanoidToyKitRightArm();
    abstract public LeftFoot createAHumanoidToyKitLeftFoot();
    abstract public RightFoot createAHumanoidToyKitRightFoot();
}

class Act{
    protected String description;

    public Act(String description){
        this.description = description;
    }

    public String walk(){
        return "pitter-patter";
    }

    public String makeNoise(){
        return "";
    }
}

interface Product{
    abstract public int getCosts();
}

interface Head extends Product{
    abstract public void createHead();
    abstract public void createEye();
    abstract public void createEar();
    abstract public void createNose();
    abstract public void createMouth();
}

interface Body extends Product{
    abstract public void createBody();
}

interface LeftArm extends Product{
    abstract public void createLeftArm();
    abstract public void createLeftHand();
}

interface RightArm extends Product{
    abstract public void createRightArm();
    abstract public void createRightHand();
}

interface LeftFoot extends Product{
    abstract public void createLeftFoot();
    abstract public void createLeftLeg();
}

interface RightFoot extends Product{
    abstract public void createRightFoot();
    abstract public void createRightLeg();
}

class HumanoidToyKitParts implements Product{
    protected String toyName;

    protected boolean hasMicrochip;
    protected boolean hasCircuitBoard;
    protected boolean hasBattery;
    protected boolean isHeadAssemled;
    protected boolean isEyesAssemled;
    protected boolean isEarsAssemled;
    protected boolean isNoseAssemled;
    protected boolean isMouthAssemled;
    protected boolean isBodyAssemled;
    protected boolean isLeftArmAssemled;
    protected boolean isLeftHandAssemled;
    protected boolean isRightArmAssemled;
    protected boolean isRightHandAssemled;
    protected boolean isLeftFootAssemled;
    protected boolean isLeftLegAssemled;
    protected boolean isRightFootAssemled;
    protected boolean isRightLegAssemled;

    protected int headAssemblyLevel;
    protected int bodyAssemblyLevel;
    protected int RightArmAssemlyLevel;
    protected int LeftArmAssemlyLevel;
    protected int rightLegAssemlyLevel;
    protected int leftLegAsssemlyLevel;

    protected int totalProductionCost;

    public HumanoidToyKitParts(){

    }


    public int getCosts(){
        return this.totalProductionCost;
    }
}

//汎用的人形クラス
class GenericHead extends HumanoidToyKitParts implements Head{
    public GenericHead(){
        super();
    }
    
    public void createHead(){
        this.isHeadAssemled = true;
    }

    public void createEye(){
        this.isEyesAssemled = true;
    }

    public void createEar(){
        this.isEarsAssemled = true;
    }

    public void createNose(){
        this.isNoseAssemled = true;
    }

    public void createMouth(){
        this.isMouthAssemled = true;
    }
}

class GenericBody extends HumanoidToyKitParts implements Body{
    public GenericBody(){
        super();
    }
    
    public void createBody(){
        this.isBodyAssemled = true;
    }
}

class GenericLeftArm extends HumanoidToyKitParts implements LeftArm{
    public GenericLeftArm(){
        super();
    }
    
    public void createLeftArm(){
        this.isLeftArmAssemled = true;
    }

    public void createLeftHand(){
        this.isLeftHandAssemled = true;
    }
}

class GenericRightArm extends HumanoidToyKitParts implements RightArm{
    public GenericRightArm(){
        super();
    }
    
    public void createRightArm(){
        this.isRightArmAssemled = true;
    }

    public void createRightHand(){
        this.isRightHandAssemled = true;
    }
}

class GenericLeftFoot extends HumanoidToyKitParts implements LeftFoot{
    public GenericLeftFoot(){
        super();
    }
    
    public void createLeftFoot(){
        this.isLeftFootAssemled = true;
    }

    public void createLeftLeg(){
        this.isLeftLegAssemled = true;
    }
}

class GenericRightFoot extends HumanoidToyKitParts implements RightFoot{
    public GenericRightFoot(){
        super();
    }

    public void createRightFoot(){
        this.isRightFootAssemled = true;
    }

    public void createRightLeg(){
        this.isRightLegAssemled = true;
    }
}

// 汎用人形のための汎用Factory
class GenericHumanoidToyKitfactory implements HumanoidToyKitfactory{
    public Head createAHumanoidToyKitHead(){
        return new GenericHead();
    }

    public Body createAHumanoidToyKitBody(){
        return new GenericBody();
    }

    public LeftArm createAHumanoidToyKitLeftArm(){
        return new GenericLeftArm();
    }

    public RightArm createAHumanoidToyKitRightArm(){
        return new GenericRightArm();
    }
    public LeftFoot createAHumanoidToyKitLeftFoot(){
        return new GenericLeftFoot();
    }

    public RightFoot createAHumanoidToyKitRightFoot(){
        return new GenericRightFoot();
    }
}

class FairyWorld{
    public void createAHumanoidToyKit(Person person, HumanoidToyKitfactory factory){

    }
}

class Main{
    public static void main(String[] args){
        FairyWorld fairyWorld = new FairyWorld();
        Person jessica = new Person("Jessica", "Roller", 30, 1.65, 95, "female");

        fairyWorld.createAHumanoidToyKit(jessica, new HumanoidToyKitfactory());
    }
}