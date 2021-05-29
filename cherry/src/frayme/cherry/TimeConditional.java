package frayme.cherry;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class TimeConditional extends Conditional {
    private static List<BooleanSupplier> conditionList(double minTime,
                                                       double maxTime) {
        return new ArrayList<>() {{
            add(new TimeCondition(
                    minTime,
                    maxTime
            ));
        }};
    }

    private static ConditionSet conditionSet(double minTime,
                                             double maxTime) {
        return new ConditionSet(
                conditionList(
                        minTime,
                        maxTime
                )
        );
    }

    public TimeConditional(Executable executable,
                           double minTime,
                           double maxTime) {
        super(
                conditionSet(
                        minTime,
                        maxTime
                ),
                executable
        );
    }
}
