package student.enterprise.project.dto.enums;

public enum RepeatFrequency {
    EVERY_DAY(1),
    EVERY_WEEK(7),
    EVERY_TWO_WEEKS(14);

    private int days;

    RepeatFrequency(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}
