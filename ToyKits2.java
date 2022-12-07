// ここから開発しましょう。
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
    public int getAge(){
        return this.age;
    }

    public String toString(){
        return this.getName();
    }
}

//体を作っていく
interface Product{
    abstract public double getCost(); // 価格を取得する 
    //価格を変更する場合は、それぞれのクラスの定数を変えてください
}

interface Parts{
    abstract public int getDifficulty(); // 組み立て難易度を取得する
    //難易度を変更する場合は、それぞれのクラスの定数を変えてください

    abstract public boolean isAssembled(); // 組み立てが完了しているかを取得する
    abstract public void effect(); // 光ったり、音を立てたり、さまざまな動きをする
}

abstract class Head implements Product, Parts{
    protected int eye;
    protected int ear;
    protected int nose;
    protected int mouse;

    public void eyeAssembled(){
        this.eye += 1;
        System.out.println("目を1つ組み立てた");
    }

    public void earAssembled(){
        this.ear += 1; 
        System.out.println("耳を1つ組み立てた");
    }

    public void noseAssembled(){
        this.nose += 1;
        System.out.println("鼻を1つ組み立てた");
    }

    public void mouseAssembled(){
        this.mouse += 1;
        System.out.println("口を1つ組み立てた");
    }

}

abstract class Torso implements Product, Parts{
    protected int core;

    public void coreAssembled(){
        this.core += 1;
        System.out.println("コア部分を1つ組み立てた");
    }
}

abstract class RightArm implements Product, Parts{
    protected int rightArm;
    protected int rightHand;

    public void rightArmAssembled(){
        this.rightArm += 1;
        System.out.println("右腕を1つ組み立てた");
    }

    public void rightHandAssembled(){
        this.rightHand += 1;
        System.out.println("右手を1つ組み立てた");
    }
}

abstract class LeftArm implements Product, Parts{
    protected int leftArm;
    protected int leftHand;

    public void leftArmAssembled(){
        this.leftArm += 1;
        System.out.println("左腕を1つ組み立てた");
    }

    public void leftHandAssembled(){
        this.leftHand += 1;
        System.out.println("左手を1つ組み立てた");
    }
}

abstract class RightLeg implements Product, Parts{
    protected int rightLeg;
    protected int rightFoot;

    public void rightLegAssembled(){
        this.rightLeg += 1;
        System.out.println("右脚を1つ組み立てた");
    }

    public void rightFootAssembled(){
        this.rightFoot += 1;
        System.out.println("右足を1つ組み立てた");
    }
}

abstract class LeftLeg implements Product, Parts{
    protected int leftLeg;
    protected int leftFoot;

    public void leftLegAssembled(){
        this.leftLeg += 1;
        System.out.println("左脚を1つ組み立てた");
    }

    public void leftFootAssembled(){
        this.leftFoot += 1;
        System.out.println("左足を1つ組み立てた");
    }
}

//Robot
class RobotHead extends Head{
    public static final double ROBOT_HEAD_COST = 5.0;
    public static final int ROBOT_HEAD_DIFFICULTY = 50;
    
    public RobotHead(){
        super();
    }

    public void effect(){
        System.out.println("頭を回転させた");
    }

    public boolean isAssembled(){
        if (this.eye >= 2 && this.ear >= 2 && this.mouse >= 1){
            System.out.println("部品が揃いました");
            return true;
        } 
        else {
            System.out.println("部品が揃っていません");
            return false;
        }
    }

    public double getCost(){
        return this.ROBOT_HEAD_COST;
    }

    public int getDifficulty(){
        return this.ROBOT_HEAD_DIFFICULTY;
    }

    public String toString(){
        return "これはロボットの頭です。目を2つ、口を1つ、耳を2つ組み立ててください。";
    }
}

class RobotTorso extends Torso{
    public static final double ROBOT_TORSO_COST = 2.0;
    public static final int ROBOT_TORSO_DIFFICULTY = 30;

    public RobotTorso(){
        super();
    }

    public void effect(){
        System.out.println("コアが赤く光った");
    }

    public boolean isAssembled(){
        if (this.core >= 1){
            System.out.println("部品が揃いました");
            return true;
        } 
        else {
            System.out.println("部品が揃っていません");
            return false;
        }
    }

    public double getCost(){
        return this.ROBOT_TORSO_COST;
    }

    public int getDifficulty(){
        return this.ROBOT_TORSO_DIFFICULTY;
    }

    public String toString(){
        return "これはロボットの胴体です。胸に動力源をつけてください";
    }
}

class RobotRightArm extends RightArm{
    public static final double ROBOT_RIGHTARM_COST = 1.0;
    public static final int ROBOT_RIGHTARM_DIFFICULTY = 20;

    public RobotRightArm(){
        super();
    }

    public void effect(){
        System.out.println("右手が伸びた");
    }

    public boolean isAssembled(){
        if (this.rightArm >= 1 && this.rightHand >= 1){
            System.out.println("部品が揃いました");
            return true;
        } 
        else {
            System.out.println("部品が揃っていません");
            return false;
        }
    }

    public double getCost(){
        return this.ROBOT_RIGHTARM_COST;
    }

    public int getDifficulty(){
        return this.ROBOT_RIGHTARM_DIFFICULTY;
    }

    public String toString(){
        return "これはロボットの右腕です。伸びる腕なので、内部に層を作って組み立ててください";
    }
}

class RobotLeftArm extends LeftArm{
    public static final double ROBOT_LEFTARM_COST = 1.0;
    public static final int ROBOT_LEFTARM_DIFFICULTY = 20;

    public RobotLeftArm(){
        super();
    }

    public void effect(){
        System.out.println("左手はさまざまな道具に変形する");
    }

    public boolean isAssembled(){
        if (this.leftArm >= 1 && this.leftHand >= 3){
            System.out.println("部品が揃いました");
            return true;
        } 
        else {
            System.out.println("部品が揃っていません");
            return false;
        }
    }

    public double getCost(){
        return this.ROBOT_LEFTARM_COST;
    }

    public int getDifficulty(){
        return this.ROBOT_LEFTARM_DIFFICULTY;
    }

    public String toString(){
        return "これはロボットの左腕です。さまざまな道具に変形します。左手部分は3つ組み立ててください";
    }
}

class RobotRightLeg extends RightLeg{
    public static final double ROBOT_RIGHTLEG_COST = 1.0;
    public static final int ROBOT_RIGHTLEG_DIFFICULTY = 20;

    public RobotRightLeg(){
        super();
    }

    public void effect(){
        System.out.println("足はキャタピラに変形します");
    }

    public boolean isAssembled(){
        if (this.rightLeg >= 1 && this.rightFoot >= 2){
            System.out.println("部品が揃いました");
            return true;
        } 
        else {
            System.out.println("部品が揃っていません");
            return false;
        }
    }

    public double getCost(){
        return this.ROBOT_RIGHTLEG_COST;
    }

    public int getDifficulty(){
        return this.ROBOT_RIGHTLEG_DIFFICULTY;
    }

    public String toString(){
        return "これはロボットの右足です。通常時の足とキャタピラを組み立ててください。";
    }
}

class RobotLeftLeg extends LeftLeg {
    public static final double ROBOT_LEFTLEG_COST = 1.0;
    public static final int ROBOT_LEFTLEG_DIFFICULTY = 20;

    public RobotLeftLeg(){
        super();
    }

    public void effect(){
        System.out.println("足はキャタピラに変形します");
    }

    public boolean isAssembled(){
        if (this.leftLeg >= 1 && this.leftFoot >= 2){
            System.out.println("部品が揃いました");
            return true;
        } 
        else {
            System.out.println("部品が揃っていません");
            return false;
        }
    }

    public double getCost(){
        return this.ROBOT_LEFTLEG_COST;
    }

    public int getDifficulty(){
        return this.ROBOT_LEFTLEG_DIFFICULTY;
    }

    public String toString(){
        return "これはロボットの左足です。通常時の足とキャタピラを組み立ててください。";
    }
}

// 組み立てられたあと、HumanoidToyとしての機能
// 未実装
interface HumanoidToy{
    abstract public void makeNoise();
    abstract public void walk();
}

//Kit
abstract class HumanoidToyKit{
    protected String name;
    protected String microchip;
    protected String circuitBoard;
    protected String battery;

    protected Head head;
    protected Torso torso;
    protected RightArm rightArm;
    protected LeftArm leftArm;
    protected RightLeg rightLeg;
    protected LeftLeg leftLeg;

    public HumanoidToyKit(Head head, Torso torso, RightArm rightArm, LeftArm leftArm, RightLeg rightLeg, LeftLeg leftLeg){
        this.head = head;
        this.torso = torso;
        this.rightArm = rightArm;
        this.leftArm = leftArm;
        this.rightLeg = rightLeg;
        this.leftLeg = leftLeg;
    }

    //組み立てらているかどうか
    abstract public boolean isAllAssembled();
}

class RobotHumanoidToyKit extends HumanoidToyKit{
    public static final String NAME = "robot";
    public static final String ROBOTTOYKIT_MICROCHIP = "PIC18F25K42-I/SP";
    public static final String ROBOTTOYKIT_CURCUITBOARD = "FCU6-DX450";
    public static final String ROBOTTOYKIT_BATTERY = "361-00056-50";

    public RobotHumanoidToyKit(Head head, Torso torso, RightArm rightArm, LeftArm leftArm, RightLeg rightLeg, LeftLeg leftLeg){
        super(head, torso, rightArm, leftArm, rightLeg, leftLeg);

        this.name = this.NAME;
        this.microchip = this.ROBOTTOYKIT_MICROCHIP;
        this.circuitBoard = this.ROBOTTOYKIT_CURCUITBOARD;
        this.battery = this.ROBOTTOYKIT_BATTERY;
    }

    public boolean isAllAssembled(){
        return head.isAssembled() && torso.isAssembled() && rightArm.isAssembled() && leftArm.isAssembled() && rightLeg.isAssembled() && leftLeg.isAssembled();
    }
}

//Factory
abstract class HumanoidToyKitFactory{
    // Kitを返す
    abstract public HumanoidToyKit getAHumanoidToyKit();

    //コストの計算、難易度の計算を行う
    abstract public double getAllCost();
    abstract public int getAllDifficulty();
}

class RobotHumanoidToyKitFactory extends HumanoidToyKitFactory{
    public RobotHumanoidToyKit robotHumanoidToyKit;

    public RobotHumanoidToyKitFactory(){
        super();  
        this.robotHumanoidToyKit = new RobotHumanoidToyKit(new RobotHead(), new RobotTorso(), new RobotRightArm(), new RobotLeftArm(), new RobotRightLeg(), new RobotLeftLeg());
    }

    public RobotHumanoidToyKit getAHumanoidToyKit(){
        return this.robotHumanoidToyKit;
    }

    public double getAllCost(){
        double res = 0;
        res += this.robotHumanoidToyKit.head.getCost();
        res += this.robotHumanoidToyKit.torso.getCost();
        res += this.robotHumanoidToyKit.rightArm.getCost();
        res += this.robotHumanoidToyKit.leftArm.getCost();
        res += this.robotHumanoidToyKit.rightLeg.getCost();
        res += this.robotHumanoidToyKit.leftLeg.getCost();
        return res;
    }

    public int getAllDifficulty(){
        int res = 0;
        res += this.robotHumanoidToyKit.head.getDifficulty();
        res += this.robotHumanoidToyKit.torso.getDifficulty();
        res += this.robotHumanoidToyKit.rightArm.getDifficulty();
        res += this.robotHumanoidToyKit.leftArm.getDifficulty();
        res += this.robotHumanoidToyKit.rightLeg.getDifficulty();
        res += this.robotHumanoidToyKit.leftLeg.getDifficulty();
        return res;
    }
}

class FairyWorld{
    public HumanoidToyKitFactory createAHumanoidToyKitFactory(String name){
        String call = name.toLowerCase();

        if ("robot".equals(call)){
            return new RobotHumanoidToyKitFactory();
        }/*
        else if ("vampire".equals(call)){
            
        }
        else if ("werewolf".equals(call)){
            
        }
        else if ("transformer".equals(call)){
            
        }
        else if ("alian".equals(call)){
            
        } */
        else {
            System.out.println("その製品は現在、存在しません");
            return null;
        }
    }

    /*
    public HumanoidToy createAHumanoidToyByKit(Person person, HumanoidToyKit Kit){
        //personの年齢により、作成できるかどうかの判断を行う
        //personに対して金額の請求

    }*/
}

class Main{
    public static void main(String[] args){
        FairyWorld fairyWorld = new FairyWorld();
        Person jessica = new Person("Jessica", "Roller", 30, 1.65, 95, "female");

        //生産者段階(Kitが作られる)
        //HumanoidToyKit kit1 = fairyWorld.createAHumanoidToyKitFactory(args[0]); 
        //使いたいオブジェクト群を変えたい時にClientのコードを全く変えないですむ 
        //recursionの場合argsが使えないから後でコメントアウト
        
        HumanoidToyKitFactory robotFactory = fairyWorld.createAHumanoidToyKitFactory("robot");
        System.out.println(robotFactory.getAllCost());
        System.out.println(robotFactory.getAllDifficulty());
        HumanoidToyKit robotKit = robotFactory.getAHumanoidToyKit();
        
        System.out.println(robotKit.isAllAssembled());

        robotKit.leftLeg.effect();
        System.out.println(robotKit.leftLeg.getCost());
        

        //消費者段階(Kitを使って、組み立てて遊んでもらう)
        //Robot robot = fairyWorld.createAHumanoidToyByKit(jessica, kit2);
    }    
}