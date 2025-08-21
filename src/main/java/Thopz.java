public class Thopz {

    public String bot = "thopz";
    public static String greetings = "Wassup wassup! Life ok? Vibes ok? Family ok? " +
            "I am thopz your virtual chatbot. " +
            "How may I help you?" ;
    public static String goodbye = "Chaoz. See you ! ";

    // Greetings and goodbye with a 3 sec delay
    public static void main(String[] args) {

        System.out.println("" + greetings);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("" + goodbye);

    }
}
