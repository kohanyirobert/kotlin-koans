package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate) =
            compareValuesBy(this, other, { it.year }, { it.month }, { it.dayOfMonth })

    operator fun plus(interval: TimeInterval) = addTimeIntervals(interval, 1)
    operator fun plus(repeated: RepeatedTimeInteral) = addTimeIntervals(repeated.interval, repeated.times)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR;

    operator fun times(times: Int) = RepeatedTimeInteral(this, times)
}

data class RepeatedTimeInteral(val interval: TimeInterval, val times: Int)

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>

operator fun ClosedRange<MyDate>.iterator() = object : Iterator<MyDate> {
    var next = start

    override fun hasNext() = next <= endInclusive

    override fun next(): MyDate {
        val curr = next
        next = next.nextDay()
        return curr
    }
}
