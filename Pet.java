public class Pet {
    private String id;
    private String name;
    private String species;
    private String ownerName;
    private int age;
    private int stayDays;
    private double ratePerDay;
    
    public Pet(String id, String name, String species, String ownerName, int age, int stayDays, double ratePerDay) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.ownerName = ownerName;
        this.age = age;
        this.stayDays = stayDays;
        this.ratePerDay = ratePerDay;
    }

    // Getter dan Setter (ADT / Encapsulation)
    public String getId() { return id; }
    public String getName() { return name; }
    public String getSpecies() { return species; }
    public String getOwnerName() { return ownerName; }
    public int getAge() { return age; }
    public int getStayDays() { return stayDays; }
    public double getRatePerDay() { return ratePerDay; }

    public double calculateCost() {
        return stayDays * ratePerDay;
    }

    public void displayInfo() {
        System.out.println("ID           : " + id);
        System.out.println("Nama Hewan   : " + name);
        System.out.println("Jenis Hewan  : " + species);
        System.out.println("Pemilik      : " + ownerName);
        System.out.println("Umur         : " + age + " tahun");
        System.out.println("Lama Titip   : " + stayDays + " hari");
        System.out.println("Tarif/Hari   : Rp " + (int)ratePerDay);

    }
}