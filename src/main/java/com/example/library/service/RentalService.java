package com.example.library.service;

import com.example.library.model.Rental;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RentalService {
    Rental findRentalById(Long id);
    Rental createRental(Rental rental);
    Page<Rental> findAll(Pageable pageable);
    void deleteRental(Long id);
}
