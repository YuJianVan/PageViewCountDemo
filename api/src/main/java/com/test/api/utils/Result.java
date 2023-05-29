package com.test.api.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Result {
    Integer error;

    public Result() {
        this.error=0;
    }

    public Result(Integer i) {
        this.error=i;
    }
}
