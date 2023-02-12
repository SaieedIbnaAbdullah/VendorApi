package thinkConstructive.com.example.thinkConstructive.demo.service;

import org.springframework.stereotype.Service;
import thinkConstructive.com.example.thinkConstructive.demo.entity.VendorEntity;
import thinkConstructive.com.example.thinkConstructive.demo.exception.ResourceNotFoundException;
import thinkConstructive.com.example.thinkConstructive.demo.repository.VendorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public VendorEntity addVendor(VendorEntity vendorEntity) {
        return vendorRepository.save(vendorEntity);
    }

    public List<VendorEntity> vendorList() {
        return vendorRepository.findAll();
    }

    public Optional<VendorEntity> vendorById(Long id) {
        Optional<VendorEntity> vendorEntity = vendorRepository.findById(id);
        if (vendorEntity.isPresent()) {
            return Optional.of(vendorEntity.get());
        } else {
            throw new ResourceNotFoundException("Vendor", "id", id);
        }
    }

    public VendorEntity updateVendorById(VendorEntity vendorEntity) {
        VendorEntity existVendor = vendorRepository.findVendorById(vendorEntity.getId()).get();
        if (existVendor == null) {
            throw new ResourceNotFoundException("Vendor", "id", existVendor.getId());
        } else {
            existVendor.setId(vendorEntity.getId());
            existVendor.setName(vendorEntity.getName());
            existVendor.setAddress(vendorEntity.getAddress());
            existVendor.setPhoneNumber(vendorEntity.getPhoneNumber());
            return vendorRepository.save(vendorEntity);
        }
    }

    public void deleteVendor(Long id) {
        Optional<VendorEntity> vendorEntity = vendorRepository.findById(id);
        if (vendorEntity.isPresent()) {
            vendorRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Vendor", "id", id);
        }
    }
}
