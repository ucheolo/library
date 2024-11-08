package com.example.library.service.impl;

import com.example.library.model.Rental;
import com.example.library.repository.RentalRepository;
import com.example.library.service.BaseService;
import com.example.library.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class RentalServiceImpl extends BaseService<Rental, Long> implements RentalService {

    @Autowired
    public RentalServiceImpl(RentalRepository rentalRepository) {
        super(rentalRepository);
    }

    @Override
    public Rental findRentalById(Long id) {
        return findById(id);
    }

    @Override
    public Rental createRental(Rental rental) {
        return save(rental);
    }

    @Override
    public Page<Rental> findAll(Pageable pageable) {
        return ((RentalRepository) repository).findAll(pageable);
    }

    @Override
    public void deleteRental(Long id) {
        deleteById(id);
    }
}
