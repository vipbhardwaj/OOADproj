package com.gamingCafe.controller;

import java.util.List;

import com.gamingCafe.model.EmpLogin;
import com.gamingCafe.service.EmpLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpLoginController {
    @Autowired
    private EmpLoginService empLoginService;

    public EmpLogin empLoginCaller(String id) {
        EmpLogin emp = empLoginService.checkIfEmpExists(id);
        if(emp != null) {
            System.out.println("\n\n\nEmployee exists\n\n\n");            
        } else {
            System.out.println("\n\n\nEmployee does not exist\n\n\n");
        }
        return emp;
    }

    public List<EmpLogin> getAllEmpsUnderMgr(String id) {
        List<EmpLogin> empList = empLoginService.getAllEmpsUnderMgr(id);
        System.out.println("Employees Returned = " + empList.size() + "\n\n\n");
        return empList;
    }

}
