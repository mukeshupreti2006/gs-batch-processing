package com.example.batchprocessing;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.stereotype.Component;

@Component
public class MySkipListener  implements SkipPolicy {

    @Override
    public boolean shouldSkip(Throwable throwable, int i) throws SkipLimitExceededException {
        return false;
    }
}
