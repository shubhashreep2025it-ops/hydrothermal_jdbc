package com.greenhouse.hydrothermal.controller;

import com.greenhouse.hydrothermal.entity.Vendor;
import com.greenhouse.hydrothermal.service.VendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorService service;

    public VendorController(VendorService service) {
        this.service = service;
    }

    @PostMapping
    public Vendor createVendor(@RequestBody Vendor vendor) {
        return service.createVendor(vendor);
    }

    @GetMapping
    public List<Vendor> getAllVendors() {
        return service.getAllVendors();
    }
}