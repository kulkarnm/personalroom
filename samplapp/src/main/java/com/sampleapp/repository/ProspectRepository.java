package com.sampleapp.repository;

import com.sampleapp.domain.Prospect;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProspectRepository  extends CrudRepository<Prospect,String>{
    List<Prospect> findByInventoryIdAndLastName(String inventoryId, String lastName);
} 
