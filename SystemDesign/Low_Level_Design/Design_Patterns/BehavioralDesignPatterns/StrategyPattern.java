package SystemDesign.Low_Level_Design.Design_Patterns.BehavioralDesignPatterns;

public class StrategyPattern {
    interface PaymentStrategy{
        boolean pay(double amount);
    }

    class CreditCardPayment implements PaymentStrategy{
        private String cardNumber;
        CreditCardPayment(String cardNumber){
            this.cardNumber = cardNumber;
        }

        @Override
        public boolean pay(double amount) {
            System.out.println("Paid " + amount + " with credit card");
            return true;
        }
    }

    class UpiPayemnt implements PaymentStrategy{
        private String upiId;
        UpiPayemnt(String upiId){
            this.upiId = upiId;
        }
        @Override
        public boolean pay(double amount) {
            System.out.println("Paid " + amount + " using UPI");
            return  true;
        }
    }

    class ShoppingCart {
        private PaymentStrategy payment;

        public void setPayment(PaymentStrategy payment) {
            this.payment = payment;
        }

        public void checkout(double amount){
            payment.pay(amount);
        }
    }
    // Usage
    ShoppingCart cart = new ShoppingCart();
    cart.setPayment(new void CreditCardPayment("1234-1234"));
    cart.checkout(100.00);;

}
