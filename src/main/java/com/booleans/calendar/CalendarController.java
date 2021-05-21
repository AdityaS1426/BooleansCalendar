package com.booleans.calendar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CalendarController {
    HashMap<String, ArrayList<Date>> calendar = new HashMap<>();

    // This map is used to store "JAN" -> 6 rows with 7 columns - empty spaces for
    // the days not of this month.
    HashMap<String, Date[][]> dateValues = new HashMap<>();

    HashMap<String, String> holidayDates = new HashMap<>();

    @GetMapping("/CalendarGenerator")
    public ModelAndView doGet() {
        int year = LocalDate.now().getYear();
        return doPost(String.valueOf(year));
    }

    @PostMapping("/Calendar")
    public ModelAndView doPost(@RequestParam String year) {
        ModelAndView mv = null;

        int yr = Integer.parseInt(year);

        buildCalendar(yr); // Calendar hash map is built.

        // https://www.redcort.com/us-federal-bank-holidays/
        setAllHolidays(yr); // isHoliday field of date set to true if its a holiday

        formatDates();

        mv = new ModelAndView("calendar");

        mv.addAllObjects(dateValues);
        mv.addAllObjects(holidayDates);
        mv.addObject("year", year);

        return mv;
    }

    private void formatDates() {
        for (String mon : Date.MONTH) {
            if (mon.equals("EMPTY"))
                continue;

            ArrayList<Date> month = calendar.get(mon);
            dateValues.put(mon, dateFormatter(month));
        }
    }

    private Date[][] dateFormatter(ArrayList<Date> month) {
        int dayPointer = 0;
        Date[][] days = new Date[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (dayPointer < month.size()) {
                    if (month.get(dayPointer).getDow() == j) {
                        days[i][j] = month.get(dayPointer);
                        dayPointer++;
                        continue;
                    }
                }
                Date nullDate = null;
                days[i][j] = nullDate;
            }
        }
        return days;
    }

    private void setAllHolidays(int year) {
        // New Years Day
        calendar.get("JAN").get(0).setHoliday();
        holidayDates.put("NewYearsDay", "New Year's Day : " + calendar.get("JAN").get(0));

        // Martin Luther King Jr. Day -- Third Monday in January
        holidayDates.put("MLKDay", "MLK Jr. Day : " + setAsHoliday(calendar.get("JAN"), "MON", 3));

        // George Washington Day -- Third Monday in February
        holidayDates.put("PresidentsDay", "President's Day : " + setAsHoliday(calendar.get("FEB"), "MON", 3));

        // Memorial Day -- Last Monday in May
        holidayDates.put("MemorialDay", "Memorial Day : " + setLastDayOccurrance(calendar.get("MAY"), "MON"));

        // Independence Day -- 4th of July
        calendar.get("JUL").get(3).setHoliday();
        holidayDates.put("IndependenceDay", "Independence Day : " + calendar.get("JUL").get(3));

        // Labor Day -- First Monday in September
        holidayDates.put("LaborDay", "Labor Day : " + setAsHoliday(calendar.get("SEP"), "MON", 1));

        // Columbus Day -- Second Monday in October
        holidayDates.put("ColumbusDay", "Columbus Day : " + setAsHoliday(calendar.get("OCT"), "MON", 2));

        // Veterans Day -- 11th of Nov. If it's on a Sunday, it's moved to Nov. 12.
        if (calendar.get("NOV").get(10).getDow() == 0) {
            calendar.get("NOV").get(11).setHoliday();
            holidayDates.put("VeteransDay", "Veterans Day : " + calendar.get("NOV").get(11));
        } else {
            calendar.get("NOV").get(10).setHoliday();
            holidayDates.put("VeteransDay", "Veterans Day : " + calendar.get("NOV").get(10));

        }

        // Thanksgiving Day
        holidayDates.put("Thanksgiving", "Thanksgiving : " + setAsHoliday(calendar.get("NOV"), "THU", 4));

        // Christmas Day
        calendar.get("DEC").get(24).setHoliday();
        holidayDates.put("Christmas", "Christmas : " + calendar.get("DEC").get(24));
    }

    private Date[] setEaster(int year) {
        ArrayList<Date> apr = calendar.get("APR");
        ArrayList<Date> mar = calendar.get("MAR");
        Date[] dates = new Date[2];

        // Constraints for the Full Moon Chart
        if (2014 <= year && year <= 2031) {
            Date fullMoon = null;

            int rem = (year + 1) % 19;

            switch (rem) {
                case 1:
                    fullMoon = apr.get(13);
                    break;
                case 2:
                    fullMoon = apr.get(2);
                    break;
                case 3:
                    fullMoon = mar.get(22);
                    break;
                case 4:
                    fullMoon = apr.get(10);
                    break;
                case 5:
                    fullMoon = mar.get(30);
                    break;
                case 6:
                    fullMoon = apr.get(17);
                    break;
                case 7:
                    fullMoon = apr.get(7);
                    break;
                case 8:
                    fullMoon = mar.get(27);
                    break;
                case 9:
                    fullMoon = apr.get(15);
                    break;
                case 10:
                    fullMoon = apr.get(4);
                    break;
                case 11:
                    fullMoon = mar.get(24);
                    break;
                case 12:
                    fullMoon = apr.get(12);
                    break;
                case 13:
                    fullMoon = apr.get(1);
                    break;
                case 14:
                    fullMoon = mar.get(21);
                    break;
                case 15:
                    fullMoon = apr.get(9);
                    break;
                case 16:
                    fullMoon = mar.get(29);
                    break;
                case 17:
                    fullMoon = apr.get(16);
                    break;
                case 18:
                    fullMoon = apr.get(6);
                    break;
            }

            int temp = fullMoon.getDow();
            int daysToFriday = 0;
            int daysToSunday = 0;
            System.out.println("fullMoon.DOW: " + temp + ", fullMoon.day: " + fullMoon.getDay());

            if (Date.DAYOFWEEK[fullMoon.getDow() + 1].equals("FRI"))
                daysToFriday = -1;
            else {
                while (!Date.DAYOFWEEK[temp].equals("FRI")) {
                    System.out.println("temp: " + temp + ", DOW: " + Date.DAYOFWEEK[temp]);
                    temp = (temp == 0) ? 6 : (temp - 1) % 7;
                    daysToFriday++;
                }
            }

            temp = fullMoon.getDow();
            while (!Date.DAYOFWEEK[temp].equals("SUN")) {
                temp = (temp + 1) % 7;
                daysToSunday++;
            }

            // Sets Easter Sunday as a holiday.
            if (fullMoon.getDay() + daysToSunday > 31) {
                // Easter Sunday falls in April.
                // So, set the first Sunday in April as a holiday.
                dates[0] = setAsHoliday(apr, "SUN", 1);
            } else
                {
                if (fullMoon.getMonth() == 3) {
                    mar.get((fullMoon.getDay() + daysToSunday) - 1).setHoliday();
                    dates[0] = mar.get((fullMoon.getDay() + daysToSunday) - 1);
                } else {
                    apr.get((fullMoon.getDay() + daysToSunday) - 1).setHoliday();
                    dates[0] = apr.get((fullMoon.getDay() + daysToSunday) - 1);
                }
            }

            // Set Good Friday as a holiday.
            if (fullMoon.getDay() - daysToFriday < 1) {
                // Good friday falls in March.
                // So, set the last Friday in March as a holiday.
                dates[1] = setLastDayOccurrance(mar, "FRI");
            } else {
                if (fullMoon.getMonth() == 3) {
                    mar.get((fullMoon.getDay() - daysToFriday) - 1).setHoliday();
                    dates[1] = mar.get((fullMoon.getDay() - daysToFriday) - 1);
                } else {
                    apr.get((fullMoon.getDay() - daysToFriday) - 1).setHoliday();
                    dates[1] = apr.get((fullMoon.getDay() - daysToFriday) - 1);
                }
            }
        }

        return dates;
    }

    private Date setAsHoliday(ArrayList<Date> month, String dayOfWeek, int nthOccurrance) {
        Date holiday = null;
        int occurrances = 0;
        for (int i = 0; i < month.size(); i++) {
            int dow = month.get(i).getDow();
            if (Date.DAYOFWEEK[dow].equals(dayOfWeek)) {
                occurrances++;
            }
            if (occurrances == nthOccurrance) {
                month.get(i).setHoliday();
                holiday = month.get(i);
                break;
            }
        }
        return holiday;
    }

    private Date setLastDayOccurrance(ArrayList<Date> month, String dayOfWeek) {
        // This loop will run backwards from the end of a month.
        // This deals with months which may have 4 or 5 occurrences of a day,
        // either of which may be the last occurrence.

        Date holiday = null;

        for (int i = month.size() - 1; i > 20; i--) {
            int dow = month.get(i).getDow();
            if (Date.DAYOFWEEK[dow].equals(dayOfWeek)) {
                month.get(i).setHoliday();
                holiday = month.get(i);
                break;
            }
        }
        return holiday;
    }

    private void buildCalendar(int year) {
        Date jan1st = new Date(1, 1, year);
        jan1st.setDow(Date.calculateDowForJan1st(year));

        Date feb1st = new Date(2, 1, year, jan1st, 31);
        int febDays = Date.isLeapYear(year) ? 29 : 28; // deal with leap day
        Date mar1st = new Date(3, 1, year, feb1st, febDays);
        Date apr1st = new Date(4, 1, year, mar1st, 31);
        Date may1st = new Date(5, 1, year, apr1st, 30);
        Date jun1st = new Date(6, 1, year, may1st, 31);
        Date jul1st = new Date(7, 1, year, jun1st, 30);
        Date aug1st = new Date(8, 1, year, jul1st, 31);
        Date sep1st = new Date(9, 1, year, aug1st, 31);
        Date oct1st = new Date(10, 1, year, sep1st, 30);
        Date nov1st = new Date(11, 1, year, oct1st, 31);
        Date dec1st = new Date(12, 1, year, nov1st, 30);

        buildMonth(jan1st, 31, 1);
        buildMonth(feb1st, febDays, 2);
        buildMonth(mar1st, 31, 3);
        buildMonth(apr1st, 30, 4);
        buildMonth(may1st, 31, 5);
        buildMonth(jun1st, 30, 6);
        buildMonth(jul1st, 31, 7);
        buildMonth(aug1st, 31, 8);
        buildMonth(sep1st, 30, 9);
        buildMonth(oct1st, 31, 10);
        buildMonth(nov1st, 30, 11);
        buildMonth(dec1st, 31, 12);
    }

    private void buildMonth(Date day1st, int monthDays, int monthNum) {
        ArrayList<Date> month = new ArrayList<>();
        month.add(day1st);

        for (int i = 2; i <= monthDays; i++) {
            Date date = new Date(monthNum, i, day1st.getYear());
            int dow = (day1st.getDow() + (i - 1)) % 7;
            date.setDow(dow);
            month.add(date);
        }
        calendar.put(Date.MONTH[monthNum], month);
    }

    public void printArray(ArrayList<Date> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("array[" + i + "] : " + list.get(i));
        }
    }
}
