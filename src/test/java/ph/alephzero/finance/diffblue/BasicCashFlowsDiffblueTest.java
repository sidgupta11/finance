package ph.alephzero.finance.diffblue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ph.alephzero.finance.cashflows.BasicCashFlows;

public class BasicCashFlowsDiffblueTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testBuildCashFlows() {
        BasicCashFlows actualBuildCashFlowsResult = BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true);
        assertNull(actualBuildCashFlowsResult.getBaseDate());
        assertFalse(actualBuildCashFlowsResult.isDated());
        assertTrue(actualBuildCashFlowsResult.isEquallySpaced());
    }

    @Test
    public void testBuildCashFlows2() {
        assertEquals(2, BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true).getCount());
    }

    @Test
    public void testBuildCashFlows3() {
        thrown.expect(ArrayIndexOutOfBoundsException.class);
        BasicCashFlows.buildCashFlows(-1, 10.0, 10.0, 10.0, true);
    }

    @Test
    public void testBuildCashFlows4() {
        thrown.expect(NegativeArraySizeException.class);
        BasicCashFlows.buildCashFlows(Integer.MIN_VALUE, 10.0, 10.0, 10.0, true);
    }

    @Test
    public void testBuildCashFlows5() {
        assertEquals(2, BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, false).getCount());
    }

    @Test
    public void testBuildCashFlows6() {
        thrown.expect(ArrayIndexOutOfBoundsException.class);
        BasicCashFlows.buildCashFlows(-1, 10.0, 10.0, 10.0, false);
    }

    @Test
    public void testConstructor() {
        assertEquals(8, (new BasicCashFlows(10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0)).getCount());
    }

    @Test
    public void testGetCount() {
        assertEquals(2, BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true).getCount());
    }

    @Test
    public void testGetDates() {
        thrown.expect(UnsupportedOperationException.class);
        BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true).getDates();
    }

    @Test
    public void testGetCashFlow() {
        assertEquals(20.0, BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true).getCashFlow(1), 0.0);
    }

    @Test
    public void testGetCashFlow2() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        BasicCashFlows.buildCashFlows(0, 10.0, 10.0, 10.0, true).getCashFlow(1);
    }

    @Test
    public void testGetCashFlow3() {
        thrown.expect(UnsupportedOperationException.class);
        BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true).getCashFlow(1, "Component");
    }

    @Test
    public void testGetCashFlow4() {
        BasicCashFlows buildCashFlowsResult = BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true);
        thrown.expect(UnsupportedOperationException.class);
        buildCashFlowsResult.getCashFlow(new Date(1L));
    }

    @Test
    public void testGetCashFlow5() {
        BasicCashFlows buildCashFlowsResult = BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true);
        thrown.expect(UnsupportedOperationException.class);
        buildCashFlowsResult.getCashFlow(new Date(1L), "Component");
    }

    @Test
    public void testAdd() {
        BasicCashFlows buildCashFlowsResult = BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true);
        buildCashFlowsResult.add(10.0);
        assertEquals(3, buildCashFlowsResult.getCount());
    }

    @Test
    public void testAdd2() {
        BasicCashFlows buildCashFlowsResult = BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true);
        buildCashFlowsResult.add(2, 10.0);
        assertEquals(3, buildCashFlowsResult.getCount());
    }

    @Test
    public void testAdd3() {
        BasicCashFlows buildCashFlowsResult = BasicCashFlows.buildCashFlows(2, 10.0, 10.0, 10.0, true);
        buildCashFlowsResult.add(2, 10.0);
        assertEquals(3, buildCashFlowsResult.getCount());
    }

    @Test
    public void testAdd4() {
        // TODO: This test is incomplete.
        //   Reason: No meaningful assertions found.
        //   To help Diffblue Cover to find assertions, please add getters to the
        //   class under test that return fields written by the method under test.
        //   See https://diff.blue/R004

        BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true).add(-1, 10.0);
    }

    @Test
    public void testAdd5() {
        thrown.expect(UnsupportedOperationException.class);
        BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true).add(2, 10.0, "Component");
    }

    @Test
    public void testRemove() {
        BasicCashFlows buildCashFlowsResult = BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true);
        buildCashFlowsResult.remove(1);
        assertEquals(1, buildCashFlowsResult.getCount());
    }

    @Test
    public void testRemove2() {
        BasicCashFlows buildCashFlowsResult = BasicCashFlows.buildCashFlows(0, 10.0, 10.0, 10.0, true);
        buildCashFlowsResult.remove(1);
        assertEquals(1, buildCashFlowsResult.getCount());
    }

    @Test
    public void testRemove3() {
        thrown.expect(UnsupportedOperationException.class);
        BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true).remove(1, "Component");
    }

    @Test
    public void testToMap() {
        thrown.expect(UnsupportedOperationException.class);
        BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true).toMap();
    }

    @Test
    public void testGetComponents() {
        assertTrue(BasicCashFlows.buildCashFlows(1, 10.0, 10.0, 10.0, true).getComponents().isEmpty());
    }
}

