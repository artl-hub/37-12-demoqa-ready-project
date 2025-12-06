package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    private final SelenideElement
            monthDropdown = $(".react-datepicker__month-select"),
            yearDropdown = $(".react-datepicker__year-select");

    private SelenideElement getDayElement(String day) {
        return $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)");
    }

    public void setDate(String day, String month, String year) {
        monthDropdown.selectOption(month);
        yearDropdown.selectOption(year);
        getDayElement(day).click();
    }
}
