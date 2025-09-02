import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Events extends Task {

    private String start;
    private String end;
    public static final DateTimeFormatter[] INPUT_FORMATS = new DateTimeFormatter[] {
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
            DateTimeFormatter.ofPattern("yyyy/dd/MM HH:mm"),
    };
    public static final DateTimeFormatter OUTPUT = DateTimeFormatter.ofPattern("MMM dd yyyy, HH:mm");


    public Events(String desc, String start, String end) {
        super(desc);
        this.start = start;
        this.end = end;
        this.start = parseDate(start.trim());
        if(this.start==null) {
            throw new IllegalArgumentException("give in date and time format");
        }
        this.end = parseDate(end.trim());
        if(this.end==null) {
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
        return "E / " + (getTaskStatus() ? "1" : "0") + " / " + getTasks()
                + " / " + start + " / " + end;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (Starts on : " + start + ", ends by : " + end + ")";
    }

}