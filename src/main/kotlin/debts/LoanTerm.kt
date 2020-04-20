package debts

import org.joda.time.*


data class LoanTerm(val start: LocalDate, val end: LocalDate) {
    val days by lazy{ Days.daysBetween(start,end).days }
    val months by lazy{ Months.monthsBetween(start,end).months}
    val years by lazy{ Years.yearsBetween(start,end).years }

}

