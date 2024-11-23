package com.finalizacao.java.ProdutoService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.ana.vendas.online.repository")
public class MongoConfig {

}