package template;
import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
public class DownloadFile {

	public static void main(String[] args) {
		// будем качать карту сайта моего сайта - в вашем случае замените ссылку на свою
        String url = "https://drive.google.com/uc?export=download&id=1uRYEKnCND45B3S8K4f9UcBY76jLYjkvk";//http://javadevblog.com/sitemap.xml
        HashMap<String,String> files =  new HashMap<String,String>();
        files.put("lab.txt",url);
		for(String material:files.keySet()){
			System.out.println(material);
		}
		Scanner input = new Scanner(System.in);
		String s = input.nextLine();
		url = files.get(s);
        
        try {
            // качаем файл с помощью NIO
            downloadUsingNIO(url, "C:/Users/Бекнур/Desktop/mapnio.xml");
             
            // качаем файл с помощью Stream
//            downloadUsingStream(url, "C:/Users/Бекнур/Desktop/map_stream.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    // качаем файл с помощью Stream
//    private static void downloadUsingStream(String urlStr, String file) throws IOException{
//        URL url = new URL(urlStr);
//        BufferedInputStream bis = new BufferedInputStream(url.openStream());
//        FileOutputStream fis = new FileOutputStream(file);
//        byte[] buffer = new byte[1024];
//        int count=0;
//        while((count = bis.read(buffer,0,1024)) != -1)
//        {
//            fis.write(buffer, 0, count);
//        }
//        fis.close();
//        bis.close();
//    }
 
    // качаем файл с помощью NIO
    private static void downloadUsingNIO(String urlStr, String file) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }

}
