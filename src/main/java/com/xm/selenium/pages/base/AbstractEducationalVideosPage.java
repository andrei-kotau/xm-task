package com.xm.selenium.pages.base;

import com.xm.selenium.utils.ActionUtils;
import com.xm.selenium.utils.PageUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class AbstractEducationalVideosPage extends AbstractBasePage {

    @FindBy(css = ".xm-videos__player .videowrapper>iframe")
    protected WebElement videoWrapperFrame;

    @FindBy(css = ".player-big-play-button svg")
    WebElement playButton;

    @FindBy(css = ".player-control-bar .player-tracks")
    WebElement playerProgressTime;

    @FindBy(css = ".player[role='main']")
    WebElement player;

    public void playFirstVideo() {
        log.info("Play first opened video");

        iframeActions(videoWrapperFrame, () -> {
            var attempts = 0;
            while (!player.getAttribute("class").contains("playing")) {
                log.debug("Attempts to play the video #{}", ++attempts);

                PageUtils.waitToBeClickable(playButton);
                playButton.click();
                ActionUtils.pauseSeconds(2);
                if (attempts >= 5) {
                    throw new RuntimeException("Failed to click 'play' video button");
                }
            }
        });
    }

    public void waitVideoToPlaySeconds(int seconds) {
        log.info("Wait for video to play at least {} seconds", seconds);

        iframeActions(videoWrapperFrame, () -> {
            int timeout = seconds + 20;
            log.debug("Timeout is set to {} seconds if we are not able to start playing the video", timeout);
            PageUtils.waitForTimestampToBeMoreThan(playerProgressTime, seconds, timeout);
        });
    }
}
