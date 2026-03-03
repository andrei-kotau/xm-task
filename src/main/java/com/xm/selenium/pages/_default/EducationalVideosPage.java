package com.xm.selenium.pages._default;

import com.xm.selenium.pages.base.AbstractEducationalVideosPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class EducationalVideosPage extends AbstractEducationalVideosPage {

    public EducationalVideosPage() {
        PageFactory.initElements(driver, this);
    }
}
