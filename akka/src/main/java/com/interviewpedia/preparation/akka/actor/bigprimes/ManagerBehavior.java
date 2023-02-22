package com.interviewpedia.preparation.akka.actor.bigprimes;

import akka.actor.typed.ActorRef;
import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.AbstractBehavior;
import akka.actor.typed.javadsl.ActorContext;
import akka.actor.typed.javadsl.Behaviors;
import akka.actor.typed.javadsl.Receive;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;

public class ManagerBehavior extends AbstractBehavior<ManagerBehavior.Command> {

    private final SortedSet<BigInteger> primes = new TreeSet<>();

    public interface Command extends Serializable {
    }

    public static class Instruction implements Command {
        private static final long serialVersionUID = 1L;
        private final String message;

        public Instruction(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public static class Result implements Command {
        private static final long serialVersionUID = 1L;
        private final BigInteger prime;

        public Result(BigInteger prime) {
            this.prime = prime;
        }

        public BigInteger getPrime() {
            return prime;
        }
    }

    private ManagerBehavior(ActorContext<ManagerBehavior.Command> context) {
        super(context);
    }

    public static Behavior<ManagerBehavior.Command> create() {
        return Behaviors.setup(ManagerBehavior::new);
    }

    @Override
    public Receive<ManagerBehavior.Command> createReceive() {
        return this.newReceiveBuilder()
                .onMessage(Instruction.class, command -> {
                    if (command.getMessage().equals("start")) {
                        for (int i = 0; i < 20; i++) {
                            ActorRef<WorkerBehavior.Command> worker = this.getContext().spawn(WorkerBehavior.create(), "worker" + i);
                            worker.tell(new WorkerBehavior.Command("start", getContext().getSelf()));
                        }
                    }
                    return this;
                })
                .onMessage(Result.class, command -> {
                    primes.add(command.getPrime());
                    System.out.printf("I have received %d prime numbers\n", primes.size());
                    return this;
                })
                .build();
    }
}
