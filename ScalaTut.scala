object ScalaTutorial {
  def main(args: Array[String]) {
    var i = 0

    val randLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    // this is a comment
    // in for loop, 
    //? *to* is inclusive, *until* is not inclusive

    // for (i <- 0 until randLetters.length)
    //   println(randLetters(i))

    // Iterate over a list, print items
    val aList = List(1,2,3,4,5)
    for(i <- aList) {

      
      if( i % 2 == 0)
        println("List items "  + i)


    }

    println("Now printing the even list!")

    // Very interesting structure
    // TODO : Read more, if needed 
    var evenList = for { i <- 1 to 20 
      if (i % 2) == 0
      } yield i

    // i stands for each element in evenList
    for (i <- evenList) {
      println(i)
    }

    //
    for(i <- 1 to 5; j <- 6 to 10) {
      println("i : " + i)
      println("j : " + j)
    }


  }
}