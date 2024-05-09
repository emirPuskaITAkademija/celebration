package ba.smoki.celebration.ejb.service;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "service_type")
public class ServiceType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    @Basic(optional = false)
    @Size(max = 45)
    private String name;

    @Column(name = "costPerUnit", nullable = false)
    private BigDecimal costPerUnit;

    @Column(name = "active")
    private Boolean active = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(BigDecimal costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceType that = (ServiceType) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
