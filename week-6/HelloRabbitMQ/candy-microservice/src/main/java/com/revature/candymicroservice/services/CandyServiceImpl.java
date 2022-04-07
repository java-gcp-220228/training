package com.revature.candymicroservice.services;

import com.revature.candymicroservice.models.Candy;
import com.revature.candymicroservice.repositories.CandyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
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
    public Candy getById(int id) {
        return candyRepo.findById(id).get();
    }

    @Override
    public Candy editCandy(Candy c) {
        Candy target = candyRepo.findById(c.getId()).get();

        target.setDescription(c.getDescription());
        target.setPrice(c.getPrice());
        target.setName(c.getName());

        return target;
    }

    @Override
    public void deleteCandyById(int id) {
        Candy target = candyRepo.getById(id);
        candyRepo.delete(target);
    }
}
