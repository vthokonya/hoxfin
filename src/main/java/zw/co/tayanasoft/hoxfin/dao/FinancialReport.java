package zw.co.tayanasoft.hoxfin.dao;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import zw.co.tayanasoft.hoxfin.enu.ReportType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "financial_report")
public class FinancialReport extends PanacheEntity {
    @ManyToOne
    @JoinColumn(name = "counter_id")
    public Counter counter;
    @Column(name="report_type", nullable = false)
    public ReportType reportType;
    @Column(name = "report_date", nullable = false)
    public LocalDate reportDate;
    @Column(nullable = false, scale = 2, precision = 14)
    public BigDecimal assets;
    @Column(nullable = false, scale = 2, precision = 14)
    public BigDecimal liabilities;
    @Column(name = "issued_shares", nullable = false, scale = 2, precision = 14)
    public BigDecimal issuedShares;
    @Column(name = "cf_operating_activities", nullable = false, scale = 2, precision = 14)
    public BigDecimal cfOperatingActivities;
    @Column(name = "interest_expenses", nullable = false, scale = 2, precision = 14)
    public BigDecimal interestExpenses;
    @Column(name = "tax_shield", scale = 2, precision = 14)
    public BigDecimal taxShield;
    @Column(nullable = false, scale = 2, precision = 14)
    public BigDecimal capex;
    @Column(nullable = false, scale = 6, precision = 14)
    public BigDecimal dividend;
    @Column(name = "net_assets", scale = 2, precision = 14)
    public BigDecimal netAssets;
    @Column(nullable = false, scale = 6, precision = 14)
    public BigDecimal eps;
    @Column(name = "eps_last_year", scale = 6, precision = 14)
    public BigDecimal epsLastYear;
    @Column(name = "earning_growth", scale = 2, precision = 14)
    public BigDecimal earningGrowth;
    @Column(name = "pe_ratio", scale = 2, precision = 14)
    public BigDecimal peRatio;
    @Column(name = "pb_ratio", scale = 2, precision = 14)
    public BigDecimal pbRatio;
    @Column(name = "dividend_ratio", scale = 2, precision = 14)
    public BigDecimal dividendRatio;
    @Column(name = "free_cash_flow", scale = 2, precision = 14)
    public BigDecimal freeCashFlow;
}