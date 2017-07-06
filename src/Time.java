public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) throws IllegalArgumentException {
        if( hour >= 24 || hour < 0 || minute < 0 || minute >= 60) throw new IllegalArgumentException();

        this.hour = hour;
        this.minute = minute;
    }
    public int getHour() {
        return this.hour;
    }
    public int getMinute() {
        return this.minute;
    }
}
