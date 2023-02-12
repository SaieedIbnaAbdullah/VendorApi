package thinkConstructive.com.example.thinkConstructive.demo.converter;

import thinkConstructive.com.example.thinkConstructive.demo.dto.VendorDto;
import thinkConstructive.com.example.thinkConstructive.demo.entity.VendorEntity;

public class DtoEntityConverter {
    public VendorEntity dtoToEntity(VendorDto vendorDto){
        VendorEntity vendorEntity = new VendorEntity();
        vendorEntity.setName(vendorDto.getName());
        vendorEntity.setPhoneNumber(vendorDto.getPhoneNumber());
        vendorEntity.setAddress(vendorDto.getAddress());
        return vendorEntity;
    }
}
