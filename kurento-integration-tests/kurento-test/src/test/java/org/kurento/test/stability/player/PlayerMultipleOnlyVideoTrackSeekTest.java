/*
 * (C) Copyright 2015 Kurento (http://kurento.org/)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 */

package org.kurento.test.stability.player;

import static org.kurento.test.config.Protocol.FILE;
import static org.kurento.test.config.Protocol.HTTP;
import static org.kurento.test.config.Protocol.S3;

import java.awt.Color;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import org.kurento.test.base.StabilityTest;
import org.kurento.test.browser.WebRtcChannel;
import org.kurento.test.config.Protocol;
import org.kurento.test.config.TestScenario;

/**
 * Test of multiple seek feature for a PlayerEndpoint. <br>
 *
 * Media Pipeline(s): <br>
 * · PlayerEndpoint -> WebRtcEndpoint <br>
 *
 * Browser(s): <br>
 * · Chrome <br>
 * · Firefox <br>
 *
 * Test logic: <br>
 * 1. (KMS) During the playback of a stream from a PlayerEndpoint to a WebRtcEndpoint, the
 * PlayerEndpoint is sought three times and then repeat numSeeks times <br>
 * 2. (Browser) WebRtcPeer in rcv-only receives media <br>
 *
 * Main assertion(s): <br>
 * · Color or the video should remain when a video is sought <br>
 * · After the seek, the color or the video should change <br>
 *
 * Secondary assertion(s): <br>
 * · Playing event should be received in remote video tag <br>
 *
 * @author Raul Benitez (rbenitez@gsyc.es)
 * @since 6.1.1
 */
public class PlayerMultipleOnlyVideoTrackSeekTest extends StabilityTest {

  @Parameters(name = "{index}: {0}")
  public static Collection<Object[]> data() {
    return TestScenario.localChromeAndFirefox();
  }

  private void initTest(Protocol protocol, String nameMedia) throws Exception {
    int pauseTimeSeconds = 3;
    int numSeeks = getTestSeekRepetitions();
    final Map<Integer, Color> expectedPositionAndColor = new LinkedHashMap<Integer, Color>();
    expectedPositionAndColor.put(2000, Color.RED);
    expectedPositionAndColor.put(10000, Color.BLUE);
    expectedPositionAndColor.put(6000, Color.GREEN);

    String mediaUrl = getMediaUrl(protocol, nameMedia);

    testPlayerMultipleSeek(mediaUrl, WebRtcChannel.VIDEO_ONLY, pauseTimeSeconds, numSeeks,
        expectedPositionAndColor);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekHttpOgv() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.ogv";
    initTest(HTTP, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekHttpMkv() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.mkv";
    initTest(HTTP, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekHttpAvi() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.avi";
    initTest(HTTP, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekHttpWebm() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.webm";
    initTest(HTTP, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekHttpMov() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.mov";
    initTest(HTTP, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekHttp3gp() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.3gp";
    initTest(HTTP, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekHttpMp4() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.mp4";
    initTest(HTTP, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekFileOgv() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.ogv";
    initTest(FILE, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekFileMkv() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.mkv";
    initTest(FILE, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekFileAvi() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.avi";
    initTest(FILE, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekFileWebm() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.webm";
    initTest(FILE, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekFileMov() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.mov";
    initTest(FILE, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekFile3gp() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.3gp";
    initTest(FILE, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekFileMp4() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.mp4";
    initTest(FILE, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekS3Ogv() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.ogv";
    initTest(S3, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekS3Mkv() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.mkv";
    initTest(S3, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekS3Avi() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.avi";
    initTest(S3, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekS3Webm() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.webm";
    initTest(S3, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekS3Mov() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.mov";
    initTest(S3, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekS33gp() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.3gp";
    initTest(S3, mediaUrl);
  }

  @Test
  public void testPlayerMultipleOnlyVideoSeekS3Mp4() throws Exception {
    // Test data
    final String mediaUrl = "/video/15sec/rgbOnlyVideo.mp4";
    initTest(S3, mediaUrl);
  }
}
