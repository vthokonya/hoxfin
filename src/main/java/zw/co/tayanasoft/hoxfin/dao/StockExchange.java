package zw.co.tayanasoft.hoxfin.dao;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "stock_exchange")
public class StockExchange extends PanacheEntity {
    @Column(name = "exchange_code", length = 5, nullable = false, unique = true)
    public String exchangeCode;
    @Column(name = "exchange_name", length = 100, nullable = false)
    public String exchangeName;
    @ManyToOne(fetch = javax.persistence.FetchType.LAZY)
    @JoinColumn(name = "currency_id")
    public TSCurrency currency;
    @ManyToOne(fetch = javax.persistence.FetchType.LAZY)
    @JoinColumn(name = "country_id")
    public Country country;
    @OneToMany(mappedBy = "exchange")
    public List<Counter> counters;
}