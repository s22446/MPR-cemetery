package com.pjatk.cemetery;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cemetery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private boolean isOpened;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Corpse> corpseList;

    public Cemetery() {

    }

    public Cemetery(Integer id, String name, boolean isOpened) {
        this.id = id;
        this.name = name;
        this.isOpened = isOpened;
    }

    public Cemetery(Integer id, String name, boolean isOpened, List<Corpse> corpseList) {
        this.id = id;
        this.name = name;
        this.isOpened = isOpened;
        this.corpseList = corpseList;
    }
    // id getters and setters
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    // name getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // isOpened getters and setters
    public boolean isOpened() {
        return isOpened;
    }

    public void setOpened(boolean opened) {
        isOpened = opened;
    }
    // Modifying corpse list
    public void addCorpse(Corpse corpse) {
        this.corpseList.add(corpse);
    }

    public List<Corpse> getCorpseList() {
        return this.corpseList;
    }

    public void setCorpseList(List<Corpse> corpseList) {
        this.corpseList = corpseList;
    }

    @Override
    public String toString() {
        return "Cemetery{" +
                "id = " + this.id +
                ", name = " + this.name +
                ", isOpened = " + this.isOpened +
                ", corpseList =" + this.corpseList +
                "}";

    }
}
