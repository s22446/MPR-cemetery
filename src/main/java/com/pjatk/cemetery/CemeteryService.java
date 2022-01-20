package com.pjatk.cemetery;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CemeteryService {
    private final CemeteryRepository cemeteryRepository;

    public CemeteryService(CemeteryRepository cemeteryRepository) {
        this.cemeteryRepository = cemeteryRepository;
    }

    public Cemetery createAndGetExampleCemetery(String name) {
        List<Corpse> corpseList = new ArrayList<>();
        Corpse corpse = new Corpse(null, "Jan", "Nowak", 50, Sex.MALE);

        corpseList.add(corpse);

        Cemetery cemetery = new Cemetery(null, name, true, corpseList);

        Cemetery save = cemeteryRepository.save(cemetery);

        return save;
    }

    public Cemetery createAndGetCemetery(String name) {
        List<Corpse> corpseList = new ArrayList<>();
        Corpse corpse = new Corpse(null, "Janina", "Nowak", 75, Sex.FEMALE);

        corpseList.add(corpse);

        Cemetery cemetery = new Cemetery(null, name, true, corpseList);

        Cemetery save = cemeteryRepository.save(cemetery);

        return save;
    }

    public List<Cemetery> getCemeteryList() {
        List<Cemetery> cemeteryList = cemeteryRepository.findAll();

        return cemeteryList;
    }

    public Cemetery getCemeteryById(Integer id) {
        Optional<Cemetery> cemetery = cemeteryRepository.findById(id);

        return cemetery.orElse(null);
    }

    public List<Cemetery> getCemeteryListForIdGreaterThan(Integer id) {
        List<Cemetery> cemeteryList = cemeteryRepository.findAllByIdIsGreaterThan(id);

        return  cemeteryList;
    }

    public boolean existsById(Integer id) {
        boolean exists = cemeteryRepository.existsById(id);

        return exists;
    }

    public void deleteCemeteryById(Integer id) {
        cemeteryRepository.deleteById(id);
    }

    public void addSuffixToCemeteryName(Cemetery cemetery) {
        if (cemetery.getName() != null) {
            String suffixName = cemetery.getName() + "_SUFFIX";

            cemetery.setName(suffixName);
        }
    }

    public void addCorpseToCemetery(Cemetery cemetery, Corpse corpse) {
        if (cemetery.getCorpseList() != null) {
            cemetery.getCorpseList().add(corpse);
        }
    }

    public void clearCemeteryCorpseList(Cemetery cemetery) {
        if (cemetery.getCorpseList() != null) {
            cemetery.getCorpseList().clear();
        }
    }
}
