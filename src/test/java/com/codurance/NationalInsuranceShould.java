package com.codurance;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class NationalInsuranceShould {

    @Test
    @Parameters({
            "8060.00, 0.00",
            "5000.00, 0.00"
    })
    public void
    be_zero_for_annual_gross_salary_below_8060_00(BigDecimal annualSalary, BigDecimal nationalInsuranceContribution) {
        NationalInsurance nationalInsurance = new NationalInsurance(annualSalary);

        assertThat(nationalInsurance.contribution()).isEqualTo(nationalInsuranceContribution);
    }

    @Test
    @Parameters({
            "9060.00, 120.00",
            "10060.00, 240.00",
            "43000.00, 4192.80"
    })
    public void
    be_12_percent_of_earnings_between_8060_00_and_43000_00(BigDecimal annualSalary, BigDecimal nationalInsuranceContribution) {
        NationalInsurance nationalInsurance = new NationalInsurance(annualSalary);

        assertThat(nationalInsurance.contribution()).isEqualTo(nationalInsuranceContribution);
    }

    @Test
    @Parameters({
            "45000.00, 4232.80"
    })
    public void
    be_2_percent_for_earnings_above_43000_00(BigDecimal annualSalary, BigDecimal nationalInsuranceContribution) {
        NationalInsurance nationalInsurance = new NationalInsurance(annualSalary);

        assertThat(nationalInsurance.contribution()).isEqualTo(nationalInsuranceContribution);
    }

}
