package com.greenhouse.hydrothermal.controller;

import com.greenhouse.hydrothermal.entity.VendorBill;
import com.greenhouse.hydrothermal.service.VendorBillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor-bills")
public class VendorBillController {

    private final VendorBillService service;

    public VendorBillController(VendorBillService service) {
        this.service = service;
    }

    @PostMapping
    public VendorBill createVendorBill(
            @RequestBody VendorBill vendorBill) {
        return service.createVendorBill(vendorBill);
    }

    @GetMapping
    public List<VendorBill> getAllVendorBills() {
        return service.getAllVendorBills();
    }
}