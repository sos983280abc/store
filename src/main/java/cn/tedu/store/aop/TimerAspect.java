package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimerAspect {
	
	@Around("execution(* cn.tedu.store.service.impl.*.*(..))")
	public Object a(ProceedingJoinPoint pjp) throws Throwable {
		//记录其实时间
		long start = System.currentTimeMillis();
		
		//执行方法,获取返回值
		Object result = pjp.proceed();
		
		//记录结束时间
		long end = System.currentTimeMillis();
		
		//计算耗时
		System.err.println("耗时"+(end - start)+"毫秒");
		
		//返回切面之后方法的返回值
		return result;
	}
}
