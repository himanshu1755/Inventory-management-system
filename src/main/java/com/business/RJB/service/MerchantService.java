package com.business.RJB.service;

import com.business.RJB.model.Merchants;
import com.business.RJB.repository.IMerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantService {
    @Autowired
    private IMerchantRepository merchantRepository;

    public void addMerchant(Merchants merchants){
        merchantRepository.save(merchants);
    }

    public List<Merchants> getMerchants(){
        return merchantRepository.findAll();
    }

}
