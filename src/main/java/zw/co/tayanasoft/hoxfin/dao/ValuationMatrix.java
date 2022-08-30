package zw.co.tayanasoft.hoxfin.dao;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import zw.co.tayanasoft.hoxfin.enu.ReportType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "valuation_matrix")
public class ValuationMatrix extends PanacheEntity {
    @Column(name = "report_date", nullable = false)
    public LocalDate reportDate;
    @Column(name = "report_type", nullable = false)
    public ReportType reportType;
    @Column(name = "growth_rate", scale = 2, precision = 14)
    public BigDecimal growthRate;
    @Column(name = "discounted_growth_rate", scale = 2, precision = 14)
    public BigDecimal discountedGrowthRate;
    @Column(name = "fcf_year1", scale = 2, precision = 14)
    public BigDecimal fcfYear1;
    @Column(name = "fcf_year2", scale = 2, precision = 14)
    public BigDecimal fcfYear2;
    @Column(name = "fcf_year3", scale = 2, precision = 14)
    public BigDecimal fcfYear3;
    @Column(name = "fcf_year4", scale = 2, precision = 14)
    public BigDecimal fcfYear4;
    @Column(name = "fcf_year5", scale = 2, precision = 14)
    public BigDecimal fcfYear5;
    @Column(name = "fcf_year6", scale = 2, precision = 14)
    public BigDecimal fcfYear6;
    @Column(name = "fcf_year7", scale = 2, precision = 14)
    public BigDecimal fcfYear7;
    @Column(name = "fcf_year8", scale = 2, precision = 14)
    public BigDecimal fcfYear8;
    @Column(name = "fcf_year9", scale = 2, precision = 14)
    public BigDecimal fcfYear9;
    @Column(name = "fcf_year10", scale = 2, precision = 14)
    public BigDecimal fcfYear10;
    @Column(name = "fcf_by_ten", scale = 2, precision = 14)
    public BigDecimal fcfByTen;
}