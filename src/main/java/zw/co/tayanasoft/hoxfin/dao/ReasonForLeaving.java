package zw.co.tayanasoft.hoxfin.dao;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reason_for_leaving")
public class ReasonForLeaving extends PanacheEntity {
    @Column(name = "description", length = 100, nullable = false)
    public String description;
}