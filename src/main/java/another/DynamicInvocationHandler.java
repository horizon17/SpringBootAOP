package another;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicInvocationHandler implements InvocationHandler {

    // The target instance
    private Object invocationTarget;

    public DynamicInvocationHandler(Object invocationTarget) {
        this.invocationTarget = invocationTarget;
    }
//    private static Logger LOGGER = LoggerFactory.getLogger(
//            DynamicInvocationHandler.class);

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {

        // Invoke the method on the target instance
        Object result = method.invoke(invocationTarget, args);

        System.out.println("Invoked method! : {} " + method.getName());

        return 42;
    }
}
