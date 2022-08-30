package zw.co.tayanasoft.hoxfin.dao;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;

@Entity
@Table(name = "ts_currency")
public class TSCurrency extends PanacheEntity {
    @Column(name = "currency_code", length = 5, unique = true)
    public String currencyCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    public Country country;
    @Column(name="currency_name", length = 50)
    public String currencyName;
}
