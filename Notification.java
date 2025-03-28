// Step 1: Define the Notification interface
interface Notification {
    void send(String message);
}

// Step 1: Implement concrete classes
class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SMSNotification implements Notification {
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

class PushNotification implements Notification {
    public void send(String message) {
        System.out.println("Push Notification sent: " + message);
    }
}

// Step 2: Define the NotificationChannelType enum
enum NotificationChannelType {
    EMAIL, SMS, PUSH;
}

// Step 3: Create the NotificationFactory class
class NotificationFactory {
    public static Notification createNotification(NotificationChannelType channelType) {
        switch (channelType) {
            case EMAIL:
                return new EmailNotification();
            case SMS:
                return new SMSNotification();
            case PUSH:
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type");
        }
    }
}

// Step 4: Demonstration and Testing
public class FactoryPatternDemo {
    public static void main(String[] args) {
        // Running demonstration
        Notification notification = NotificationFactory.createNotification(NotificationChannelType.EMAIL);
        notification.send("Hello!");

        // Running tests
        testNotification(NotificationChannelType.EMAIL, "Test Email Message");
        testNotification(NotificationChannelType.SMS, "Test SMS Message");
        testNotification(NotificationChannelType.PUSH, "Test Push Notification Message");
    }

    private static void testNotification(NotificationChannelType channelType, String message) {
        Notification notification = NotificationFactory.createNotification(channelType);
        notification.send(message);
    }
}
