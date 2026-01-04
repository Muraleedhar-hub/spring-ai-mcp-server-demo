package com.spring.ai.mcp.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class AccountInfo {

    @Id
    private String id;
    private String name;
    private Double amount;
    private Integer accountNumber;
}
