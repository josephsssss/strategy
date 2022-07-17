package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        //비즈 실행
        log.info("비즈1 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("비즈1 결과시간={}", resultTime);

    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        //비즈 실행
        log.info("비즈2 실행");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("비즈2 결과시간={}", resultTime);

    }

    // 템플릿 메서드 패턴 적용
    @Test
    void TemplateMethodV1() {
        AbstractTemplate template1 = new SubClassLogic1();
        AbstractTemplate template2 = new SubClassLogic2();
        template1.execute();
        template2.execute();
    }

    @Test
    void TemplateMethodV2() {
        AbstractTemplate template = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈1 실행");
            }
        };
        log.info("클래스이름={}", template.getClass());
        template.execute();


        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈2 실행");
            }

        };
        log.info("클래스이름={}", template.getClass());
        template2.execute();
    }
}

