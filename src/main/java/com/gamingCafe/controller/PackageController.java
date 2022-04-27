package com.gamingCafe.controller;

import java.util.List;

import com.gamingCafe.model.Package;
import com.gamingCafe.service.PackageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PackageController {
    
    @Autowired
    private PackageService pkgService;

    public List<Package> getPerPlayerPackages() {
        List<Package> packages = pkgService.getPerPlayerPackages();
        System.out.println("--------------------------------------------------------------");
        for (Package p : packages) {
            System.out.println(p.getName());
            System.out.println(p.getHours());
            System.out.println(p.getPrice());
            p.buys.forEach(b -> System.out.println(b.getEmail()));
        }
        return packages;
    }

    public List<Package> getAllPackages() {
        List<Package> pkgList = pkgService.getAllPackages();
        System.out.println("Returning Packages\n\n\n\n\n");
        return pkgList;
    }
}
