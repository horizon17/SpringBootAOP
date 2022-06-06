Behavior like that: 

Aspect1
method1
method2
because by default works Real-time weaving.

CTW (Compile-time weaving):
CTW causes Aspect1 to be executed before method_2
How to run CTW? Use: aspectj-maven-plugin

LTW (Load-time weaving):
Behavior like RTW
How to run RTW? @EnableLoadTimeWeaving



JDK dynamic proxy VS CGLIB
Behavior like that:
Aspect1
method1
method2
looks like used JDK dynamic proxy, because before method2 not called Aspect1

Condition for JDK dynamic proxy:
NativeDetector.inNativeImage() || !config.isOptimize() && !config.isProxyTargetClass() && !this.hasNoUserSuppliedProxyInterfaces(config)
In reality used CGLIB proxy because there:
!targetClass.isInterface() && !Proxy.isProxyClass(targetClass) && !ClassUtils.isLambdaClass(targetClass)

OOP example:
CGLIB proxy work:
SampleParent.method1
ProxyObject.method2
