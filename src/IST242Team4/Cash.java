package IST242Team4;
public class Cash {
    //Instance variables
    private int dollars;
    private int cents;
    
    //Constructor
    public Cash(int dollars, int cents)
    {
        
        this.dollars = dollars;
        this.cents = cents;
    }
    //Accessor methods
    public int getDollars() {
        return dollars;
    }

    public void setDollars(int dollars) {
        this.dollars = dollars;
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }

}


