package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate) =
            compareValuesBy(this, other, { it.year }, { it.month }, { it.dayOfMonth })
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>

operator fun ClosedRange<MyDate>.iterator() = object : Iterator<MyDate> {
    var next = start;

    override fun hasNext() = next <= endInclusive

    override fun next(): MyDate {
        var curr = next
        next = next.nextDay()
        return curr
    }
}
