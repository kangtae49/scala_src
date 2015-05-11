package kkt

object Test {
  def run(i: Int) = {
    println("run:%d".format(i))
    i
  }

  def test(){
    val s1 = Stream.range(0,10)
    val s2 = for (i <- s1) yield {
      run(i)
    }

    for (i<- 0 to 9){
      println("hi:%d".format(s2(i)))
    }


    /*
    s1.foreach((x) => {
       println(x)
    })
    */
    /*
    val s2 = for (i <- s1) yield {
        println(i)
        i
    }
    */
  }

  def test7(){
    val r1  = 1 to 100
    println(r1)
    val r2 = for(i <- r1) yield {
      println("r2:%d".format(i))
      i
    }
    println(r2)
    val r3 = for(j <- r2) yield {
      println("r3:%d".format(j))
      j
    }

    println(r3)

  }

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }

  def test6(){


    val capitals = Map("France" -> "Paris", "Korea" -> "Seoul")
    println (show(capitals get "France"))

  }

  def test5(){
    val r = 0 to 10
    println(r)
    var r1 = for(i <- r) yield {
      i
    }

    val sum = r1.fold (0) {
      (z, i) =>
        z + i
    }
    println(sum)

  }

  def test4(){
    // 91 s
    val l1 = BigInt("0") to BigInt("1000")*BigInt("1000")*BigInt("1000")
    val ret = l1.fold(BigInt("0")){
        (z, i) =>
          z + i
    }


    /*
    val l1 = 0 to BigInt("1000")

    //val l1 = List(3,2,1,0,1,2,3)
    val ret = l1.fold(0){
        (z, i) =>
          z + i
    }

    */
    println(ret)
  }

  def test2(){
    println("test2")
    val t = test1 _
    t()
  }

  def test1(){
    println("start")

    val l1 = List(3,2,1,0,1,2,3)
    val i1 = 12345.0f

    println(l1)
    println(i1)

    var d1 = i1
    for(l <- l1){
      d1 /= l
      println("d1: %f" format d1)
    }

    println(d1)

    println("end")
  }

  def main(args: Array[String]){
    //test
    import kkt.TestStdio._
    stdin_test
    //read_file_test
    //write_file_test

  }
}
