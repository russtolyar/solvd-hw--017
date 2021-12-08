package com.solved.mvchw017.persistence;

import com.solved.mvchw017.domain.Passport;

import java.util.List;

public interface PassportRepository {

    void create(Passport passport);

    List<Passport> findAll();
}
