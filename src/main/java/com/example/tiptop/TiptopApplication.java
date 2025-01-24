package com.example.tiptop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TiptopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiptopApplication.class, args);
	}
	//keytool -genkey -alias tiptop-https -storetype JKS -keyalg RSA -keysize 2048 -validity 365 -keystore tiptop.jks

	//keytool -genkey -alias spring-https -storetype JKS -keyalg RSA -keysize 2048 -validity 365 -keystore tiptop.jks



}
