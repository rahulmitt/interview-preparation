package com.interviewpedia.preparation.akka.actor.helloworld;

import akka.actor.typed.ActorSystem;

public class Main {
    public static void main(String[] args) {
        ActorSystem<String> actorSystem = ActorSystem.create(FirstSimpleBehavior.create(), "FirstActorSystem");
        actorSystem.tell("say hello");
        actorSystem.tell("who are you");
        actorSystem.tell("create a child");
        actorSystem.tell("Hello are you there?");
        actorSystem.tell("This is the second message");
    }
}
