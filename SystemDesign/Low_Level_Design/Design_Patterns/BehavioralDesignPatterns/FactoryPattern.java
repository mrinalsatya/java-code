package SystemDesign.Low_Level_Design.Design_Patterns.BehavioralDesignPatterns;

public class FactoryPattern {

    // Product interface
    // All notification types must implement this
    interface Notification {
        void send(String message);
    }

    // Concrete Product - Email
    public static class EmailNotification implements Notification {
        @Override
        public void send(String message) {
            System.out.println("Email notification received: " + message);
        }
    }

    // Concrete Product - SMS
    public static class SMSNotification implements Notification {
        @Override
        public void send(String message) {
            System.out.println("SMS notification received: " + message);
        }
    }

    // Factory class
    // Responsible for creating Notification objects
    public static class NotificationFactory {

        // Factory method
        public static Notification create(String type) {

            if (type.equalsIgnoreCase("sms")) {
                return new SMSNotification();
            }
            else if (type.equalsIgnoreCase("email")) {
                return new EmailNotification();
            }
            else {
                throw new IllegalArgumentException("Invalid Notification type");
            }
        }
    }

    // Client code
    public static void main(String[] args) {

        Notification email = NotificationFactory.create("email");
        email.send("Hello via Email");

        Notification sms = NotificationFactory.create("sms");
        sms.send("Hello via SMS");
    }
