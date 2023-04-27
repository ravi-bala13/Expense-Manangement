package com.expense.management.database.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "expense")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Expense {

    @Id
    private String id;

    @Field("claim_type")
    private String claimType;

    private Integer amount;

    @Field("date_of_expense")
    private Date dateOfExpense;

    @Field("claim_month")
    private String claimMonth;

    @Field("claim_year")
    private Integer claimYear;

}
