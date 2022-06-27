enum Color:
  case Red, Green, Blue

enum DayofWeek:
  case Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday

import DayofWeek.*

def isWeekend(day: DayofWeek) = day match
  case Saturday | Sunday => true
  case _ => false
