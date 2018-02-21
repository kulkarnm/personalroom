/*
 * The MIT License
 *
 * Copyright 2017 Intuit Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package demo.webseries;

import com.karate.library.demo.domain.WebSeries;
import org.junit.Test;
import static org.junit.Assert.*;


public class WebSeriesJava {

    /*
    {
      name: 'Billie',
      kittens: [
          { id: 23, name: 'Bob' },
          { id: 42, name: 'Wild' }
      ]
    }    
     */
    @Test
    public void testMatchingUsingPojos() {

        WebSeries myWebSeries = new WebSeries();
        myWebSeries.setName("MyWebSeries");
        WebSeries yourWebSeries = new WebSeries();
        yourWebSeries.setId(23);
        yourWebSeries.setName("YourWebSeries");
        myWebSeries.addEpisode(yourWebSeries);
        WebSeries theirWebSeries = new WebSeries();
        theirWebSeries.setId(42);
        theirWebSeries.setName("TheirWebSeries");
        myWebSeries.addEpisode(theirWebSeries);

        // * match billie.kittens contains { id: 42, name: 'Wild' }
        boolean found = false;
        if (myWebSeries.getEpisodes() != null) {
            for (WebSeries episode : myWebSeries.getEpisodes()) {
                if (episode.getId() == 42 && "TheirWebSeries".equals(episode.getName())) {
                    found = true;
                }
            }
        }
        assertTrue(found);
        
        WebSeries test = new WebSeries();
        test.setId(42);
        test.setName("TheirWebSeries");
        
        assertTrue(hasEpisodes(myWebSeries, test));
        
    }

    private static boolean hasEpisodes(WebSeries webSeries, WebSeries part) {
        if (webSeries.getEpisodes() != null) {
            for (WebSeries episode : webSeries.getEpisodes()) {
                if (episode.getId() == part.getId()) {
                    if (episode.getName() == null) {
                        if (part.getName() == null) {
                            return true;
                        }
                    } else if (episode.getName().equals(part.getName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
