package com.interviewpedia.preparation.akka.actor.bigprimes;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Random;

public class WorkerBehavior extends AbstractBehavior<WorkerBehavior.Command> {

    public static class Command implements Serializable {
        private static final long serialVersionUID = 1L;
        private final String message;
        private final ActorRef<ManagerBehavior.Command> sender;

        public Command(String message, ActorRef<ManagerBehavior.Command> sender) {
            this.message = message;
            this.sender = sender;
        }

        public String getMessage() {
            return message;
        }

        public ActorRef<ManagerBehavior.Command> getSender() {
            return sender;
        }
    }

    private WorkerBehavior(ActorContext<WorkerBehavior.Command> context) {
        super(context);
    }

    public static Behavior<WorkerBehavior.Command> create() {
        return Behaviors.setup(WorkerBehavior::new);
    }

    @Override
    public Receive<WorkerBehavior.Command> createReceive() {
        return this.newReceiveBuilder()
                .onAnyMessage(command -> {
                    if (command.getMessage().equals("start")) {
                        BigInteger bigInteger = new BigInteger(2000, new Random());
                        BigInteger nextPrime = bigInteger.nextProbablePrime();
//                        System.out.println(nextPrime);
                        command.getSender().tell(new ManagerBehavior.Result(nextPrime));
                    }
                    return this;
                })
                .build();
    }
}
