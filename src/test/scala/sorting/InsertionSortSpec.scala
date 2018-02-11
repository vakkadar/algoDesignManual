package sorting

import org.scalatest.{FlatSpec, Matchers}
import InsertionSort._
class InsertionSortSpec  extends FlatSpec with Matchers {
  "Array Object Array(3,1,2) when sorted ascending order  " should " Array(1,2,3)" in {
    implicit val arr = Array(3,1,2)
    implicit val sortFunc : (Int, Int) => Boolean = _ < _
    sort()
    arr should equal (Array(1,2,3))
  }
  "Array Object Array(3,1,2) when sorted descending order  " should " Array(3,2,1)" in {
    implicit val arr = Array(3,1,2)

    implicit val sortFunc : (Int, Int) => Boolean = _ >  _
    sort()
    arr should equal (Array(3,2,1))
  }
  it should "throw IllegalArgumentException" in {
    a [IllegalArgumentException] should be thrownBy {
      implicit val emptyArray = Array[Int]()
      implicit val sortFunc : (Int, Int) => Boolean = _ >  _
      sort()
    }
  }
}
