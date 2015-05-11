package kkt

object TestStdio {
    def stdin_test() : Unit = {
      import scala.io.Source

      //val genLine = Source.fromInputStream(System.in, "UTF-8").getLines
      val genLine = Source.fromInputStream(System.in, "cp949").getLines
      for (line <- genLine){
        println(line)
      }
    }

    def read_file_test() : Unit = {
      import scala.io._
      val file = Source.fromFile ("./test.txt", "UTF-8")
      val genLine = file.getLines
      for (line <- genLine){
        println(line)
      }
    }

    def write_file_test() : Unit = {
      import java.io._
      val writer = new PrintWriter(new File("./test2.txt" ), "UTF-8")
      try{
        writer.write("한글 Scala\n")
      }finally{
        writer.close()
      }
    }

}
