package zw.co.tayanasoft.hoxfin.dao;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "counter")
public class Counter extends PanacheEntity {
    @Column(unique = true, nullable = false, length = 10)
    public String ticker;
    @Column(name = "counter_name", length = 100, nullable = false)
    public String counterName;
    @Column(name = "year_high", nullable = false)
    public BigDecimal yearHigh;
    @Column(name = "year_low", nullable = false)
    public BigDecimal yearLow;
    @Column(name = "current_price", nullable = false)
    public BigDecimal currentPrice;
    @ManyToOne
    @JoinColumn(name = "exchange_id")
    public StockExchange exchange;
    @ManyToMany(mappedBy = "counters")
    public List<StockIndex> indices;
    @Column(name = "year_end", nullable = false)
    public String yearEnd;
    @Column(name = "market_cap")
    public BigDecimal marketCap;
    @Column(name = "intrinsic_value")
    public BigDecimal intrinsicValue;
    @Column(name = "margin_of_safety")
    public BigDecimal marginOfSafety;
}