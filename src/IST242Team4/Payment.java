package IST242Team4;
abstract class Payment {
    /**
     * payment charge will store payment charges of product
     */
    private double paymentCharge;

    /**
     * this a counstructor for paycharge
     * @param payCharge
     */
    public Payment(double payCharge){
        paymentCharge = payCharge;
    }

    /**
     * This is getmothed for getingpayment
     * @return
     */
    public double getPaymentCharge() {
        return paymentCharge;
    }



    /**
     * this method will handle payment and turning into double
     * @param pay
     * @return
     */
    public abstract double handlePayment(double pay);

}
