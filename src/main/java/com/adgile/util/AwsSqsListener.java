package com.adgile.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Component
@Lazy
public class AwsSqsListener {

	private static final Logger logger = LoggerFactory.getLogger(AwsSqsListener.class);

	CountDownLatch countDownLatch;

	public void setCountDownLatch(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@SqsListener(value = "${cloud.aws.sqs.queue.name}", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
	public void receiveMessage(Object message) {
		logger.info("received message ::: {}", message);
		if (countDownLatch != null) {
			logger.info("countDownLatch.countDown");
			countDownLatch.countDown();
		}
	}

}
