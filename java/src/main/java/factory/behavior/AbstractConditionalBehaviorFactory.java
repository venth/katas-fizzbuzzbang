package factory.behavior;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by marcin on 20.04.17.
 */
public interface AbstractConditionalBehaviorFactory {

    List<ConditionalBehavior> createBehaviorList();

}
