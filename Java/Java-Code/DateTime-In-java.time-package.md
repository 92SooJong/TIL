# DateTime In java.time package

Package java.time in java.base module is the main API for dates, instants,  and durations.

They are based on the ISO calendar system following the proleptic Gregorian rules.

All the classes are immutable and thread-safe.

Each date time instance is composed of fields that are made by the APIs.

In java.time package three DateTime Class.

The first is LocalDateTime. It represents current system date and time, such as 2007-12-03T10:15:30.

The second is ZonedDateTime. It represents date and time with offset, such as 2007-12-03T10:15:30+01:00. OffsetDateTime has LocalDateTime and ZoneOffset 

The third is ZonedDateTime. it represents date and time with time zone, such as 2007-12-03T10:15:30+01:00 Europe/Paris. 

ZonedDateTime has LocalDateTime, ZoneOffset, ZoneId.

# Dates and Times

Instants is a numeric timestamp. The current Instant can be retrieved from a Clock. This is useful for logging.

LocalDate stores a date without a time, such as 2010-12-03. It could be used to store birthday.

LocalTime stores a time without a date, such as 11:30. it could be used to store an opening or closing time.

LocalDateTime stores a date and time, such as 2010-12-03T11:30.

ZonedDateTime stores a date and time with a time-zone. If you want to perform accurate calculation of dates and times taking into account the ZoneId, such as Europe/Paris. Where possible, It is recommended to use simpler class without a time-zone. time-zone tend to add complexity to an application.

# Duration and Period

Duration is simple measure of time along the time-line in nanoseconds.

A Period expresses an amount of time and meaningful to humans, such as years or days.

# Additional value types

OffsetTime stores a time and offset from UTC without a date, such as ‘11:30+01:00’.

The ZoneOffset is of the form ‘+01:00’

skip other value types…

# **Design notes (non normative)**

The API has a lot of method so we need manageable method prefixes.

- `of` - static factory method
- `parse` - static factory method focussed on parsing
- `get` - gets the value of something
- `is` - checks if something is true
- `with` - the immutable equivalent of a setter
- `plus` - adds an amount to an object
- `minus` - subtracts an amount from an object
- `to` - converts this object to another type
- `at` - combines this object with another, such as `date.atTime(time)`

When you need arbitrary calendar systems, you can use ChronoLocalDate. it is vital to read all the associated warnings in the Javadoc of that interface berfore using it.

# Clock

LocalDateTime uses Clock for getting date and time.

Clock is abstract class which has four nested implementation class.

- FixedClock
- OffsetClock
- TickClock
- SystemClock

Basically, LocalDateTime is injected SystemClock instance. Use of a Clock is optional. LocalDateTime has now() factory method so you just put ZonedId in now() method.

# zoneId

A time-zone ID, such as Europe/Paris.

ZoneId is used to identify the rules used to convert between an Instant and a LocalDateTime. There are two distinct types of ID

- Fixed offsets - use the same offset for all local date-times. Most fixed offsets are represented by ZoneOffset.
- Geographical regions - an area where a specific set of rules for finding the offset from UTC/Greenwich apply.

There are three types of ID.

- it’s from ZoneOffset. This consists of ‘Z’ and IDs starting with ‘+’ or ‘-’
- offset-style ID, such as ‘GMT+2’ or ‘UTC+01:00’. The recognised prefixes are ‘UTC’, ‘GMT’ and ‘UT’
- Region-based IDs.

The equals method should be used for comparisons

# Instant

An instantaneous point on the time-line

epoch second is number of seconds from 1970-01-01T00:00:00Z