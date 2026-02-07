package SystemDesign.Low_Level_Design.Design_Patterns.BehavioralDesignPatterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    // Observer interface
    // Any class interested in receiving updates must implement this
    public interface Observer {
        void update(String message);
    }

    // Subject interface
    // Manages subscription and notification
    public interface Subscriber {
        void subscribe(Observer observer);
        void unSubscribe(Observer observer);
        void notifyObservers();
    }

    // Concrete Observer
    // Represents a user who wants notifications
    public static class User implements Observer {
        String name;

        public User(String name) {
            this.name = name;
        }

        // Called by Subject when state changes
        @Override
        public void update(String message) {
            System.out.println(name + " got notification: " + message);
        }
    }

    // Concrete Subject
    // Represents a YouTube channel
    public static class YoutubeChannel implements Subscriber {

        // List of subscribed observers
        private List<Observer> users = new ArrayList<>();

        // State of the subject
        private String latestVideo;

        // Add a new subscriber
        @Override
        public void subscribe(Observer observer) {
            users.add(observer);
        }

        // Remove a subscriber
        @Override
        public void unSubscribe(Observer observer) {
            users.remove(observer);
        }

        // Notify all subscribed observers
        @Override
        public void notifyObservers() {
            for (Observer user : users) {
                user.update("New video uploaded: " + latestVideo);
            }
        }

        // Business logic method
        // When a new video is uploaded, observers are notified
        public void uploadVideo(String title) {
            this.latestVideo = title;
            notifyObservers();
        }
    }

    // Client code
    public static void main(String[] args) {

        YoutubeChannel channel = new YoutubeChannel();

        User u1 = new User("User 1");
        User u2 = new User("User 2");
        User u3 = new User("Mrinal");

        channel.subscribe(u1);
        channel.subscribe(u2);
        channel.subscribe(u3);

        channel.unSubscribe(u2); // User 2 unsubscribes

        channel.uploadVideo("Observer Pattern Explained");
    }
}
