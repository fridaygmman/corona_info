import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;

public class APItest {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1741000/DisasterMsg3/getDisasterMsg1List"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=w7XDn2ZP9SRVjgyl64GF3CZylNLQpkB8FK8GHNZo6OGL0O%2BzaJnzmO8JQkTUR1heHigYwaspulhclYo1iFBwUQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + URLEncoder.encode("w7XDn2ZP9SRVjgyl64GF3CZylNLQpkB8FK8GHNZo6OGL0O+zaJnzmO8JQkTUR1heHigYwaspulhclYo1iFBwUQ==", "UTF-8")); /*공공데이터포털에서 받은 인증키*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*호출문서 형식*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);			// append 함수 : 문자열 붙이기
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        
        // 추가
        try (Scanner scanner = new Scanner(System.in)) {
        	String index = new String(); 
			int find=sb.indexOf(scanner.next());		// 특정 문자열이 시작하는 인덱스 리턴
			index=sb.substring(find, find+1000);		// 문자열 중 특정 부분을 뽑아냄
	        System.out.println(index.substring(0,index.indexOf("</location")));
	        System.out.println(index.substring(index.indexOf("<msg>")+5,index.indexOf("</msg>")));
		} catch(Exception re) {
			System.out.println("nodata");
		}
        
                
        

    }
}

