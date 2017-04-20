package factory.behavior;

import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by marcin on 20.04.17.
 */
public interface AbstractBehaviorFactory {

    Map<Predicate<Integer>, String> createBehaviorMap();

}
