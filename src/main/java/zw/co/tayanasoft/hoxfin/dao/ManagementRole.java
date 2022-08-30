package zw.co.tayanasoft.hoxfin.dao;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "management_role")
public class ManagementRole extends PanacheEntity {
    @Column(name = "role_code", length = 5, unique = true, nullable = false)
    public String roleCode;
    @Column(name = "role_name", length = 50, nullable = false)
    public String roleName;
}