package com.adgile.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Slf4j
@Configuration
public class AmazonSqsConfig {

	@Value("${cloud.aws.credentials.access-key}")
	private String accessKey;

	@Value("${cloud.aws.credentials.secret-key}")
	private String secretKey;

	/**
	 * sqs 접근을 위한 사용자 bean
	 */

	@Bean
	public QueueMessagingTemplate queueMessagingTemplate() {
		return new QueueMessagingTemplate(amazonSQSAsync());
	}

	@Primary
	@Bean
	public AmazonSQSAsync amazonSQSAsync() {
		AWSCredentialsProvider awsCredentialsProvider = new AWSStaticCredentialsProvider(
				new BasicAWSCredentials(accessKey, secretKey)
		);

		return AmazonSQSAsyncClientBuilder
				.standard()
				.withRegion(Regions.AP_NORTHEAST_2)
				.withCredentials(awsCredentialsProvider)
				.build();
	}

}
