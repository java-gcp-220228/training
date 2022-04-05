package com.revature.HelloSpringBoot.services;

import com.revature.HelloSpringBoot.models.Candy;
import com.revature.HelloSpringBoot.repositories.CandyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CandyServiceImpl implements CandyService{

    @Autowired
    private CandyRepository candyRepo;


    @Override
    public Candy createCandy(Candy c) {
        Candy newCandy = candyRepo.save(c);
        return newCandy;
    }

    @Override
    public List<Candy> getAll() {
        return candyRepo.findAll();
    }

    @Override
    @Transactional
    public Candy editCandy(Candy c) {
        Candy target = candyRepo.findById(c.getId()).get();

        target.setdescription(c.getdescription());
        target.setPrice(c.getPrice());
        target.setName(c.getName());

        return target;
    }

    @Override
    @Transactional
    public void deleteCandyById(int id) {
        Candy target = candyRepo.getById(id);
        candyRepo.delete(target);
    }
}
