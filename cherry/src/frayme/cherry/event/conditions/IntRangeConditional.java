package frayme.cherry.event.conditions;

import frayme.cherry.event.Conditional;

import java.util.function.Supplier;

public class IntRangeConditional extends Conditional<Integer> {
    public IntRangeConditional(int minVal,
                               int maxVal,
                               Supplier<Integer> supplier) {
        super(aDouble ->
                        minVal < supplier.get() &&
                                supplier.get() < maxVal
                , supplier);
    }
}
