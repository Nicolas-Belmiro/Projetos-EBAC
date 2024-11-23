package com.finalizacao.java.vendas.onlineconfig;

import org.springframework.context.annotation.Configuration;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.ana.vendas.online.repository")
public class MongoConfig {

}