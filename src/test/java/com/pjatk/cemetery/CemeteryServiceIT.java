package com.pjatk.cemetery;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class CemeteryServiceIT {
    @Mock
    private CemeteryRepository cemeteryRepository;

    @Autowired
    private CemeteryService cemeteryService;

    // Testy
    @Test
    void shouldAddSuffixToName() {
        // GIVEN
        Cemetery cemetery = new Cemetery(null, "Cmentarz", true, List.of());
        // WHEN
        cemeteryService.addSuffixToCemeteryName(cemetery);
        // THEN
        assertThat(cemetery.getName()).isEqualTo("Cmentarz_SUFFIX");
    }
    @Test
    void shouldNotAddSuffixToName() {
        // GIVEN
        Cemetery cemetery = new Cemetery(null, null, true, List.of());
        // WHEN
        cemeteryService.addSuffixToCemeteryName(cemetery);
        // THEN
        assertThat(cemetery.getName()).isNull();
    }
    @Test
    void shouldAddCorpseToList() {
        // GIVEN
        Cemetery cemetery = new Cemetery(null, "Cmentarz", true, new ArrayList<>());
        Corpse corpse = new Corpse(null, "Janina", "Nowak", 75, Sex.FEMALE);
        // WHEN
        cemeteryService.addCorpseToCemetery(cemetery, corpse);
        // THEN
        assertThat(cemetery.getCorpseList().size()).isGreaterThan(0);
    }
    @Test
    void shouldNotAddCorpseToList() {
        // GIVEN
        Cemetery cemetery = new Cemetery(null, "Cmentarz", true, null);
        Corpse corpse = new Corpse(null, "Janina", "Nowak", 75, Sex.FEMALE);
        // WHEN
        cemeteryService.addCorpseToCemetery(cemetery, corpse);
        // THEN
        assertThat(cemetery.getCorpseList()).isNull();
    }
    @Test
    void shouldClearZooList() {
        // GIVEN
        List<Corpse> corpseList = new ArrayList<>();
        Corpse corpse = new Corpse(null, "Janina", "Nowak", 75, Sex.FEMALE);
        corpseList.add(corpse);
        Cemetery cemetery = new Cemetery(null, "Cmentarz", true, corpseList);
        // WHEN
        cemeteryService.clearCemeteryCorpseList(cemetery);
        // THEN
        assertThat(cemetery.getCorpseList().size()).isEqualTo(0);
    }
    @Test
    void shouldNotClearZooList() {
        // GIVEN
        Cemetery cemetery = new Cemetery(null, "Cmentarz", true, null);
        // WHEN
        cemeteryService.clearCemeteryCorpseList(cemetery);
        // THEN
        assertThat(cemetery.getCorpseList()).isNull();
    }
    @Test
    void shouldFindById() {
        when(cemeteryRepository.findById(any()))
                .thenReturn(Optional.of(new Cemetery(null, "Cmentarz", true, null)));

        Cemetery byId = cemeteryService.getCemeteryById(1);

        assertThat(byId).isNotNull();
    }
    @Test
    void shouldNotFindById() {
        when(cemeteryRepository.findById(any()))
                .thenReturn(Optional.empty());

        Cemetery byId = cemeteryService.getCemeteryById(1);

        assertThat(byId).isNull();
    }
    @Test
    void shouldExistsZoo() {
        when(cemeteryRepository.existsById(any()))
                .thenReturn(true);

        boolean existsById = cemeteryService.existsById(1);

        assertThat(existsById).isTrue();
    }
    @Test
    void shouldNotExistZoo() {
        when(cemeteryRepository.existsById(any()))
                .thenReturn(false);

        boolean existsById = cemeteryService.existsById(1);

        assertThat(existsById).isFalse();
    }
    @Test
    void shouldDeleteZoo() {
        cemeteryService.deleteCemeteryById(1);

        verify(cemeteryRepository).deleteById(any());
    }
}
