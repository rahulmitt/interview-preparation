package com.interviewpedia.preparation.akka.actor.bigprimes;

import akka.actor.typed.ActorSystem;

public class BigPrimesMain {
    public static void main(String[] args) {
        ActorSystem<ManagerBehavior.Command> actorSystem = ActorSystem.create(ManagerBehavior.create(), "bigPrimes");
        actorSystem.tell(new ManagerBehavior.Instruction("start"));
    }
}
