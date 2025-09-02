import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task{
    private String due;
    public static final DateTimeFormatter[] INPUT_FORMATS = new DateTimeFormatter[] {
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
            DateTimeFormatter.ofPattern("yyyy/dd/MM HH:mm"),
    };
    public static final DateTimeFormatter OUTPUT = DateTimeFormatter.ofPattern("MMM dd yyyy, HH:mm");

    public Deadline (String tasks, String string) {
        super(tasks);
        this.due = parseDate(string.trim());
        if(this.due==null) {
            throw new IllegalArgumentException("give in date and time format");
        }
    }

    public String parseDate(String dateString) {
        for (DateTimeFormatter formatter : INPUT_FORMATS) {
            try {
                return LocalDateTime.parse(dateString, formatter).format(OUTPUT);
            } catch (DateTimeException e) {
                // Try next format
//                System.out.println("Date time input error: " + e.getMessage());
            }
        }
        return dateString;
    }



    @Override
    public String saveformat() {
        return  "D / " + (getTaskStatus() ? "1" : "0") + " / " + getTasks() + " / " + due;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (due by "  + due +")";
    }
}
