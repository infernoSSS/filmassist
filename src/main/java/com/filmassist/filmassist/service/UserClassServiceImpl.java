package com.filmassist.filmassist.service;

import com.filmassist.filmassist.model.UserClass;
import com.filmassist.filmassist.repository.UserClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserClassServiceImpl implements UserClassService{

    @Autowired
    private UserClassRepository repository;

    @Override
    public void addUserCLass(UserClass userClass) {
        repository.save(userClass);
    }

    @Override
    public boolean isExistByPattern(String pattern) {
        return repository.findAll().stream().anyMatch(x -> x.getPattern().equals(pattern));
    }

    @Override
    public long getIdByPattern(String pattern) {
        return repository.findAll().stream().filter(x -> x.getPattern().equals(pattern)).findFirst()
                .orElse(new UserClass(){
                    {
                       setPattern(pattern);
                    }
                }).getId();
    }
}
