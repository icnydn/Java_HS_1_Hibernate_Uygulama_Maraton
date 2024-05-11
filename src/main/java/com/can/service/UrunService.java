package com.can.service;

import com.can.entity.Urun;
import com.can.repository.UrunRepository;

import java.util.List;

public class UrunService {
    private final UrunRepository urunRepository;

    public UrunService() {
        urunRepository = new UrunRepository();
    }

    public void save(Urun urun) {
        urunRepository.save(urun);
    }

    public List<Urun> findAll() {
        return urunRepository.findAll();
    }

    public List<Urun> findAllByGivenValue(Object value) {
        return urunRepository.findAllByGivenValue(value);
    }
}
