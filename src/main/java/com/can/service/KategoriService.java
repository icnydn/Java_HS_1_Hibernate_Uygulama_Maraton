package com.can.service;

import com.can.entity.Kategori;
import com.can.repository.KategoriRepository;

import java.util.List;

public class KategoriService {
    private final KategoriRepository kategoriRepository;

    public KategoriService() {
        kategoriRepository = new KategoriRepository();
    }

    public void save(Kategori kategori) {
        kategoriRepository.save(kategori);
    }

    public List<Kategori> findAll() {
        return kategoriRepository.findAll();
    }

    public Kategori findById(Long id) {
        return kategoriRepository.findById(id).get();
    }
}
