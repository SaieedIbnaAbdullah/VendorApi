package thinkConstructive.com.example.thinkConstructive.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thinkConstructive.com.example.thinkConstructive.demo.entity.VendorEntity;
import thinkConstructive.com.example.thinkConstructive.demo.service.VendorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendor/api")
public class VendorController {
    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @PostMapping
    public ResponseEntity<VendorEntity> saveVendor(@RequestBody VendorEntity vendorEntity) {
        return new ResponseEntity<>(vendorService.addVendor(vendorEntity), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VendorEntity>> getList() {
        return new ResponseEntity<>(vendorService.vendorList(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<VendorEntity>> findVendorById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(vendorService.vendorById(id), HttpStatus.FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<VendorEntity> editById(@RequestBody VendorEntity vendorEntity, @PathVariable("id") Long id) {
        vendorEntity.setId(id);
        return new ResponseEntity<>(vendorService.updateVendorById(vendorEntity), HttpStatus.FOUND);
    }

    @DeleteMapping("{id}")
    public void deleteVendorById(@PathVariable("id") Long id){
        vendorService.deleteVendor(id);
    }
}
