package com.solved.mvchw017.service;

import com.solved.mvchw017.domain.Passport;

import java.util.List;

public interface PassportService {
    Passport create (Passport passport);

    List<Passport> findAll();
}
