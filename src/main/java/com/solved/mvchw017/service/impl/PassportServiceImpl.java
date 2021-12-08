package com.solved.mvchw017.service.impl;

import com.solved.mvchw017.domain.Passport;
import com.solved.mvchw017.persistence.PassportRepository;
import com.solved.mvchw017.persistence.impl.PassportJDBCRepositoryImpl;
import com.solved.mvchw017.service.PassportService;

public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;

    public PassportServiceImpl() {
        this.passportRepository = new PassportJDBCRepositoryImpl();
    }

    @Override
    public Passport create(Passport passport) {
        passport.setId(null);
        passportRepository.create(passport);
        return passport;
    }
}
