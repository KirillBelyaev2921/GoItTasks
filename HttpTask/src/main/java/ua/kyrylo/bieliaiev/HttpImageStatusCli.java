package ua.kyrylo.bieliaiev;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {

    private final String downloadFolderUrl;

    public HttpImageStatusCli(String downloadFolderUrl) {
        this.downloadFolderUrl = downloadFolderUrl;
    }

    void askStatus() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter HTTP status code");
        int code = 0;
        try {
            code = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please enter valid number");
            return;
        }
        HttpStatusDownloader downloader = new HttpStatusDownloader(downloadFolderUrl);
        try {
            downloader.downloadStatusImage(code);
            System.out.println("The image has been downloaded successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("There is not image for HTTP status " + code);
        }
    }
}
