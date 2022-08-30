package zw.co.tayanasoft.hoxfin.dao;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "manager")
public class Manager extends PanacheEntity {
    @ManyToOne
    @JoinColumn(name = "counter_id")
    public Counter counter;
    @ManyToOne
    @JoinColumn(name = "role_id")
    public ManagementRole role;
    @Column(name = "full_name", length = 150, nullable = false)
    public String fullName;
    @Column(name = "from_date", nullable = false)
    public LocalDate fromDate;
    @Column(name = "to_date")
    public LocalDate toDate;
    @Column(length = 200)
    public String comment;
    @ManyToOne
    @JoinColumn(name = "reason_id")
    public ReasonForLeaving reason;
}