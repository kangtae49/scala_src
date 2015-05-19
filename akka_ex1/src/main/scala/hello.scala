import akka.actor.{Props, Actor, ActorSystem}

/**
 * Created by ktkim on 2015-05-19.
 */


case class EfMsg(msg: String)

class TestActor extends Actor {


  def run_job(msg: String) = {
    println(s"[TestActor] msg: $msg")
    val testActor2 = context.actorOf(Props[TestActor2], "testactor2")
    testActor2 ! EfMsg(msg)
  }

  def receive = {
    case EfMsg(msg) => run_job(msg)
  }
}

class TestActor2 extends Actor {


  def run_job(msg: String) = {
    println(s"[TestActor2] msg: $msg")
  }

  def receive = {
    case EfMsg(msg) => run_job(msg)
  }
}


object hello {

  def main(args: Array[String]) {
    println(args mkString " ")

    val system = ActorSystem("hello")

    val testActor = system.actorOf(Props[TestActor], "testactor")
    testActor ! EfMsg("kkt")

    println("terminated")


  }

}
