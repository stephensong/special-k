// -*- mode: Scala;-*- 
// Filename:    Monadic.scala 
// Authors:     lgm                                                    
// Creation:    Wed Dec 29 13:57:38 2010 
// Copyright:   Not supplied 
// Description: 
// ------------------------------------------------------------------------

//package net.liftweb.amqp
package com.biosimilarity.lift.lib

import scala.util.continuations._

import scala.concurrent.{Channel => Chan, _}
import scala.concurrent.cpsops._

import _root_.com.rabbitmq.client.{ Channel => RabbitChan,
				   ConnectionParameters => RabbitCnxnParams, _}
//import _root_.scala.actors.Actor

import _root_.java.io.ObjectInputStream
import _root_.java.io.ByteArrayInputStream
import _root_.java.util.Timer
import _root_.java.util.TimerTask

trait MonadicDispatcher[T] 
extends FJTaskRunners {
  self : WireTap with Journalist =>

  type Channel
  type Ticket
  type ConnectionParameters
  type Payload

  trait Generable[+A,-B,+C] {
    def funK : (A => (B @suspendable)) => (C @suspendable)
    
    def foreach( f : (A => B @suspendable) ) : C @suspendable = {
      funK( f )
    }
  }

  case class Generator[+A,-B,+C](
    override val funK : (A => (B @suspendable)) => (C @suspendable)
  ) extends Generable[A,B,C] {   
  }

  //val reportage = report( Twitterer() ) _

  def acceptConnections(
    params : ConnectionParameters,
    host : String,
    port : Int
  ) : Generator[Channel,Unit,Unit]

  def beginService(
    params : ConnectionParameters,
    host : String,
    port : Int
  ) : Generator[T,Unit,Unit]
  
  def callbacks(
    channel : Channel, ticket : Ticket
  ) : Generator[Payload,Unit,Unit]

  def readT(
    channel : Channel,
    ticket : Ticket
  ) : Generator[T,Unit,Unit]
}


