package com.expense.management.service;

import com.expense.management.database.dao.ExpenseDao;
import com.expense.management.database.entity.Expense;
import com.expense.management.response.BaseResponse;
import com.expense.management.response.CentralResponse;
import com.expense.management.utils.BaseResponseUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.List;


@Service
@Log4j2
public class CentralService {

    @Autowired
    ExpenseDao expenseDao;

    @Async
    public void saveExpenseDetails(Expense expense) {
        expenseDao.save(expense);
    }

    public BaseResponse getExpensesDetails() {
        try {
            List<Expense> expenses = expenseDao.findAll();

            if(CollectionUtils.isEmpty(expenses))
                return BaseResponseUtils.createNoDataBaseResponse();

            return CentralResponse.builder()
                    .expenses(expenses)
                    .es(0)
                    .message("success !")
                    .status(200)
                    .time(System.currentTimeMillis())
                    .build();
        }catch (Exception e){
            log.info("Error in getExpensesDetails", e);
            return BaseResponseUtils.createErrorBaseResponse();
        }
    }
}
