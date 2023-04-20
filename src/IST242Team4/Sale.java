package IST242Team4;
public class Sale {
    public static double getTax (double saleTotal, StateCode state) {
        double total = 0.0;
        if (state == StateCode.PA)
        total = .06 * saleTotal;

        else if (state == StateCode.NJ)
        total = .06625 * saleTotal;

        else if (state == StateCode.GA)
        total = .04 * saleTotal;

        else if (state == StateCode.NY)
        total = .04 * saleTotal;

        return total ;
    }
    }