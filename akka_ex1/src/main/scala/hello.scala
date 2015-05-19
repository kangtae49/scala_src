/**
 * Created by ktkim on 2015-05-19.
 */
import akka.actor.SupervisorStrategy.{Escalate, Restart, Resume}
import akka.actor._
import scala.concurrent.duration._


case class EfMsg(msg: String) extends Serializable

class TestActor extends Actor with ActorLogging {

  override val supervisorStrategy = {
    OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 minute){
      case _: ArithmeticException      ⇒ Resume
      case _: NullPointerException     ⇒ Restart
      case _: Exception                ⇒ Escalate
    }
  }


  val testActor2 = context.actorOf(Props[TestActor2], "testactor2")

  def run_job(msg: String) = {
    println(s"[TestActor] msg: $msg")

    testActor2 forward EfMsg("[child1]" ++ msg)
    testActor2 forward EfMsg("[child2]" ++ msg)

  }

  override def receive = {
    case EfMsg(msg) => run_job(msg)
  }


}

class TestActor2 extends Actor with ActorLogging {


  def run_job(msg: String) = {
    println(s"[TestActor2] msg: $msg")
  }

  def receive = {
    case EfMsg(msg) => run_job(msg)
  }
}


object hello {
  val system = ActorSystem("hello")

  def test() = {
    val tt = system.actorSelection("akka.tcp://hello@192.168.56.1:2552/user/testActor")
    println("tt:" + tt)
    tt ! EfMsg("kkkkkkkkkkkkk")
  }

  def main(args: Array[String]) {
    println(args mkString " ")



    val testActor = system.actorOf(Props[TestActor], "testActor")

    testActor ! EfMsg("kkt-1")
    println("testActor:" + testActor)

    Thread sleep 5000

    test ()


    /*
    testActor ! EfMsg("kkt-1")
    Thread sleep 1000
    testActor ! EfMsg("kkt-2")
    Thread sleep 1000
    testActor ! EfMsg("kkt-3")
    */

    //Thread sleep 5000

    println("terminated")


  }

}
