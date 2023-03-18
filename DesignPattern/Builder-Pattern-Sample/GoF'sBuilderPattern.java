//////////////////////////////////// PhoneBuilder.java
public interface PhoneBuilder {


    void buildName();
    void buildRealeseDate();
    void buildCompanyName();
    void buildIsAndroid();
    void buildIsKoreaCompany();
    Phone getPhone();

}

//////////////////////////////////// Iphone13Builder.java
public class Iphone13Builder implements PhoneBuilder{

    private Phone phone;

    public Iphone13Builder() {
        this.phone = new Phone();
    }

    @Override
    public void buildName() {
        phone.setName("Iphone13");
    }

    @Override
    public void buildRealeseDate() {
        phone.setCompanyName("202110");
    }

    @Override
    public void buildCompanyName() {
        phone.setCompanyName("apple");
    }

    @Override
    public void buildIsAndroid() {
        phone.setIsAndroid(false);
    }

    @Override
    public void buildIsKoreaCompany() {
        phone.setIsKoreaCompany(false);
    }

    @Override
    public Phone getPhone() {
        return this.phone;
    }
}

//////////////////////////////////// Phone.java
public class Phone{

    private String name;
    private String realeseDate;
    private String companyName;
    private boolean isAndroid;
    private boolean isKoreaCompany;

    // setter와 getter를 만든다
    public void setName(String name) {
        this.name = name;
    }

    public void setRealeseDate(String realeseDate) {
        this.realeseDate = realeseDate;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public void setIsAndroid(boolean isAndroid) {
        this.isAndroid = isAndroid;
    }


    public void setIsKoreaCompany(boolean isKoreaCompany) {
        this.isKoreaCompany = isKoreaCompany;
    }


    public String getName() {
        return name;
    }

    public String getRealeseDate() {
        return realeseDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public boolean isAndroid() {
        return isAndroid;
    }

    public boolean isKoreaCompany() {
        return isKoreaCompany;
    }
}

//////////////////////////////////// Director.java

public class Director {

    private PhoneBuilder phoneBuilder;

    public Director(PhoneBuilder phoneBuilder) {
        this.phoneBuilder = phoneBuilder;
    }

    public Phone getPhone(){
        return this.phoneBuilder.getPhone();
    }

    public void makePhone(){
        this.phoneBuilder.buildName();
        this.phoneBuilder.buildCompanyName();
        this.phoneBuilder.buildRealeseDate();
        this.phoneBuilder.buildIsAndroid();
        this.phoneBuilder.buildIsKoreaCompany();

    }

}


//////////////////////////////////// Main.java

public class Main {

    public static void main(String[] args){

        PhoneBuilder iphoneBuilder = new Iphone13Builder(); // 아이폰13 빌더
        Director director = new Director(iphoneBuilder); // 지시자에게 주입
        director.makePhone(); // 지시
        Phone madePhone = director.getPhone(); // 완성품

        System.out.println("madePhone.getName() = " + madePhone.getName());
        System.out.println("madePhone.getCompanyName() = " + madePhone.getCompanyName());
    }
}
