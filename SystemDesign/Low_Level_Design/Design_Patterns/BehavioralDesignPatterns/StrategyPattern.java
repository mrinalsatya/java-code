package SystemDesign.Low_Level_Design.Design_Patterns.BehavioralDesignPatterns;

public class StrategyPattern {

    // 1️⃣ Strategy Interface
    interface PaymentStrategy {
        boolean pay(double amount);
    }

    // 2️⃣ Concrete Strategy: Credit Card
    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;

        CreditCardPayment(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        @Override
        public boolean pay(double amount) {
            System.out.println("Paid ₹" + amount + " using Credit Card: " + cardNumber);
            return true;
        }
    }

    // 3️⃣ Concrete Strategy: UPI
    static class UpiPayment implements PaymentStrategy {
        private String upiId;

        UpiPayment(String upiId) {
            this.upiId = upiId;
        }

        @Override
        public boolean pay(double amount) {
            System.out.println("Paid ₹" + amount + " using UPI: " + upiId);
            return true;
        }
    }

    // 4️⃣ Context Class
    static class ShoppingCart {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void checkout(double amount) {
            if (paymentStrategy == null) {
                throw new IllegalStateException("Payment strategy not set");
            }
            paymentStrategy.pay(amount);
        }
    }

    // 5️⃣ Client Code
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Pay using Credit Card
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678"));
        cart.checkout(1000);

        // Switch strategy at runtime
        cart.setPaymentStrategy(new UpiPayment("user@upi"));
        cart.checkout(500);
    }

}
