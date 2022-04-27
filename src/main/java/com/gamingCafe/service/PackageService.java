package com.gamingCafe.service;

import java.util.ArrayList;
import java.util.List;

import com.gamingCafe.model.Package;
import com.gamingCafe.repository.PackageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageService {

    @Autowired
    private PackageRepository repo;

    public List<Package> getPerPlayerPackages() {
        List<Package> packages = new ArrayList<Package>();
        repo.FindAllWithDescriptionQuery().forEach(packages::add);
        return packages;
    }
    
    public List<Package> getAllPackages() {
        List<Package> pkgs = new ArrayList<>();
        repo.findAll().forEach(pkgs::add);
        return pkgs;
    }
}