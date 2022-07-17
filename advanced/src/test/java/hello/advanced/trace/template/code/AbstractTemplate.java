package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        long startTime = System.currentTimeMillis();
        //비즈 실행
        call();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("비즈1 결과시간={}", resultTime);
    }

    protected abstract void call();
}