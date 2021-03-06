package camt.se331.shoppingcart.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class History {
    @Id
    @GeneratedValue
    Long Id;
    @Column(length=55600)
    String description;
    String lang;
    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Image> images = new HashSet<>();

    public History() {
    }

    public History(Long id,String lang, String description) {
        this.Id = id;
        this.lang = lang;
        this.description = description;
    }

    public History(String description, Set<Image> images) {
        this.description = description;
        this.lang = "en";
        this.images = images;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

}