package frayme.cherry.event.conditions;

import frayme.cherry.event.Conditional;

import java.util.function.Supplier;

public class RangeConditional extends Conditional<Double> {
    public RangeConditional(double minVal,
                            double maxVal,
                            Supplier<Double> supplier) {
        super(aDouble ->
                        minVal < supplier.get() &&
                                supplier.get() < maxVal
                , supplier);
    }
}
