package com.spring.ai.mcp.demo.repositoties;

import com.spring.ai.mcp.demo.entity.AccountInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

@EnableMongoRepositories
public interface AccountRepository extends MongoRepository<AccountInfo, String> {
    AccountInfo findByAccountNumber(Integer accountNumber);
    Double getAmountByAccountNumber(Integer accountNumber);
    Double getAmountByName(String name);
}
