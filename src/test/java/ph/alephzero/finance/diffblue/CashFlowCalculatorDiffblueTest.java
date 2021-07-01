package ph.alephzero.finance.diffblue;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ph.alephzero.finance.cashflows.BasicCashFlows;
import ph.alephzero.finance.cashflows.BasicDatedCashFlows;
import ph.alephzero.finance.cashflows.CashFlowCalculator;
import ph.alephzero.finance.cashflows.MergedCashFlows;

public class CashFlowCalculatorDiffblueTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testPresentValue() {
        Assert.assertEquals(1.0000000003469889, CashFlowCalculator.presentValue(10.0, 10.0, 10.0, 10.0, true), 0.0);
        assertEquals(10.999999999961446, CashFlowCalculator.presentValue(10.0, 10.0, 10.0, 10.0, false), 0.0);
        assertEquals(0.0, CashFlowCalculator.presentValue(new MergedCashFlows(), 10.0), 0.0);
        assertEquals(11.818181818181818,
                CashFlowCalculator.presentValue(BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true), 10.0), 0.0);
    }

    @Test
    public void testPresentValue2() {
        thrown.expect(UnsupportedOperationException.class);
        CashFlowCalculator.presentValue(new BasicDatedCashFlows(new Date(1L)), 10.0);
    }

    @Test
    public void testFutureValue() {
        assertEquals(2.8531167061E11, CashFlowCalculator.futureValue(10.0, 10.0, 10.0, 10.0, true), 0.0);
        assertEquals(5.4468591661E11, CashFlowCalculator.futureValue(10.0, 10.0, 10.0, 10.0, false), 0.0);
        assertEquals(130.0,
                CashFlowCalculator.futureValue(BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true), 10.0, 1), 0.0);
    }

    @Test
    public void testFutureValue2() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        CashFlowCalculator.futureValue(new MergedCashFlows(), 10.0, 1);
    }

    @Test
    public void testFutureValue3() {
        thrown.expect(UnsupportedOperationException.class);
        CashFlowCalculator.futureValue(new BasicDatedCashFlows(new Date(1L)), 10.0, 1);
    }

    @Test
    public void testAnnuities() {
        assertEquals(120.0, CashFlowCalculator.annuities(10.0, 1, 10.0, 10.0, true), 0.0);
        assertEquals(10.909090909090908, CashFlowCalculator.annuities(10.0, 1, 10.0, 10.0, false), 0.0);
        assertEquals(0.0, CashFlowCalculator.annuities(new MergedCashFlows(), 10.0, 1, true), 0.0);
        assertEquals(130.0,
                CashFlowCalculator.annuities(BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true), 10.0, 1, true), 0.0);
        assertEquals(0.0, CashFlowCalculator.annuities(new MergedCashFlows(), 10.0, 1, false), 0.0);
    }

    @Test
    public void testAnnuities2() {
        thrown.expect(UnsupportedOperationException.class);
        CashFlowCalculator.annuities(new BasicDatedCashFlows(new Date(1L)), 10.0, 1, true);
    }

    @Test
    public void testInternalRateOfReturn() {
        assertEquals(Double.NEGATIVE_INFINITY, CashFlowCalculator.internalRateOfReturn(1, 10.0, 10.0, 10.0, true), 0.0);
        assertEquals(Double.NEGATIVE_INFINITY, CashFlowCalculator.internalRateOfReturn(1, 10.0, 10.0, 10.0, false), 0.0);
        assertEquals(Double.NaN, CashFlowCalculator.internalRateOfReturn(new MergedCashFlows()), 0.0);
        assertEquals(Double.NEGATIVE_INFINITY,
                CashFlowCalculator.internalRateOfReturn(BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true)), 0.0);
    }

    @Test
    public void testInternalRateOfReturn2() {
        thrown.expect(UnsupportedOperationException.class);
        CashFlowCalculator.internalRateOfReturn(new BasicDatedCashFlows(new Date(1L)));
    }
}

