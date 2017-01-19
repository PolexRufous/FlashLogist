package com.flashlogist.applications.rout.app_wide;

import lombok.Getter;

@Getter
public enum Page {
    ROUT_MAIN("/rout", "applications/rout/rout");

    private final String url;
    private final String view;

    Page(String url, String view) {
        this.url = url;
        this.view = view;
    }
}
