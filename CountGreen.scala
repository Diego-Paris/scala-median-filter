import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.awt.Color


val img = ImageIO.read(new File("truered.png"))

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

    //set pixel to blue
    img.setRGB(x,y, Color.BLUE.getRGB())

    val c = new Color(img.getRGB(x, y))
    if (isEqual(c, green)) {
      ctrGreen += 1
    }
    ctrTotal += 1;

  }

  println("Green pixel count: " + ctrGreen)
  println("Total pixel count: " + ctrTotal)
}

def isEqual(c1: Color, c2: Color): Boolean = {  
  c1.getRed == c2.getRed && c1.getBlue == c2.getBlue && c1.getGreen == c2.getGreen
}

ImageIO.write(img,"jpg",new File("test.jpg"))

// Declare an array using type and size
// var z = new Array[Int](3)

// Declare a literal array,
var z = Array("Zara", "Nuha", "Ayan")

z.foreach { println }

// Successfully sorts the array
scala.util.Sorting.quickSort(z)

println("After sorting!")

z.foreach {println}


println(img.getRGB(0, 0))

println("Got to end!")