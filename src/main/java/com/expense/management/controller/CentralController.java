package com.expense.management.controller;

import com.expense.management.database.entity.Expense;
import com.expense.management.response.BaseResponse;
import com.expense.management.service.CentralService;
import com.expense.management.utils.BaseResponseUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Log4j2
@RestController
@RequestMapping("/central")
public class CentralController {

    @Autowired
    CentralService centralService;

    @PostMapping("/add-expense")
    public BaseResponse addExpense(@RequestBody Expense expense){
        try {
            log.info("Expense - {}", expense);
            if(Objects.isNull(expense))
                return BaseResponseUtils.createErrorBaseResponse("Request object is can't be null");

            centralService.saveExpenseDetails(expense);
            return BaseResponseUtils.createSuccessBaseResponse();
        }catch (Exception e){
            log.info("Error in addExpense", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }

    @GetMapping("/get-expenses")
    public BaseResponse getExpenses(){
        try {
            return centralService.getExpensesDetails();
        }catch (Exception e){
            log.info("Error in getExpenses", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }

}
