package zw.co.tayanasoft.hoxfin.dao;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "stock_index")
public class StockIndex extends PanacheEntity {
    @Column(name = "index_code", length = 5, nullable = false, unique = true)
    public String indexCode;
    @Column(name = "index_name", length = 100, nullable = false)
    public String indexName;
    @ManyToMany
    @JoinTable(name = "counter_stock_index", joinColumns = {@JoinColumn(name = "stock_index_id")},
    inverseJoinColumns = {@JoinColumn(name = "counter_id")})
    public List<Counter> counters;
}
