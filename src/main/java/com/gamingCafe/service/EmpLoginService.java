package com.gamingCafe.service;

import java.util.ArrayList;
import java.util.List;

import com.gamingCafe.model.EmpLogin;
import com.gamingCafe.model.Maintains;
import com.gamingCafe.repository.EmpLoginRepository;
import com.gamingCafe.repository.MaintainsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpLoginService {
    
    @Autowired
    private EmpLoginRepository empLoginRepository;
    
    public EmpLogin checkIfEmpExists(String id) {
        EmpLogin emp;

        if(!empLoginRepository.findById(id).isPresent())
            emp = null;
        else
            emp = empLoginRepository.findById(id).get();
        return emp;
    }

    public List<EmpLogin> getAllEmpsUnderMgr(String id) {
        List<EmpLogin> empList = new ArrayList<>();
        for(EmpLogin emp : empLoginRepository.findAll()) {
            if(emp.mgr_id != null && emp.mgr_id.equals(id))
                empList.add(emp);
        }
        return empList;
    }

    @Autowired
    private MaintainsRepository maintainsRepository;
    
    public Maintains getMaintains(String id) {
        Maintains maintains;
        if(!maintainsRepository.findById(id).isPresent())
            maintains = null;
        else
            maintains = maintainsRepository.findById(id).get();
        return maintains;
    }
}
