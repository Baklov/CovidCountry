/* Copyright 2022 freecodeformat.com */
package com.covid.demo.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonProperty;
/* Time: 2022-11-21 17:20:5 @author freecodeformat.com @website http://www.freecodeformat.com/json2javabean.php */
@Entity
@Table(name = "COUNTRIES_DATA")
public class CountryEntity {

    @JsonProperty("Country")
    private String country;
    @JsonProperty("Slug")
    private String slug;
    @Id
    @JsonProperty("ISO2")
    private String iso2;
    
    public void setCountry(String country) {
         this.country = country;
     }
     public String getCountry() {
         return country;
     }

    public void setSlug(String slug) {
         this.slug = slug;
     }
     public String getSlug() {
         return slug;
     }

    public void setIso2(String iso2) {
         this.iso2 = iso2;
     }
     public String getIso2() {
         return iso2;
     }
	@Override
	public String toString() {
		return "CountryBean [country=" + country + ", slug=" + slug + ", iso2=" + iso2 + "]";
	}

}