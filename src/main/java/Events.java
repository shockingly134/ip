public class Events extends Task {

    private String start;
    private String end;

    public Events(String desc, String start, String end) {
        super(desc);
        this.start = start;
        this.end = end;

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