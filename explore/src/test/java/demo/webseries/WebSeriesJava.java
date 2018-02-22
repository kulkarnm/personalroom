package demo.webseries;

import com.karate.library.demo.domain.WebSeries;
import org.junit.Test;
import static org.junit.Assert.*;


public class WebSeriesJava {

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
