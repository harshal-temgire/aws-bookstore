package com.aws.bookstore.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aws.bookstore.entity.AwsSecrets;
import com.google.gson.Gson;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

@Configuration
public class ApplicationConfig {
	
	@Value("$(cloud.aws.credentials.access-key)")
	private String accessKey;
	
	@Value("$(cloud.aws.credentials.secret-key)")
	private String secretKey;
	
	private Gson gson = new Gson();
	
	@Bean
	public DataSource dataSource() {
		AwsSecrets awssecrets = getSecret();
		return DataSourceBuilder
				.create()
				.url("jdbc:"+awssecrets.getEngine()+"://"+awssecrets.getHost()+":"+awssecrets.getPort()+"/bookstoredb")
				.username(awssecrets.getUsername())
				.password(awssecrets.getPassword())
				.build();
	}

	private AwsSecrets getSecret() {

		String secretName = "bookstoredb-secret";
		Region region = Region.of("us-east-1");

		// Create a Secrets Manager client
		SecretsManagerClient client = SecretsManagerClient.builder()
				.region(region)
				.credentialsProvider(StaticCredentialsProvider.create(AwsBasicCredentials.create("AKIA5SAL3DS3XV5DSJEM", "Qu7gBxsZVoSafWItKJutYrGoiiPKKzpk3CmGLBoK")))
				.build();

		GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
				.secretId(secretName)
				.build();

		GetSecretValueResponse getSecretValueResponse;

		try {
			getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
		} catch (Exception e) {
			throw e;
		}

		String secret = getSecretValueResponse.secretString();

		return gson.fromJson(secret, AwsSecrets.class);
	}
}
