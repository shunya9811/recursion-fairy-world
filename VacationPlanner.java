import java.util.*;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;

class VacationInvoice{
    private LocalDateTime startingDate;
    private LocalDateTime endingDate;
    private int totalAmountOfPeople;
    private int hotelDays;
    private String hotelType;
    private int fairyWorldDays;
    private int adultFastPass;
    private int kidsFastPass;
    private int arcadePass;
    private String vipTour1;
    private String vipTour2;
    private String vipTour3;
    private boolean threeMealsRegularRestaurants;
    private boolean threeMealsFineDiningRestaurants;
    private boolean photoShoot;

    public VacationInvoice(LocalDateTime startingDate, LocalDateTime endingDate, int totalAmountOfPeople, int hotelDays, String hotelType, int fairyWorldDays, int adultFastPass, int kidsFastPass, int arcadePass, String vipTour1, String vipTour2, String vipTour3, boolean threeMealsRegularRestaurants, boolean threeMealsFineDiningRestaurants, boolean photoShoot){
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.totalAmountOfPeople = totalAmountOfPeople;
        this.hotelDays = hotelDays;
        this.hotelType = hotelType;
        this.fairyWorldDays = fairyWorldDays;
        this.adultFastPass = adultFastPass;
        this.kidsFastPass = kidsFastPass;
        this.arcadePass = arcadePass;
        this.vipTour1 = vipTour1;
        this.vipTour2 = vipTour2;
        this.vipTour3 = vipTour3;
        this.threeMealsRegularRestaurants = threeMealsRegularRestaurants;
        this.threeMealsFineDiningRestaurants = threeMealsFineDiningRestaurants;
        this.photoShoot = photoShoot;
    }

    public String toString(){
        String endl = System.lineSeparator();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        String hotel = "";
        if ("high".equals(this.hotelType)){
            hotel = "Ambassador Hotel";
        } else if ("middle".equals(this.hotelType)){
            hotel = "Hilton Tokyo Bay Hotel";
        } else {
            hotel = "Capsule Hotel";
        }

        String invoice = "---------------------------------------" + endl;
        invoice += "Schedule: " + this.startingDate.format(f) + " ~ " + this.endingDate.format(f) + endl;
        invoice += "People: " + Integer.valueOf(this.totalAmountOfPeople).toString() + endl;
        invoice += "Hotel: " + hotel + " " + Integer.valueOf(this.hotelDays).toString() + " night" + endl;
        invoice += "FairyWorldTicket: "+ endl + "   Adult: " + Integer.valueOf(this.adultFastPass).toString() + " Child: " + Integer.valueOf(this.kidsFastPass).toString() + endl;
        invoice += "Option: " + endl;
        if (this.arcadePass != 0) invoice += "  ArcadePass: " + Integer.valueOf(this.arcadePass).toString() + endl;
        if (this.vipTour1 != null) invoice += "    VipTour: " + this.vipTour1 + endl;
        if (this.vipTour2 != null) invoice += "    VipTour: " + this.vipTour2 + endl;
        if (this.vipTour3 != null) invoice += "    VipTour: " + this.vipTour3 + endl;
        if (this.threeMealsRegularRestaurants) invoice += "    Full board in regular restaurants" + endl;
        if (this.threeMealsFineDiningRestaurants) invoice += "    Full board in exclusive restaurant" + endl;
        if (this.photoShoot) invoice += "    photographing" + endl;

        invoice += "Total: " + Integer.valueOf(this.getCost()).toString() + endl;
        invoice += "---------------------------------------";

        return invoice;
    }

    public int getCost(){
        int cost = 0;
        // ホテル
        int hotelCost = 0;
        if (this.hotelType == "hight"){
            hotelCost = 10000;
        }
        else if (this.hotelType == "middle"){
            hotelCost = 8000;
        }
        else {
            hotelCost = 5000;
        }

        cost += this.adultFastPass * this.hotelDays * hotelCost;
        cost += this.kidsFastPass * this.hotelDays * hotelCost * 0.5;
        cost += this.arcadePass * this.hotelDays * hotelCost * 0.8;
        
        // fairyworld
        cost += this.adultFastPass * this.fairyWorldDays * 8000;
        cost += this.kidsFastPass * this.fairyWorldDays * 6000;

        if (this.arcadePass != 0) cost += this.arcadePass * 500;

        //option
        if (this.vipTour1 != null) cost += 4000;
        if (this.vipTour2 != null) cost += 4000;
        if (this.vipTour3 != null) cost += 4000;

        if (this.threeMealsRegularRestaurants) cost += 2000;
        if (this.threeMealsFineDiningRestaurants) cost += 4000;
        
        if (this.photoShoot) cost +=  1000;

        return cost;
    }
}

class VacationInvoiceBuilder{
    private LocalDateTime startingDate;
    private LocalDateTime endingDate;
    private int totalAmountOfPeople;
    private int hotelDays;
    private String hotelType;
    private int fairyWorldDays;
    private int adultFastPass;
    private int kidsFastPass;
    private int arcadePass;
    private String vipTour1;
    private String vipTour2;
    private String vipTour3;
    private boolean threeMealsRegularRestaurants;
    private boolean threeMealsFineDiningRestaurants;
    private boolean photoShoot;

    public VacationInvoiceBuilder(){
        this.reset();
    }

    public VacationInvoiceBuilder setStartingDate(LocalDateTime startingDate){
        this.startingDate = startingDate;
        return this;
    }

    public VacationInvoiceBuilder setEndingDate(LocalDateTime endingDate){
        this.endingDate = endingDate;
        return this;
    }

    public VacationInvoiceBuilder setTotalAmountOfPeople(int people){
        this.totalAmountOfPeople = people;
        return this;
    }

    public VacationInvoiceBuilder setHotelDays(int days){
        this.hotelDays = days;
        LocalDateTime endingDate = this.startingDate.plusDays(days);
        this.setEndingDate(endingDate);
        return this;
    }

    public VacationInvoiceBuilder setHotelType(String type){
        this.hotelType = type;
        return this;
    }

    public VacationInvoiceBuilder setFairyWorldDays(int days){
        this.fairyWorldDays = days;
        return this;
    }

    public VacationInvoiceBuilder setAdultFastPass(int pass){
        this.adultFastPass = pass;
        return this;
    }

    public VacationInvoiceBuilder setKidsFastPass(int pass){
        this.kidsFastPass = pass;
        return this;
    }

    public VacationInvoiceBuilder setArcadePass(int pass){
        this.arcadePass = pass;
        return this;
    }

    public VacationInvoiceBuilder addVipTour1(String tour){
        this.vipTour1 = tour;
        return this;
    }

    public VacationInvoiceBuilder addVipTour2(String tour){
        this.vipTour2 = tour;
        return this;
    }

    public VacationInvoiceBuilder addVipTour3(String tour){
        this.vipTour3 = tour;
        return this;
    }

    public VacationInvoiceBuilder addThreeMealsRegularRestaurants(){
        this.threeMealsRegularRestaurants = true;
        return this;
    }

    public VacationInvoiceBuilder addThreeMealsFineDiningRestaurants(){
        this.threeMealsFineDiningRestaurants = true;
        return this;
    }

    public VacationInvoiceBuilder getPhoto(){
        this.photoShoot = true;
        return this;
    }

    public VacationInvoice build(){
        VacationInvoice s = new VacationInvoice(
            this.startingDate, this.endingDate, this.totalAmountOfPeople, this.hotelDays, this.hotelType, this.fairyWorldDays, this.adultFastPass, this.kidsFastPass, this.arcadePass, this.vipTour1, this.vipTour2, this.vipTour3, this.threeMealsRegularRestaurants, this.threeMealsFineDiningRestaurants, this.photoShoot
        );
        this.reset();
        return s;
    }

    public VacationInvoiceBuilder reset(){
        this.startingDate = LocalDateTime.now();
        this.startingDate = LocalDateTime.now().plusDays(1);
        this.totalAmountOfPeople = 1;
        this.hotelDays = 1;
        this.hotelType = "middle";
        this.fairyWorldDays = 1;
        this.adultFastPass = 0;
        this.kidsFastPass = 0;
        this.arcadePass = 0;
        this.vipTour1 = null;
        this.vipTour2 = null;
        this.vipTour3 = null;
        this.threeMealsRegularRestaurants = false;
        this.threeMealsFineDiningRestaurants = false;
        this.photoShoot = false;

        return this;
    }
}

enum VacationOption{
    COUPLE_WEEKEND_RETREAT,
    FAMILY_WEEKEND_RETREAT_VIP,
    FAMILY_WEEK_DELUXE
}

class FairyWorldVacationDirector{
    public static VacationInvoiceBuilder coupleWeekendRetreat(VacationInvoiceBuilder builder){
        builder.setTotalAmountOfPeople(2).setHotelDays(1)
            .setHotelType("high").setFairyWorldDays(2)
            .setAdultFastPass(2).addVipTour1("firework")
            .addThreeMealsRegularRestaurants();
        return builder;
    }

    public static VacationInvoiceBuilder familyWeekendRetreatVip(VacationInvoiceBuilder builder){
        builder.setTotalAmountOfPeople(6).setHotelDays(1)
            .setHotelType("middle").setFairyWorldDays(2)
            .setAdultFastPass(4).setKidsFastPass(2)
            .addThreeMealsRegularRestaurants().getPhoto();
        return builder;
    }

    public static VacationInvoiceBuilder familyWeekDeluxe(VacationInvoiceBuilder builder){
        builder.setTotalAmountOfPeople(6).setHotelDays(6)
            .setHotelType("high").setArcadePass(6)
            .setAdultFastPass(4).setKidsFastPass(2)
            .addThreeMealsFineDiningRestaurants().addVipTour1("show")
            .getPhoto();
        return builder;
    }
}

class FairyWorld{
    public static VacationInvoice planMyVacation(int year, int month, int day, VacationOption option){
        VacationInvoiceBuilder builder = new VacationInvoiceBuilder();

        //日付の処理
        LocalDateTime startingDate = LocalDateTime.of(year, month, day, 0, 0);
        builder.setStartingDate(startingDate);
        

        switch(option){
            case COUPLE_WEEKEND_RETREAT: FairyWorldVacationDirector.coupleWeekendRetreat(builder); break;
            case FAMILY_WEEKEND_RETREAT_VIP: FairyWorldVacationDirector.familyWeekendRetreatVip(builder); break;
            case FAMILY_WEEK_DELUXE: FairyWorldVacationDirector.familyWeekDeluxe(builder); break;
        }

        return builder.build();
    }
}

class Main{
    public static void main(String[] args){
        FairyWorld fairyWorld = new FairyWorld();

        VacationInvoice invoice1 = FairyWorld.planMyVacation(2023, 2, 4, VacationOption.COUPLE_WEEKEND_RETREAT);
        VacationInvoice invoice2 = FairyWorld.planMyVacation(2023, 2, 4, VacationOption.FAMILY_WEEKEND_RETREAT_VIP);
        VacationInvoice invoice3 = FairyWorld.planMyVacation(2023, 2, 4, VacationOption.FAMILY_WEEK_DELUXE);

        String endl = System.lineSeparator();
        System.out.println(invoice1 + endl);
        System.out.println(invoice2 + endl);
        System.out.println(invoice3 + endl);
    }
}