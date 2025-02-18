package ua.kyrylo.bieliaiev;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {

    private final String downloadFolderUrl;
    private final Scanner in = new Scanner(System.in);

    public HttpImageStatusCli(String downloadFolderUrl) {
        this.downloadFolderUrl = downloadFolderUrl;
    }

    void askStatus() {
        while (true) {
            System.out.println("Enter HTTP status code (or type 'q' to quit): ");
            int code = 0;
            try {
                String line = in.nextLine();
                if (line.equalsIgnoreCase("q")) {
                    break;
                }
                code = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid number");
                continue;
            }
            HttpStatusDownloader downloader = new HttpStatusDownloader(downloadFolderUrl);
            try {
                downloader.downloadStatusImage(code);
                System.out.println("The image has been downloaded successfully");
            } catch (IllegalArgumentException e) {
                System.out.println("There is not image for HTTP status " + code);
            } catch (IOException e) {
                System.out.println("There was an error downloading the image " + code + ": " + e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("Interrupted while downloading the image " + code + ": " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}
