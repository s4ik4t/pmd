/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */

package net.sourceforge.pmd.lang.java.metrics.api;

import net.sourceforge.pmd.lang.java.ast.ASTAnyTypeDeclaration;
import net.sourceforge.pmd.lang.java.metrics.impl.AtfdMetric.AtfdClassMetric;
import net.sourceforge.pmd.lang.java.metrics.impl.CycloMetric.CycloClassMetric;
import net.sourceforge.pmd.lang.java.metrics.impl.LocMetric.LocClassMetric;
import net.sourceforge.pmd.lang.java.metrics.impl.NcssMetric.NcssClassMetric;
import net.sourceforge.pmd.lang.java.metrics.impl.WmcMetric;
import net.sourceforge.pmd.lang.metrics.MetricKey;

/**
 * Keys identifying standard class metrics.
 */
public enum JavaClassMetricKey implements MetricKey<ASTAnyTypeDeclaration> {

    /**
     * Access to Foreign Data.
     *
     * @see net.sourceforge.pmd.lang.java.metrics.impl.AtfdMetric
     */
    ATFD(new AtfdClassMetric()),

    /**
     * Weighed Method Count.
     *
     * @see WmcMetric
     */
    WMC(new WmcMetric()),

    /**
     * Cyclomatic complexity.
     *
     * @see net.sourceforge.pmd.lang.java.metrics.impl.CycloMetric
     */
    CYCLO(new CycloClassMetric()),

    /**
     * Non Commenting Source Statements.
     *
     * @see net.sourceforge.pmd.lang.java.metrics.impl.NcssMetric
     */
    NCSS(new NcssClassMetric()),

    /**
     * Lines of Code.
     *
     * @see net.sourceforge.pmd.lang.java.metrics.impl.LocMetric
     */
    LOC(new LocClassMetric());

    private final JavaClassMetric calculator;


    JavaClassMetricKey(JavaClassMetric m) {
        calculator = m;
    }


    @Override
    public JavaClassMetric getCalculator() {
        return calculator;
    }


    @Override
    public boolean supports(ASTAnyTypeDeclaration node) {
        return calculator.supports(node);
    }


}