package com.filmassist.filmassist.service;

import com.filmassist.filmassist.model.UserClass;
import org.springframework.stereotype.Service;

@Service
public interface UserClassService {
    public void addUserCLass(UserClass userClass);
    public boolean isExistByPattern(String pattern);
    public long getIdByPattern(String pattern);
}
