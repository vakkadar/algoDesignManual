package sorting

trait Sortable{

  def sort[A]()(implicit
     elems:Array[A],
     f:(A,A) => Boolean
  )

  def swap[A](
     sourceIndex:Int,
     targetIndex:Int
   )(implicit elems:Array[A]):Unit ={
    val temp = elems(sourceIndex)
    elems(sourceIndex) = elems(targetIndex)
    elems(targetIndex) = temp
  }
}

object InsertionSort extends Sortable{
  def sort[A]()(implicit
     elems: Array[A],
     f: (A, A) => Boolean
  ): Unit = {
    val size = elems.size
    if(size > 0){
      for (i <- 1 until size){
        var j = i
        while ( j >0 && f(elems(j), elems(j-1))){
          val sourceIndex = j
          val targetIndex = j-1
          swap(sourceIndex, targetIndex)
          j -= 1
        }
      }
    }else{
      throw new IllegalArgumentException(s"Array size should be greater than Zero for sorting")
    }

  }
}
