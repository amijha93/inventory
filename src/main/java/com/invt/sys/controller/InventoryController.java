package com.invt.sys.controller;

import com.invt.sys.model.Product;
import com.invt.sys.repo.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InventoryController {
    @Autowired
    private InventoryRepo repo;
    @GetMapping("/inventories")
    public ResponseEntity<List<Product>> getProductList() {

        return ResponseEntity.ok(repo.findAll());
    }
    @GetMapping("/inventory")
    public ResponseEntity<Product> getProductById(@RequestParam int id) {

        return ResponseEntity.ok(repo.findById(id).get());
    }
}
