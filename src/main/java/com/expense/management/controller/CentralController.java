package com.expense.management.controller;

import com.expense.management.Request.CentralBaseRequest;
import com.expense.management.database.entity.Expense;
import com.expense.management.response.BaseResponse;
import com.expense.management.service.CentralService;
import com.expense.management.utils.BaseResponseUtils;
import lombok.extern.log4j.Log4j2;
//import org.apache.commons.lang3.StringUtils;
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

//    @GetMapping("/get-users")
//    public BaseResponse getUsers(@RequestBody(required = false) List<String> mobileNoList){
//        try {
//            return centralService.getUserDetails(mobileNoList);
//        }catch (Exception e){
//            log.info("Error in addUser", e);
//            return BaseResponseUtils.createErrorBaseResponse();
//        }
//    }
//
//    @PostMapping("/add-partner")
//    public BaseResponse addPartner(@RequestBody CentralBaseRequest centralBaseRequest){
//        try {
//            log.info("centralBaseRequest - {}", centralBaseRequest);
//            if(StringUtils.isEmpty(centralBaseRequest.getName()) || StringUtils.isEmpty(centralBaseRequest.getMobile()))
//                return BaseResponseUtils.createErrorBaseResponse("Username or Mobile must not be empty");
//
//            centralService.savePartnerDetails(centralBaseRequest);
//            return BaseResponseUtils.createSuccessBaseResponse();
//        }catch (Exception e){
//            log.info("Error in addPartner", e);
//            return BaseResponseUtils.createErrorBaseResponse();
//        }
//    }
//
//    @GetMapping("/get-partners")
//    public BaseResponse getPartners(@RequestBody(required = false) List<String> mobileNoList){
//        try {
//            return centralService.getPartnerDetails(mobileNoList);
//        }catch (Exception e){
//            log.info("Error in addUser", e);
//            return BaseResponseUtils.createErrorBaseResponse();
//        }
//    }

}
