package zw.co.tayanasoft.hoxfin.dao;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ts_country")
@SequenceGenerator(name = "ts_country_sequence", sequenceName = "ts_country_sequence", initialValue = 1)
public class Country extends PanacheEntity {
    @Column(name = "country_code", length = 3, unique = true)
    public String countryCode;
    @Column(name = "country_name", length = 50)
    public String countryName;
    @OneToMany(mappedBy = "country")
    public List<TSCurrency> currencyList;
}
