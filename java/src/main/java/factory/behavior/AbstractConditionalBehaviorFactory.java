package factory.behavior;

import java.util.List;

/**
 * Created by marcin on 20.04.17.
 */
public interface AbstractConditionalBehaviorFactory {

    List<ConditionalBehavior> createBehaviorList();

}
