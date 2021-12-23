//////////////////////// Phone.java
public class Phone{

    private String name;
    private String realeseDate;
    private String companyName;
    private boolean isAndroid;
    private boolean isKoreaCompany;

    public static class Builder{

        private String name;
        private String realeseDate;
        private String companyName;
        private boolean isAndroid;
        private boolean isKoreaCompany;

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder realeseDate(String realeseDate){
            this.realeseDate = realeseDate;
            return this;
        }
        public Builder companyName(String companyName){
            this.companyName = companyName;
            return this;
        }
        public Builder isAndroid(boolean isAndroid){
            this.isAndroid = isAndroid;
            return this;
        }
        public Builder isKoreaCompany(boolean isKoreaCompany){
            this.isKoreaCompany = isKoreaCompany;
            return this;
        }

        public Phone buildInstance(){
            return new Phone(this);
        }

    }

    private Phone(Builder builder){
        this.name = builder.name;
        this.realeseDate = builder.realeseDate;
        this.companyName = builder.companyName;
        this.isAndroid = builder.isAndroid;
        this.isKoreaCompany = builder.isKoreaCompany;
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

//////////////////////// Main.java
public class Main {

    public static void main(String[] args){

        Phone iphone = new Phone.Builder()
                .companyName("apple")
                .name("Iphone13")
                .isKoreaCompany(false)
                .isAndroid(false)
                .realeseDate("2021")
                .buildInstance();

        System.out.println("iphone.getName() = " + iphone.getName());
        System.out.println("iphone.getCompanyName() = " + iphone.getCompanyName());

    }
}
