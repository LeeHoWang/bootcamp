public class Coupon {
    private String code;
    private double discount;
    private boolean isApplied;

    public Coupon(String code, double discount) {
        this.code = code;
        this.discount = discount;
        this.isApplied = false;
    }

    public String getCode() {
        return code;
    }

    public double getDiscount() {
        return discount;
    }

    public boolean isDuplicate(Coupon coupon) {
        return this.code.equals(coupon.getCode());
    }

    public double applyDiscount(double originalPrice) {
        if (isApplied) {
            System.out.println("Coupon already used!");
            return originalPrice;
        }
        
        System.out.println("Applying coupon: " + code);
        this.isApplied = true;
        
        double discountedPrice = originalPrice * (1 - discount);
        System.out.println("Original Price: " + originalPrice);
        System.out.println("Discounted Price: " + discountedPrice);
        return discountedPrice;
    }
}