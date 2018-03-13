package Scenarios;

import Pages.MainPage;

public interface Scenario<I extends MainPage, O extends MainPage> {
    O run(I entry);
}
