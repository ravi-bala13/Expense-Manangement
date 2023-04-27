package com.expense.management.controller;

import com.expense.management.database.entity.Expense;
import com.expense.management.response.BaseResponse;
import com.expense.management.service.CentralService;
import com.expense.management.utils.BaseResponseUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Log4j2
@RestController
@RequestMapping("/central")
public class CentralController {

    @Autowired
    CentralService centralService;

    /**
     * This api is used to add or store expense in the db
     * @param expense object having values of expense class
     * @return
     */
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

    /**
     * This is api will give list expenses from mongodb in pagination manner
     * @param offset this value ensure how many data need to skip from start
     * @param limit this value ensure how many data need to get
     * @return BaseResponse
     */
    @GetMapping("/get-expenses")
    public BaseResponse getExpenses(@RequestParam(value = "offset", required = false) Integer offset, @RequestParam(value = "limit", required = false) Integer limit){
        try {
            return centralService.getExpensesDetails(offset, limit);
        }catch (Exception e){
            log.info("Error in getExpenses", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }

}
