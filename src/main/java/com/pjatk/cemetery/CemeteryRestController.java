package com.pjatk.cemetery;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getCemeteryById/{id}")
    public ResponseEntity<Cemetery> getCemeteryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(cemeteryService.getCemeteryById(id));
    }

    @GetMapping("/getAllWithIdGreaterThan")
    public  ResponseEntity<List<Cemetery>> getCemeteryListForIdGreaterThan(@RequestParam Integer id) {
        return ResponseEntity.ok(cemeteryService.getCemeteryListForIdGreaterThan(id));
    }
}
