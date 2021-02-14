package com.lsl.controller;

import com.lsl.pojo.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/validate")
@Valid
public class ValidateController {

    private Logger logger = LoggerFactory.getLogger(ValidateController.class);

    @RequestMapping("/annotation")
    public ModelAndView annotationValidate(@Validated Transaction transaction, Errors errors){
        Long productId = transaction.getProductId();
        logger.info(transaction+"==================="+errors.hasErrors());
        if(errors.hasErrors()){
            List<FieldError> errorList = errors.getFieldErrors();
            for (FieldError error:errorList){
                logger.info("fied：" + error.getField() + "\t" + "msg：" + error.getDefaultMessage());
                System.out.println("fied：" + error.getField() + "\t" + "msg：" + error.getDefaultMessage());
            }
        }
        ModelAndView mv = new ModelAndView();
        return mv;
    }
}
