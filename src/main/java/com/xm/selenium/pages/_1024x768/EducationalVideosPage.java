package com.xm.selenium.pages._1024x768;

import com.xm.selenium.pages.base.AbstractEducationalVideosPage;
import com.xm.selenium.utils.JSUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class EducationalVideosPage extends AbstractEducationalVideosPage {

    public EducationalVideosPage() {
        PageFactory.initElements(driver, this);
    }

    public void playFirstVideo() {
        JSUtils.scrollTo(videoWrapperFrame);
        super.playFirstVideo();
    }
}
