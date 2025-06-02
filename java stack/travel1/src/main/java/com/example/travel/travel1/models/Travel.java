package com.example.travel.travel1.models;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "travel")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    @NotNull
    @Size(min=2, max=30, message="Name must be between 2 and 30 characters")
    private String name;
    @NotNull
    @Size(min=2, max=30, message="Vendor must be between 2 and 30 characters")
    private String vendor;
    @NotNull
    @Min(value=1, message="Amount must be at least 1")
    private Integer amount;
    @NotNull
    @Size(min=2, max=100, message="Description must be between 2 and 100 characters")
    private String description;


    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;


    public Travel() {
    }
    public Travel(String name, String vendor, Integer amount, String description) {
        this.name = name;
        this.vendor = vendor;
        this.amount = amount;
        this.description = description;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getVendor() {
        return vendor;
    }
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }


}
