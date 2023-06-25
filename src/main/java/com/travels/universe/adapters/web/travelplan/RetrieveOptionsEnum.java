package com.travels.universe.adapters.web.travelplan;

import java.util.Arrays;

public enum RetrieveOptionsEnum {

    NORMAL(false, false),
    EXPAND(true, false),
    OPTIMIZE(false, true),
    EXPAND_OPTIMIZE(true, true);

    private final Boolean expand;
    private final Boolean optimize;

    RetrieveOptionsEnum(Boolean expand, Boolean optimize) {
        this.expand = expand;
        this.optimize = optimize;
    }

    public static RetrieveOptionsEnum getRetrieveOptions(Boolean expand, Boolean optimize) {
        return Arrays.stream(RetrieveOptionsEnum.values())
                .filter(option -> option.expand.equals(expand))
                .filter(option -> option.optimize.equals(optimize))
                .findFirst()
                .orElse(NORMAL);
    }
}
