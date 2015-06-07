package com.kkt.www.actor

import akka.actor.SupervisorStrategy.Escalate
import akka.actor._


/**
 * Created by kkt on 2015-06-06.
 */

class SuperActor extends Actor with ActorLogging{

  override val supervisorStrategy =
//    AllForOneStrategy(){
    OneForOneStrategy(){
      case _: Exception => {
        println("!!!!!!!!!!!!!!!!!!")
        Escalate
      }
    }

  val childAct1 = context.actorOf(Props[ChildActor])

  def receive  = {
    case x => {
      childAct1 ! "***" + x
    }
  }




}
