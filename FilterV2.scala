import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.awt.Color


val img = ImageIO.read(new File("zozo.png"))
val img2 = ImageIO.read(new File("zozo.png"))

val w = img.getWidth
val h = img.getHeight

val green = Color.GREEN

var ctrGreen = 0
var ctrTotal = 0

//? neighborhood

// topL  topM   topR
// midL  (x,y)  midR
// lowL  lowM   lowR

//  ( x-1, y+1 ) ( x, y+1 ) ( x+1, y+1 )
//  ( x-1, y   ) ( x, y   ) ( x+1, y   )
//  ( x-1, y-1 ) ( x, y-1 ) ( x+1, y-1 )


for (x <- 0 until w) {
  for (y <- 0 until h) {

    val pixel = img.getRGB(x,y)

    // Todo, add to check within range instead of try/catch
    try {
      // Left side
      val topL = img.getRGB(x-1,y+1)
      val midL = img.getRGB(x-1,y)
      val lowL = img.getRGB(x-1,y-1)

      // Middle side, excluding middle pixel
      val topM = img.getRGB(x,y+1)
      val lowM = img.getRGB(x,y-1)

      // Right side
      val topR = img.getRGB(x+1,y+1)
      val midR = img.getRGB(x+1,y)
      val lowR = img.getRGB(x+1,y-1)

      // Place values in an array
      var myArr = Array(topL, midL, lowL, topM, pixel, lowM, topR, midR, lowR)

      // Get median
      val median = getMedian(myArr)

      // Set pixel to median
      img2.setRGB(x,y, median)
      println("Changed pixel")
    } catch {
      case e:Exception=>
        println("Skipped pixel!!")
    }

  //   //set pixel to blue using the RGB val
  //   img.setRGB(x,y, Color.BLUE.getRGB())

  //   // get value and turn into Color obj
  //   val c = new Color(img.getRGB(x, y))
    
  //   if (isEqual(c, green)) {
  //     ctrGreen += 1
  //   }
  //   ctrTotal += 1;

  // }

  // println("Green pixel count: " + ctrGreen)
  // println("Total pixel count: " + ctrTotal)  
  }
}

ImageIO.write(img2,"png",new File("outputV22.png"))

def isEqual(c1: Color, c2: Color): Boolean = {  
  c1.getRed == c2.getRed && c1.getBlue == c2.getBlue && c1.getGreen == c2.getGreen
}

def getMedian(arr: Array[Int]): Int = {  
  
  // We only expect to view a 3x3 matrix resulting an array of length 9
  if(arr.length != 9) {
    throw new ArithmeticException("Array must be of length 9")
  }

  // Clone given array
  var cloneArr = arr.clone

  // Sort clone array
  scala.util.Sorting.quickSort(cloneArr)

  // Return median value of clone array
  cloneArr((arr.length/2))  
}



// // Declare an array using type and size
// // var z = new Array[Int](3)

// // Declare a literal array,
// var z = Array("Zara", "Nuha", "Ayan")

// z.foreach { println }

// // Successfully sorts the array
// scala.util.Sorting.quickSort(z)

// println("After sorting!")

// z.foreach {println}


// println(img.getRGB(0, 0))

// var myArr = Array(48, 138, 2, 73, 22, 91, 88, 30, 1)

// println(getMedian(myArr))

//! Note: 
// instead of affecting the original img
// use original img to build the new

println("Got to end!")