package com.pjatk.cemetery;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cemetery")
public class CemeteryRestController {
    public final CemeteryService cemeteryService;

    public CemeteryRestController(CemeteryService cemeteryService) {
        this.cemeteryService = cemeteryService;
    }

    @GetMapping("/createExampleCemetery")
    public ResponseEntity<Cemetery> createAndGetExampleCemetery() {
        return ResponseEntity.ok(cemeteryService.createAndGetExampleCemetery("Przykładowy cmentarz"));
    }

    @GetMapping("/createCemetery")
    public ResponseEntity<Cemetery> createAndGetCemetery(@RequestParam String name) {
        return ResponseEntity.ok(cemeteryService.createAndGetCemetery(name));
    }

    @GetMapping("/getCemeteryList")
    public ResponseEntity<List<Cemetery>> getCemeteryList() {
        return ResponseEntity.ok(cemeteryService.getCemeteryList());
    }

    @GetMapping("/getCemeteryById")
    public ResponseEntity<Cemetery> getCemeteryById(@RequestParam Integer id) {
        return ResponseEntity.ok(cemeteryService.getCemeteryById(id));
    }

    @GetMapping("/getAllWithIdGreaterThan")
    public  ResponseEntity<List<Cemetery>> getCemeteryListForIdGreaterThan(@RequestParam Integer id) {
        return ResponseEntity.ok(cemeteryService.getCemeteryListForIdGreaterThan(id));
    }
}
