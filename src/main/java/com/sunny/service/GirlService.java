package com.sunny.service;

import com.sunny.controller.GirlController;
import com.sunny.domain.Girl;
import com.sunny.enums.ResultEnum;
import com.sunny.exception.GirlException;
import com.sunny.repository.GirlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;

@Service
public class GirlService {

    private final static Logger logger=LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setAge(18);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(19);
        girlB.setCupSize("B");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findById(id).orElse(null);
        Integer age = girl.getAge();
        logger.info("age: "+age);
        if (age < 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }


    public Girl findOne(Integer id){
        return girlRepository.findById(id).orElse(null);
    }
}
