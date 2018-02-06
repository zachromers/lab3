import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static void main(String[] unused) {
        //System.out.println(urlToString("http://tgftp.nws.noaa.gov/data/raw/fz/fzus53.klot.srf.lot.txt"));
        String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
        text = text.replace('\n',' ');
        text = text.toLowerCase();
        String[] textstring = text.split(" ");
        int wordcount = textstring.length;
        System.out.println(wordcount);
        String wordtosearch = "prince";
        int specificwordcount = 0;
        for(int i = 0 ; i < textstring.length ; i++) {
            String lowercased = textstring[i].toLowerCase();
            if(lowercased.equals(wordtosearch)) {
                specificwordcount++;
            }
        }
        System.out.println(specificwordcount);
    }
}
