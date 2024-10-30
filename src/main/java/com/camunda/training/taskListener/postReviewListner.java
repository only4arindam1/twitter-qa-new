package com.camunda.training.taskListener;

import com.camunda.training.model.Tweet;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

public class postReviewListner implements ExecutionListener {


    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        String tweet = (String)delegateExecution.getVariable("myTweet");

//        delegateExecution.setVariable("myTweet",tweet.toUpperCase());
    }
}
