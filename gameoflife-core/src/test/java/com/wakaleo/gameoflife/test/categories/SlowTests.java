package com.wakaleo.gameoflife.test.categories;

public interface SlowTests {
  // Open the home page
    open("/");
    assertThat(title()).isEqualTo("JPetStore Demo");
}
