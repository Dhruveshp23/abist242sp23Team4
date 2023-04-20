package IST242Team4;
public class CreditCard {
    //Instance variables
    private String bank;
    private String number;
    private String name;
    private String expireDate;
    private int cvvCode;


//Constructor
    public CreditCard(String bank, String number, String name, String expireDate, int cvvCode) {
        this.bank = bank;
        this.number = number;
        this.name = name;
        this.expireDate = expireDate;
        this.cvvCode = cvvCode;

        }
    //Accessor methods

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getexpireDate(){
        return expireDate;
    }

    public int getCvvCode(){
        return cvvCode;
    }



}

