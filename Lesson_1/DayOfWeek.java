package Lesson_1;

public enum DayOfWeek {
    MONDAY(8,17), TUESDAY(8, 17),
    WEDNESDAY(8, 17), THURSDAY(8, 16),
    FRIDAY (9, 15), SATURDAY, SUNDAY;

    int beginDayHour;
    int endDayHour;

    DayOfWeek(int beginDayHour, int endDayHour) {
        this.beginDayHour = beginDayHour;
        this.endDayHour = endDayHour;
    }

    DayOfWeek() {
        this(0, 0);
    }

    static int getTodayWorkingHours(DayOfWeek day) {
        int result = day.endDayHour - day.beginDayHour;
        return (result >= 0) ? result : 0;
    }

    static String getWorkingHours(DayOfWeek day) {
        if (getTodayWorkingHours(day) == 0) {
            return "Сегодня выходной";
        }

        int result = 0;
        for (int i = day.ordinal(); i < DayOfWeek.values().length; i++) {
            result += DayOfWeek.getTodayWorkingHours(DayOfWeek.values()[i]);
        }

        return "До конца недели осталось проработать " + result + " часов";
    }
}
