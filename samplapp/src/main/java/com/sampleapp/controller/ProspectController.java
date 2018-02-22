package com.sampleapp.controller;

import com.sampleapp.controller.request.NewProspectRequest;
import com.sampleapp.domain.Prospect;
import com.sampleapp.repository.ProspectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping(value = "/prospect")
public class ProspectController {
    private final AtomicInteger counter = new AtomicInteger();
    private ProspectRepository prospectRepository;

    @Autowired
    public ProspectController(ProspectRepository prospectRepository) {
        this.prospectRepository = prospectRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> addProspect(@RequestBody NewProspectRequest request) throws Exception {
        Prospect newProspect = new Prospect();
        newProspect.setProspectId(Integer.toString(counter.incrementAndGet()));
        newProspect.setInvitationId(request.getInvitationId());
        newProspect.setFirstName(request.getFirstName());
        newProspect.setLastName(request.getLastName());
        newProspect.setAddress(request.getAddress());
        prospectRepository.save(newProspect);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{inventoryId}/{lastName}")
    public ResponseEntity<Prospect> getPProspect(@PathVariable(name = "inventoryId") String inventoryId, @PathVariable(name = "lastName") String lastName) {
        Prospect prospect = prospectRepository.findByInventoryIdAndLastName(inventoryId, lastName).get(0);
        return new ResponseEntity<>(prospect,HttpStatus.OK);
    }

} 
