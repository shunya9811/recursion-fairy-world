import java.util.*;

class RandomWrapper{
    public static int getRan(int min, int max){
        return min + (int)(Math.random() * ((max - min) + 1));
    }
    public static boolean ranBoolean(){
        return new Random().nextBoolean();
    }
}

// Poster
class Poster{
    protected String poster;

    public void setPoster(String[] designs){
        int randomInt = RandomWrapper.getRan(0, designs.length-1);
        this.poster = designs[randomInt];
    }

    public String getPoster(){
        return this.poster;
    }

    public String toString(){
        String newline = System.lineSeparator();
        return newline + "- - - - - - - - - - - - - - - - - - - - " + newline + 
            this.poster + 
            newline + "- - - - - - - - - - - - - - - - - - - - " + newline;
    }
}

class SpringPoster extends Poster{  
    public static final String[] designs = {"Best time to see cherry blossoms", "Let's raise a carp streamer.", "How about a picnic in the mild spring weather?"};

    public SpringPoster(){
        super.setPoster(this.designs);
    }
}

// StringOfLights
class RGB24{
    public int red;
    public int green;
    public int blue;

    public RGB24(int red, int green, int blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    // 文字列のみを入力とするRGB24用のコンストラクタ。これには関数のオーバーロードを使用しています。
    // コンストラクタは、新しいクラスのインスタンスを作成するときに最初に実行しなければならない関数であることを覚えておいてください。ここでは、状態を初期化するために必要なことは何でもできます。
    public RGB24(String inputString){
        int l = inputString.length();

        if(l == 6) this.setColorsByHex(inputString);
        else if(l == 24) this.setColorsByBin(inputString);
        else this.setAsBlack();
    }

    // RGBの状態を16進数で指定します。
    public void setColorsByHex(String hex){
        if(hex.length() != 6) this.setAsBlack();
        else{
            this.red = Integer.parseInt(hex.substring(0,2), 16);
            this.green = Integer.parseInt(hex.substring(2,4), 16);
            this.blue = Integer.parseInt(hex.substring(4,6), 16);
        }
    }

    // RGBの状態を2進数で指定します。
    public void setColorsByBin(String bin){
        if(bin.length() != 24) this.setAsBlack();
        else{
            this.red = Integer.parseInt(bin.substring(0,8), 2);
            this.green = Integer.parseInt(bin.substring(8,16), 2);
            this.blue = Integer.parseInt(bin.substring(16), 2);
        }
    }

    // 状態を黒に設定します。
    public void setAsBlack(){
        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }

    public String getHex(){
        String hex = Integer.toHexString(this.red);
        hex+=Integer.toHexString(this.green);
        hex+=Integer.toHexString(this.blue);

        return hex;
    } 

    public String getBits(){
        return Integer.toBinaryString(Integer.parseInt(this.getHex(), 16));
    }

    // RGBが赤、青、緑の中でどの色が濃いのか、もしくはgrayなのか決定することができます。
    public String getColorShade(){
        if(this.red == this.green && this.green == this.blue) return "grayscale";
        String[] stringTable = new String[]{"red","green","blue"};
        int[] values = {this.red, this.green, this.blue};

        // max algorithm。maxへの線形探索。
        int max = values[0];
        int maxIndex = 0;
        for(int i = 1; i < values.length; i++){
            if(max <= values[i]){
                max = values[i];
                maxIndex = i;
            }
        }

        return stringTable[maxIndex];
    }

    // 文字列変換メソッドtoString()。Javaは、System.out.println(data)関数のように、オブジェクトを文字列に変換する必要がある場合、この関数を自動的に呼び出します。
    public String toString(){
        return "The color is rgb(" + this.red + "," + this.green + "," + this.blue + "). Hex: " + this.getHex() + ", binary: " + this.getBits();
    }
}

class StringOfLights{
    protected RGB24[] lights;

    public void setLights(RGB24[] patterns){
        this.lights = patterns;
    }

    public String getLights(){
        return Arrays.toString(this.lights);
    }

    public String toString(){
        return "Light patterns tonight is " + Arrays.toString(this.lights);
    }
}

class SpringStringOfLights extends StringOfLights{
    //ピンク、紫、オレンジ、青
    public static final RGB24[] patterns = {new RGB24("ff00a1"), new RGB24("db00ff"), new RGB24("ff9b00"), new RGB24("0000ff")};

    public SpringStringOfLights(){
        super.setLights(this.patterns);
    }
}

// LightShow
class LightShow{
    protected String show;

    public void setShow(String show){
        this.show = show;
    }

    public String getShow(){
        return this.show;
    }

    public String toString(){
        return "This show is " + this.show;
    }

    public String narration(){
        String newline = System.lineSeparator();
        return "Welcome to Fairy World!" + newline + 
                "We will start a 20-minute night show from now. " + newline + 
                "Enjoy " + this.show + " that can only be seen this season!" + newline;
    }
}

class SpringLightShow extends LightShow{
    public static final String show = "easter celebration";

    public SpringLightShow(){
        super.setShow(this.show);
    }   
}

// MusicSong
class Time{
    public static String secToMinitesString(int inputSeconds){
        int minutes = inputSeconds / 60;
        int seconds = inputSeconds % 60;
        return minutes + " : " + seconds;
    }
}

class Song{
    public String title;
    public String lyrics;
    public int songSec;

    public Song(String title, String lyrics, int songSec){
        this.title = title;
        this.lyrics = lyrics;
        this.songSec = songSec;
    }

    public String toString(){
        String newline = System.lineSeparator();
        return newline + "- - - - - - - - - - - - - - - - - - - - " + newline + 
            "This is " + this.song.title + newLine + 
            "Lyrics:" + this.song.lyrics + 
            newline + "- - - - - - - - - - - - - - - - - - - - " + newline
            + Time.secToMinitesString(this.song.songSec) + newline;
    }
}

class MusicSong{
    protected Song song;

    public void setSong(Song[] songs){
        int randomInt = RandomWrapper.getRan(0, songs.length-1);
        this.song = songs[randomInt];
    }

    public String getSongTitle(){
        return this.song.title;
    }

    public String getSongLyrycs(){
        return this.song.lyrics;
    }

    public int getSongLyrycs(){
        return this.song.songSec;
    }

    public String toString(){
        return this.song;
    }
}

class SpringMusicSong extends MusicSong{
    public static final Song[] songs = {
        new Song("KICK BACK", "努力　未来　A Beautiful Star
            努力　未来　A Beautiful Star
            努力　未来　A Beautiful Star
            努力　未来　A Beautiful Star

            ランドリー今日はガラ空きでラッキーデイ
            かったりい油汚れもこれでバイバイ

            誰だ誰だ頭の中　呼びかける声は
            あれが欲しいこれが欲しいと歌っている

            幸せになりたい　楽して生きていたい
            この手に掴みたい　あなたのその胸の中

            ハッピーで埋め尽くして　レストインピースまで行こうぜ
            いつかみた地獄もいいところ　愛をばら撒いて
            アイラブユー貶してくれ　全部奪って笑ってくれマイハニー
            努力　未来　A Beautiful Star
            努力　未来　A Beautiful Star
            努力　未来　A Beautiful Star
            なんか忘れちゃってんだ

            努力　未来　A Beautiful Star
            努力　未来　A Beautiful Star
            努力　未来　A Beautiful Star
            努力　未来　A Beautiful Star

            4443で外れる炭酸水
            ハングリー拗らせて吐きそうな人生

            「止まない雨はない」より先に　その傘をくれよ
            あれが欲しい　これが欲しい　全て欲しい　ただ虚しい

            幸せになりたい　楽して生きていたい
            全部滅茶苦茶にしたい　何もかも消し去りたい
            あなたのその胸の中

            ラッキーで埋め尽くして　レストインピースまで行こうぜ
            良い子だけ迎える天国じゃ　どうも生きらんない
            アイラブユー貶して奪って笑ってくれマイハニー
            努力　未来　A Beautiful Star
            努力　未来　A Beautiful Star
            努力　未来　A Beautiful Star
            なんか忘れちゃってんだ

            ハッピー　ラッキー　こんにちはベイビー
            (ハッピー　ラッキー　こんにちはベイビー)
            良い子でいたい　そりゃつまらない
            (あなたの未来　そりゃつまらない)
            ハッピー　ラッキー　こんにちはベイビーソースイート
            (ハッピー　ラッキー　こんにちはベイビーソースイート)
            努力　未来　AA Beautiful Star
            努力　未来　AA Beautiful Star
            努力　未来　AA Beautiful Star
            なんかすごい良い感じ

            努力　未来　AA Beautiful Star
            努力　未来　AA Beautiful Star
            努力　未来　AA Beautiful Star
            努力　未来　AA Beautiful Star", 193), 
            new Song("新時代", "新時代はこの未来だ
                世界中全部　変えてしまえば　変えてしまえば…

                ジャマモノ　やなもの　なんて消して
                この世とメタモルフォーゼしようぜ
                ミュージック　キミが起こす　マジック

                目を閉じれば未来が開いて
                いつまでも終わりが来ないようにって
                この歌を歌うよ

                Do you wanna play? リアルゲーム　ギリギリ
                綱渡りみたいな旋律　認めない戻れない忘れたい
                夢の中に居させて　I wanna be free
                見えるよ新時代が　世界の向こうへ
                さあ行くよ　NewWorld

                新時代はこの未来だ
                世界中全部　変えてしまえば　変えてしまえば
                果てしない音楽がもっと届くように
                夢は見ないわ　キミが話した　「ボクを信じて」

                あれこれいらないものは消して
                リアルをカラフルに越えようぜ
                ミュージック　今始まる　ライジング

                目をつぶりみんなで逃げようよ
                今よりイイモノを見せてあげるよ
                この歌を歌えば

                Do you wanna play? リアルゲーム　ギリギリ
                綱渡りみたいな運命　認めない戻れない忘れたい
                夢の中に居させて　I wanna be free
                見えるよ新時代が　世界の向こうへ
                さあ行くよ　NewWorld

                信じたいわ　この未来を
                世界中全部　変えてしまえば　変えてしまえば
                果てしない音楽がもっと届くように
                夢を見せるよ　夢を見せるよ　新時代だ

                新時代だ", 226)}
    
    public SpringMusicSong(){
        super.setSong(this.songs);
    }
}

// Mascots
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

class Mascot{
    protected String name;
    protected double heightM;
    protected double widthM;
    protected String appearance;
    protected Person kuroko;

    public Mascot(String name, double heightM, double widthM, String appearance, Person kuroko){
        this.name = name;
        this.heightM = heightM;
        this.widthM = widthM;
        this.appearance = appearance;
        this.kuroko = kuroko;
    }

    public Person whoInside(){
        return this.kuroko;
    }
}

class SpringMascot extends Mascot{
    public SpringMascot(String name, double heightM, double widthM, String appearance, Person kuroko){
        super(name, heightM, widthM, appearance, kuroko);        
    }

    public String toString(){
        String newline = System.lineSeparator();
        return this.name + " is in the plaza, shaking hands and giving hugs." + newLine;
    }
}

// Factory
interface FairyWorldThemeFactory{
    abstract public Poster createPoster();
    abstract public StringOfLights createLights();
    abstract public LightShow createLightShow();
    abstract public MusicSong createMusicSong();
    abstract public Mascot[] createMascots(Person[] performers);
}

class SpringThemeFactory implements FairyWorldThemeFactory{
    public Poster createPoster(){
        return new SpringPoster();
    }

    public StringOfLights createLights(){
        return new SpringStringOfLights();
    }

    public LightShow createLightShow(){
        return new SpringLightShow();
    }

    public MusicSong createMusicSong(){
        return new SpringMusicSong();
    }

    public Mascot[] createMascots(Person[] performers){
        String[] types = new String[]{"Mikey Mouse", "Minnie Mouse", "Donald Duck", "Winnie the Pooh", "Daisy Duck", "Pluto"};
    }
}

class FairyWorld{
    public void demoTheme(FairyWorldThemeFactory factory, Person[] persons){
        String newline = System.lineSeparator();

        System.out.println("The demo of the theme today is starting...");

        System.out.println(factory.createPoster());
        System.out.println(factory.createLights());
        System.out.println(factory.createLightShow());
        System.out.println(factory.createMusicSong());
    }
}

class Main{
    public static void main(String[] args){
        FairyWorld fairyWorld = new FairyWorld();
        Person jessica = new Person("Jessica", "Roller", 30, 1.65, 95, "female");
        Person mike = new Person("mike", "Joseph", 19, 1.80, 75, "male");
        Person jet = new Person("Jet", "Arabella", 8, 1.20, 35, "male");

        Person[] list = new Person[]{jessica, mike, jet};



        fairyWorld.demoTheme(new SpringThemeFactory(), list);
    }
}
