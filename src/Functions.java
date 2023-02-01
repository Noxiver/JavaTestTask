import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Functions {

    static String increase(String url, int n) throws MalformedURLException {
        URL aURL = new URL(url);
        String[] parsedUrl = aURL.getPath().split("/");
        String page = parsedUrl[parsedUrl.length - 1];
        int newPageValue = Integer.parseInt(page) + n;
        parsedUrl[parsedUrl.length - 1] = Integer.toString(newPageValue);
        StringBuilder result = new StringBuilder();
        result.append(aURL.getProtocol() + "://" + aURL.getAuthority());
        for (int i = 0; i < parsedUrl.length; i++) {
            result.append(parsedUrl[i]).append("/");
        }
        if (aURL.getQuery() != null) {
            result.append("?" + aURL.getQuery());
        }
        return result.toString();
    }

    static UrlPage getUrlAndPage(String url) throws MalformedURLException {
        URL aURL = new URL(url);
        String[] parsedUrl = aURL.getPath().split("/");
        String page = parsedUrl[parsedUrl.length - 1];
        int pageNumber = Integer.parseInt(page);
        return new UrlPage(url, pageNumber);
    }

    static String[] evenNumbers(String[] urls) throws MalformedURLException {
        List<UrlPage> urlPages = new ArrayList<UrlPage>();
        List<String> result = new ArrayList<String>();
        for (String url : urls) {
            urlPages.add(getUrlAndPage(url));

        }
        urlPages.sort(new Comparator<UrlPage>() {
            @Override
            public int compare(UrlPage o1, UrlPage o2) {
                return Integer.compare(o1.page, o2.page);
            }
        });
        for (UrlPage urlPage : urlPages) {
            if (result.size() < 20) {
                if (urlPage.page % 2 == 0) {
                    result.add(urlPage.url);
                }
            } else {
                break;
            }
        }
        return result.toArray(new String[0]);
    }

    static int getHTTPResponse(String url) {
        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.statusCode();
        } catch (Exception e) {
            return 400;
        }
    }
}
