package com.spring.ai.mcp.demo;

import com.spring.ai.mcp.demo.service.AccountService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories
@SpringBootApplication
public class SpringAiMcpDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiMcpDemoApplication.class, args);
	}

	@Bean
	public List<ToolCallback> accountServiceToolCallback(AccountService accountService){
		return List.of(ToolCallbacks.from(accountService));
	}
}
