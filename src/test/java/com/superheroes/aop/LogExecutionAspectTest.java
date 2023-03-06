package com.superheroes.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LogExecutionAspectTest {

    @Mock
    private ProceedingJoinPoint proceedingJoinPoint;

    @InjectMocks
    private LogExecutionAspect logExecutionAspect;

    @Test
    public void test_ExecutionTimeOK() throws Throwable {
        logExecutionAspect.logExecutionTime(proceedingJoinPoint);

        verify(proceedingJoinPoint, times(1)).proceed();
        verify(proceedingJoinPoint, never()).proceed(null);
    }
}